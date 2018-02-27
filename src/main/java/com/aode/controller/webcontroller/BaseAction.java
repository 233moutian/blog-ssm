package com.aode.controller.webcontroller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public class BaseAction {
    protected int pageNo;
    protected int pageSize;
    private Integer defaultPageSize = Integer.valueOf(10);
    private Integer defaultPageNo = Integer.valueOf(1);
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;

    public BaseAction() {
    }

    public int getPageNo() {
        return (this.getCurrentPageNo().intValue() - 1) * this.getCurrentPageSize().intValue();
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.getCurrentPageSize().intValue();
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getDefaultPageSize() {
        return this.defaultPageSize;
    }

    public void setDefaultPageSize(Integer defaultPageSize) {
        this.defaultPageSize = defaultPageSize;
    }

    public Integer getDefaultPageNo() {
        return this.defaultPageNo;
    }

    public void setDefaultPageNo(Integer defaultPageNo) {
        this.defaultPageNo = defaultPageNo;
    }

    private Integer getCurrentPageNo() {
        String currentpageNo = this.request.getParameter("pageNo");
        if(StringUtils.isBlank(currentpageNo)) {
            this.pageNo = this.defaultPageNo.intValue();
        } else {
            this.pageNo = Integer.valueOf(currentpageNo).intValue();
            if(this.pageNo <= 0) {
                this.pageNo = this.defaultPageNo.intValue();
            }
        }

        return Integer.valueOf(this.pageNo);
    }

    private Integer getCurrentPageSize() {
        String currentPageSize = this.request.getParameter("pageSize");
        if(StringUtils.isBlank(currentPageSize)) {
            this.pageSize = this.defaultPageSize.intValue();
        } else {
            this.pageSize = Integer.valueOf(currentPageSize).intValue();
            if(this.pageSize <= 0) {
                this.pageSize = this.defaultPageSize.intValue();
            }
        }

        return Integer.valueOf(this.pageSize);
    }

    protected Integer getPageCount(Integer count) {
        Integer pageCount = Integer.valueOf(0);
        if(count.intValue() % this.pageSize == 0) {
            pageCount = Integer.valueOf(count.intValue() / this.pageSize);
        } else {
            pageCount = Integer.valueOf(count.intValue() / this.pageSize + 1);
        }

        return pageCount;
    }
}
