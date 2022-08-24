package com.kms.blog.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bId;

    private String bTopic;
    private String bContent;
    private LocalDateTime bTime;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "cId")
    private Category category;

    public Blog() {
    }

    public Blog(Integer bId, String bTopic, String bContent, LocalDateTime bTime, Category category) {
        this.bId = bId;
        this.bTopic = bTopic;
        this.bContent = bContent;
        this.bTime = bTime;
        this.category = category;
    }

    public Blog(Integer bId, String bTopic, String bContent, Category category) {
        this.bId = bId;
        this.bTopic = bTopic;
        this.bContent = bContent;
        this.category = category;
    }

    public LocalDateTime getbTime() {
        return bTime;
    }

    public void setbTime(LocalDateTime bTime) {
        this.bTime = bTime;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
