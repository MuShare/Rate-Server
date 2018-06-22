package org.mushare.rate.service.common;

public enum Result {

    Success(901),
    SessionError(902),
    ObjectIdError(903),
    SaveInternalError(904),

    CurrencyExsited(1001);

    public int code;
    public Object object;

    private Result(int code) {
        this.code = code;
    }

    private Result(int code, Object object) {
        this.code = code;
        this.object = object;
    }

}
