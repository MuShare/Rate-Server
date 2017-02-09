package org.mushare.rate.service.util;

import org.mushare.rate.dao.CurrencyDao;
import org.mushare.rate.dao.NewsDao;
import org.mushare.rate.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerTemplate {

    @Autowired
    protected NewsDao newsDao;

    @Autowired
    protected CurrencyDao currencyDao;

    @Autowired
    protected UserDao userDao;

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
