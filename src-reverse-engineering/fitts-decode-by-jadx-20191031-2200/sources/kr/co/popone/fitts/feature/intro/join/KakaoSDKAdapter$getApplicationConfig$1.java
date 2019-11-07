package kr.co.popone.fitts.feature.intro.join;

import android.content.Context;
import com.kakao.auth.IApplicationConfig;
import org.jetbrains.annotations.NotNull;

final class KakaoSDKAdapter$getApplicationConfig$1 implements IApplicationConfig {
    final /* synthetic */ KakaoSDKAdapter this$0;

    KakaoSDKAdapter$getApplicationConfig$1(KakaoSDKAdapter kakaoSDKAdapter) {
        this.this$0 = kakaoSDKAdapter;
    }

    @NotNull
    public final Context getApplicationContext() {
        return this.this$0.mContext;
    }
}
