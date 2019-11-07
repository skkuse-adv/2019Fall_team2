package kr.co.popone.fitts.viewmodel.refund.detail;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.refund.RefundCompleteActivity;
import kr.co.popone.fitts.repository.RefundRepository;
import org.jetbrains.annotations.NotNull;

public final class RefundApplyCompleteFragmentModule {
    @NotNull
    public final RefundDetailViewModel provideExchangeDetailViewModel(@NotNull RefundCompleteActivity refundCompleteActivity, @NotNull RefundDetailViewModelFactory refundDetailViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(refundCompleteActivity, "activity");
        Intrinsics.checkParameterIsNotNull(refundDetailViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) refundCompleteActivity, (Factory) refundDetailViewModelFactory).get(RefundDetailViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…ilViewModel::class.java)]");
        return (RefundDetailViewModel) viewModel;
    }

    @NotNull
    public final RefundDetailViewModelFactory providesViewModelFactory(@NotNull RefundRepository refundRepository) {
        Intrinsics.checkParameterIsNotNull(refundRepository, "refundRepository");
        return new RefundDetailViewModelFactory(refundRepository);
    }
}
