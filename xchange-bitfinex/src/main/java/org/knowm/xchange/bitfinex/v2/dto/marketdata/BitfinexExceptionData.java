package org.knowm.xchange.bitfinex.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class BitfinexExceptionData {
    private String error;
    private long code;
    private String desc;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
