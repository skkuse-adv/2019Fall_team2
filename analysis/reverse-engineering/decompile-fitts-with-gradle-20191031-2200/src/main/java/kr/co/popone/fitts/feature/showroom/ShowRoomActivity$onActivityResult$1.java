package kr.co.popone.fitts.feature.showroom;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.user.UserAPI.ResponseImageId;
import org.jetbrains.annotations.NotNull;

final class ShowRoomActivity$onActivityResult$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$onActivityResult$1(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    @NotNull
    public final Single<String> apply(@NotNull ResponseImageId responseImageId) {
        Intrinsics.checkParameterIsNotNull(responseImageId, "response");
        return this.this$0.getUserAPI$app_productionFittsRelease().uploadShowroomImage(responseImageId.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
