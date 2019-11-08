package kr.co.popone.fitts.viewmodel.order.complete;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderCompleteRenderViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<ExpectedReceivablePoint> _expectedReceivablePoint = new MutableLiveData<>();
    private final FittsCommerceRepository commerceRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public Function0<Long> getOrderId;
    @NotNull
    private final MutableLiveData<OrderDetailViewData> orderDetailViewDataLiveData = new MutableLiveData<>();
    private final FittsSchemeHandler schemeHandler;

    public OrderCompleteRenderViewModel(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.commerceRepository = fittsCommerceRepository;
        this.schemeHandler = fittsSchemeHandler;
    }

    @NotNull
    public final MutableLiveData<OrderDetailViewData> getOrderDetailViewDataLiveData() {
        return this.orderDetailViewDataLiveData;
    }

    @NotNull
    public final Function0<Long> getGetOrderId() {
        Function0<Long> function0 = this.getOrderId;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getOrderId");
        }
        return function0;
    }

    public final void setGetOrderId(@NotNull Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.getOrderId = function0;
    }

    @NotNull
    public final MutableLiveData<ExpectedReceivablePoint> onExpectedReceivablePointUpdate() {
        return this._expectedReceivablePoint;
    }

    public final void getOrderLineItem(long j) {
        this.getOrderId = new OrderCompleteRenderViewModel$getOrderLineItem$1(j);
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.getOrderLineItem(j).subscribe(new OrderCompleteRenderViewModel$getOrderLineItem$2(this), new OrderCompleteRenderViewModel$getOrderLineItem$3(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.getOr…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void getExpectedReceivablePoint() {
        Function0<Long> function0 = this.getOrderId;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getOrderId");
        }
        long longValue = ((Number) function0.invoke()).longValue();
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.getExpectedReceivableFittsPoint(longValue).subscribe(new OrderCompleteRenderViewModel$getExpectedReceivablePoint$$inlined$let$lambda$1(this), new OrderCompleteRenderViewModel$getExpectedReceivablePoint$$inlined$let$lambda$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.getEx…()\n                    })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void handleScheme(@Nullable Activity activity, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        if (activity != null) {
            this.schemeHandler.handleScheme(activity, str);
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
