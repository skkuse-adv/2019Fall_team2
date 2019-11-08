package com.kakao.kakaolink.v2.network;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.ServerProtocol;
import com.kakao.network.storage.ImageDeleteRequest;

class LinkImageDeleteRequest extends ImageDeleteRequest {
    LinkImageDeleteRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, String str2) {
        super(phaseInfo, iConfiguration, str, str2);
    }

    public Builder getUriBuilder() {
        Builder uriBuilder = super.getUriBuilder();
        uriBuilder.path(ServerProtocol.LINK_IMAGE_DELETE_PATH);
        return uriBuilder;
    }
}
