package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.common.util.DateTool;
import org.mushare.rate.dao.RateDao;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.domain.Rate;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class RateDaoHibernate extends BaseHibernateDaoSupport<Rate> implements RateDao {

    public RateDaoHibernate() {
        super();
        setClass(Rate.class);
    }

    public List<Rate> findCurrents() {
        String hql = "from Rate where date = ?";
        return (List<Rate>) getHibernateTemplate().find(hql, DateTool.getToday().getTime());
    }

    public Rate getCurrentByCurrency(Currency currency) {
        String hql = "from Rate where currency = ? and date = ?";
        List<Rate> rates = (List<Rate>) getHibernateTemplate().find(hql, currency, DateTool.getToday().getTime());
        if (rates.size() == 0) {
            return null;
        }
        return rates.get(0);
    }


}
