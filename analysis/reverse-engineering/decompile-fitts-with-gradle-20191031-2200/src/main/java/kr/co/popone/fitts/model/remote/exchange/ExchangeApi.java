package kr.co.popone.fitts.model.remote.exchange;

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

public interface ExchangeApi {
    @NotNull
    @DELETE("api/v9/order_line_item_variants/{variant_id}/exchanges/{exchange_id}")
    @Headers({"Accept: application/json"})
    Completable deleteExchange(@Path("variant_id") long j, @Path("exchange_id") long j2);

    @NotNull
    @GET("api/v9/order_line_item_variants/{variant_id}/exchanges/{exchange_id}")
    @Headers({"Accept: application/json"})
    Single<ExchangeApplyResponse> getExchange(@Path("variant_id") long j, @Path("exchange_id") long j2);

    @FormUrlEncoded
    @NotNull
    @POST("api/v9/order_line_item_variants/{variant_id}/exchanges")
    @Headers({"Accept: application/json"})
    Single<ExchangeApplyResponse> postExchange(@Path("variant_id") long j, @Field("quantity") int i, @NotNull @Field("exchange_wish_option") String str, @Field("bank_account_holder") @Nullable String str2, @Field("bank_account_number") @Nullable String str3, @Field("bank_name") @Nullable String str4, @NotNull @Field("reason") String str5, @NotNull @Field("detail_reason") String str6);

    @NotNull
    @POST("api/v9/order_line_item_variants/{variant_id}/pre_exchange_data")
    @Headers({"Accept: application/json"})
    Single<PreExchageResponse> postPreExchangeData(@Path("variant_id") long j);
}
