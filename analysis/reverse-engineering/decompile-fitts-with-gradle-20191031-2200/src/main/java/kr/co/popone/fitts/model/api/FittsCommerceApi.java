package kr.co.popone.fitts.model.api;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem;
import kr.co.popone.fitts.model.datamodel.commerce.wish.WishProduct;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import kr.co.popone.fitts.model.order.OrderDetailListItem;
import kr.co.popone.fitts.model.order.OrderListItem;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FittsCommerceApi {
    @NotNull
    @DELETE("/api/v9/orders/{id}")
    @Headers({"Accept: application/json"})
    Completable deleteOrderLineItem(@Path("id") long j);

    @NotNull
    @DELETE("/api/v9/wish_lists")
    @Headers({"Accept: application/json"})
    Completable deleteWishProduct(@Query("product_id") long j);

    @NotNull
    @GET("/api/v9/coupons/available_coupons")
    @Headers({"Accept: application/json"})
    Single<List<CouponInfo>> getAvailableCoupons();

    @NotNull
    @GET("/api/v9/orders/{id}")
    @Headers({"Accept: application/json"})
    Single<OrderDetailListItem> getOrderLineItem(@Path("id") long j);

    @NotNull
    @GET("/api/v9/orders")
    @Headers({"Accept: application/json"})
    Single<List<OrderListItem>> getOrderLineItemList(@Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/orders/receivable_points")
    @Headers({"Accept: application/json"})
    Single<ExpectedReceivablePoint> getReceivableFittsPoints(@Field("order_id") long j, @Field("from_cart") boolean z);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/orders/receivable_points")
    @Headers({"Accept: application/json"})
    Single<ExpectedReceivablePoint> getReceivableFittsPoints(@Field("variants") @Nullable String str, @Field("type") @Nullable String str2, @Field("type_id") @Nullable Long l, @Field("fitts_point") @Nullable Integer num, @Field("coupon_id") @Nullable Long l2, @Field("membership_id") @Nullable Long l3, @Field("from_cart") boolean z);

    @NotNull
    @GET("/api/v9/wish_lists/check")
    @Headers({"Accept: application/json"})
    Observable<WishProduct> getWishProductCheckById(@Query("product_id") long j);

    @NotNull
    @GET("/api/v9/wish_lists")
    @Headers({"Accept: application/json"})
    Single<List<Product>> getWishProducts(@Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/orders/total_price")
    @Headers({"Accept: application/json"})
    Single<ProductLineItem> postOrderTotalPrice(@NotNull @Field("variants") String str, @Field("membership_id") long j, @NotNull @Field("from_type") String str2);

    @NotNull
    @PUT("/api/v9/wish_lists")
    @Headers({"Accept: application/json"})
    Completable putWishProduct(@Query("product_id") long j);
}
