package kr.co.popone.fitts.feature.setting;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class SettingActivity$logoutWithFirebaseToken$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$logoutWithFirebaseToken$1(SettingActivity settingActivity) {
        this.this$0 = settingActivity;
    }

    @NotNull
    public final Single<String> apply(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        return this.this$0.getUserAPI$app_productionFittsRelease().logout().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
