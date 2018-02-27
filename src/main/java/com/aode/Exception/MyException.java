package com.aode.Exception;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public class MyException extends Exception {
    private static final long serialVersionUID = 3627645256433923779L;
    private String errorCode;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
