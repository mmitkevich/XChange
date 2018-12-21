package org.knowm.xchange.bitfinex.v2;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.bitfinex.v1.BitfinexAdapters;
import org.knowm.xchange.bitfinex.v1.dto.account.BitfinexAccountFeesResponse;
import org.knowm.xchange.bitfinex.v1.dto.marketdata.BitfinexSymbolDetail;
import org.knowm.xchange.bitfinex.v1.dto.trade.BitfinexAccountInfosResponse;
import org.knowm.xchange.bitfinex.v2.service.BitfinexAccountService;
import org.knowm.xchange.bitfinex.v2.service.BitfinexMarketDataService;
import org.knowm.xchange.bitfinex.v2.service.BitfinexTradeService;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.utils.nonce.AtomicLongIncrementalTime2013NonceFactory;
import si.mazi.rescu.SynchronizedValueFactory;

import java.io.IOException;
import java.util.List;

public class EthfinexExchange extends BitfinexExchange {

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification =
        new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://api.ethfinex.com/");
    exchangeSpecification.setHost("api.ethfinex.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("Ethfinex");
    exchangeSpecification.setExchangeDescription("Ethfnex is a cryptocurrency and fiat exchange.");

    return exchangeSpecification;
  }
}
