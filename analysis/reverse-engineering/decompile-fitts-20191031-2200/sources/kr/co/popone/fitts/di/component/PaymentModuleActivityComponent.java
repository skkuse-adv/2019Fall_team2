package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.payment.PaymentModuleActivity;

public interface PaymentModuleActivityComponent extends AndroidInjector<PaymentModuleActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PaymentModuleActivity> {
    }
}
