package org.mushare.rate.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rate_feedback")
public class Feedback {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fdid;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private Integer type;

    @Column(name = "contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    public void setFdid(String fdid) {
        this.fdid = fdid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
