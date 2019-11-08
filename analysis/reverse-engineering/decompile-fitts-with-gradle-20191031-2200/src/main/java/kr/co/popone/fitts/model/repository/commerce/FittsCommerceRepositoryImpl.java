package kr.co.popone.fitts.model.repository.commerce;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.api.FittsCommerceApi;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.commerce.order.OrderDiscountInfo;
import kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.order.OrderListViewData;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittsCommerceRepositoryImpl implements FittsCommerceRepository {
    private final FittsCommerceApi commerceApi;

    public FittsCommerceRepositoryImpl(@NotNull FittsCommerceApi fittsCommerceApi) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceApi, "commerceApi");
        this.commerceApi = fittsCommerceApi;
    }

    @NotNull
    public Single<List<ProductFeedViewData>> getWishProducts(@Nullable Long l, @Nullable Integer num) {
        Single<List<ProductFeedViewData>> observeOn = this.commerceApi.getWishProducts(l, num).subscribeOn(Schedulers.io()).map(FittsCommerceRepositoryImpl$getWishProducts$1.INSTANCE).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.getWishProdu…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Completable addWishProduct(long j) {
        Completable observeOn = this.commerceApi.putWishProduct(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.putWishProdu…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Completable deleteWishProduct(long j) {
        Completable observeOn = this.commerceApi.deleteWishProduct(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.deleteWishPr…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Observable<Boolean> checkWishProductById(long j) {
        Observable<Boolean> observeOn = this.commerceApi.getWishProductCheckById(j).subscribeOn(Schedulers.io()).map(FittsCommerceRepositoryImpl$checkWishProductById$1.INSTANCE).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.getWishProdu…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<List<CouponInfo>> getAvailableCoupons(int i) {
        Single<List<CouponInfo>> observeOn = this.commerceApi.getAvailableCoupons().subscribeOn(Schedulers.io()).map(new FittsCommerceRepositoryImpl$getAvailableCoupons$1(i)).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.getAvailable…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<ProductLineItem> calculateMembershipPrice(@NotNull String str, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Single<ProductLineItem> observeOn = this.commerceApi.postOrderTotalPrice(str, j, str2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.postOrderTot…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<OrderDetailViewData> getOrderLineItem(long j) {
        Single<OrderDetailViewData> map = this.commerceApi.getOrderLineItem(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(FittsCommerceRepositoryImpl$getOrderLineItem$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "commerceApi.getOrderLine…wData()\n                }");
        return map;
    }

    @NotNull
    public Completable deleteOrderLineItem(long j) {
        Completable observeOn = this.commerceApi.deleteOrderLineItem(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.deleteOrderL…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<List<OrderListViewData>> getOrderLineItemList(@Nullable Long l, @Nullable Integer num) {
        Single<List<OrderListViewData>> map = this.commerceApi.getOrderLineItemList(l, num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(FittsCommerceRepositoryImpl$getOrderLineItemList$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "commerceApi.getOrderLine…t.mapToOrderListItems() }");
        return map;
    }

    @NotNull
    public Single<ExpectedReceivablePoint> getExpectedReceivableFittsPoint(@NotNull OrderDiscountInfo orderDiscountInfo) {
        Intrinsics.checkParameterIsNotNull(orderDiscountInfo, "orderDiscountInfo");
        Single<ExpectedReceivablePoint> observeOn = this.commerceApi.getReceivableFittsPoints(orderDiscountInfo.getVariantJson(), orderDiscountInfo.getSpecialDiscountType(), orderDiscountInfo.getSpecialDiscountId(), orderDiscountInfo.getFittsPoint(), orderDiscountInfo.getCouponId(), orderDiscountInfo.getMembershipId(), orderDiscountInfo.isFromCart()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.getReceivabl…dSchedulers.mainThread())");
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "orderDiscountInfo.run {\n…s.mainThread())\n        }");
        return observeOn;
    }

    @NotNull
    public Single<ExpectedReceivablePoint> getExpectedReceivableFittsPoint(long j) {
        Single<ExpectedReceivablePoint> observeOn = this.commerceApi.getReceivableFittsPoints(j, false).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "commerceApi.getReceivabl…dSchedulers.mainThread())");
        return observeOn;
    }
}
