package kr.co.popone.fitts.viewmodel.order.detail;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiConsumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderDetailViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<Unit> cancelCompleteLiveData = new MutableLiveData<>();
    private final FittsCommerceRepository commerceRepository;
    private final CreatePostActivityUtil createPostActivityUtil;
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final MutableLiveData<OrderDetailViewData> orderDetailLiveData = new MutableLiveData<>();
    @Nullable
    private Long orderId;

    public OrderDetailViewModel(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull CreatePostActivityUtil createPostActivityUtil2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(createPostActivityUtil2, "createPostActivityUtil");
        this.commerceRepository = fittsCommerceRepository;
        this.createPostActivityUtil = createPostActivityUtil2;
    }

    @NotNull
    public final MutableLiveData<OrderDetailViewData> getOrderDetailLiveData() {
        return this.orderDetailLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getCancelCompleteLiveData() {
        return this.cancelCompleteLiveData;
    }

    @Nullable
    public final Long getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(@Nullable Long l) {
        this.orderId = l;
    }

    public final void initDetailOrderId(@NotNull Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        long longValue = ((Number) function0.invoke()).longValue();
        this.commerceRepository.getOrderLineItem(longValue).subscribe((BiConsumer<? super T, ? super Throwable>) new OrderDetailViewModel$initDetailOrderId$$inlined$run$lambda$1<Object,Object>(this));
        this.orderId = Long.valueOf(longValue);
    }

    public final void getPaymentMethod(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        OrderDetailViewData orderDetailViewData = (OrderDetailViewData) this.orderDetailLiveData.getValue();
        function1.invoke(orderDetailViewData != null ? orderDetailViewData.getPaymentMethod() : null);
    }

    public final void cancelOrder() {
        Long l = this.orderId;
        if (l != null) {
            this.commerceRepository.deleteOrderLineItem(l.longValue()).subscribe(new OrderDetailViewModel$cancelOrder$$inlined$let$lambda$1(this), new OrderDetailViewModel$cancelOrder$$inlined$let$lambda$2(this));
        }
    }

    public final void startCreatePost(@NotNull Activity activity, @NotNull PostType postType, @NotNull PostVariantViewData postVariantViewData, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(postType, "postType");
        Intrinsics.checkParameterIsNotNull(postVariantViewData, "postVariantViewData");
        Intrinsics.checkParameterIsNotNull(str, "from");
        this.createPostActivityUtil.startCreatePostActivity(activity, postType, postVariantViewData, str);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.createPostActivityUtil.clear();
        this.disposables.dispose();
        super.onCleared();
    }
}
