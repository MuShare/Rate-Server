package org.mushare.rate.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.rate.dao.FavoriteDao;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.domain.Favorite;
import org.mushare.rate.domain.User;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteDaoHibernate extends BaseHibernateDaoSupport<Favorite> implements FavoriteDao {

    public FavoriteDaoHibernate() {
        super();
        setClass(Favorite.class);
    }

    public List<Favorite> getFavorites(User user) {
        String hql = "from Favorite where user = ?";
        return (List<Favorite>) getHibernateTemplate().find(hql, user);
    }

    public void deleteFavoriteByCurrency(final Currency currency, final User user) {
        final String hql = "delete from Favorite where currency = ? and user = ?";
        getHibernateTemplate().execute(new HibernateCallback<Object>() {
            public Integer doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                query.setParameter(0, currency);
                query.setParameter(1, user);
                return query.executeUpdate();
            }
        });
    }

}
