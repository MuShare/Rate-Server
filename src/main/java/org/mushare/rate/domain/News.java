package org.mushare.rate.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rate_news")
public class News implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String nid;

    @Column(nullable = false)
    private String title;

    @Column
    private String source;

    @Column(nullable = false)
    private Long pubtime;

    @Column
    private String link;

    @Column
    private String lan;

    @Column
    private String cover;

    @Column(nullable = false, columnDefinition = "TEXT")
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

    public Long getPubtime() {
        return pubtime;
    }

    public void setPubtime(Long pubtime) {
        this.pubtime = pubtime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
