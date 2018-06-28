package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.rate.dao.UserDao;
import org.mushare.rate.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoHibernate extends BaseHibernateDaoSupport<User> implements UserDao {

    public UserDaoHibernate() {
        super();
        setClass(User.class);
    }

    public User getByIdentifierWithType(String identifier, String type) {
        String hql = "from User where identifier = ? and type = ?";
        List<User> users = (List<User>)getHibernateTemplate().find(hql, identifier, type);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }
}
