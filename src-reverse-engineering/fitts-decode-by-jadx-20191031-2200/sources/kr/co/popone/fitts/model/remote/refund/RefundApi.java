package kr.co.popone.fitts.model.remote.refund;

import io.reactivex.Completable;
import io.reactivex.Single;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RefundApi {
    @NotNull
    @DELETE("api/v9/order_line_item_variants/{variant_id}/refunds/{refund_id}")
    @Headers({"Accept: application/json"})
    Completable deleteRefund(@Path("variant_id") long j, @Path("refund_id") long j2);

    @NotNull
    @GET("api/v9/order_line_item_variants/{variant_id}/refunds/{refund_id}")
    @Headers({"Accept: application/json"})
    Single<RefundApplyResponse> getRefund(@Path("variant_id") long j, @Path("refund_id") long j2);

    @NotNull
    @POST("api/v9/order_line_item_variants/{variant_id}/pre_refund_data")
    @Headers({"Accept: application/json"})
    Single<PreRefundResponse> postPreRefundData(@Path("variant_id") long j);

    @FormUrlEncoded
    @NotNull
    @POST("api/v9/order_line_item_variants/{variant_id}/refunds")
    @Headers({"Accept: application/json"})
    Single<RefundApplyResponse> postRefund(@Path("variant_id") long j, @Field("quantity") int i, @Field("bank_account_holder") @Nullable String str, @Field("bank_account_number") @Nullable String str2, @Field("bank_name") @Nullable String str3, @NotNull @Field("reason") String str4, @NotNull @Field("detail_reason") String str5);
}
