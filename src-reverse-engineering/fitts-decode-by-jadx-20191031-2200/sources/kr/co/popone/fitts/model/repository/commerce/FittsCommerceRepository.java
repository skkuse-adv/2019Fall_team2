package kr.co.popone.fitts.model.repository.commerce;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.commerce.order.OrderDiscountInfo;
import kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.order.OrderListViewData;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FittsCommerceRepository {
    @NotNull
    Completable addWishProduct(long j);

    @NotNull
    Single<ProductLineItem> calculateMembershipPrice(@NotNull String str, long j, @NotNull String str2);

    @NotNull
    Observable<Boolean> checkWishProductById(long j);

    @NotNull
    Completable deleteOrderLineItem(long j);

    @NotNull
    Completable deleteWishProduct(long j);

    @NotNull
    Single<List<CouponInfo>> getAvailableCoupons(int i);

    @NotNull
    Single<ExpectedReceivablePoint> getExpectedReceivableFittsPoint(long j);

    @NotNull
    Single<ExpectedReceivablePoint> getExpectedReceivableFittsPoint(@NotNull OrderDiscountInfo orderDiscountInfo);

    @NotNull
    Single<OrderDetailViewData> getOrderLineItem(long j);

    @NotNull
    Single<List<OrderListViewData>> getOrderLineItemList(@Nullable Long l, @Nullable Integer num);

    @NotNull
    Single<List<ProductFeedViewData>> getWishProducts(@Nullable Long l, @Nullable Integer num);
}
