package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.me.like.LikedActivity;

public interface LikedActivityComponent extends AndroidInjector<LikedActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<LikedActivity> {
    }
}
