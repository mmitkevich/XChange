package org.knowm.xchange.bitfinex.v2.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.bitfinex.common.dto.BitfinexException;
import org.knowm.xchange.bitfinex.v1.dto.trade.BitfinexCancelAllOrdersRequest;
import org.knowm.xchange.bitfinex.v1.dto.trade.BitfinexCancelOrderMultiRequest;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexExceptionData;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexOrder;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexOrderBody;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexTrade;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.trade.TradeService;
import si.mazi.rescu.HttpStatusIOException;

import java.io.IOException;
import java.util.List;

public class BitfinexTradeService extends BitfinexBaseService implements TradeService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public BitfinexTradeService(Exchange exchange) {
    super(exchange);
  }

  public List<BitfinexTrade> getBitfinexTradeHistory() throws IOException {
    try {
      return bitfinex.recentTrades(exchange.getNonceFactory().createValue(), apiKey, signatureCreator, new BitfinexOrderBody());
    } catch (IOException e) {
      throw extractDataFromException(e);
    }
  }

  public List<BitfinexOrder> getBitfinexOpenOrders(CurrencyPair currencyPair) throws IOException {
    return bitfinex.orders(exchange.getNonceFactory().createValue(), apiKey, signatureCreator, new BitfinexOrderBody(),
            "t" + currencyPair.base.toString() + currencyPair.counter.toString());
  }

  public List<BitfinexOrder> getBitfinexOrderHistory(CurrencyPair currencyPair) throws IOException {
    return bitfinex.orderHistory(exchange.getNonceFactory().createValue(), apiKey, signatureCreator, new BitfinexOrderBody(),
            "t" + currencyPair.base.toString() + currencyPair.counter.toString());
  }

  private IOException extractDataFromException(IOException e) throws IOException {
    if (e instanceof HttpStatusIOException) {
      String body = ((HttpStatusIOException) e).getHttpBody();
      BitfinexExceptionData data = mapper.readValue(body, BitfinexExceptionData.class);
      return new IOException(data.getDesc());
    }
    return e;
  }

  public List<BitfinexTrade> getBitfinexOrderTrades(String clientOrderId, CurrencyPair currencyPair) throws IOException {
    return bitfinex.trades(exchange.getNonceFactory().createValue(), apiKey, signatureCreator, new BitfinexOrderBody(),
            "t" + currencyPair.base.toString() + currencyPair.counter.toString()+"_"+clientOrderId);
  }

  public boolean cancelAllBitfinexOrders() throws IOException {

    try {
      bitfinex.cancelAllOrders(
              apiKey,
              payloadCreator,
              signatureCreator,
              new BitfinexCancelAllOrdersRequest(
                      String.valueOf(exchange.getNonceFactory().createValue())));
      return true;
    } catch (BitfinexException e) {
      if (e.getMessage().equals("Orders could not be cancelled.")) {
        return false;
      } else {
        throw handleException(e);
      }
    }
  }

  public boolean cancelBitfinexOrderMulti(List<String> orderIds) throws IOException {

    long[] cancelOrderIds = new long[orderIds.size()];

    for (int i = 0; i < cancelOrderIds.length; i++) {
      cancelOrderIds[i] = Long.valueOf(orderIds.get(i));
    }

    try {
      bitfinex.cancelOrderMulti(
              apiKey,
              payloadCreator,
              signatureCreator,
              new BitfinexCancelOrderMultiRequest(
                      String.valueOf(exchange.getNonceFactory().createValue()), cancelOrderIds));
      return true;
    } catch (BitfinexException e) {
      throw handleException(e);
    }
  }
}
