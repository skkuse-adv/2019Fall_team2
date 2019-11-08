package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

public abstract class ViewScrollChangeEvent {
    public abstract int oldScrollX();

    public abstract int oldScrollY();

    public abstract int scrollX();

    public abstract int scrollY();

    @NonNull
    public abstract View view();

    @CheckResult
    @NonNull
    public static ViewScrollChangeEvent create(@NonNull View view, int i, int i2, int i3, int i4) {
        AutoValue_ViewScrollChangeEvent autoValue_ViewScrollChangeEvent = new AutoValue_ViewScrollChangeEvent(view, i, i2, i3, i4);
        return autoValue_ViewScrollChangeEvent;
    }

    ViewScrollChangeEvent() {
    }
}
