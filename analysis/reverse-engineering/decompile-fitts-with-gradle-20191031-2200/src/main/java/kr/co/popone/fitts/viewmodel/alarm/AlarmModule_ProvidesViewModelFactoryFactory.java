package kr.co.popone.fitts.viewmodel.alarm;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class AlarmModule_ProvidesViewModelFactoryFactory implements Factory<AlarmViewModelFactory> {
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<FittsSchemeHandler> fittsSchemeHandlerProvider;
    private final Provider<FittsServiceRepository> fittsServiceRepositoryProvider;
    private final AlarmModule module;

    public AlarmModule_ProvidesViewModelFactoryFactory(AlarmModule alarmModule, Provider<FittsServiceRepository> provider, Provider<FittsSchemeHandler> provider2, Provider<EventTracker> provider3, Provider<ActionLogUtil> provider4) {
        this.module = alarmModule;
        this.fittsServiceRepositoryProvider = provider;
        this.fittsSchemeHandlerProvider = provider2;
        this.eventTrackerProvider = provider3;
        this.actionLogUtilProvider = provider4;
    }

    public AlarmViewModelFactory get() {
        return provideInstance(this.module, this.fittsServiceRepositoryProvider, this.fittsSchemeHandlerProvider, this.eventTrackerProvider, this.actionLogUtilProvider);
    }

    public static AlarmViewModelFactory provideInstance(AlarmModule alarmModule, Provider<FittsServiceRepository> provider, Provider<FittsSchemeHandler> provider2, Provider<EventTracker> provider3, Provider<ActionLogUtil> provider4) {
        return proxyProvidesViewModelFactory(alarmModule, (FittsServiceRepository) provider.get(), (FittsSchemeHandler) provider2.get(), (EventTracker) provider3.get(), (ActionLogUtil) provider4.get());
    }

    public static AlarmModule_ProvidesViewModelFactoryFactory create(AlarmModule alarmModule, Provider<FittsServiceRepository> provider, Provider<FittsSchemeHandler> provider2, Provider<EventTracker> provider3, Provider<ActionLogUtil> provider4) {
        AlarmModule_ProvidesViewModelFactoryFactory alarmModule_ProvidesViewModelFactoryFactory = new AlarmModule_ProvidesViewModelFactoryFactory(alarmModule, provider, provider2, provider3, provider4);
        return alarmModule_ProvidesViewModelFactoryFactory;
    }

    public static AlarmViewModelFactory proxyProvidesViewModelFactory(AlarmModule alarmModule, FittsServiceRepository fittsServiceRepository, FittsSchemeHandler fittsSchemeHandler, EventTracker eventTracker, ActionLogUtil actionLogUtil) {
        return (AlarmViewModelFactory) Preconditions.checkNotNull(alarmModule.providesViewModelFactory(fittsServiceRepository, fittsSchemeHandler, eventTracker, actionLogUtil), "Cannot return null from a non-@Nullable @Provides method");
    }
}
