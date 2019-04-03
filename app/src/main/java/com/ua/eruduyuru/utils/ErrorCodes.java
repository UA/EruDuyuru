package com.ua.eruduyuru.utils;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCodes {
    OCCURRED_ERROR(0, "An occurred error!");

    private int errorCode;
    private String errorMessage;
    private static Map<Integer, ErrorCodes> errorCodeByErrorNumber = new HashMap<Integer, ErrorCodes>();

    static {
        for (ErrorCodes errorCode : ErrorCodes.values()) {
            errorCodeByErrorNumber.put(errorCode.getErrorCode(), errorCode);
        }
    }

    ErrorCodes(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static ErrorCodes getErrorCodeByNumber(Integer errorNumber) {
        return errorCodeByErrorNumber.get(errorNumber);
    }
}
