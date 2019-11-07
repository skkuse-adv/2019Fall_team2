package com.kakao.auth;

import androidx.annotation.Nullable;

public interface ISessionConfig {
    @Nullable
    ApprovalType getApprovalType();

    AuthType[] getAuthTypes();

    @Deprecated
    boolean isSaveFormData();

    boolean isSecureMode();

    boolean isUsingWebviewTimer();
}
