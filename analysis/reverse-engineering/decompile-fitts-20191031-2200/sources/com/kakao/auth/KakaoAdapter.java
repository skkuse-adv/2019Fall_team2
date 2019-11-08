package com.kakao.auth;

public abstract class KakaoAdapter {
    public abstract IApplicationConfig getApplicationConfig();

    public ISessionConfig getSessionConfig() {
        return new ISessionConfig() {
            public boolean isSaveFormData() {
                return true;
            }

            public boolean isSecureMode() {
                return false;
            }

            public boolean isUsingWebviewTimer() {
                return false;
            }

            public AuthType[] getAuthTypes() {
                return new AuthType[]{AuthType.KAKAO_LOGIN_ALL};
            }

            public ApprovalType getApprovalType() {
                return ApprovalType.INDIVIDUAL;
            }
        };
    }

    public IPushConfig getPushConfig() {
        return new IPushConfig() {
            public String getDeviceUUID() {
                return null;
            }

            public ApiResponseCallback<Integer> getTokenRegisterCallback() {
                return null;
            }
        };
    }
}
