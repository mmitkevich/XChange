package org.knowm.xchange.proxy;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import si.mazi.rescu.ClientConfig;
import si.mazi.rescu.Interceptor;
import si.mazi.rescu.RestResponseProxyFactory;

public class Socks4ProxyHelper {

    private static boolean isProxyAbsent(Exchange exchange) {
        ExchangeSpecification eSpec = exchange.getExchangeSpecification();
        return eSpec.getProxyHost() == null && eSpec.getProxyPort() == null;
    }

    public static <I> I createSock4OrDirectProxyRest(Class<I> restInterface, Exchange exchange, String baseUrl, Interceptor... interceptors) {
        if (isProxyAbsent(exchange)) {
            return RestResponseProxyFactory.createProxy(restInterface, baseUrl, interceptors);
        } else {
            String proxyHost = exchange.getExchangeSpecification().getProxyHost();
            Integer proxyPort = exchange.getExchangeSpecification().getProxyPort();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.setProxyHost(proxyHost);
            clientConfig.setProxyPort(proxyPort);
            return RestResponseProxyFactory.createProxy(
                    restInterface,
                    baseUrl,
                    clientConfig,
                    interceptors
            );
        }
    }


    public static <I> I createSock4OrDirectProxyRest(Class<I> restInterface, Exchange exchange, String baseUrl, ClientConfig clientConfig) {
        if (isProxyAbsent(exchange)) {
            return RestResponseProxyFactory.createProxy(restInterface, baseUrl, clientConfig);
        } else {
            String proxyHost = exchange.getExchangeSpecification().getProxyHost();
            Integer proxyPort = exchange.getExchangeSpecification().getProxyPort();

            clientConfig.setProxyHost(proxyHost);
            clientConfig.setProxyPort(proxyPort);
            return RestResponseProxyFactory.createProxy(
                    restInterface,
                    baseUrl,
                    clientConfig
            );
        }
    }
}
