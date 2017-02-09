package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.PageHibernateDaoSupport;
import org.mushare.rate.dao.CurrencyDao;
import org.mushare.rate.domain.Currency;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyDaoHibernate extends PageHibernateDaoSupport<Currency> implements CurrencyDao {
    public CurrencyDaoHibernate() {
        super();
        setClass(Currency.class);
    }
}
