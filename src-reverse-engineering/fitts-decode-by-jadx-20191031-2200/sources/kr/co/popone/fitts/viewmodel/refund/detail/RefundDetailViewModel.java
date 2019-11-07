package kr.co.popone.fitts.viewmodel.refund.detail;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.model.remote.refund.RefundApplyResponse;
import kr.co.popone.fitts.repository.RefundRepository;
import org.jetbrains.annotations.NotNull;

public final class RefundDetailViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<Unit> cancelCompleteLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposable = new CompositeDisposable();
    private Function0<Long> getOrderLineItemVariantId;
    private Function0<Long> getRefundId;
    private MutableLiveData<String> paymentMethodLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<RefundApplyResponse> refundInfoLiveData = new MutableLiveData<>();
    private final RefundRepository refundRepository;

    public RefundDetailViewModel(@NotNull RefundRepository refundRepository2) {
        Intrinsics.checkParameterIsNotNull(refundRepository2, "refundRepository");
        this.refundRepository = refundRepository2;
    }

    @NotNull
    public final MutableLiveData<RefundApplyResponse> getRefundInfoLiveData() {
        return this.refundInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getCancelCompleteLiveData() {
        return this.cancelCompleteLiveData;
    }

    public final void getRefundDetailInfo(long j, long j2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "paymentMethod");
        this.getOrderLineItemVariantId = new RefundDetailViewModel$getRefundDetailInfo$1(j);
        this.getRefundId = new RefundDetailViewModel$getRefundDetailInfo$2(j2);
        this.paymentMethodLiveData.setValue(str);
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = this.refundRepository.requestRefundDetailInfo(j, j2).subscribe(new RefundDetailViewModel$getRefundDetailInfo$3(this), new RefundDetailViewModel$getRefundDetailInfo$4(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "refundRepository.request…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void cancelExchange() {
        CompositeDisposable compositeDisposable = this.disposable;
        RefundRepository refundRepository2 = this.refundRepository;
        Function0<Long> function0 = this.getOrderLineItemVariantId;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getOrderLineItemVariantId");
        }
        long longValue = ((Number) function0.invoke()).longValue();
        Function0<Long> function02 = this.getRefundId;
        if (function02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getRefundId");
        }
        Disposable subscribe = refundRepository2.requestRefundCancel(longValue, ((Number) function02.invoke()).longValue()).subscribe(new RefundDetailViewModel$cancelExchange$1(this), new RefundDetailViewModel$cancelExchange$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "refundRepository.request…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final MutableLiveData<String> getPaymentMethod() {
        return this.paymentMethodLiveData;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposable.dispose();
        super.onCleared();
    }
}
