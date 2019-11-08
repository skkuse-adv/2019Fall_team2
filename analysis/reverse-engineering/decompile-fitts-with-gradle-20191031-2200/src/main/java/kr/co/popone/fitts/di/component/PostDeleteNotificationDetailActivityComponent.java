package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.post.notification.PostDeleteNotificationDetailActivity;

public interface PostDeleteNotificationDetailActivityComponent extends AndroidInjector<PostDeleteNotificationDetailActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PostDeleteNotificationDetailActivity> {
    }
}
