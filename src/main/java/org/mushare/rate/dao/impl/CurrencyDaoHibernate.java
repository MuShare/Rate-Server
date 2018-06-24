package org.mushare.rate.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.rate.dao.CurrencyDao;
import org.mushare.rate.domain.Currency;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyDaoHibernate extends BaseHibernateDaoSupport<Currency> implements CurrencyDao {

    public CurrencyDaoHibernate() {
        super();
        setClass(Currency.class);
    }

    public List<Currency> findByRevison(int revision) {
        String hql = "from Currency where revision >= ?";
        return (List<Currency>) getHibernateTemplate().find(hql, revision);
    }

    public Currency getByCode(String code) {
        String hql = "from Currency where code = ?";
        List<Currency> currencies = (List<Currency>) getHibernateTemplate().find(hql, code);
        if (currencies.size() == 0) {
            return null;
        }
        return currencies.get(0);
    }

    public int getCount() {
        final String hql = "select count(*) from Currency";
        return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            public Integer doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                return (Integer) query.uniqueResult();
            }
        });
    }

    public int getMaxRev() {
        final String hql = "select max(revision) from Currency";
        return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            public Integer doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                return (Integer) query.uniqueResult();
            }
        });
    }
}
