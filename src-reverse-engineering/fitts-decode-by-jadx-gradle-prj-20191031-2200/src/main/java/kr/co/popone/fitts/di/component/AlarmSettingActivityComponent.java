package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.alarm.AlarmSettingActivity;

public interface AlarmSettingActivityComponent extends AndroidInjector<AlarmSettingActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<AlarmSettingActivity> {
    }
}
