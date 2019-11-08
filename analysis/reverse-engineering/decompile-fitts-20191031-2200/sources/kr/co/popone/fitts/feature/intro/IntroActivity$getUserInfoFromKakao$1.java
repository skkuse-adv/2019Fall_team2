package kr.co.popone.fitts.feature.intro;

import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.orhanobut.logger.Logger;
import org.jetbrains.annotations.Nullable;

public final class IntroActivity$getUserInfoFromKakao$1 extends MeV2ResponseCallback {
    final /* synthetic */ IntroActivity this$0;

    IntroActivity$getUserInfoFromKakao$1(IntroActivity introActivity) {
        this.this$0 = introActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(@org.jetbrains.annotations.Nullable com.kakao.usermgmt.response.MeV2Response r5) {
        /*
            r4 = this;
            kr.co.popone.fitts.feature.intro.IntroActivity r0 = r4.this$0
            com.kakao.auth.Session r1 = com.kakao.auth.Session.getCurrentSession()
            java.lang.String r2 = "Session.getCurrentSession()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            com.kakao.auth.authorization.accesstoken.AccessToken r1 = r1.getTokenInfo()
            java.lang.String r2 = "Session.getCurrentSession().tokenInfo"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.String r1 = r1.getAccessToken()
            java.lang.String r2 = "Session.getCurrentSession().tokenInfo.accessToken"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r2 = 0
            if (r5 == 0) goto L_0x002b
            com.kakao.usermgmt.response.model.UserAccount r3 = r5.getKakaoAccount()
            if (r3 == 0) goto L_0x002b
            java.lang.String r3 = r3.getEmail()
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            if (r5 == 0) goto L_0x0032
            java.lang.String r2 = r5.getProfileImagePath()
        L_0x0032:
            java.lang.String r5 = "kakao"
            r0.requestSNSLogin(r5, r1, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.intro.IntroActivity$getUserInfoFromKakao$1.onSuccess(com.kakao.usermgmt.response.MeV2Response):void");
    }

    public void onSessionClosed(@Nullable ErrorResult errorResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("onKakaoSessionOpened requestMe errorResult(");
        sb.append(errorResult);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
    }
}
