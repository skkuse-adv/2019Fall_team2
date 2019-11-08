package kr.co.popone.fitts.feature.intro.join;

import android.content.Context;
import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.KakaoAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class KakaoSDKAdapter extends KakaoAdapter {
    /* access modifiers changed from: private */
    public Context mContext;

    public KakaoSDKAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        this.mContext = context;
    }

    @NotNull
    public ISessionConfig getSessionConfig() {
        return new KakaoSDKAdapter$getSessionConfig$1();
    }

    @NotNull
    public IApplicationConfig getApplicationConfig() {
        return new KakaoSDKAdapter$getApplicationConfig$1(this);
    }
}
