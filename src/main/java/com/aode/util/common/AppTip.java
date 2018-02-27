package com.aode.util.common;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public class AppTip {
    public static final int SUCCESS_STATUS = 1;
    public static final int FAIL_STATUS = 0;
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String TIP_INSERT_SUCCESS = "msg.insert.success";
    public static final String TIP_UPDATE_SUCCESS = "msg.update.success";
    public static final String TIP_SELECT_SUCCESS = "msg.select.success";
    public static final String TIP_DELETE_SUCCESS = "msg.delete.success";
    public static final String TIP_DELETE_ERROR = "msg.delete.error";
    public static final String TIP_SELECT_ERROR = "msg.select.error";
    public static final String TIP_UPDATE_ERROR = "msg.update.error";
    public static final String TIP_INSERT_ERROR = "msg.insert.error";

    public AppTip() {
    }

    public interface Code {
        String CHECK_PARAM_EX_CODE = "CLOUD_0000100";
        String CHECK_IDTENFIFY_EX_CODE = "CLOUD_0000101";
        String CHECK_MOBILE_CODE_ERROR = "CLOUD_0000102";
        String CHECK_IMEI_CODE_ERROR = "CLOUD_0000103";
        String CLASS_NOT_FOUNT_EX_CODE = "CLOUD_0000102";
        String CLASS_PASSWORD_ERROR_EX_CODE = "CLOUD_0000103";
    }
}

