package kr.co.popone.fitts.viewmodel.refund.apply;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.refund.RefundApplyActivity;
import kr.co.popone.fitts.repository.RefundRepository;
import org.jetbrains.annotations.NotNull;

public final class RefundModule {
    @NotNull
    public final RefundViewModel provideRefundViewModel(@NotNull RefundApplyActivity refundApplyActivity, @NotNull RefundViewModelFactory refundViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(refundApplyActivity, "activity");
        Intrinsics.checkParameterIsNotNull(refundViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) refundApplyActivity, (Factory) refundViewModelFactory).get(RefundViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…ndViewModel::class.java)]");
        return (RefundViewModel) viewModel;
    }

    @NotNull
    public final RefundViewModelFactory providesViewModelFactory(@NotNull RefundRepository refundRepository) {
        Intrinsics.checkParameterIsNotNull(refundRepository, "refundRepository");
        return new RefundViewModelFactory(refundRepository);
    }
}
