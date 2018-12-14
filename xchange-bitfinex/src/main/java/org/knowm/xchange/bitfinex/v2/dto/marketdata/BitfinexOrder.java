package org.knowm.xchange.bitfinex.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.ARRAY;

@JsonFormat(shape = ARRAY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitfinexOrder {
    private Long orderId;
    private Long gid;
    private Long clOrdID;
    private String symbol;
    private Long createTimestamp;
    private Long updateTimestamp;
    private Double amount;
    private Double origAmount;
    private String type;
    private String prevType;
    private String placeholder1;
    private String placeholder2;
    private Long flags;
    private String status;
    private String placeholder3;
    private String placeholder4;
    private Double price;
    private Double avgPrice;

    public BitfinexOrder() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Long getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(Long clOrdID) {
        this.clOrdID = clOrdID;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Long getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getOrigAmount() {
        return origAmount;
    }

    public void setOrigAmount(Double origAmount) {
        this.origAmount = origAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrevType() {
        return prevType;
    }

    public void setPrevType(String prevType) {
        this.prevType = prevType;
    }

    public String getPlaceholder1() {
        return placeholder1;
    }

    public void setPlaceholder1(String placeholder1) {
        this.placeholder1 = placeholder1;
    }

    public String getPlaceholder2() {
        return placeholder2;
    }

    public void setPlaceholder2(String placeholder2) {
        this.placeholder2 = placeholder2;
    }

    public Long getFlags() {
        return flags;
    }

    public void setFlags(Long flags) {
        this.flags = flags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlaceholder3() {
        return placeholder3;
    }

    public void setPlaceholder3(String placeholder3) {
        this.placeholder3 = placeholder3;
    }

    public String getPlaceholder4() {
        return placeholder4;
    }

    public void setPlaceholder4(String placeholder4) {
        this.placeholder4 = placeholder4;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    @Override
    public String toString() {
        return "BitfinexOrder{" +
                "orderId=" + orderId +
                ", gid=" + gid +
                ", clOrdID=" + clOrdID +
                ", symbol='" + symbol + '\'' +
                ", createTimestamp=" + createTimestamp +
                ", updateTimestamp=" + updateTimestamp +
                ", amount=" + amount +
                ", origAmount=" + origAmount +
                ", type='" + type + '\'' +
                ", prevType='" + prevType + '\'' +
                ", placeholder1='" + placeholder1 + '\'' +
                ", placeholder2='" + placeholder2 + '\'' +
                ", flags=" + flags +
                ", status='" + status + '\'' +
                ", placeholder3='" + placeholder3 + '\'' +
                ", placeholder4='" + placeholder4 + '\'' +
                ", price=" + price +
                ", avgPrice=" + avgPrice +
                '}';
    }


}
