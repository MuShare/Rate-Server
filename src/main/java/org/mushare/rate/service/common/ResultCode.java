package org.mushare.rate.service.common;

public enum ResultCode {

    Success(901),
    SessionError(902),
    ObjectIdError(903),
    SaveInternalError(904),

    CurrencyNotSupported(1001),
    CurrencyExsited(1002),
    CurrencyNotFound(1003),

    UserEmailRegistered(3001),
    CategoryRemoveNotAllow(3002),
    SelectionRemoveNotAllow(3003),
    OptionRemoveNotAllow(3004),
    MessageModifyNoPrevilege(3006),
    FavoriteNotExisted(3007);

    public int code;

    private ResultCode(int code) {
        this.code = code;
    }

}
