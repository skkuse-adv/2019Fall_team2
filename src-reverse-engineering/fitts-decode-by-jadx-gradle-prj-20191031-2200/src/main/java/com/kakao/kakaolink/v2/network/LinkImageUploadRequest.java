package com.kakao.kakaolink.v2.network;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.ServerProtocol;
import com.kakao.network.storage.ImageUploadRequest;
import java.io.File;

class LinkImageUploadRequest extends ImageUploadRequest {
    LinkImageUploadRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, Boolean bool, File file) {
        super(phaseInfo, iConfiguration, bool, file);
    }

    public Builder getUriBuilder() {
        Builder uriBuilder = super.getUriBuilder();
        uriBuilder.path(ServerProtocol.LINK_IMAGE_UPLOAD_PATH);
        return uriBuilder;
    }
}
