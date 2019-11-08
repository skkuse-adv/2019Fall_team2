package kr.co.popone.fitts.di.module;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.api.FittsCommerceApi;
import kr.co.popone.fitts.model.api.FittsServiceApi;
import kr.co.popone.fitts.model.api.FittsSocialApi;
import kr.co.popone.fitts.model.cart.CartAPI;
import kr.co.popone.fitts.model.category.CategoryAPI;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.product.ProductAPI;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApi;
import kr.co.popone.fitts.model.remote.refund.RefundApi;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.store.StoreAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

public final class ServiceModule {
    @NotNull
    public final SearchAPI provideSearchAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(SearchAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(SearchAPI::class.java)");
        return (SearchAPI) create;
    }

    @NotNull
    public final UserAPI provideUserAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(UserAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(UserAPI::class.java)");
        return (UserAPI) create;
    }

    @NotNull
    public final PostAPI providePostAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(PostAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(PostAPI::class.java)");
        return (PostAPI) create;
    }

    @NotNull
    public final CollectionAPI provideCollectionAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(CollectionAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(CollectionAPI::class.java)");
        return (CollectionAPI) create;
    }

    @NotNull
    public final EventAPI provideEventAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(EventAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(EventAPI::class.java)");
        return (EventAPI) create;
    }

    @NotNull
    public final CouponAPI provideCouponAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(CouponAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(CouponAPI::class.java)");
        return (CouponAPI) create;
    }

    @NotNull
    public final ActionLogAPI provideActionLogAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(ActionLogAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(ActionLogAPI::class.java)");
        return (ActionLogAPI) create;
    }

    @NotNull
    public final PaymentAPI providePaymentAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(PaymentAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(PaymentAPI::class.java)");
        return (PaymentAPI) create;
    }

    @NotNull
    public final CategoryAPI provideCategoryAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(CategoryAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(CategoryAPI::class.java)");
        return (CategoryAPI) create;
    }

    @NotNull
    public final ProductAPI provideProductAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(ProductAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(ProductAPI::class.java)");
        return (ProductAPI) create;
    }

    @NotNull
    public final StoreAPI provideStoreAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(StoreAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(StoreAPI::class.java)");
        return (StoreAPI) create;
    }

    @NotNull
    public final CartAPI provideCartAPI(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(CartAPI.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(CartAPI::class.java)");
        return (CartAPI) create;
    }

    @NotNull
    public final FittsServiceApi provideFittsServiceApi(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(FittsServiceApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(FittsServiceApi::class.java)");
        return (FittsServiceApi) create;
    }

    @NotNull
    public final FittsCommerceApi provideFittsCommerceApi(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(FittsCommerceApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(FittsCommerceApi::class.java)");
        return (FittsCommerceApi) create;
    }

    @NotNull
    public final FittsSocialApi provideFittsSocialApi(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(FittsSocialApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(FittsSocialApi::class.java)");
        return (FittsSocialApi) create;
    }

    @NotNull
    public final ExchangeApi provideExchangeApi(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(ExchangeApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(ExchangeApi::class.java)");
        return (ExchangeApi) create;
    }

    @NotNull
    public final RefundApi provideRefundApi(@NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(RefundApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(RefundApi::class.java)");
        return (RefundApi) create;
    }
}
