package kr.co.popone.fitts.feature.alarm;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class AlarmSettingActivity_MembersInjector implements MembersInjector<AlarmSettingActivity> {
    private final Provider<UserAPI> userAPIProvider;

    public AlarmSettingActivity_MembersInjector(Provider<UserAPI> provider) {
        this.userAPIProvider = provider;
    }

    public static MembersInjector<AlarmSettingActivity> create(Provider<UserAPI> provider) {
        return new AlarmSettingActivity_MembersInjector(provider);
    }

    public void injectMembers(AlarmSettingActivity alarmSettingActivity) {
        injectUserAPI(alarmSettingActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectUserAPI(AlarmSettingActivity alarmSettingActivity, UserAPI userAPI) {
        alarmSettingActivity.userAPI = userAPI;
    }
}
