package org.mushare.rate.controller.common;

public enum ErrorCode {

    ErrorToken(901, "Token is wrong."),
    ObjectIdError(902, "Object id is not found."),
    RevisionIllegal(1011, "Revision parameter illegal"),

    FromAndToAreNull(2001, "fromCid and toCid should not be null at the same time");


    public int code;
    public String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
