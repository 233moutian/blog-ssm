package com.blog.util.common;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public enum UserStatus {
    ZERO(0, "不可用"),
    ONE(1, "可用"),
    TWO(2, "黑名单"),
    EIGHT(8, "注销"),
    NINE(9, "删除");

    private int status;
    private String value;

    private UserStatus(int status, String value) {
        this.status = status;
        this.value = value;
    }

    public static String getUserValue(int status) {
        String res = "";
        switch(status) {
            case 0:
                res = ZERO.getValue();
                break;
            case 1:
                res = ONE.getValue();
                break;
            case 2:
                res = TWO.getValue();
            case 8:
                res = EIGHT.getValue();
            case 9:
                res = NINE.getValue();
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                res = ONE.getValue();
        }

        return res;
    }

    public int getStatus() {
        return this.status;
    }

    public String getValue() {
        return this.value;
    }
}

