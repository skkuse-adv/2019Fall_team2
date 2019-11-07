package com.kakao.kakaolink.v2.network;

import android.content.Context;
import com.kakao.common.KakaoContextService;
import com.kakao.network.IRequest;
import java.io.File;

class DefaultKakaoLinkImageService implements KakaoLinkImageService {
    private KakaoContextService contextService;

    DefaultKakaoLinkImageService(KakaoContextService kakaoContextService) {
        this.contextService = kakaoContextService;
    }

    public IRequest imageUploadRequest(Context context, File file, boolean z) {
        this.contextService.initialize(context);
        return new LinkImageUploadRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), Boolean.valueOf(z), file);
    }

    public IRequest imageScrapRequest(Context context, String str, boolean z) {
        this.contextService.initialize(context);
        return new LinkImageScrapRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), str, Boolean.valueOf(z));
    }

    public IRequest imageDeleteRequestWithUrl(Context context, String str) {
        this.contextService.initialize(context);
        return new LinkImageDeleteRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), str, null);
    }

    public IRequest imageDeleteRequestWithToken(Context context, String str) {
        this.contextService.initialize(context);
        return new LinkImageDeleteRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), null, str);
    }
}
