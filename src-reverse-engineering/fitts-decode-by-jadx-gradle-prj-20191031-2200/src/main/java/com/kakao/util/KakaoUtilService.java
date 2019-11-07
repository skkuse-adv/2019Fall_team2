package com.kakao.util;

import android.content.Context;
import android.content.Intent;

public interface KakaoUtilService {

    public static class Factory {
        private static KakaoUtilService instance = new DefaultKakaoUtilService();

        private Factory() {
        }

        public static KakaoUtilService getInstance() {
            return instance;
        }
    }

    Intent resolveIntent(Context context, Intent intent, int i);
}
