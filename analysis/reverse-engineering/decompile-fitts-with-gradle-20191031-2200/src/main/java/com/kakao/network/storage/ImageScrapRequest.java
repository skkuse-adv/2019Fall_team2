package com.kakao.network.storage;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.ApiRequest;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;

public class ImageScrapRequest extends ApiRequest {
    private String imageUrl;
    private Boolean secureResource;

    public String getMethod() {
        return HttpRequest.METHOD_POST;
    }

    protected ImageScrapRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, Boolean bool) {
        super(phaseInfo, iConfiguration);
        this.imageUrl = str;
        this.secureResource = bool;
    }

    public Builder getUriBuilder() {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(ServerProtocol.apiAuthority());
        if (this.secureResource.booleanValue()) {
            builder.appendQueryParameter("secure_resource", String.valueOf(this.secureResource));
        }
        String str = this.imageUrl;
        if (str != null) {
            builder.appendQueryParameter("image_url", str);
        }
        return builder;
    }
}
