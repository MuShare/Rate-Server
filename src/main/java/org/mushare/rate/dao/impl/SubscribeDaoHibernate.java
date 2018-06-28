package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.rate.dao.SubscribeDao;
import org.mushare.rate.domain.Subscribe;
import org.mushare.rate.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscribeDaoHibernate extends BaseHibernateDaoSupport<Subscribe> implements SubscribeDao {

    public SubscribeDaoHibernate() {
        super();
        setClass(Subscribe.class);
    }

    public List<Subscribe> getSubscribes(User user) {
        String hql = "from Subscribe where user = ?";
        return (List<Subscribe>)getHibernateTemplate().find(hql, user);
    }

}
