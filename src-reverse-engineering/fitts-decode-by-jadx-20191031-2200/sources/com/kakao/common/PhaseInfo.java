package com.kakao.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface PhaseInfo {
    @Nullable
    String appKey();

    @Nullable
    String clientSecret();

    @NonNull
    KakaoPhase phase();
}
