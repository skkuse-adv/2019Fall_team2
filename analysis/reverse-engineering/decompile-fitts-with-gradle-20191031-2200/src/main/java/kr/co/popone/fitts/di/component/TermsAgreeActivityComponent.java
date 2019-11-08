package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.coupon.TermsAgreeWebViewActivity;

public interface TermsAgreeActivityComponent extends AndroidInjector<TermsAgreeWebViewActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<TermsAgreeWebViewActivity> {
    }
}
