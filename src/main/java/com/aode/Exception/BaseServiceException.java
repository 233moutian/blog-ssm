//package com.aode.Exception;
//
///**
// * Created by moutian on 2017/6/27 0027.
// */
//
//public class BaseServiceException extends com.tools.exception.BaseException {
//    private String code;
//    private String[] args;
//    private static final long serialVersionUID = -8041558356166466863L;
//
//    public BaseServiceException() {
//    }
//
//    public BaseServiceException(Throwable throwable) {
//        super(throwable);
//    }
//
//    public BaseServiceException(String message) {
//        super(message);
//    }
//
//    public BaseServiceException(String message, Throwable throwable) {
//        super(message, throwable);
//    }
//
//    public BaseServiceException(String code, String message) {
//        super(message);
//        this.code = code;
//    }
//
//    public BaseServiceException(String code, String message, String[] args) {
//        super(message);
//        this.code = code;
//        this.args = args;
//    }
//
//    public BaseServiceException(String code, String message, String[] args, Throwable throwable) {
//        super(message, throwable);
//        this.code = code;
//        this.args = args;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String[] getArgs() {
//        return this.args;
//    }
//
//    public void setArgs(String[] args) {
//        this.args = args;
//    }
//}