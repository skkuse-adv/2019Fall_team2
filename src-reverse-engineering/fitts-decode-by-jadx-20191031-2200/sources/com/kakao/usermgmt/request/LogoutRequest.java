package com.kakao.usermgmt.request;

import android.net.Uri.Builder;
import com.kakao.auth.network.AuthorizedApiRequest;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;

public class LogoutRequest extends AuthorizedApiRequest {
    public String getMethod() {
        return HttpRequest.METHOD_POST;
    }

    public Builder getUriBuilder() {
        return super.getUriBuilder().path(ServerProtocol.USER_LOGOUT_PATH);
    }
}
