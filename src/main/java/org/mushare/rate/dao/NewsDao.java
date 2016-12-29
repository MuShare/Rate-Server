package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.CrudDao;
import org.mushare.rate.domain.News;

import java.util.List;

public interface NewsDao extends CrudDao<News> {

    /**
     *
     * @param keyword
     * @return
     */
    List<News> findByKeyword(String keyword);
}
