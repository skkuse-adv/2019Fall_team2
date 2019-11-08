package kr.co.popone.fitts.viewmodel.refund.detail;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.refund.RefundApplyCompleteFragment;
import kr.co.popone.fitts.repository.RefundRepository;
import org.jetbrains.annotations.NotNull;

public final class RefundCompleteActivityModule {
    @NotNull
    public final RefundDetailViewModel provideExchangeDetailViewModel(@NotNull RefundApplyCompleteFragment refundApplyCompleteFragment, @NotNull RefundDetailViewModelFactory refundDetailViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(refundApplyCompleteFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(refundDetailViewModelFactory, "viewModelFactory");
        FragmentActivity activity = refundApplyCompleteFragment.getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        ViewModel viewModel = ViewModelProviders.of(activity, (Factory) refundDetailViewModelFactory).get(RefundDetailViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…ilViewModel::class.java)]");
        return (RefundDetailViewModel) viewModel;
    }

    @NotNull
    public final RefundDetailViewModelFactory providesViewModelFactory(@NotNull RefundRepository refundRepository) {
        Intrinsics.checkParameterIsNotNull(refundRepository, "refundRepository");
        return new RefundDetailViewModelFactory(refundRepository);
    }
}
