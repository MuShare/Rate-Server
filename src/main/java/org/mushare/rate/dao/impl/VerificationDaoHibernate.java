package org.mushare.rate.dao.impl;


import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.rate.dao.VerificationDao;
import org.mushare.rate.domain.Verification;
import org.springframework.stereotype.Repository;

@Repository
public class VerificationDaoHibernate extends BaseHibernateDaoSupport<Verification> implements VerificationDao {

    public VerificationDaoHibernate() {
        super();
        setClass(Verification.class);
    }

}
