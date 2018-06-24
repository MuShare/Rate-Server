package org.mushare.rate.service.common;

public enum ResultCode {

    Success(901),
    SessionError(902),
    ObjectIdError(903),
    SaveInternalError(904),

    CurrencyNotSupported(1001),
    CurrencyExsited(1002);

    public int code;

    private ResultCode(int code) {
        this.code = code;
    }

}
