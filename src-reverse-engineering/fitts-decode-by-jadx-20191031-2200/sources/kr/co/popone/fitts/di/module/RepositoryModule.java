package kr.co.popone.fitts.di.module;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.api.FittsCommerceApi;
import kr.co.popone.fitts.model.api.FittsServiceApi;
import kr.co.popone.fitts.model.api.FittsSocialApi;
import kr.co.popone.fitts.model.cart.CartAPI;
import kr.co.popone.fitts.model.category.CategoryAPI;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.product.ProductAPI;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApi;
import kr.co.popone.fitts.model.remote.refund.RefundApi;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepositoryImpl;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepositoryImpl;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepositoryImpl;
import kr.co.popone.fitts.model.search.RealSearchHistoryRepository;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.model.store.StoreAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.CategoryRepository;
import kr.co.popone.fitts.repository.CouponRepository;
import kr.co.popone.fitts.repository.ExchangeRepository;
import kr.co.popone.fitts.repository.PostRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.SearchRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.repository.home.HomeRepository;
import org.jetbrains.annotations.NotNull;

public final class RepositoryModule {
    @NotNull
    public final SearchHistoryRepository provideAllSearchHistoryRepository(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new RealSearchHistoryRepository(context, "search_history");
    }

    @NotNull
    public final SearchHistoryRepository provideShopSearchHistoryRepository(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new RealSearchHistoryRepository(context, "shop_search_history");
    }

    @NotNull
    public final HomeRepository provideHomeRepository(@NotNull UserAPI userAPI, @NotNull SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(userAPI, "userAPI");
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        return new HomeRepository(userAPI, sessionManager);
    }

    @NotNull
    public final CategoryRepository provideCategorySearchRepository(@NotNull CategoryAPI categoryAPI) {
        Intrinsics.checkParameterIsNotNull(categoryAPI, "categoryAPI");
        return new CategoryRepository(categoryAPI);
    }

    @NotNull
    public final CartRepository provideCartRepository(@NotNull CartAPI cartAPI) {
        Intrinsics.checkParameterIsNotNull(cartAPI, "cartAPI");
        return new CartRepository(cartAPI);
    }

    @NotNull
    public final ProductRepository provideProductRepository(@NotNull ProductAPI productAPI) {
        Intrinsics.checkParameterIsNotNull(productAPI, "productAPI");
        return new ProductRepository(productAPI);
    }

    @NotNull
    public final CouponRepository provideCouponRepository(@NotNull CouponAPI couponAPI) {
        Intrinsics.checkParameterIsNotNull(couponAPI, "couponAPI");
        return new CouponRepository(couponAPI);
    }

    @NotNull
    public final SearchRepository provideSearchRepository(@NotNull SearchAPI searchAPI) {
        Intrinsics.checkParameterIsNotNull(searchAPI, "searchAPI");
        return new SearchRepository(searchAPI);
    }

    @NotNull
    public final RefundRepository provideRefundRepository(@NotNull RefundApi refundApi) {
        Intrinsics.checkParameterIsNotNull(refundApi, "refundApi");
        return new RefundRepository(refundApi);
    }

    @NotNull
    public final ExchangeRepository provideExchangeRepository(@NotNull ExchangeApi exchangeApi) {
        Intrinsics.checkParameterIsNotNull(exchangeApi, "exchangeApi");
        return new ExchangeRepository(exchangeApi);
    }

    @NotNull
    public final UserRepository provideUserRepository(@NotNull UserAPI userAPI) {
        Intrinsics.checkParameterIsNotNull(userAPI, "userAPI");
        return new UserRepository(userAPI);
    }

    @NotNull
    public final PostRepository providePostRepository(@NotNull PostAPI postAPI) {
        Intrinsics.checkParameterIsNotNull(postAPI, "postAPI");
        return new PostRepository(postAPI);
    }

    @NotNull
    public final StoreRepository provideStoreRepository(@NotNull StoreAPI storeAPI) {
        Intrinsics.checkParameterIsNotNull(storeAPI, "storeAPI");
        return new StoreRepository(storeAPI);
    }

    @NotNull
    public final FittsServiceRepository provideFittsServiceRepository(@NotNull FittsServiceApi fittsServiceApi) {
        Intrinsics.checkParameterIsNotNull(fittsServiceApi, "fittsServiceApi");
        return new FittsServiceRepositoryImpl(fittsServiceApi);
    }

    @NotNull
    public final FittsCommerceRepository provideFittsCommerceRepository(@NotNull FittsCommerceApi fittsCommerceApi) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceApi, "fittsCommerceApi");
        return new FittsCommerceRepositoryImpl(fittsCommerceApi);
    }

    @NotNull
    public final FittsSocialRepository provideFittsSocialRepository(@NotNull FittsSocialApi fittsSocialApi) {
        Intrinsics.checkParameterIsNotNull(fittsSocialApi, "fittsSocialApi");
        return new FittsSocialRepositoryImpl(fittsSocialApi);
    }
}
