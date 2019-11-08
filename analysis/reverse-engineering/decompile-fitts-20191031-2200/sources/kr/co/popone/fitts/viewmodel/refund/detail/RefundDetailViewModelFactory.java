package kr.co.popone.fitts.viewmodel.refund.detail;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.repository.RefundRepository;
import org.jetbrains.annotations.NotNull;

public final class RefundDetailViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final RefundRepository refundRepository;

    public RefundDetailViewModelFactory(@NotNull RefundRepository refundRepository2) {
        Intrinsics.checkParameterIsNotNull(refundRepository2, "refundRepository");
        this.refundRepository = refundRepository2;
    }

    @NotNull
    public final RefundRepository getRefundRepository() {
        return this.refundRepository;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new RefundDetailViewModel(this.refundRepository);
    }
}
