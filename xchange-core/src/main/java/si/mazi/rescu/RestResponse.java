package si.mazi.rescu;

import java.util.List;
import java.util.Map;

public class RestResponse<ResultType> {
    private ResultType result;
    private Map<String,List<String>> headers;

    public RestResponse(ResultType result, Map<String,List<String>> headers) {
        this.result = result;
        this.headers = headers;
    }

    public RestResponse() {
    }

    public ResultType getResult() {
        return result;
    }

    public Map<String,List<String>> getHeaders() {
        return headers;
    }
}
