package com.kakao.util;

public class KakaoParameterException extends Exception {
    private static final long serialVersionUID = 4539740978213889048L;
    private ERROR_CODE code = ERROR_CODE.UNKNOWN;

    public enum ERROR_CODE {
        UNKNOWN,
        CORE_PARAMETER_MISSING,
        MINIMUM_IMAGE_SIZE_REQUIRED,
        DUPLICATE_OBJECTS_USED,
        UNSUPPORTED_ENCODING,
        JSON_PARSING_ERROR,
        NOT_EXIST_IMAGE
    }

    public ERROR_CODE getCode() {
        return this.code;
    }

    public String getMessage() {
        if (this.code == null) {
            return super.getMessage();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.code);
        sb.append(":");
        sb.append(super.getMessage());
        return sb.toString();
    }

    public KakaoParameterException(String str) {
        super(str);
    }

    public KakaoParameterException(ERROR_CODE error_code, String str) {
        super(str);
        this.code = error_code;
    }

    public KakaoParameterException(ERROR_CODE error_code, Exception exc) {
        super(exc);
        this.code = error_code;
    }
}
