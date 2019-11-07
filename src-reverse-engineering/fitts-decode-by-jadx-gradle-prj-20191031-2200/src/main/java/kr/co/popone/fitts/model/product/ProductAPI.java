package kr.co.popone.fitts.model.product;

import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kr.co.popone.fitts.model.order.OrderDetailListItem;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductAPI {
    @NotNull
    @GET("/api/v9/products/{product_id}/posts")
    @Headers({"Accept: application/json"})
    Observable<List<Post>> getPostsById(@Path("product_id") long j);

    @NotNull
    @GET("/api/v9/products")
    @Headers({"Accept: application/json"})
    Single<List<Product>> getProductList(@NotNull @Query("type") String str, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/variants/{id}")
    @Headers({"Accept: application/json"})
    Single<VariantInfo> getProductVariant(@Path("id") long j);

    @NotNull
    @GET("/api/v9/products/{id}/options")
    @Headers({"Accept: application/json"})
    Observable<VariantOptionResult> getProductVariantOptions(@Path("id") long j);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/products/check_orderable")
    @Headers({"Accept: application/json"})
    Single<AffiliatesProduct> postCheckOrderableProduct(@NotNull @Field("url") String str, @Field("post_id") @Nullable Long l, @NotNull @Field("type") String str2, @Field("type_id") @Nullable Long l2);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/products/order")
    @Headers({"Accept: application/json"})
    Single<OrderDetailListItem> postOrderProductVariants(@NotNull @Field("variants") String str, @NotNull @Field("name") String str2, @NotNull @Field("contact") String str3, @Field("email") @Nullable String str4, @NotNull @Field("shipping_name") String str5, @NotNull @Field("shipping_contact") String str6, @NotNull @Field("shipping_zipcode") String str7, @NotNull @Field("shipping_address") String str8, @NotNull @Field("shipping_address2") String str9, @Field("shipping_message") @Nullable String str10, @Field("multiple_adjustment_type") @Nullable String str11, @Field("multiple_adjustment_price") @Nullable Integer num, @Field("coupon_id") @Nullable Long l, @Field("membership_id") @Nullable Long l2, @Field("bank_id") @Nullable Long l3, @Field("remittor_name") @Nullable String str12, @Field("tax_deduction_type") @Nullable String str13, @Field("tax_deduction_number") @Nullable String str14, @Field("post_id") @Nullable Long l4, @NotNull @Field("type") String str15, @Field("type_id") @Nullable Long l5);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/products/pre_order_data")
    @Headers({"Accept: application/json"})
    Single<ProductOrderableItem> postProductPreOrderData(@NotNull @Field("variants") String str, @NotNull @Field("type") String str2, @Field("type_id") @Nullable Long l);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/variants/total_price")
    @Headers({"Accept: application/json"})
    Single<VariantTotalPrice> postProductVariantsTotalPrice(@NotNull @Field("variants") String str, @NotNull @Field("type") String str2, @Field("type_id") @Nullable Long l);
}
