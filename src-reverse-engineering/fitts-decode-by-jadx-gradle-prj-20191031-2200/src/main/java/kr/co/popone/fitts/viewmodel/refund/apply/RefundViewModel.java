package kr.co.popone.fitts.viewmodel.refund.apply;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.Single;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState;
import kr.co.popone.fitts.repository.RefundRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefundViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<Integer> countLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<List<RefundInvalidViewState>> invalidStateListLiveData = new MutableLiveData<>();
    @NotNull
    private Function0<Boolean> isVaidationCheckMode = RefundViewModel$isVaidationCheckMode$1.INSTANCE;
    @NotNull
    public Function0<Long> orderLineItemVariantId;
    @NotNull
    private MutableLiveData<String> paymentMethod = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<ExchangeRefundVariant> preRefundLiveData = new MutableLiveData<>();
    private Function0<? extends Single<Pair<Long, Long>>> refundApply;
    /* access modifiers changed from: private */
    public final RefundRepository refundRepository;
    @NotNull
    private final MutableLiveData<Unit> showDialogLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public Function0<Integer> variantQuantity;

    public RefundViewModel(@NotNull RefundRepository refundRepository2) {
        Intrinsics.checkParameterIsNotNull(refundRepository2, "refundRepository");
        this.refundRepository = refundRepository2;
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
    public final MutableLiveData<ExchangeRefundVariant> getPreRefundLiveData() {
        return this.preRefundLiveData;
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
    public final MutableLiveData<List<RefundInvalidViewState>> getInvalidStateListLiveData() {
        return this.invalidStateListLiveData;
    }

    public final void initPaymentMethod(@NotNull Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        this.paymentMethod.setValue(function0.invoke());
    }

    public final void getPreRefundInfo() {
        Function0<Long> function0 = this.orderLineItemVariantId;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderLineItemVariantId");
        }
        this.refundRepository.requestPreRefundInfo(((Number) function0.invoke()).longValue()).subscribe(new RefundViewModel$getPreRefundInfo$$inlined$run$lambda$1(this), new RefundViewModel$getPreRefundInfo$$inlined$run$lambda$2(this));
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

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0074, code lost:
        if (r1 != false) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkValidation(int r11, @org.jetbrains.annotations.Nullable java.lang.String r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.Nullable java.lang.String r14, @org.jetbrains.annotations.Nullable java.lang.String r15, @org.jetbrains.annotations.Nullable java.lang.String r16, boolean r17) {
        /*
            r10 = this;
            r8 = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = r11
            if (r3 >= r1) goto L_0x000d
            r4 = 0
            goto L_0x000e
        L_0x000d:
            r4 = 1
        L_0x000e:
            if (r15 == 0) goto L_0x0019
            int r5 = r15.length()
            if (r5 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r5 = 0
            goto L_0x001a
        L_0x0019:
            r5 = 1
        L_0x001a:
            if (r5 == 0) goto L_0x0022
            kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState r4 = kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState.EXCHANGE_REASON
            r0.add(r4)
            r4 = 0
        L_0x0022:
            if (r16 == 0) goto L_0x002d
            int r5 = r16.length()
            if (r5 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r5 = 0
            goto L_0x002e
        L_0x002d:
            r5 = 1
        L_0x002e:
            if (r5 == 0) goto L_0x0036
            kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState r4 = kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState.EXCHANGE_DETAIL_REASON
            r0.add(r4)
            r4 = 0
        L_0x0036:
            if (r17 != 0) goto L_0x003e
            kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState r4 = kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState.AGREEMENT_FAILED
            r0.add(r4)
            r4 = 0
        L_0x003e:
            androidx.lifecycle.MutableLiveData<java.lang.String> r5 = r8.paymentMethod
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "direct_deposit"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x007c
            if (r12 == 0) goto L_0x0059
            int r5 = r12.length()
            if (r5 != 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r5 = 0
            goto L_0x005a
        L_0x0059:
            r5 = 1
        L_0x005a:
            if (r5 != 0) goto L_0x0076
            if (r13 == 0) goto L_0x0067
            int r5 = r13.length()
            if (r5 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r5 = 0
            goto L_0x0068
        L_0x0067:
            r5 = 1
        L_0x0068:
            if (r5 != 0) goto L_0x0076
            if (r14 == 0) goto L_0x0074
            int r5 = r14.length()
            if (r5 != 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r1 = 0
        L_0x0074:
            if (r1 == 0) goto L_0x007c
        L_0x0076:
            kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState r1 = kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState.BANK_ACCOUNT
            r0.add(r1)
            goto L_0x007d
        L_0x007c:
            r2 = r4
        L_0x007d:
            if (r2 == 0) goto L_0x0097
            kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel$checkValidation$1 r9 = new kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel$checkValidation$1
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.refundApply = r9
            androidx.lifecycle.MutableLiveData<kotlin.Unit> r0 = r8.showDialogLiveData
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r0.setValue(r1)
            goto L_0x009c
        L_0x0097:
            androidx.lifecycle.MutableLiveData<java.util.List<kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState>> r1 = r8.invalidStateListLiveData
            r1.setValue(r0)
        L_0x009c:
            kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel$checkValidation$2 r0 = kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel$checkValidation$2.INSTANCE
            r8.isVaidationCheckMode = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel.checkValidation(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    @Nullable
    public final String getBankInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        if (Intrinsics.areEqual((Object) (String) this.paymentMethod.getValue(), (Object) "direct_deposit")) {
            return str;
        }
        return null;
    }

    public final void requestRefund(@NotNull Function1<? super Pair<Long, Long>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        Function0<? extends Single<Pair<Long, Long>>> function0 = this.refundApply;
        if (function0 != null) {
            Single single = (Single) function0.invoke();
            if (single != null) {
                single.subscribe(new RefundViewModel$requestRefund$1(function1), new RefundViewModel$requestRefund$2(this));
            }
        }
    }
}
