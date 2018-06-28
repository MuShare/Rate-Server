package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.BaseDao;
import org.mushare.rate.domain.User;

public interface UserDao extends BaseDao<User> {

    /**
     * Get a user by an indentifier with a type
     * @param identifier
     * @param type
     * @return
     */
    User getByIdentifierWithType(String identifier, String type);

}
