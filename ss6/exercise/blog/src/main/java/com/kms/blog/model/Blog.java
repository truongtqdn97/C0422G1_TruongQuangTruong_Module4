package com.kms.blog.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bId;

    private String bTopic;
    private String bContent;

    public Blog() {
    }

    public Blog(Integer bId, String bTopic, String bContent) {
        this.bId = bId;
        this.bTopic = bTopic;
        this.bContent = bContent;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbTopic() {
        return bTopic;
    }

    public void setbTopic(String bTopic) {
        this.bTopic = bTopic;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }
}
