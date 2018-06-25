package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.BaseDao;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.domain.Rate;

import java.util.List;

public interface RateDao extends BaseDao<Rate> {

    List<Rate> findCurrents();

    Rate getCurrentByCurrency(Currency currency);

}
