package com.FXDealer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FXDeal {

    private int id;
    private String dealUniqueId;
    private String fromCurrencyISOCode;
    private String toCurrencyISOCode;
    private LocalDateTime dealTimestamp;
    private BigDecimal dealAmount;

    public FXDeal(
            @JsonProperty("id") int id,
            @JsonProperty("dealUniqueId") String dealUniqueId,
            @JsonProperty("fromCurrencyISOCode") String fromCurrencyISOCode,
            @JsonProperty("toCurrencyISOCode") String toCurrencyISOCode,
            @JsonProperty("dealTimestamp") LocalDateTime dealTimestamp,
            @JsonProperty("dealAmount") BigDecimal dealAmount
    ) {
        this.id = id;
        this.dealUniqueId = dealUniqueId;
        this.fromCurrencyISOCode = fromCurrencyISOCode;
        this.toCurrencyISOCode = toCurrencyISOCode;
        this.dealTimestamp = dealTimestamp;
        this.dealAmount = dealAmount;
    }

    //////// Getters ////////
    public int getId() {
        return id;
    }

    public String getDealUniqueId() {
        return dealUniqueId;
    }

    public String getFromCurrencyISOCode() {
        return fromCurrencyISOCode;
    }

    public String getToCurrencyISOCode() {
        return toCurrencyISOCode;
    }

    public LocalDateTime getDealTimestamp() {
        return dealTimestamp;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    //////// Setters ////////


    public void setDealUniqueId(String dealUniqueId) {
        this.dealUniqueId = dealUniqueId;
    }

    public void setFromCurrencyISOCode(String fromCurrencyISOCode) {
        this.fromCurrencyISOCode = fromCurrencyISOCode;
    }

    public void setToCurrencyISOCode(String toCurrencyISOCode) {
        this.toCurrencyISOCode = toCurrencyISOCode;
    }

    public void setDealTimestamp(LocalDateTime dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }
}
