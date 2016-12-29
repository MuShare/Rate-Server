package org.mushare.rate.service;

import org.mushare.rate.bean.NewsBean;

import java.util.List;

public interface NewsManager {

    /**
     * Dowanload news from Baidu API.
     * @return
     */
    String downloadNews(String title, String source, String content);

    /**
     *
     * @param keyword
     * @return
     */
    List<NewsBean> getNews(String keyword);

}
