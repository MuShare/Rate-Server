package org.mushare.rate.controller.util;

public enum ErrorCode {
    ErrorToken(901, "Token is wrong."),
    RevisionIllegal(1011, "Revision parameter illegal");


    public int code;
    public String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
