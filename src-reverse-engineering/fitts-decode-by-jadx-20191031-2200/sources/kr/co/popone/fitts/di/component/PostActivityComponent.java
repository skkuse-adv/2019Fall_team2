package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.post.detail.PostActivity;

public interface PostActivityComponent extends AndroidInjector<PostActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PostActivity> {
    }
}
