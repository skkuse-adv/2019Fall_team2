package kr.co.popone.fitts.feature.alarm;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.alarm.AlarmViewModel;

public final class AlarmFragment_MembersInjector implements MembersInjector<AlarmFragment> {
    private final Provider<AlarmViewModel> vmProvider;

    public AlarmFragment_MembersInjector(Provider<AlarmViewModel> provider) {
        this.vmProvider = provider;
    }

    public static MembersInjector<AlarmFragment> create(Provider<AlarmViewModel> provider) {
        return new AlarmFragment_MembersInjector(provider);
    }

    public void injectMembers(AlarmFragment alarmFragment) {
        injectVm(alarmFragment, (AlarmViewModel) this.vmProvider.get());
    }

    public static void injectVm(AlarmFragment alarmFragment, AlarmViewModel alarmViewModel) {
        alarmFragment.vm = alarmViewModel;
    }
}
