package org.mushare.rate.bean;

import org.mushare.rate.domain.Subscribe;

public class SubscribeMobileBean {
    private String sid;
    private String sname;
    private String fromCid;
    private String toCid;
    private boolean isEnable;
    private boolean isSendEmail;
    private boolean isSendSms;
    private double threshold;


    public SubscribeMobileBean(Subscribe subscribe){
        this.sid = subscribe.getSid();
        this.sname = subscribe.getSname();
        this.fromCid = subscribe.getCurrency().getCid();
        this.toCid = subscribe.getToCurrency().getCid();
        this.isEnable = subscribe.getEnable();
        this.isSendEmail = subscribe.getSendEmail();
        this.isSendSms = false;
        threshold = (subscribe.getMin() != 0 ? subscribe.getMin() : subscribe.getMax());
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFromCid() {
        return fromCid;
    }

    public void setFromCid(String fromCid) {
        this.fromCid = fromCid;
    }

    public String getToCid() {
        return toCid;
    }

    public void setToCid(String toCid) {
        this.toCid = toCid;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public boolean isSendEmail() {
        return isSendEmail;
    }

    public void setIsSendEmail(boolean isSendEmail) {
        this.isSendEmail = isSendEmail;
    }

    public boolean isSendSms() {
        return isSendSms;
    }

    public void setIsSendSms(boolean isSendSms) {
        this.isSendSms = isSendSms;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}
