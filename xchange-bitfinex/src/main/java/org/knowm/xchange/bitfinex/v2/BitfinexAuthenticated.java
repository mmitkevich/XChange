package org.knowm.xchange.bitfinex.v2;

import org.knowm.xchange.bitfinex.common.dto.BitfinexException;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexTrade;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexOrder;
import org.knowm.xchange.bitfinex.v2.dto.marketdata.BitfinexOrderBody;
import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("v2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BitfinexAuthenticated extends Bitfinex {

    @POST
    @Path("auth/r/orders")
    List<BitfinexOrder> orders(
            @HeaderParam("bfx-nonce") Long nonce,
            @HeaderParam("bfx-apikey") String apiKey,
            @HeaderParam("bfx-signature") ParamsDigest signature,
            BitfinexOrderBody body
    ) throws IOException, BitfinexException;

    @POST
    @Path("auth/r/orders/{currency}")
    List<BitfinexOrder> orders(
            @HeaderParam("bfx-nonce") Long nonce,
            @HeaderParam("bfx-apikey") String apiKey,
            @HeaderParam("bfx-signature") ParamsDigest signature,
            BitfinexOrderBody body,
            @PathParam("currency") String currency
    ) throws IOException, BitfinexException;

    @POST
    @Path("auth/r/order/{symbol_orderId}/trades")
    List<BitfinexTrade> trades(
            @HeaderParam("bfx-nonce") Long nonce,
            @HeaderParam("bfx-apikey") String apiKey,
            @HeaderParam("bfx-signature") ParamsDigest signature,
            BitfinexOrderBody body,
            @PathParam("symbol_orderId") String symbolCurrencyOrderId
    ) throws IOException, BitfinexException;

    @POST
    @Path("auth/r/trades/hist")
    List<BitfinexTrade> recentTrades(
            @HeaderParam("bfx-nonce") Long nonce,
            @HeaderParam("bfx-apikey") String apiKey,
            @HeaderParam("bfx-signature") ParamsDigest signature,
            BitfinexOrderBody body
    ) throws IOException, BitfinexException;

    @POST
    @Path("auth/r/orders/{symbol_currency}/hist")
    List<BitfinexOrder> orderHistory(
            @HeaderParam("bfx-nonce") Long nonce,
            @HeaderParam("bfx-apikey") String apiKey,
            @HeaderParam("bfx-signature") ParamsDigest signature,
            BitfinexOrderBody body,
            @PathParam("symbol_currency") String symbolCurrency
    ) throws IOException, BitfinexException;

    @POST
    @Path("auth/r/orders/{currency}/hist")
    List<BitfinexOrder> orderHistory(
            @HeaderParam("bfx-nonce") Long nonce,
            @HeaderParam("bfx-apikey") String apiKey,
            @HeaderParam("bfx-signature") ParamsDigest signature,
            BitfinexOrderBody body,
            @PathParam("currency") String symbolCurrency,
            @QueryParam("start") Long start,
            @QueryParam("end") Long end,
            @QueryParam("limit") Long limit
    ) throws IOException, BitfinexException;

    @POST
    @Path("auth/r/orders/hist")
    List<BitfinexOrder> orderHistory(
            @HeaderParam("bfx-nonce") Long nonce,
            @HeaderParam("bfx-apikey") String apiKey,
            @HeaderParam("bfx-signature") ParamsDigest signature,
            BitfinexOrderBody body,
            @QueryParam("start") Long start,
            @QueryParam("end") Long end,
            @QueryParam("limit") Long limit
    ) throws IOException, BitfinexException;
}

