package kr.co.popone.fitts.services;

import dagger.android.AndroidInjector;

public interface FittsFirebaseMessasingServiceComponent extends AndroidInjector<FittsFirebaseMessagingService> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<FittsFirebaseMessagingService> {
    }
}
