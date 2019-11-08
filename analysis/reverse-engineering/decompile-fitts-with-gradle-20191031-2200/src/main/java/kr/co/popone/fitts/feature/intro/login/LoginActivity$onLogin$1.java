package kr.co.popone.fitts.feature.intro.login;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.user.UserAPI.Me;
import org.jetbrains.annotations.NotNull;

final class LoginActivity$onLogin$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onLogin$1(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    @NotNull
    public final Single<MyInfo> apply(@NotNull Me me2) {
        Intrinsics.checkParameterIsNotNull(me2, "user");
        this.this$0.loginRequest = null;
        this.this$0.getSessionManager$app_productionFittsRelease().successLogin(me2.getFittsid(), me2.getAuth_token(), me2.getId());
        return this.this$0.getUserAPI$app_productionFittsRelease().getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
