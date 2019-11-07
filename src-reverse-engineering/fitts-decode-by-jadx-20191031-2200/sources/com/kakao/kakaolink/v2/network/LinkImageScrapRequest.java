package com.kakao.kakaolink.v2.network;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.ServerProtocol;
import com.kakao.network.storage.ImageScrapRequest;

class LinkImageScrapRequest extends ImageScrapRequest {
    LinkImageScrapRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, Boolean bool) {
        super(phaseInfo, iConfiguration, str, bool);
    }

    public Builder getUriBuilder() {
        Builder uriBuilder = super.getUriBuilder();
        uriBuilder.path(ServerProtocol.LINK_IMAGE_SCRAP_PATH);
        return uriBuilder;
    }
}
