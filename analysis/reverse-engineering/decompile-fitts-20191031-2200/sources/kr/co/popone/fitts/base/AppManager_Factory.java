package kr.co.popone.fitts.base;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;

public final class AppManager_Factory implements Factory<AppManager> {
    private final Provider<Application> applicationProvider;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;

    public AppManager_Factory(Provider<Application> provider, Provider<FittsServiceRepository> provider2) {
        this.applicationProvider = provider;
        this.serviceRepositoryProvider = provider2;
    }

    public AppManager get() {
        return provideInstance(this.applicationProvider, this.serviceRepositoryProvider);
    }

    public static AppManager provideInstance(Provider<Application> provider, Provider<FittsServiceRepository> provider2) {
        return new AppManager((Application) provider.get(), (FittsServiceRepository) provider2.get());
    }

    public static AppManager_Factory create(Provider<Application> provider, Provider<FittsServiceRepository> provider2) {
        return new AppManager_Factory(provider, provider2);
    }

    public static AppManager newAppManager(Application application, FittsServiceRepository fittsServiceRepository) {
        return new AppManager(application, fittsServiceRepository);
    }
}
