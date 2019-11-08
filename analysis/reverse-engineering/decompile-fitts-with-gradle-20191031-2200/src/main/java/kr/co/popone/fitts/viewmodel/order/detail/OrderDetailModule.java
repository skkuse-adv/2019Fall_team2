package kr.co.popone.fitts.viewmodel.order.detail;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;

public final class OrderDetailModule {
    @NotNull
    public final OrderDetailViewModel provideOrderViewModel(@NotNull OrderDetailActivity orderDetailActivity, @NotNull OrderDetailViewModelFactory orderDetailViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(orderDetailActivity, "activity");
        Intrinsics.checkParameterIsNotNull(orderDetailViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) orderDetailActivity, (Factory) orderDetailViewModelFactory).get(OrderDetailViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…ilViewModel::class.java)]");
        return (OrderDetailViewModel) viewModel;
    }

    @NotNull
    public final OrderDetailViewModelFactory providesViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull CreatePostActivityUtil createPostActivityUtil) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(createPostActivityUtil, "createPostActivityUtil");
        return new OrderDetailViewModelFactory(fittsCommerceRepository, createPostActivityUtil);
    }
}
