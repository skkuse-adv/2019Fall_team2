package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.comment.CommentsActivity;

public interface CommentsActivityComponent extends AndroidInjector<CommentsActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<CommentsActivity> {
    }
}
