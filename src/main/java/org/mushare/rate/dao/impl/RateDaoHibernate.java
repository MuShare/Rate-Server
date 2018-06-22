package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.rate.dao.RateDao;
import org.mushare.rate.domain.Rate;
import org.springframework.stereotype.Repository;

@Repository
public class RateDaoHibernate extends BaseHibernateDaoSupport<Rate> implements RateDao {

    public RateDaoHibernate() {
        super();
        setClass(Rate.class);
    }

}
