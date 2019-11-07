package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.post.upload.guide.PostFirstWriteGuideActivity;

public interface PostFirstWriteGuideActivityComponent extends AndroidInjector<PostFirstWriteGuideActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PostFirstWriteGuideActivity> {
    }
}
