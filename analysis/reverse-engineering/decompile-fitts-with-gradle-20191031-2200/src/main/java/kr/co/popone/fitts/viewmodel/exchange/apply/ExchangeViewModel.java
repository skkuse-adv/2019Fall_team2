package kr.co.popone.fitts.viewmodel.exchange.apply;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.Single;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.repository.ExchangeRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExchangeViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<Integer> countLiveData = new MutableLiveData<>();
    private Function0<? extends Single<Pair<Long, Long>>> exchangeApply;
    /* access modifiers changed from: private */
    public final ExchangeRepository exchangeRepository;
    @NotNull
    private final MutableLiveData<List<ExchangeInvalidViewState>> invalidStateListLiveData = new MutableLiveData<>();
    @NotNull
    private Function0<Boolean> isVaidationCheckMode = ExchangeViewModel$isVaidationCheckMode$1.INSTANCE;
    @NotNull
    public Function0<Long> orderLineItemVariantId;
    @NotNull
    private MutableLiveData<String> paymentMethod = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<ExchangeRefundVariant> preExchangeLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Unit> showDialogLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public Function0<Integer> variantQuantity;

    public ExchangeViewModel(@NotNull ExchangeRepository exchangeRepository2) {
        Intrinsics.checkParameterIsNotNull(exchangeRepository2, "exchangeRepository");
        this.exchangeRepository = exchangeRepository2;
    }

    @NotNull
    public final Function0<Long> getOrderLineItemVariantId() {
        Function0<Long> function0 = this.orderLineItemVariantId;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderLineItemVariantId");
        }
        return function0;
    }

    public final void setOrderLineItemVariantId(@NotNull Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.orderLineItemVariantId = function0;
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
    public final MutableLiveData<String> getPaymentMethod() {
        return this.paymentMethod;
    }

    public final void setPaymentMethod(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.paymentMethod = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<ExchangeRefundVariant> getPreExchangeLiveData() {
        return this.preExchangeLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> getCountLiveData() {
        return this.countLiveData;
    }

    @NotNull
    public final MutableLiveData<Unit> getShowDialogLiveData() {
        return this.showDialogLiveData;
    }

    @NotNull
    public final MutableLiveData<List<ExchangeInvalidViewState>> getInvalidStateListLiveData() {
        return this.invalidStateListLiveData;
    }

    public final void initPaymentMethod(@NotNull Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        this.paymentMethod.setValue(function0.invoke());
    }

    public final void getPreExchangeInfo() {
        Function0<Long> function0 = this.orderLineItemVariantId;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderLineItemVariantId");
        }
        this.exchangeRepository.requestPreExchangeInfo(((Number) function0.invoke()).longValue()).subscribe(new ExchangeViewModel$getPreExchangeInfo$$inlined$run$lambda$1(this), new ExchangeViewModel$getPreExchangeInfo$$inlined$run$lambda$2(this));
    }

    public final void canPlusCount(int i) {
        Function0<Integer> function0 = this.variantQuantity;
        if (function0 != null) {
            Integer num = (Integer) function0.invoke();
            if (num != null) {
                int i2 = i + 1;
                if (i2 <= num.intValue()) {
                    this.countLiveData.setValue(Integer.valueOf(i2));
                }
            }
        }
    }

    public final void canMinusCount(int i) {
        int i2 = i - 1;
        if (i2 > 0) {
            this.countLiveData.setValue(Integer.valueOf(i2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0088, code lost:
        if (r1 != false) goto L_0x008a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkValidation(int r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.Nullable java.lang.String r14, @org.jetbrains.annotations.Nullable java.lang.String r15, @org.jetbrains.annotations.Nullable java.lang.String r16, @org.jetbrains.annotations.Nullable java.lang.String r17, @org.jetbrains.annotations.Nullable java.lang.String r18, boolean r19) {
        /*
            r11 = this;
            r9 = r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = r12
            if (r3 >= r1) goto L_0x000d
            r4 = 0
            goto L_0x000e
        L_0x000d:
            r4 = 1
        L_0x000e:
            if (r13 == 0) goto L_0x0019
            int r5 = r13.length()
            if (r5 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r5 = 0
            goto L_0x001a
        L_0x0019:
            r5 = 1
        L_0x001a:
            if (r5 == 0) goto L_0x0022
            kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState r4 = kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState.EXCHANGE_OPTION
            r0.add(r4)
            r4 = 0
        L_0x0022:
            if (r17 == 0) goto L_0x002d
            int r5 = r17.length()
            if (r5 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r5 = 0
            goto L_0x002e
        L_0x002d:
            r5 = 1
        L_0x002e:
            if (r5 == 0) goto L_0x0036
            kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState r4 = kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState.EXCHANGE_REASON
            r0.add(r4)
            r4 = 0
        L_0x0036:
            if (r18 == 0) goto L_0x0041
            int r5 = r18.length()
            if (r5 != 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r5 = 0
            goto L_0x0042
        L_0x0041:
            r5 = 1
        L_0x0042:
            if (r5 == 0) goto L_0x004a
            kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState r4 = kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState.EXCHANGE_DETAIL_REASON
            r0.add(r4)
            r4 = 0
        L_0x004a:
            if (r19 != 0) goto L_0x0052
            kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState r4 = kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState.AGREEMENT_FAILED
            r0.add(r4)
            r4 = 0
        L_0x0052:
            androidx.lifecycle.MutableLiveData<java.lang.String> r5 = r9.paymentMethod
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "direct_deposit"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x0090
            if (r14 == 0) goto L_0x006d
            int r5 = r14.length()
            if (r5 != 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r5 = 0
            goto L_0x006e
        L_0x006d:
            r5 = 1
        L_0x006e:
            if (r5 != 0) goto L_0x008a
            if (r15 == 0) goto L_0x007b
            int r5 = r15.length()
            if (r5 != 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r5 = 0
            goto L_0x007c
        L_0x007b:
            r5 = 1
        L_0x007c:
            if (r5 != 0) goto L_0x008a
            if (r16 == 0) goto L_0x0088
            int r5 = r16.length()
            if (r5 != 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r1 = 0
        L_0x0088:
            if (r1 == 0) goto L_0x0090
        L_0x008a:
            kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState r1 = kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState.BANK_ACCOUNT
            r0.add(r1)
            goto L_0x0091
        L_0x0090:
            r2 = r4
        L_0x0091:
            if (r2 == 0) goto L_0x00ae
            kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel$checkValidation$1 r10 = new kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel$checkValidation$1
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.exchangeApply = r10
            androidx.lifecycle.MutableLiveData<kotlin.Unit> r0 = r9.showDialogLiveData
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r0.setValue(r1)
            goto L_0x00b3
        L_0x00ae:
            androidx.lifecycle.MutableLiveData<java.util.List<kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState>> r1 = r9.invalidStateListLiveData
            r1.setValue(r0)
        L_0x00b3:
            kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel$checkValidation$2 r0 = kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel$checkValidation$2.INSTANCE
            r9.isVaidationCheckMode = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel.checkValidation(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    @Nullable
    public final String getBankInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        if (Intrinsics.areEqual((Object) (String) this.paymentMethod.getValue(), (Object) "direct_deposit")) {
            return str;
        }
        return null;
    }

    public final void requestExchange(@NotNull Function1<? super Pair<Long, Long>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        Function0<? extends Single<Pair<Long, Long>>> function0 = this.exchangeApply;
        if (function0 != null) {
            Single single = (Single) function0.invoke();
            if (single != null) {
                single.subscribe(new ExchangeViewModel$requestExchange$1(function1), new ExchangeViewModel$requestExchange$2(this));
            }
        }
    }
}
