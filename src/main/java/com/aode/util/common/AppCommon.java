package com.aode.util.common;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public class AppCommon {
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    public static final String USER_PASSWORD = "userPassword";
    public static final String ADMIN_USER = "adminUser";
    public static final String ADMIN_USER_ID = "adminUserId";
    public static String LAST_REQUEST_URL = "lastRequestUrl";
    public static String CONEXT_PATH = "contextPath";
    public static String ROOT_PATH = "rootPath";
    public static final int AVAILALBE_STATUS = 1;
    public static final int UNAVAILABLE_STATUS = 0;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final String RETURN_DATA_TYPE_XML = "xml";
    public static final String RETURN_DATA_TYPE_JSON = "json";
    public static final String FORMAT_XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    public static final String FORMAT_XML_CHARACTER_1 = "<";
    public static final String FORMAT_XML_CHARACTER_2 = ">";
    public static final String FORMAT_XML_CHARACTER_3 = "/";
    public static final String IDENTIFY_CODE = "identifyCode";

    public AppCommon() {
    }

    public interface Kafka {
        String LOG4J_TOPIC_LOGGER = "logger";
        String LOG4J_TOPIC_DEBUG = "loggerDeg";
        String LOG4J_TOPIC_INFO = "loggerInfo";
        String LOG4J_TOPIC_ERROR = "loggerError";
    }

    public interface Mobile {
        int VM_DEFAULT_EXPIRE = 3600;
        int VM_STATUS_UNCHECK = 1;
        int VM_STATUS_CHECKED = 2;
        int VM_TYPE_PASSWORK_BACK = 1;
        int VM_TYPE_ACCOUNT_APPLICATION = 2;
        int VM_TYPE_LOGIN_AUTHENTICATION = 3;
        int VM_TYPE_LOGIN_TO_VERIFY = 4;
        int VM_IMPROVE_DATA_VALIDATION = 5;
        int TS_CODE_FAILED_TO_SEND = 0;
        int TS_CODE_SUCC = 200;
        int TS_CODE_ACC_OR_PWD_ERR = 301;
        int TS_CODE_ACC_SPOTED = 302;
        int TS_CODE_BALANCE_INSUFF = 303;
        int TS_CODE_NUM_EMPTY_OR_SEND_MAX = 304;
        int TS_CODE_DATA_AUTH_ERR = 305;
        int TS_CODE_CONTENT_EMPTY_OR_TOO_LONG = 306;
        int TS_CODE_EXPAN_CODE_NOT_CORRECT = 307;
        int TS_CODE_BATCH_NUM_TOO_LONG = 308;
        int TS_CODE_CONTAIN_SEN_WORDS = 309;
        int TS_CODE_NON_TEMPLATE_CONTENT = 310;
        int TS_CODE_TIME_OUT = 998;
        int TS_CODE_UNKNOWN_ERR = 999;
    }

    public interface TX {
        String TX_APPID = "wxa56ffaf12219c6eb";
        String TX_MCHID = "1277596901";
    }

    public interface User {
        int GENDER_MALE = 1;
        int GENDER_FEMALE = 2;
        int GENDER_OTHER = 3;
        int USER_TYPE_USER = 1;
        int USER_TYPE_DOCTOR = 2;
        int USER_TYPE_OTHER = 3;
        int USER_STATUS_UNAVAILABLE = 0;
        int USER_STATUS_AVAIABLE = 1;
        int USER_STATUS_LOCK = 2;
        int USER_STATUS_BLACK = 3;
        String USER_PASSWORD_INIT = "123456";
        int USER_CARD_TYPE_ID = 1;
        int USER_CARD_TYPE_RESIDENCE = 2;
        int USER_CARD_TYPE_VISA = 3;
        int USER_CARD_TYPE_PASSPORT = 4;
        int USER_CARD_TYPE_ACCOUNT = 5;
        int USER_CARD_TYPE_HKMPASS = 6;
        int USER_REG_TYPE_WEB = 1;
        int USER_REG_TYPE_ANDORID = 2;
        int USER_REG_TYPE_IOS = 3;
        int USER_REG_TYPE_ALI = 4;
        int USER_REG_TYPE_WX = 5;
        int USER_REG_TYPE_ORTHER = 6;
    }
}

