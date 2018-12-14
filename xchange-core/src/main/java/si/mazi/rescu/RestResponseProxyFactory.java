package si.mazi.rescu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class RestResponseProxyFactory {


    private RestResponseProxyFactory() {
    }

    /**
     * Create a proxy implementation of restInterface. The interface must be annotated with jax-rs annotations. Basic support exists for {@link javax.ws.rs.Path}, {@link javax.ws.rs.GET},
     * {@link javax.ws.rs.POST}, {@link javax.ws.rs.QueryParam}, {@link javax.ws.rs.FormParam}, {@link javax.ws.rs.HeaderParam}, {@link javax.ws.rs.PathParam}., {@link javax.ws.rs.PATCH}
     *
     * @param restInterface The interface to implement
     * @param baseUrl       The service base baseUrl
     * @param <I>           The interface to implement
     * @param config        Client configuration
     * @param interceptors  The interceptors that will be able to intercept all proxy method calls
     * @return a proxy implementation of restInterface
     */
    public static <I> I createProxy(Class<I> restInterface, String baseUrl, ClientConfig config, Interceptor... interceptors) {
        return createProxy(restInterface, wrap(new RestResponseInvocationHandler(restInterface, baseUrl, config), interceptors));
    }

    static InvocationHandler wrap(InvocationHandler handler, Interceptor... interceptors) {
        for (Interceptor interceptor : interceptors) {
            handler = new InterceptedInvocationHandler(interceptor, handler);
        }
        return handler;
    }

    public static <I> I createProxy(Class<I> restInterface, String baseUrl, Interceptor... interceptors) {
        return createProxy(restInterface, baseUrl, null, interceptors);
    }

    static <I> I createProxy(Class<I> restInterface, InvocationHandler restInvocationHandler, Interceptor... interceptors) {
        Object proxy = Proxy.newProxyInstance(restInterface.getClassLoader(), new Class[]{restInterface}, wrap(restInvocationHandler, interceptors));
        // noinspection unchecked
        return (I) proxy;
    }
}