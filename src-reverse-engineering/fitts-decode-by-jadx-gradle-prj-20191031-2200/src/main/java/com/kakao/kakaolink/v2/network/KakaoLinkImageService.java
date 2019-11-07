package com.kakao.kakaolink.v2.network;

import android.content.Context;
import com.kakao.common.KakaoContextService;
import com.kakao.network.IRequest;
import java.io.File;

public interface KakaoLinkImageService {

    public static class Factory {
        public static KakaoLinkImageService getInstance() {
            return new DefaultKakaoLinkImageService(KakaoContextService.getInstance());
        }
    }

    IRequest imageDeleteRequestWithToken(Context context, String str);

    IRequest imageDeleteRequestWithUrl(Context context, String str);

    IRequest imageScrapRequest(Context context, String str, boolean z);

    IRequest imageUploadRequest(Context context, File file, boolean z);
}
