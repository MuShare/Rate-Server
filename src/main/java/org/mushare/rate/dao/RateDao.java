package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.BaseDao;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.domain.Rate;

import java.util.List;

public interface RateDao extends BaseDao<Rate> {

    /**
     *
     * @return
     */
    List<Rate> findCurrents();

    /**
     *
     * @param currency
     * @return
     */
    Rate getCurrentByCurrency(Currency currency);

    /**
     *
     * @param currency
     * @param start
     * @param end
     * @return
     */
    List<Rate> findByCurrency(Currency currency, Long start, Long end);

}
