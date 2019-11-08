package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity;

public interface RewardUsageDetailActivityComponent extends AndroidInjector<RewardUsageDetailActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<RewardUsageDetailActivity> {
    }
}
