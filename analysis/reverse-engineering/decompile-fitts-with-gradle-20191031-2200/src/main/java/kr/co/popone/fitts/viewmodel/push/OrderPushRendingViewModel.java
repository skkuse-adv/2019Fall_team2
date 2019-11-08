package kr.co.popone.fitts.viewmodel.push;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderPushRendingViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<ExpectedReceivablePoint> _expectedReceivablePoint = new MutableLiveData<>();
    private final FittsCommerceRepository commerceRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final MutableLiveData<ExchangeRefundVariant> exchangeRefundLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Unit> invalidStateLiveData = new MutableLiveData<>();
    @NotNull
    private Function0<Boolean> isVaidationCheckMode = OrderPushRendingViewModel$isVaidationCheckMode$1.INSTANCE;
    @NotNull
    private final MutableLiveData<OrderDetailViewData> orderDetailViewDataLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Unit> refundAccountInputedLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<RefundAccount> refundAccountLiveData = new MutableLiveData<>();
    private final RefundRepository refundRepository;
    private final FittsSchemeHandler schemeHandler;
    private final UserRepository userRepository;

    public OrderPushRendingViewModel(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull UserRepository userRepository2, @NotNull RefundRepository refundRepository2, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        Intrinsics.checkParameterIsNotNull(refundRepository2, "refundRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.commerceRepository = fittsCommerceRepository;
        this.userRepository = userRepository2;
        this.refundRepository = refundRepository2;
        this.schemeHandler = fittsSchemeHandler;
    }

    @NotNull
    public final MutableLiveData<OrderDetailViewData> getOrderDetailViewDataLiveData() {
        return this.orderDetailViewDataLiveData;
    }

    @NotNull
    public final MutableLiveData<RefundAccount> getRefundAccountLiveData() {
        return this.refundAccountLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getRefundAccountInputedLiveData() {
        return this.refundAccountInputedLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getInvalidStateLiveData() {
        return this.invalidStateLiveData;
    }

    @NotNull
    public final MutableLiveData<ExchangeRefundVariant> getExchangeRefundLiveData() {
        return this.exchangeRefundLiveData;
    }

    @NotNull
    public final Function0<Boolean> isVaidationCheckMode() {
        return this.isVaidationCheckMode;
    }

    public final void setVaidationCheckMode(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.isVaidationCheckMode = function0;
    }

    @NotNull
    public final MutableLiveData<ExpectedReceivablePoint> onExpectedReceivablePointUpdate() {
        return this._expectedReceivablePoint;
    }

    public final void requestOrderInfo(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.getOrderLineItem(j).subscribe(new OrderPushRendingViewModel$requestOrderInfo$1(this), new OrderPushRendingViewModel$requestOrderInfo$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.getOr…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void getExtendedEarnPoint(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.getExpectedReceivableFittsPoint(j).subscribe(new OrderPushRendingViewModel$getExtendedEarnPoint$1(this), new OrderPushRendingViewModel$getExtendedEarnPoint$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.getEx…mpty()\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void requestRefundAccount() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.userRepository.getUserRefundAccountInfo().subscribe(new OrderPushRendingViewModel$requestRefundAccount$1(this), new OrderPushRendingViewModel$requestRefundAccount$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userRepository.getUserRe…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void requestPreRefundItemInfo(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.refundRepository.requestPreRefundInfo(j).subscribe(new OrderPushRendingViewModel$requestPreRefundItemInfo$1(this), new OrderPushRendingViewModel$requestPreRefundItemInfo$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "refundRepository.request…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void updateRefundAccountInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "accountHolder");
        Intrinsics.checkParameterIsNotNull(str2, "accountNumber");
        Intrinsics.checkParameterIsNotNull(str3, "bankName");
        boolean z = true;
        boolean z2 = !(str3.length() == 0);
        if (str.length() == 0) {
            z2 = false;
        }
        if (str2.length() != 0) {
            z = false;
        }
        if (z) {
            z2 = false;
        }
        if (z2) {
            CompositeDisposable compositeDisposable = this.disposables;
            Disposable subscribe = this.userRepository.postUserRefundAccountInfo(str, str2, str3).subscribe(new OrderPushRendingViewModel$updateRefundAccountInfo$1(this), new OrderPushRendingViewModel$updateRefundAccountInfo$2(this));
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "userRepository.postUserR…it\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        } else {
            this.invalidStateLiveData.setValue(Unit.INSTANCE);
        }
        this.isVaidationCheckMode = OrderPushRendingViewModel$updateRefundAccountInfo$3.INSTANCE;
    }

    public final void handleScheme(@Nullable Activity activity, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        if (activity != null) {
            this.schemeHandler.handleScheme(activity, str);
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.disposables.clear();
    }
}
