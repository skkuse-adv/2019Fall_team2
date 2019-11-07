package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.post.PostingViolationNoticeActivity;

public interface PostingViolationNoticeActivityComponent extends AndroidInjector<PostingViolationNoticeActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PostingViolationNoticeActivity> {
    }
}
