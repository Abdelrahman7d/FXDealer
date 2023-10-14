package com.FXDealer.exception;

public enum ErrorCode {

    //////// Fields ////////
    MISSING_FIELDS("ERR_1_001","Missing fields!"),

    //////// Currency - Amount ////////
    INVALID_CURRENCY_ISO_CODE("ERR_2_001", "Currency ISO Code is invalid!"),
    INVALID_OR_MISSING_AMOUNT("ERR_2_002", "The amount is missing or incorrect!"),

    //////// Date - Time ////////
    INVALID_DATE_TIMESTAMP_AFTER_NOW("ERR_3_001", "Invalid timestamp, The entered timestamp is after the current moment!")

    ;

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
