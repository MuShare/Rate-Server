package org.mushare.rate.service.impl;

import org.mushare.rate.bean.NewsBean;
import org.mushare.rate.domain.News;
import org.mushare.rate.service.NewsManager;
import org.mushare.rate.service.common.ManagerTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsManagerImpl extends ManagerTemplate implements NewsManager {

    public String downloadNews(String title, String source, String content) {
        News news = new News();
        news.setTitle(title);
        news.setSource(source);
        news.setContent(content);
        news.setPubtime(System.currentTimeMillis() / 1000L);
        return newsDao.save(news);
    }

    public List<NewsBean> getNews(String keyword) {
        List<NewsBean> newses = new ArrayList<NewsBean>();
        for (News news: newsDao.findByKeyword(keyword)) {

        }
        return newses;
    }
}
