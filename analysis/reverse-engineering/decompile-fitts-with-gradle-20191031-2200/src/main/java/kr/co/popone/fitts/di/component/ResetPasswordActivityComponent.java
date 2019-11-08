package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.intro.login.ResetPasswordActivity;

public interface ResetPasswordActivityComponent extends AndroidInjector<ResetPasswordActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ResetPasswordActivity> {
    }
}
