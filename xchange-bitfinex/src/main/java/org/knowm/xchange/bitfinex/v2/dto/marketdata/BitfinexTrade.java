package org.knowm.xchange.bitfinex.v2.dto.marketdata;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.ARRAY;

@JsonFormat(shape = ARRAY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitfinexTrade {

    @JsonProperty("ID")
    private Long tradeId;
    @JsonProperty("PAIR")
    private String pair;
    @JsonProperty("MST_CREATED")
    private Date timestamp;
    @JsonProperty("OEDER_ID")
    private Long orderId;
    @JsonProperty("EXEC_AMOUNT")
    private double amount;
    @JsonProperty("EXEC_PRICE")
    private double price;
    @JsonProperty("ORDER_TYPE")
    private String orderIype;
    @JsonProperty("ORDER_PRICE")
    private double orderPrice;
    @JsonProperty("MAKER")
    private int maker;
    @JsonProperty("FEE")
    private double fee;
    @JsonProperty("FEE_CURRENCY")
    private String feeCurrency;

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderIype() {
        return orderIype;
    }

    public void setOrderIype(String orderIype) {
        this.orderIype = orderIype;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getMaker() {
        return maker;
    }

    public void setMaker(int maker) {
        this.maker = maker;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }
}
