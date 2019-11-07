package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import photopicker.view.ImagePreviewActivity;

public interface ImagePreviewActivityComponent extends AndroidInjector<ImagePreviewActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ImagePreviewActivity> {
    }
}
