package com.kakao.auth;

import android.util.SparseArray;
import com.kakao.network.ApiErrorCode;

@Deprecated
public enum ErrorCode {
    AUTH_ERROR_CODE(ApiErrorCode.AUTH_ERROR_CODE),
    CLIENT_ERROR_CODE(-777),
    UNDEFINED_ERROR_CODE(ApiErrorCode.UNDEFINED_ERROR_CODE),
    INTERNAL_ERROR_CODE(-1),
    INVALID_PARAM_CODE(-2),
    NOT_SUPPORTED_API_CODE(-3),
    BLOCKED_ACTION_CODE(-4),
    ACCESS_DENIED_CODE(-5),
    EXCEED_LIMIT_CODE(-10),
    NOT_REGISTERED_USER_CODE(ApiErrorCode.NOT_REGISTERED_USER_CODE),
    ALREADY_REGISTERED_USER_CODE(ApiErrorCode.ALREADY_REGISTERED_USER_CODE),
    NOT_EXIST_KAKAO_ACCOUNT_CODE(ApiErrorCode.NOT_EXIST_KAKAO_ACCOUNT_CODE),
    NOT_REGISTERED_PROPERTY_KEY_CODE(com.kakao.usermgmt.ApiErrorCode.NOT_REGISTERED_PROPERTY_KEY_CODE),
    NOT_EXIST_APP_CODE(ApiErrorCode.NOT_EXIST_APP_CODE),
    NOT_EXIST_APP_CATEGORY_CODE(-302),
    INVALID_TOKEN_CODE(ApiErrorCode.INVALID_TOKEN_CODE),
    INVALID_SCOPE_CODE(ApiErrorCode.INVALID_SCOPE_CODE),
    NOT_REGISTERED_ORIGIN_CODE(ApiErrorCode.NOT_REGISTERED_ORIGIN_CODE),
    NEED_TO_AGE_AUTHENTICATION(ApiErrorCode.NEED_TO_AGE_AUTHENTICATION),
    UNDER_AGE_LIMIT(ApiErrorCode.UNDER_AGE_LIMIT),
    NOT_EXIST_KAKAOTALK_USER_CODE(-501),
    NOT_SUPPORTED_OS(-504),
    MSG_DISABLED(-530),
    MSG_SENDER_RECEIVER_MONTHLY(-531),
    MSG_SENDER_DAILY(-532),
    NOT_EXIST_KAKAOSTORY_USER_CODE(-601),
    EXCEED_MAX_UPLOAD_SIZE(-602),
    EXECUTION_TIMED_OUT(ApiErrorCode.EXECUTION_TIMED_OUT),
    INVALID_STORY_SCRAP_URL(-604),
    INVALID_STORY_ACTIVITY_ID(-605),
    EXCEED_MAX_UPLOAD_NUMBER(-606),
    NOT_EXIST_DEVELOPER_CODE(-701),
    NOT_EXIST_PUSH_TOKEN(-901),
    DEVELOPER_NOT_EXISTENT_CODE(ApiErrorCode.DEVELOPER_NOT_EXISTENT_CODE),
    INVALID_FRIENDS_RESULT_ID(-904),
    KAKAO_MAINTENANCE_CODE(ApiErrorCode.KAKAO_MAINTENANCE_CODE);
    
    private static final SparseArray<ErrorCode> reverseMap = null;
    private final int errorCode;

    static {
        int i;
        ErrorCode[] values;
        reverseMap = new SparseArray<>();
        for (ErrorCode errorCode2 : values()) {
            reverseMap.put(errorCode2.getErrorCode(), errorCode2);
        }
    }

    private ErrorCode(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public static ErrorCode valueOf(Integer num) {
        if (num == null) {
            return null;
        }
        ErrorCode errorCode2 = (ErrorCode) reverseMap.get(num.intValue());
        if (errorCode2 != null) {
            return errorCode2;
        }
        return UNDEFINED_ERROR_CODE;
    }
}
