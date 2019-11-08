package kr.co.popone.fitts.viewmodel.exchange.detail;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApplyResponse;
import kr.co.popone.fitts.repository.ExchangeRepository;
import org.jetbrains.annotations.NotNull;

public final class ExchangeDetailViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<Unit> cancelCompleteLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    private final MutableLiveData<ExchangeApplyResponse> exchangeInfoLiveData = new MutableLiveData<>();
    private final ExchangeRepository exchangeRepository;
    private Function0<Long> getExchnageId;
    private Function0<Long> getOrderLineItemVariantId;
    private MutableLiveData<String> paymentMethodLiveData = new MutableLiveData<>();

    public ExchangeDetailViewModel(@NotNull ExchangeRepository exchangeRepository2) {
        Intrinsics.checkParameterIsNotNull(exchangeRepository2, "exchangeRepository");
        this.exchangeRepository = exchangeRepository2;
    }

    @NotNull
    public final MutableLiveData<ExchangeApplyResponse> getExchangeInfoLiveData() {
        return this.exchangeInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getCancelCompleteLiveData() {
        return this.cancelCompleteLiveData;
    }

    public final void getExchangeDetailInfo(long j, long j2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "paymentMethod");
        this.getOrderLineItemVariantId = new ExchangeDetailViewModel$getExchangeDetailInfo$1(j);
        this.getExchnageId = new ExchangeDetailViewModel$getExchangeDetailInfo$2(j2);
        this.paymentMethodLiveData.setValue(str);
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = this.exchangeRepository.requestExchangeDetailInfo(j, j2).subscribe(new ExchangeDetailViewModel$getExchangeDetailInfo$3(this), new ExchangeDetailViewModel$getExchangeDetailInfo$4(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "exchangeRepository.reque…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void cancelExchange() {
        CompositeDisposable compositeDisposable = this.disposable;
        ExchangeRepository exchangeRepository2 = this.exchangeRepository;
        Function0<Long> function0 = this.getOrderLineItemVariantId;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getOrderLineItemVariantId");
        }
        long longValue = ((Number) function0.invoke()).longValue();
        Function0<Long> function02 = this.getExchnageId;
        if (function02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getExchnageId");
        }
        Disposable subscribe = exchangeRepository2.requestExchangeCancel(longValue, ((Number) function02.invoke()).longValue()).subscribe(new ExchangeDetailViewModel$cancelExchange$1(this), new ExchangeDetailViewModel$cancelExchange$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "exchangeRepository.reque…e = it\n                })");
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
