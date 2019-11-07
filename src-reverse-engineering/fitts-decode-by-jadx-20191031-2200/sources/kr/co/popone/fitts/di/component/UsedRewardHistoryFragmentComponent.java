package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.reward.UsedRewardHistoryFragment;

public interface UsedRewardHistoryFragmentComponent extends AndroidInjector<UsedRewardHistoryFragment> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<UsedRewardHistoryFragment> {
    }
}
