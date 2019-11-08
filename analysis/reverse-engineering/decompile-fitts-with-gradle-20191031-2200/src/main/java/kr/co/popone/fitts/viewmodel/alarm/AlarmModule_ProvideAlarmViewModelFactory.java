package kr.co.popone.fitts.viewmodel.alarm;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.alarm.AlarmFragment;

public final class AlarmModule_ProvideAlarmViewModelFactory implements Factory<AlarmViewModel> {
    private final Provider<AlarmFragment> fragmentProvider;
    private final AlarmModule module;
    private final Provider<AlarmViewModelFactory> viewModelFactoryProvider;

    public AlarmModule_ProvideAlarmViewModelFactory(AlarmModule alarmModule, Provider<AlarmFragment> provider, Provider<AlarmViewModelFactory> provider2) {
        this.module = alarmModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public AlarmViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static AlarmViewModel provideInstance(AlarmModule alarmModule, Provider<AlarmFragment> provider, Provider<AlarmViewModelFactory> provider2) {
        return proxyProvideAlarmViewModel(alarmModule, (AlarmFragment) provider.get(), (AlarmViewModelFactory) provider2.get());
    }

    public static AlarmModule_ProvideAlarmViewModelFactory create(AlarmModule alarmModule, Provider<AlarmFragment> provider, Provider<AlarmViewModelFactory> provider2) {
        return new AlarmModule_ProvideAlarmViewModelFactory(alarmModule, provider, provider2);
    }

    public static AlarmViewModel proxyProvideAlarmViewModel(AlarmModule alarmModule, AlarmFragment alarmFragment, AlarmViewModelFactory alarmViewModelFactory) {
        return (AlarmViewModel) Preconditions.checkNotNull(alarmModule.provideAlarmViewModel(alarmFragment, alarmViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
