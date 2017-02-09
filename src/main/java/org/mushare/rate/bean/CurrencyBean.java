package org.mushare.rate.bean;

import org.mushare.rate.domain.Currency;

/**
 * Created by lee on 2017/2/9.
 */
public class CurrencyBean {
    private String cid;
    private String code;
    private String icon;
    private String name;

    public CurrencyBean(Currency currency) {
        this.cid = currency.getCid();
        this.code = currency.getCode();
        this.icon =
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
