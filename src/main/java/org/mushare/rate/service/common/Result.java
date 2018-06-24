package org.mushare.rate.service.common;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class Result {

    private ResultCode code;
    private Object data = null;

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return code == ResultCode.Success;
    }

    public Result(ResultCode code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static Result withCode(ResultCode code) {
        return new Result(code, null);
    }

    public static Result successWithData(Object data) {
        return new Result(ResultCode.Success, data);
    }

    public static Result success() {
        return new Result(ResultCode.Success,null);
    }

    public static Result saveInternalError() {
        return withCode(ResultCode.SaveInternalError);
    }

}

