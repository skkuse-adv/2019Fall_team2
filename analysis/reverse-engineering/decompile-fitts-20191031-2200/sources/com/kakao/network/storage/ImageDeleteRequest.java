package com.kakao.network.storage;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.ApiRequest;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;

public class ImageDeleteRequest extends ApiRequest {
    protected final String IMAGE_TOKEN = "image_token";
    protected final String IMAGE_URL = "image_url";
    private String imageToken;
    private String imageUrl;

    public String getMethod() {
        return HttpRequest.METHOD_DELETE;
    }

    public ImageDeleteRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, String str2) {
        super(phaseInfo, iConfiguration);
        this.imageUrl = str;
        this.imageToken = str2;
    }

    public Builder getUriBuilder() {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(ServerProtocol.apiAuthority());
        String str = this.imageUrl;
        if (str != null) {
            builder.appendQueryParameter("image_url", str);
        }
        String str2 = this.imageToken;
        if (str2 != null) {
            builder.appendQueryParameter("image_token", str2);
        }
        return builder;
    }
}
