package org.mushare.rate.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscribe")
public class Subscribe {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String sid;

    // The name for this subcription by user.
    @Column
    private String sname;

    // The bottom threshold
    @Column
    private Double min = 0.0;

    // The top threshold
    @Column
    private Double max = 0.0;

    // Enable alert.
    @Column(name = "isenable")
    private Boolean isEnable = true;

    // Enable email notification
    @Column
    private Boolean isSendEmail = true;

    @Column
    private Integer revision = 0;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "fromcid")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "tocid")
    private Currency toCurrency;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

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

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Boolean getSendEmail() {
        return isSendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        isSendEmail = sendEmail;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

