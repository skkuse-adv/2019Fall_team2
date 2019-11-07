package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.post.PostFirstWriteNoticeActivity;

public interface PostFirstWriteNoticeActivityComponent extends AndroidInjector<PostFirstWriteNoticeActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PostFirstWriteNoticeActivity> {
    }
}
