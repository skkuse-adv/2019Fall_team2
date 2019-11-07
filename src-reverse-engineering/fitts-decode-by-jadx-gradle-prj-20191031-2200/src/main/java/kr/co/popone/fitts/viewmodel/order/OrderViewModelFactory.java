package kr.co.popone.fitts.viewmodel.order;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;

public final class OrderViewModelFactory extends BaseViewModelFactory {
    private final CartRepository cartRepository;
    private final FittsCommerceRepository commerceRepository;
    private final EventTracker eventTracker;
    private final OrderInitialData orderInitialData;
    private final ProductRepository productRepository;
    private final FittsSocialRepository socialRepository;

    public OrderViewModelFactory(@NotNull OrderInitialData orderInitialData2, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSocialRepository fittsSocialRepository, @NotNull ProductRepository productRepository2, @NotNull CartRepository cartRepository2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(orderInitialData2, "orderInitialData");
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        Intrinsics.checkParameterIsNotNull(productRepository2, "productRepository");
        Intrinsics.checkParameterIsNotNull(cartRepository2, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.orderInitialData = orderInitialData2;
        this.commerceRepository = fittsCommerceRepository;
        this.socialRepository = fittsSocialRepository;
        this.productRepository = productRepository2;
        this.cartRepository = cartRepository2;
        this.eventTracker = eventTracker2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        OrderViewModel orderViewModel = new OrderViewModel(this.orderInitialData, this.commerceRepository, this.socialRepository, this.productRepository, this.cartRepository, this.eventTracker);
        return orderViewModel;
    }
}
