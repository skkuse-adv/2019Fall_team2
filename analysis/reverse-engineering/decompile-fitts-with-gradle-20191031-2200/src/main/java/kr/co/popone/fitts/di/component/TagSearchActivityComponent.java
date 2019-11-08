package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.tag.TagSearchActivity;

public interface TagSearchActivityComponent extends AndroidInjector<TagSearchActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<TagSearchActivity> {
    }
}
