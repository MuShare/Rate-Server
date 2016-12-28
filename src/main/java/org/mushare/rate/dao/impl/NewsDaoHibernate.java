package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.PageHibernateDaoSupport;
import org.mushare.rate.dao.NewsDao;
import org.mushare.rate.domain.News;

public class NewsDaoHibernate extends PageHibernateDaoSupport<News> implements NewsDao {

    public NewsDaoHibernate() {
        super();
        setClass(News.class);
    }

}
