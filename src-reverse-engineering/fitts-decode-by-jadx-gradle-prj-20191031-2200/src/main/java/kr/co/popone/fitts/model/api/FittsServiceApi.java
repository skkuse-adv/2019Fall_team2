package kr.co.popone.fitts.model.api;

import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import kr.co.popone.fitts.model.datamodel.service.app.AppInfo;
import kr.co.popone.fitts.model.datamodel.service.app.Version;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.datamodel.service.banner.NewBannerCount;
import kr.co.popone.fitts.model.datamodel.service.promotion.Promotion;
import kr.co.popone.fitts.model.datamodel.service.web.OpenWeb;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FittsServiceApi {
    @NotNull
    @GET("/api/v9/activities")
    @Headers({"Accept: application/json"})
    Single<List<Alarm>> getActivities(@Nullable @Query("base") Long l, @Query("limit") int i);

    @NotNull
    @GET("/api/v9/appinfo")
    @Headers({"Accept: application/json"})
    Single<AppInfo> getAppInformation();

    @NotNull
    @GET("/api/v9/versions/check?os=android")
    @Headers({"Accept: application/json"})
    Single<Version> getAppVersion(@NotNull @Query("version") String str);

    @NotNull
    @GET("/api/v9/banners/badge")
    @Headers({"Accept: application/json"})
    Single<NewBannerCount> getBannerBadge(@NotNull @Query("type") String str, @Query("timestamp") int i);

    @NotNull
    @GET("/api/v9/banners")
    @Headers({"Accept: application/json"})
    Single<List<Banner>> getBannerList(@NotNull @Query("type") String str);

    @NotNull
    @GET("/api/v9/recommendations/fitties")
    @Headers({"Accept: application/json"})
    Single<List<RecommendFittie>> getFittieRecommendation(@Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/fitts_webs/{id}")
    @Headers({"Accept: application/json"})
    Single<OpenWeb> getFittsWebById(@Path("id") long j);

    @NotNull
    @GET("/api/v9/promotions")
    @Headers({"Accept: application/json"})
    Single<Promotion> getPromotions(@NotNull @Query("path") String str, @Nullable @Query("is_new_user") Boolean bool);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/feedbacks")
    @Headers({"Accept: application/json"})
    Completable postFeedbacks(@NotNull @Field("description") String str);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/action_logs")
    @Headers({"Accept: application/json"})
    Completable postFittsActionLogs(@Field("type") @Nullable String str, @Field("main_path") @Nullable String str2, @Field("sub_path") @Nullable String str3, @Field("from_id") @Nullable Long l, @Field("target_id") @Nullable Long l2, @Field("scheme") @Nullable String str4);

    @NotNull
    @PUT("/api/v9/activities/touch")
    @Headers({"Accept: application/json"})
    Completable putActivitiesTouch();

    @NotNull
    @PUT("/api/v9/notifications/{id}/feedback")
    @Headers({"Accept: application/json"})
    Completable putNotificationFeedback(@Path("id") long j);
}
