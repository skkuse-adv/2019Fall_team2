package kr.co.popone.fitts.model.repository.service;

import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
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

public interface FittsServiceRepository {

    public static final class DefaultImpls {
        @NotNull
        public static /* synthetic */ Single getPromotions$default(FittsServiceRepository fittsServiceRepository, String str, Boolean bool, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    bool = null;
                }
                return fittsServiceRepository.getPromotions(str, bool);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPromotions");
        }
    }

    @NotNull
    Single<Version> checkAppVersion(@NotNull String str);

    @NotNull
    Single<List<Alarm>> getActivities(@Nullable Long l, int i);

    @NotNull
    Single<AppInfo> getAppInformation();

    @NotNull
    Single<NewBannerCount> getBannerBadgeCount(@NotNull String str, int i);

    @NotNull
    Single<List<Banner>> getBanners(@NotNull String str);

    @NotNull
    Single<List<RecommendFittie>> getFittieRecommendation(@Nullable Long l, @Nullable Integer num);

    @NotNull
    Single<OpenWeb> getFittsWebInfo(long j);

    @NotNull
    Single<Promotion> getPromotions(@NotNull String str, @Nullable Boolean bool);

    @NotNull
    Completable postFeedbacks(@NotNull String str);

    @NotNull
    Completable postFittsActionLog(@NotNull ActionLog actionLog);

    @NotNull
    Completable updateActivitiesTouch();

    @NotNull
    Completable updateNotificationFeedback(long j);
}
