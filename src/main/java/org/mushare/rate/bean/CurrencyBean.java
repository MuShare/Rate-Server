package org.mushare.rate.bean;

import org.mushare.rate.domain.Currency;

import java.util.Locale;

public class CurrencyBean {

    private String cid;
    private String code;
    private String name;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrencyBean(Currency currency, String lan) {
        this.cid = currency.getCid();
        this.code = currency.getCode();
        this.name = java.util.Currency.getInstance(currency.getCode()).getDisplayName(Locale.forLanguageTag(lan));
    }

}
