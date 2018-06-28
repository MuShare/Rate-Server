package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.BaseDao;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.domain.Favorite;
import org.mushare.rate.domain.User;

import java.util.List;

public interface FavoriteDao extends BaseDao<Favorite> {

    /**
     *
     * @param user
     * @return
     */
    List<Favorite> getFavorites(User user);

    /**
     *
     * @param currency
     * @param user
     * @return
     */
    void deleteFavoriteByCurrency(Currency currency, User user);
}
