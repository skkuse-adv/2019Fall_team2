package kr.co.popone.fitts.model.api;

import io.reactivex.Single;
import java.util.List;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FittsSocialApi {
    @NotNull
    @GET("api/v9/home_feeds")
    @Headers({"Accept: application/json"})
    Single<FeedInfo> getHomeFeeds(@NotNull @Query("type") String str, @Nullable @Query("version") String str2, @Nullable @Query("base") Long l, @Query("limit") int i);

    @NotNull
    @GET("/api/v9/users/me/memberships")
    @Headers({"Accept: application/json"})
    Single<List<Membership>> getMemberships();

    @NotNull
    @GET("/api/v9/personalized_recommends/{id}")
    @Headers({"Accept: application/json"})
    Single<PersonalRecommendation> getPersonalizedRecommends(@Path("id") int i);

    @NotNull
    @GET("api/v9/trend_detail")
    @Headers({"Accept: application/json"})
    Single<FeedInfo> getTrendDetail(@Query("id") long j, @NotNull @Query("type") String str);
}
