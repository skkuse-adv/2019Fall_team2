package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.post.detail.ReportPostActivity;

public interface ReportPostComponent extends AndroidInjector<ReportPostActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ReportPostActivity> {
    }
}
