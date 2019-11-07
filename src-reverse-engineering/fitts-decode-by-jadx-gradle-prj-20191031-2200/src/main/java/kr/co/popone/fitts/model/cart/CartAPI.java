package kr.co.popone.fitts.model.cart;

import io.reactivex.Completable;
import io.reactivex.Single;
import kr.co.popone.fitts.model.order.OrderDetailListItem;
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

public interface CartAPI {
    @NotNull
    @DELETE("/api/v9/carts/line_item_variants/{id}")
    @Headers({"Accept: application/json"})
    Single<CartLineItemEntity> deleteCartLineItemVariants(@Path("id") long j);

    @NotNull
    @GET("/api/v9/carts")
    @Headers({"Accept: application/json"})
    Single<CartLineItemEntity> getCartLineItems();

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/carts/total_price")
    @Headers({"Accept: application/json"})
    Single<CartPriceItemEntity> postCartLineItemVariantsTotalPrice(@NotNull @Field("variants") String str);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/carts/order")
    @Headers({"Accept: application/json"})
    Single<OrderDetailListItem> postOrderCartLineItemVariants(@NotNull @Field("variants") String str, @NotNull @Field("name") String str2, @NotNull @Field("contact") String str3, @Field("email") @Nullable String str4, @NotNull @Field("shipping_name") String str5, @NotNull @Field("shipping_contact") String str6, @NotNull @Field("shipping_zipcode") String str7, @NotNull @Field("shipping_address") String str8, @NotNull @Field("shipping_address2") String str9, @Field("shipping_message") @Nullable String str10, @Field("multiple_adjustment_type") @Nullable String str11, @Field("multiple_adjustment_price") @Nullable Integer num, @Field("coupon_id") @Nullable Long l, @Field("membership_id") @Nullable Long l2, @Field("bank_id") @Nullable Long l3, @Field("remittor_name") @Nullable String str12, @Field("tax_deduction_type") @Nullable String str13, @Field("tax_deduction_number") @Nullable String str14);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/carts/line_item_variants")
    @Headers({"Accept: application/json"})
    Completable putCartLineItemVariants(@NotNull @Field("variants") String str, @Field("post_id") @Nullable Long l);

    @PUT("/api/v9/carts/line_item_variants/{id}")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<CartLineItemEntity> putCartLineItemsVariants(@Path("id") long j, @Query("quantity") int i);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/carts/pre_order_data")
    @Headers({"Accept: application/json"})
    Single<CartOrderableItem> putPreOrderableItems(@NotNull @Field("variants") String str);
}
