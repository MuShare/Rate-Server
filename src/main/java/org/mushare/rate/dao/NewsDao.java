package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.BaseDao;
import org.mushare.rate.domain.News;

import java.util.List;

public interface NewsDao extends BaseDao<News> {

    /**
     *
     * @param keyword
     * @return
     */
    List<News> findByKeyword(String keyword);
}
