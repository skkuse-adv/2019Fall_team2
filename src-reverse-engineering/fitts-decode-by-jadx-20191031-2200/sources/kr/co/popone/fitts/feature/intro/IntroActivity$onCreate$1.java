package kr.co.popone.fitts.feature.intro;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;

public final class IntroActivity$onCreate$1 implements FacebookCallback<LoginResult> {
    final /* synthetic */ IntroActivity this$0;

    IntroActivity$onCreate$1(IntroActivity introActivity) {
        this.this$0 = introActivity;
    }

    public void onSuccess(@NotNull LoginResult loginResult) {
        Intrinsics.checkParameterIsNotNull(loginResult, "loginResult");
        StringBuilder sb = new StringBuilder();
        sb.append("FacebookCallback onSuccess(");
        sb.append(loginResult);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        GraphRequest newMeRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new IntroActivity$onCreate$1$onSuccess$request$1(ref$ObjectRef, ref$ObjectRef2));
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id, email, picture.width(512).height(512)");
        Intrinsics.checkExpressionValueIsNotNull(newMeRequest, "request");
        newMeRequest.setParameters(bundle);
        newMeRequest.executeAsync();
        IntroActivity introActivity = this.this$0;
        AccessToken accessToken = loginResult.getAccessToken();
        Intrinsics.checkExpressionValueIsNotNull(accessToken, "loginResult.accessToken");
        String token = accessToken.getToken();
        Intrinsics.checkExpressionValueIsNotNull(token, "loginResult.accessToken.token");
        introActivity.requestSNSLogin("facebook", token, (String) ref$ObjectRef.element, (String) ref$ObjectRef2.element);
    }

    public void onCancel() {
        Logger.d("IntroPresenter onFacebookLoginCancel", new Object[0]);
    }

    public void onError(@NotNull FacebookException facebookException) {
        Intrinsics.checkParameterIsNotNull(facebookException, "e");
        StringBuilder sb = new StringBuilder();
        sb.append("IntroPresenter onFacebookLoginError(");
        sb.append(facebookException);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
    }
}
