package org.mushare.rate.dao.impl;

import org.mushare.common.hibernate.support.BaseHibernateDaoSupport;
import org.mushare.rate.dao.NewsDao;
import org.mushare.rate.domain.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDaoHibernate extends BaseHibernateDaoSupport<News> implements NewsDao {

    public NewsDaoHibernate() {
        super();
        setClass(News.class);
    }

    public List<News> findByKeyword(String keyword) {
        String hql = "from News where title like ? or content like ? order by pubDate desc";
        String search = "%" + keyword + "%";
        return (List<News>) getHibernateTemplate().find(hql, search, search);
    }
}
