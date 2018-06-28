package org.mushare.rate.service.common;

import org.mushare.rate.component.ConfigComponent;
import org.mushare.rate.component.MailComponent;
import org.mushare.rate.component.RateComponent;
import org.mushare.rate.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerTemplate {

    @Autowired
    protected RateComponent rateComponent;

    @Autowired
    protected ConfigComponent configComponent;

    @Autowired
    protected MailComponent mailComponent;

    @Autowired
    protected NewsDao newsDao;

    @Autowired
    protected CurrencyDao currencyDao;

    @Autowired
    protected RateDao rateDao;

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected DeviceDao deviceDao;

    @Autowired
    private FavoriteDao favoriteDao;

    @Autowired
    protected SubscribeDao subscribeDao;

    @Autowired
    protected VerificationDao verificationDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public CurrencyDao getCurrencyDao() {
        return currencyDao;
    }

    public void setCurrencyDao(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    public NewsDao getNewsDao() {
        return newsDao;
    }

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

}
