package kr.co.popone.fitts.viewmodel.ncommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class NCommerceModule_ProvidesViewModelFactoryFactory implements Factory<NCommerceViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final NCommerceModule module;
    private final Provider<PaymentAPI> paymentAPIProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public NCommerceModule_ProvidesViewModelFactoryFactory(NCommerceModule nCommerceModule, Provider<UserRepository> provider, Provider<PaymentAPI> provider2, Provider<EventTracker> provider3, Provider<FittsSchemeHandler> provider4) {
        this.module = nCommerceModule;
        this.userRepositoryProvider = provider;
        this.paymentAPIProvider = provider2;
        this.eventTrackerProvider = provider3;
        this.schemeHandlerProvider = provider4;
    }

    public NCommerceViewModelFactory get() {
        return provideInstance(this.module, this.userRepositoryProvider, this.paymentAPIProvider, this.eventTrackerProvider, this.schemeHandlerProvider);
    }

    public static NCommerceViewModelFactory provideInstance(NCommerceModule nCommerceModule, Provider<UserRepository> provider, Provider<PaymentAPI> provider2, Provider<EventTracker> provider3, Provider<FittsSchemeHandler> provider4) {
        return proxyProvidesViewModelFactory(nCommerceModule, (UserRepository) provider.get(), (PaymentAPI) provider2.get(), (EventTracker) provider3.get(), (FittsSchemeHandler) provider4.get());
    }

    public static NCommerceModule_ProvidesViewModelFactoryFactory create(NCommerceModule nCommerceModule, Provider<UserRepository> provider, Provider<PaymentAPI> provider2, Provider<EventTracker> provider3, Provider<FittsSchemeHandler> provider4) {
        NCommerceModule_ProvidesViewModelFactoryFactory nCommerceModule_ProvidesViewModelFactoryFactory = new NCommerceModule_ProvidesViewModelFactoryFactory(nCommerceModule, provider, provider2, provider3, provider4);
        return nCommerceModule_ProvidesViewModelFactoryFactory;
    }

    public static NCommerceViewModelFactory proxyProvidesViewModelFactory(NCommerceModule nCommerceModule, UserRepository userRepository, PaymentAPI paymentAPI, EventTracker eventTracker, FittsSchemeHandler fittsSchemeHandler) {
        return (NCommerceViewModelFactory) Preconditions.checkNotNull(nCommerceModule.providesViewModelFactory(userRepository, paymentAPI, eventTracker, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
