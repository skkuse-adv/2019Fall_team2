package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.reward.RewardPointUseActivity;

public interface RewardPointUseActivityComponent extends AndroidInjector<RewardPointUseActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<RewardPointUseActivity> {
    }
}
