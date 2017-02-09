package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.PageHibernateDaoSupport;
import org.mushare.rate.dao.CurrencyDao;
import org.mushare.rate.domain.Currency;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyDaoHibernate extends PageHibernateDaoSupport<Currency> implements CurrencyDao {

    public CurrencyDaoHibernate() {
        super();
        setClass(Currency.class);
    }

    public List<Currency> findByRevison(int revision) {
        String hql = "from Currency where revision > ?";
        return (List<Currency>) getHibernateTemplate().find(hql, revision);
    }

}
