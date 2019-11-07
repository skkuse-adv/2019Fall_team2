package kr.co.popone.fitts.viewmodel.refund.apply;

import io.reactivex.Single;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.repository.RefundRepository;
import org.jetbrains.annotations.NotNull;

final class RefundViewModel$checkValidation$1 extends Lambda implements Function0<Single<Pair<? extends Long, ? extends Long>>> {
    final /* synthetic */ String $accountHolder;
    final /* synthetic */ String $accountNumber;
    final /* synthetic */ String $bankName;
    final /* synthetic */ String $detailReason;
    final /* synthetic */ int $quantity;
    final /* synthetic */ String $reason;
    final /* synthetic */ RefundViewModel this$0;

    RefundViewModel$checkValidation$1(RefundViewModel refundViewModel, int i, String str, String str2, String str3, String str4, String str5) {
        this.this$0 = refundViewModel;
        this.$quantity = i;
        this.$accountHolder = str;
        this.$accountNumber = str2;
        this.$bankName = str3;
        this.$reason = str4;
        this.$detailReason = str5;
        super(0);
    }

    @NotNull
    public final Single<Pair<Long, Long>> invoke() {
        RefundRepository access$getRefundRepository$p = this.this$0.refundRepository;
        long longValue = ((Number) this.this$0.getOrderLineItemVariantId().invoke()).longValue();
        int i = this.$quantity;
        RefundViewModel refundViewModel = this.this$0;
        String str = this.$accountHolder;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        String bankInfo = refundViewModel.getBankInfo(str);
        RefundViewModel refundViewModel2 = this.this$0;
        String str2 = this.$accountNumber;
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        String bankInfo2 = refundViewModel2.getBankInfo(str2);
        RefundViewModel refundViewModel3 = this.this$0;
        String str3 = this.$bankName;
        if (str3 == null) {
            Intrinsics.throwNpe();
        }
        String bankInfo3 = refundViewModel3.getBankInfo(str3);
        String str4 = this.$reason;
        if (str4 == null) {
            Intrinsics.throwNpe();
        }
        String str5 = this.$detailReason;
        if (str5 == null) {
            Intrinsics.throwNpe();
        }
        return access$getRefundRepository$p.requestRefundApply(longValue, i, bankInfo, bankInfo2, bankInfo3, str4, str5);
    }
}
