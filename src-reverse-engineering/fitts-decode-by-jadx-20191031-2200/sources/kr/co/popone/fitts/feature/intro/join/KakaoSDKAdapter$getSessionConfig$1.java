package kr.co.popone.fitts.feature.intro.join;

import com.kakao.auth.ApprovalType;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionConfig;
import org.jetbrains.annotations.NotNull;

public final class KakaoSDKAdapter$getSessionConfig$1 implements ISessionConfig {
    public boolean isSaveFormData() {
        return true;
    }

    public boolean isSecureMode() {
        return false;
    }

    public boolean isUsingWebviewTimer() {
        return false;
    }

    KakaoSDKAdapter$getSessionConfig$1() {
    }

    @NotNull
    public AuthType[] getAuthTypes() {
        return new AuthType[]{AuthType.KAKAO_LOGIN_ALL};
    }

    @NotNull
    public ApprovalType getApprovalType() {
        return ApprovalType.INDIVIDUAL;
    }
}
