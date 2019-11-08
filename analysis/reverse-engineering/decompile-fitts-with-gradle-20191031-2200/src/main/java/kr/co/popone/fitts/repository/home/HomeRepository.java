package kr.co.popone.fitts.repository.home;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.datamodel.service.user.BodyFilter;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.model.user.UserAPI.BadgeCount;
import org.jetbrains.annotations.NotNull;

public final class HomeRepository {
    private final SessionManager sessionManager;
    private final UserAPI userAPI;

    public HomeRepository(@NotNull UserAPI userAPI2, @NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        this.userAPI = userAPI2;
        this.sessionManager = sessionManager2;
    }

    @NotNull
    public final Single<MyInfo> requestUserInfo() {
        Single<MyInfo> observeOn = this.userAPI.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.getUserInfo()\n  …dSchedulers.mainThread())");
        return observeOn;
    }

    public final void updateSession(@NotNull MyInfo myInfo) {
        Intrinsics.checkParameterIsNotNull(myInfo, "userInfo");
        this.sessionManager.setUserInfo(myInfo);
        SessionManager sessionManager2 = this.sessionManager;
        BodyFilter bodyFilter = myInfo.getBodyFilter();
        if (bodyFilter == null) {
            Intrinsics.throwNpe();
        }
        sessionManager2.setSimilarityBodyFilter(Integer.valueOf(bodyFilter.getMin_height()), Integer.valueOf(myInfo.getBodyFilter().getMax_height()), Integer.valueOf(myInfo.getBodyFilter().getMin_weight()), Integer.valueOf(myInfo.getBodyFilter().getMax_weight()));
    }

    @NotNull
    public final Single<BadgeCount> requestBadgeCount() {
        Single<BadgeCount> observeOn = this.userAPI.getBadgeCount().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.getBadgeCount()\n…dSchedulers.mainThread())");
        return observeOn;
    }
}
