package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.BaseDao;
import org.mushare.rate.domain.Subscribe;
import org.mushare.rate.domain.User;

import java.util.List;

public interface SubscribeDao extends BaseDao<Subscribe> {

    /**
     *
     * @param user
     * @return
     */
    List<Subscribe> getSubscribes(User user);

}
