package org.mushare.rate.controller;

import org.mushare.rate.controller.util.ResponseTool;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
@RequestMapping("/api/news")
public class NewsController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getNewsList() {
        return ResponseTool.generateOK(new HashMap<String, Object>(){{
            put("success", true);
        }});
    }

}
