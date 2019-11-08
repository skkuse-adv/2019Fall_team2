package kr.co.popone.fitts.viewmodel.order;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.order.OrderActivity;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;

public final class OrderModule {
    @NotNull
    public final OrderViewModel provideOrderViewModel(@NotNull OrderActivity orderActivity, @NotNull OrderViewModelFactory orderViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(orderActivity, "activity");
        Intrinsics.checkParameterIsNotNull(orderViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) orderActivity, (Factory) orderViewModelFactory).get(OrderViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…erViewModel::class.java)]");
        return (OrderViewModel) viewModel;
    }

    @NotNull
    public final OrderViewModelFactory providesViewModelFactory(@NotNull OrderActivity orderActivity, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSocialRepository fittsSocialRepository, @NotNull ProductRepository productRepository, @NotNull CartRepository cartRepository, @NotNull EventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(orderActivity, "activity");
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        Intrinsics.checkParameterIsNotNull(productRepository, "productRepository");
        Intrinsics.checkParameterIsNotNull(cartRepository, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        OrderInitialData orderInitialData = (OrderInitialData) orderActivity.getIntent().getParcelableExtra(OrderActivity.KEY_ORDER_INITIAL_DATA);
        Intrinsics.checkExpressionValueIsNotNull(orderInitialData, "orderInitialData");
        OrderViewModelFactory orderViewModelFactory = new OrderViewModelFactory(orderInitialData, fittsCommerceRepository, fittsSocialRepository, productRepository, cartRepository, eventTracker);
        return orderViewModelFactory;
    }
}
