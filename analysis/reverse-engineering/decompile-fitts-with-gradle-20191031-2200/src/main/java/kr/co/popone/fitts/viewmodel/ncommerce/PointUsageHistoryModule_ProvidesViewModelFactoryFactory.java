package kr.co.popone.fitts.viewmodel.ncommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class PointUsageHistoryModule_ProvidesViewModelFactoryFactory implements Factory<NCommerceViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final PointUsageHistoryModule module;
    private final Provider<PaymentAPI> paymentAPIProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public PointUsageHistoryModule_ProvidesViewModelFactoryFactory(PointUsageHistoryModule pointUsageHistoryModule, Provider<UserRepository> provider, Provider<PaymentAPI> provider2, Provider<EventTracker> provider3, Provider<FittsSchemeHandler> provider4) {
        this.module = pointUsageHistoryModule;
        this.userRepositoryProvider = provider;
        this.paymentAPIProvider = provider2;
        this.eventTrackerProvider = provider3;
        this.schemeHandlerProvider = provider4;
    }

    public NCommerceViewModelFactory get() {
        return provideInstance(this.module, this.userRepositoryProvider, this.paymentAPIProvider, this.eventTrackerProvider, this.schemeHandlerProvider);
    }

    public static NCommerceViewModelFactory provideInstance(PointUsageHistoryModule pointUsageHistoryModule, Provider<UserRepository> provider, Provider<PaymentAPI> provider2, Provider<EventTracker> provider3, Provider<FittsSchemeHandler> provider4) {
        return proxyProvidesViewModelFactory(pointUsageHistoryModule, (UserRepository) provider.get(), (PaymentAPI) provider2.get(), (EventTracker) provider3.get(), (FittsSchemeHandler) provider4.get());
    }

    public static PointUsageHistoryModule_ProvidesViewModelFactoryFactory create(PointUsageHistoryModule pointUsageHistoryModule, Provider<UserRepository> provider, Provider<PaymentAPI> provider2, Provider<EventTracker> provider3, Provider<FittsSchemeHandler> provider4) {
        PointUsageHistoryModule_ProvidesViewModelFactoryFactory pointUsageHistoryModule_ProvidesViewModelFactoryFactory = new PointUsageHistoryModule_ProvidesViewModelFactoryFactory(pointUsageHistoryModule, provider, provider2, provider3, provider4);
        return pointUsageHistoryModule_ProvidesViewModelFactoryFactory;
    }

    public static NCommerceViewModelFactory proxyProvidesViewModelFactory(PointUsageHistoryModule pointUsageHistoryModule, UserRepository userRepository, PaymentAPI paymentAPI, EventTracker eventTracker, FittsSchemeHandler fittsSchemeHandler) {
        return (NCommerceViewModelFactory) Preconditions.checkNotNull(pointUsageHistoryModule.providesViewModelFactory(userRepository, paymentAPI, eventTracker, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
