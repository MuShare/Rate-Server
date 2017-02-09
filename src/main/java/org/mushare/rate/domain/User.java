package org.mushare.rate.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lee on 2017/2/3.
 */
@Entity
@Table(name = "rate_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String uid;

    @Column
    private String uname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Temporal(TemporalType.DATE)
    private Date loginDate;

    // User is active or not.
    @Column
    private Boolean status = false;

    // Active validate code, send by email.
    @Column
    private String validateCode;

    @Column
    private Integer favoriteRevision = 0;

    @Column(name = "subscribe_revision")
    private Integer subscribeRevision = 0;

    // File path of avatar.
    @Column(name = "avatar")
    private String avatar;

    // Verification code for modifying password.
    @Column(name = "verification_code")
    private String verificationCode;

    // Code expiration for modifying password.
    @Column(name = "code_expiration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date codeExpiration;

    // Avatar revision.
    @Column(name = "avatar_revision")
    private Integer avatarRevision = 0;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public Integer getFavoriteRevision() {
        return favoriteRevision;
    }

    public void setFavoriteRevision(Integer favoriteRevision) {
        this.favoriteRevision = favoriteRevision;
    }

    public Integer getSubscribeRevision() {
        return subscribeRevision;
    }

    public void setSubscribeRevision(Integer subscribeRevision) {
        this.subscribeRevision = subscribeRevision;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Date getCodeExpiration() {
        return codeExpiration;
    }

    public void setCodeExpiration(Date codeExpiration) {
        this.codeExpiration = codeExpiration;
    }

    public Integer getAvatarRevision() {
        return avatarRevision;
    }

    public void setAvatarRevision(Integer avatarRevision) {
        this.avatarRevision = avatarRevision;
    }
}
