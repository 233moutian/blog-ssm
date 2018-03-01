package com.blog.model.POJO;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by moutian on 2018/2/28 0028.
 */
@Table(name = "blog_blog")
public class Blog {
    @Id
    private String bId;
    private Long aId;
    private String title;
    private String summary;
    private Date releaseDate;
    private int  clickDit;
    private int replyHit;
    private String content;
    private Date createTime;
    private Date updatetime;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
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

    public int getClickDit() {
        return clickDit;
    }

    public void setClickDit(int clickDit) {
        this.clickDit = clickDit;
    }

    public int getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(int replyHit) {
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
