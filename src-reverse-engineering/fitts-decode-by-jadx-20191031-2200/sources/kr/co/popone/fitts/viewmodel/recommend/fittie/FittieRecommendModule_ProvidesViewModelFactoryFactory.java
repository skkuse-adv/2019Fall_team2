package kr.co.popone.fitts.viewmodel.recommend.fittie;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;

public final class FittieRecommendModule_ProvidesViewModelFactoryFactory implements Factory<FittieRecommendViewModelFactory> {
    private final FittieRecommendModule module;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public FittieRecommendModule_ProvidesViewModelFactoryFactory(FittieRecommendModule fittieRecommendModule, Provider<FittsServiceRepository> provider, Provider<UserAPI> provider2, Provider<SessionManager> provider3) {
        this.module = fittieRecommendModule;
        this.serviceRepositoryProvider = provider;
        this.userAPIProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public FittieRecommendViewModelFactory get() {
        return provideInstance(this.module, this.serviceRepositoryProvider, this.userAPIProvider, this.sessionManagerProvider);
    }

    public static FittieRecommendViewModelFactory provideInstance(FittieRecommendModule fittieRecommendModule, Provider<FittsServiceRepository> provider, Provider<UserAPI> provider2, Provider<SessionManager> provider3) {
        return proxyProvidesViewModelFactory(fittieRecommendModule, (FittsServiceRepository) provider.get(), (UserAPI) provider2.get(), (SessionManager) provider3.get());
    }

    public static FittieRecommendModule_ProvidesViewModelFactoryFactory create(FittieRecommendModule fittieRecommendModule, Provider<FittsServiceRepository> provider, Provider<UserAPI> provider2, Provider<SessionManager> provider3) {
        return new FittieRecommendModule_ProvidesViewModelFactoryFactory(fittieRecommendModule, provider, provider2, provider3);
    }

    public static FittieRecommendViewModelFactory proxyProvidesViewModelFactory(FittieRecommendModule fittieRecommendModule, FittsServiceRepository fittsServiceRepository, UserAPI userAPI, SessionManager sessionManager) {
        return (FittieRecommendViewModelFactory) Preconditions.checkNotNull(fittieRecommendModule.providesViewModelFactory(fittsServiceRepository, userAPI, sessionManager), "Cannot return null from a non-@Nullable @Provides method");
    }
}
