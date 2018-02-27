package com.aode.Exception;

/**
 * Created by moutian on 2017/6/27 0027.
 */
public class BaseException extends Exception {
    private static final long serialVersionUID = -8041558356166466863L;

    public BaseException() {
    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

