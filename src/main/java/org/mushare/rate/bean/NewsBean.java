package org.mushare.rate.bean;

import org.mushare.rate.domain.News;

public class NewsBean {

    private String nid;
    private String title;
    private String source;
    private long pubDate;
    private String link;
    private String content;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsBean(News news) {
        this.nid = news.getNid();
        this.title = news.getTitle();
        this.source = news.getSource();
        this.pubDate = news.getPubDate();
        this.link = news.getLink();
        this.content = news.getContent();
    }

}
