package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.rate.dao.UserDao;
import org.mushare.rate.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoHibernate extends BaseHibernateDaoSupport<User> implements UserDao {
    public UserDaoHibernate() {
        super();
        setClass(User.class);
    }
}
