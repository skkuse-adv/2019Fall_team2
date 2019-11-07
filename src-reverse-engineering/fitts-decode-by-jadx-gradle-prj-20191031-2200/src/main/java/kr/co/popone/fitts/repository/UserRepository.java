package kr.co.popone.fitts.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.datamodel.social.point.PointInfo;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class UserRepository {
    private final UserAPI userAPI;

    public UserRepository(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        this.userAPI = userAPI2;
    }

    @NotNull
    public final Single<PointInfo> getFittsPointInfo() {
        Single<PointInfo> observeOn = this.userAPI.rewardPoints().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.rewardPoints()\n …dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<RefundAccount> getUserRefundAccountInfo() {
        Single<RefundAccount> observeOn = this.userAPI.getRefundAccounts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.getRefundAccount…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<RefundAccount> postUserRefundAccountInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "accountHolder");
        Intrinsics.checkParameterIsNotNull(str2, "accountNumber");
        Intrinsics.checkParameterIsNotNull(str3, "bankName");
        Single<RefundAccount> observeOn = this.userAPI.postRefundAccounts(str, str2, str3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.postRefundAccoun…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<UserResponse$NCommerceResponse> getNCommerceInfo() {
        Single<UserResponse$NCommerceResponse> observeOn = this.userAPI.getNCommerceInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.getNCommerceInfo…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<MyInfo> getUserInfo() {
        Single<MyInfo> observeOn = this.userAPI.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.getUserInfo()\n  …dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<FollowResult> putUserFollow(long j) {
        Single<FollowResult> observeOn = this.userAPI.putFollow(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.putFollow(userId…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<FollowResult> deleteUserFollow(long j) {
        Single<FollowResult> observeOn = this.userAPI.deleteFollow(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.deleteFollow(use…dSchedulers.mainThread())");
        return observeOn;
    }
}
