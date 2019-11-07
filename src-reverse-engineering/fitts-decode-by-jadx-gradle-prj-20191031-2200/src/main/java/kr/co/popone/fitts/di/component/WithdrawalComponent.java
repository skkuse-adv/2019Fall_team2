package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.setting.WithdrawalActivity;

public interface WithdrawalComponent extends AndroidInjector<WithdrawalActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<WithdrawalActivity> {
    }
}
