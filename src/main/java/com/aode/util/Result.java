package com.aode.util;

import java.util.List;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public class Result {
    private int code;
    private String message;
    private String messageCode;
    private String desc;
    private Object obj;
    private List<?> data;
    private int totalCount;
    private int pageNo;
    private int pageSize;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String messageCode, String message) {
        this.code = code;
        this.messageCode = messageCode;
        this.message = message;
    }

    public Result(int code, String messageCode, String message, String desc) {
        this.code = code;
        this.messageCode = messageCode;
        this.message = message;
        this.desc = desc;
    }

    public Result(Object obj, Integer code) {
        this.obj = obj;
        this.code = code.intValue();
    }

    public Result(Object obj, Integer code, String message) {
        this.obj = obj;
        this.code = code.intValue();
        this.message = message;
    }

    public Result(List<?> list, int totalCount, int pageNo, int pageSize, int code, String message) {
        this.data = list;
        this.totalCount = totalCount;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageCode() {
        return this.messageCode;
    }

    public String getDesc() {
        return this.desc;
    }

    public Object getObj() {
        return this.obj;
    }

    public List<?> getData() {
        return this.data;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo <= 0?1:pageNo / this.pageSize + 1;
    }
}
