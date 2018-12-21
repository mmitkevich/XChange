package org.knowm.xchange.bitfinex.v1 ;

import org.knowm.xchange.ExchangeSpecification;

public class EthfinexExchange extends BitfinexExchange {


  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification =
        new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://api.ethfinex.com/");
    exchangeSpecification.setHost("api.ethfinex.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("EthFinex");
    exchangeSpecification.setExchangeDescription("EthFinex is a bitcoin exchange.");

    return exchangeSpecification;
  }
}
