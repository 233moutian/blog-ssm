package com.blog.model.POJO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by moutian on 2018/2/28 0028.
 */
@Table(name = "blog_blog")
public class Blog {
    @Id
    private String blogId;
    private Long adminId;
    private String title;
    private String summary;
    private Date releaseDate;
    private Integer clickHit;
    private Integer replyHit;
    private String content;
    private Date createTime;
    private Date updateTime;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
