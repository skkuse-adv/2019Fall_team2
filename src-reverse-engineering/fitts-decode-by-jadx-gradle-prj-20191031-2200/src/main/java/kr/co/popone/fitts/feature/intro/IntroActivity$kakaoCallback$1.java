package kr.co.popone.fitts.feature.intro;

import com.kakao.auth.ISessionCallback;
import com.kakao.util.exception.KakaoException;
import com.orhanobut.logger.Logger;
import org.jetbrains.annotations.Nullable;

public final class IntroActivity$kakaoCallback$1 implements ISessionCallback {
    final /* synthetic */ IntroActivity this$0;

    IntroActivity$kakaoCallback$1(IntroActivity introActivity) {
        this.this$0 = introActivity;
    }

    public void onSessionOpenFailed(@Nullable KakaoException kakaoException) {
        StringBuilder sb = new StringBuilder();
        sb.append("onKakaoSessionOpenFailed ");
        sb.append(kakaoException);
        Logger.d(sb.toString(), new Object[0]);
    }

    public void onSessionOpened() {
        this.this$0.getUserInfoFromKakao();
    }
}
