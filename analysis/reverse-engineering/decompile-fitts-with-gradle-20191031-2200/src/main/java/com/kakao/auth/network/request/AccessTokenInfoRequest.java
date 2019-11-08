package com.kakao.auth.network.request;

import android.net.Uri.Builder;
import com.kakao.auth.network.AuthorizedApiRequest;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;

public class AccessTokenInfoRequest extends AuthorizedApiRequest {
    public String getMethod() {
        return HttpRequest.METHOD_GET;
    }

    public Builder getUriBuilder() {
        return super.getUriBuilder().path(ServerProtocol.USER_ACCESS_TOKEN_INFO_PATH);
    }
}
