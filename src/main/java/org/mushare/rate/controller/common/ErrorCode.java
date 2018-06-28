package org.mushare.rate.controller.common;

public enum ErrorCode {

    ErrorToken(901, "Token is wrong."),
    ObjectIdError(902, "Object id is not found."),
    RevisionIllegal(1011, "Revision parameter illegal"),

    // User
    ErrorEmailExist(3011, "This email has been registered."),
    ErrorIllegalIDeviceOS(3021, "Device OS should be iOS or Android."),
    ErrorEmailNotExist(3022, "This email is not exsit."),
    ErrorPasswordWrong(3023, "Password is wrong."),
    ErrorFacebookAccessTokenInvalid(3031, "Facebook access token is invalid"),
    ErrorSendResetPasswordMail(3061, "Send reset password email failed."),

    FromAndToAreNull(2001, "fromCid and toCid should not be null at the same time");


    public int code;
    public String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
