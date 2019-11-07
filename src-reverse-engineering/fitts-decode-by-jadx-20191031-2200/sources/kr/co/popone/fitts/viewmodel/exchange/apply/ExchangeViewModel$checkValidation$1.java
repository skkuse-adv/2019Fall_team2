package kr.co.popone.fitts.viewmodel.exchange.apply;

import io.reactivex.Single;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.repository.ExchangeRepository;
import org.jetbrains.annotations.NotNull;

final class ExchangeViewModel$checkValidation$1 extends Lambda implements Function0<Single<Pair<? extends Long, ? extends Long>>> {
    final /* synthetic */ String $accountHolder;
    final /* synthetic */ String $accountNumber;
    final /* synthetic */ String $bankName;
    final /* synthetic */ String $detailReason;
    final /* synthetic */ String $option;
    final /* synthetic */ int $quantity;
    final /* synthetic */ String $reason;
    final /* synthetic */ ExchangeViewModel this$0;

    ExchangeViewModel$checkValidation$1(ExchangeViewModel exchangeViewModel, int i, String str, String str2, String str3, String str4, String str5, String str6) {
        this.this$0 = exchangeViewModel;
        this.$quantity = i;
        this.$option = str;
        this.$accountHolder = str2;
        this.$accountNumber = str3;
        this.$bankName = str4;
        this.$reason = str5;
        this.$detailReason = str6;
        super(0);
    }

    @NotNull
    public final Single<Pair<Long, Long>> invoke() {
        ExchangeRepository access$getExchangeRepository$p = this.this$0.exchangeRepository;
        long longValue = ((Number) this.this$0.getOrderLineItemVariantId().invoke()).longValue();
        int i = this.$quantity;
        String str = this.$option;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        ExchangeViewModel exchangeViewModel = this.this$0;
        String str2 = this.$accountHolder;
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        String bankInfo = exchangeViewModel.getBankInfo(str2);
        ExchangeViewModel exchangeViewModel2 = this.this$0;
        String str3 = this.$accountNumber;
        if (str3 == null) {
            Intrinsics.throwNpe();
        }
        String bankInfo2 = exchangeViewModel2.getBankInfo(str3);
        ExchangeViewModel exchangeViewModel3 = this.this$0;
        String str4 = this.$bankName;
        if (str4 == null) {
            Intrinsics.throwNpe();
        }
        String bankInfo3 = exchangeViewModel3.getBankInfo(str4);
        String str5 = this.$reason;
        if (str5 == null) {
            Intrinsics.throwNpe();
        }
        String str6 = this.$detailReason;
        if (str6 == null) {
            Intrinsics.throwNpe();
        }
        return access$getExchangeRepository$p.requestExchangeApply(longValue, i, str, bankInfo, bankInfo2, bankInfo3, str5, str6);
    }
}
