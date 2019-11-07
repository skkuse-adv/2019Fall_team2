package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import photopicker.view.ImageSelectorActivity;

public interface ImageSelectorActivityComponent extends AndroidInjector<ImageSelectorActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ImageSelectorActivity> {
    }
}
