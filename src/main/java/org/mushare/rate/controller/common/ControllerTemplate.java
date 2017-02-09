package org.mushare.rate.controller.common;

import org.mushare.rate.service.CurrencyManager;
import org.mushare.rate.service.NewsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lee on 2017/2/3.
 */
public class ControllerTemplate {

    @Autowired
    protected CurrencyManager currencyManager;

    @Autowired
    protected NewsManager newsManager;

    public CurrencyManager getCurrencyManager() {
        return currencyManager;
    }

    public void setCurrencyManager(CurrencyManager currencyManager) {
        this.currencyManager = currencyManager;
    }

    public NewsManager getNewsManager() {
        return newsManager;
    }

    public void setNewsManager(NewsManager newsManager) {
        this.newsManager = newsManager;
    }


    public ResponseEntity generateOK(Map<String, Object> result) {
        return generateResponseEntity(result, HttpStatus.OK, null, null);
    }

    public ResponseEntity generateBadRequest(int errorCode, String errorMessage) {
        return generateResponseEntity(null, HttpStatus.BAD_REQUEST, errorCode, errorMessage);
    }

    public ResponseEntity generateBadRequest(ErrorCode errorCode) {
        return generateBadRequest(errorCode.code, errorCode.message);
    }

    public ResponseEntity generateResponseEntity(Map<String, Object> result, HttpStatus status, Integer errCode, String errMsg) {
        Map<String, Object> data = new HashMap<String, Object>();
        if (result != null) {
            data.put("result", result);
        }
        data.put("status", status.value());
        if (errCode != null) {
            data.put("errorCode", errCode);
        }
        if (errMsg != null) {
            data.put("errorMessage", errMsg);
        }
        return new ResponseEntity(data, status);
    }
}
