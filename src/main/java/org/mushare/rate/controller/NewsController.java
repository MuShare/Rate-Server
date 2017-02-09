package org.mushare.rate.controller;

import org.mushare.rate.bean.NewsBean;
import org.mushare.rate.controller.util.ControllerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/api/news")
public class NewsController extends ControllerTemplate {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getNewsList(String keyword) {
        if (keyword == null) {
            keyword = "";
        }
        final List<NewsBean> newses = newsManager.getNews(keyword);
        return generateOK(new HashMap<String, Object>(){{
            put("result", newses);
        }});
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addNews(@RequestParam String title, @RequestParam String source, @RequestParam String content) {
        final String nid = newsManager.downloadNews(title, source, content);
        return generateOK(new HashMap<String, Object>(){{
            put("nid", nid);
        }});
    }
}
