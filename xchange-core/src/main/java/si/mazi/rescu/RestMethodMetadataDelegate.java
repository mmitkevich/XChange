package si.mazi.rescu;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class RestMethodMetadataDelegate extends RestMethodMetadata {
    private RestMethodMetadata delegate;

    public RestMethodMetadataDelegate(RestMethodMetadata delegate) {
        super(null, null, null, null, null, null,
                null, null, null, null, null);
        this.delegate = delegate;
    }

    public static RestMethodMetadata create(Method method, String baseUrl, String intfacePath) {
        return RestMethodMetadata.create(method, baseUrl, intfacePath);
    }

    public static HttpMethod getHttpMethod(Method method) {
        return RestMethodMetadata.getHttpMethod(method);
    }

    @Override
    public Type getReturnType() {
        if (delegate.getReturnType() instanceof ParameterizedType) {
            return ((ParameterizedType) delegate.getReturnType()).getActualTypeArguments()[0];
        }
        return delegate.getReturnType();
    }

    @Override
    public HttpMethod getHttpMethod() {
        return delegate.getHttpMethod();
    }

    @Override
    public String getBaseUrl() {
        return delegate.getBaseUrl();
    }

    @Override
    public String getIntfacePath() {
        return delegate.getIntfacePath();
    }

    @Override
    public String getMethodPathTemplate() {
        return delegate.getMethodPathTemplate();
    }

    @Override
    public Class<? extends RuntimeException> getExceptionType() {
        return delegate.getExceptionType();
    }

    @Override
    public String getReqContentType() {
        return delegate.getReqContentType();
    }

    @Override
    public String getResContentType() {
        return delegate.getResContentType();
    }

    @Override
    public String getMethodName() {
        return delegate.getMethodName();
    }

    @Override
    public Map<Class<? extends Annotation>, Annotation> getMethodAnnotationMap() {
        return delegate.getMethodAnnotationMap();
    }

    @Override
    public Annotation[][] getParameterAnnotations() {
        return delegate.getParameterAnnotations();
    }
}
