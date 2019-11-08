package kr.co.popone.fitts.model.repository.service;

import com.facebook.internal.ServerProtocol;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.api.FittsServiceApi;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import kr.co.popone.fitts.model.datamodel.service.app.AppInfo;
import kr.co.popone.fitts.model.datamodel.service.app.Version;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.datamodel.service.banner.NewBannerCount;
import kr.co.popone.fitts.model.datamodel.service.log.ActionLog;
import kr.co.popone.fitts.model.datamodel.service.promotion.Promotion;
import kr.co.popone.fitts.model.datamodel.service.web.OpenWeb;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittsServiceRepositoryImpl implements FittsServiceRepository {
    private final FittsServiceApi fittsServiceApi;

    public FittsServiceRepositoryImpl(@NotNull FittsServiceApi fittsServiceApi2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceApi2, "fittsServiceApi");
        this.fittsServiceApi = fittsServiceApi2;
    }

    @NotNull
    public Single<List<Alarm>> getActivities(@Nullable Long l, int i) {
        Single<List<Alarm>> observeOn = this.fittsServiceApi.getActivities(l, i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.getActiv…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Completable updateActivitiesTouch() {
        Completable observeOn = this.fittsServiceApi.putActivitiesTouch().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.putActiv…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<AppInfo> getAppInformation() {
        Single<AppInfo> observeOn = this.fittsServiceApi.getAppInformation().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.getAppIn…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<Version> checkAppVersion(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        Single<Version> observeOn = this.fittsServiceApi.getAppVersion(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.getAppVe…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Completable postFittsActionLog(@NotNull ActionLog actionLog) {
        Intrinsics.checkParameterIsNotNull(actionLog, "log");
        Completable observeOn = this.fittsServiceApi.postFittsActionLogs(actionLog.getType(), actionLog.getPath(), actionLog.getSubPath(), actionLog.getFrom(), actionLog.getTarget(), actionLog.getScheme()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.postFitt…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<List<Banner>> getBanners(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Single<List<Banner>> observeOn = this.fittsServiceApi.getBannerList(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.getBanne…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<NewBannerCount> getBannerBadgeCount(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Single<NewBannerCount> observeOn = this.fittsServiceApi.getBannerBadge(str, i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.getBanne…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Completable postFeedbacks(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Completable observeOn = this.fittsServiceApi.postFeedbacks(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.postFeed…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Completable updateNotificationFeedback(long j) {
        Completable observeOn = this.fittsServiceApi.putNotificationFeedback(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.putNotif…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<Promotion> getPromotions(@NotNull String str, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        Single<Promotion> observeOn = this.fittsServiceApi.getPromotions(str, bool).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.getPromo…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<List<RecommendFittie>> getFittieRecommendation(@Nullable Long l, @Nullable Integer num) {
        Single<List<RecommendFittie>> observeOn = this.fittsServiceApi.getFittieRecommendation(l, num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.getFitti…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<OpenWeb> getFittsWebInfo(long j) {
        Single<OpenWeb> observeOn = this.fittsServiceApi.getFittsWebById(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "fittsServiceApi.getFitts…dSchedulers.mainThread())");
        return observeOn;
    }
}
