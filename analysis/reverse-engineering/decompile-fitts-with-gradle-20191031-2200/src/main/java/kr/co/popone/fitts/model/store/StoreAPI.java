package kr.co.popone.fitts.model.store;

import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StoreAPI {
    @NotNull
    @DELETE("/api/v9/store_shop_favorites")
    @Headers({"Accept: application/json"})
    Completable deleteShopBookmark(@Query("store_shop_id") long j);

    @NotNull
    @GET("/api/v9/store_shop_favorites")
    @Headers({"Accept: application/json"})
    Single<List<StoreInfo>> getShopBookmarkList(@Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/store_shops/{id}")
    @Headers({"Accept: application/json"})
    Single<StoreInfo> getShopInfo(@Path("id") long j);

    @NotNull
    @GET("/api/v9/special_discount_events")
    @Headers({"Accept: application/json"})
    Single<SpecialDiscountInfo> getSpecialDiscountEvents();

    @NotNull
    @GET("/api/v9/store_home_feeds")
    @Headers({"Accept: application/json"})
    Single<FeedInfo> getStoreHomeFeeds(@NotNull @Query("type") String str, @Nullable @Query("version") String str2, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/store_shops/{id}/products")
    @Headers({"Accept: application/json"})
    Single<List<Product>> getStoreProducts(@Path("id") long j, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @POST("/api/v9/store_shop_favorites")
    @Headers({"Accept: application/json"})
    Completable postShopBookmark(@Query("store_shop_id") long j);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/store_shops/shop_info")
    @Headers({"Accept: application/json"})
    Single<StoreInfo> postStoreInfo(@NotNull @Field("url") String str);
}
