package kr.co.popone.fitts.feature.intro;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.user.UserAPI.Me;
import org.jetbrains.annotations.NotNull;

final class IntroActivity$requestSNSLogin$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ IntroActivity this$0;

    IntroActivity$requestSNSLogin$1(IntroActivity introActivity) {
        this.this$0 = introActivity;
    }

    @NotNull
    public final Single<MyInfo> apply(@NotNull Me me2) {
        Intrinsics.checkParameterIsNotNull(me2, "<name for destructuring parameter 0>");
        long component1 = me2.component1();
        this.this$0.getSessionManager$app_productionFittsRelease().successLogin(me2.component2(), me2.component3(), component1);
        return this.this$0.getUserAPI$app_productionFittsRelease().getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
