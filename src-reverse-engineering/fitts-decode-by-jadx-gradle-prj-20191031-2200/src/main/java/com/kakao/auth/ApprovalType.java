package com.kakao.auth;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum ApprovalType {
    INDIVIDUAL,
    PROJECT;
    
    private static final Map<String, ApprovalType> REVERSE_MAP = null;

    static {
        int i;
        ApprovalType[] values;
        REVERSE_MAP = new HashMap();
        for (ApprovalType approvalType : values()) {
            REVERSE_MAP.put(approvalType.toString(), approvalType);
        }
    }

    public String toString() {
        return super.toString().toLowerCase(Locale.ROOT);
    }

    public static ApprovalType getApprovalTypeByString(String str) throws InvalidParameterException {
        if (str == null) {
            return null;
        }
        ApprovalType approvalType = (ApprovalType) REVERSE_MAP.get(str);
        if (approvalType != null) {
            return approvalType;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ApprovalType is one of ");
        sb.append(Arrays.toString(values()));
        throw new InvalidParameterException(sb.toString());
    }
}
