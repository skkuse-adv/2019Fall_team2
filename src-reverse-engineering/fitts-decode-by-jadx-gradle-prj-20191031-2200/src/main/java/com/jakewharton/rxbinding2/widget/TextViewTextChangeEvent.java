package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

public abstract class TextViewTextChangeEvent {
    public abstract int before();

    public abstract int count();

    public abstract int start();

    @NonNull
    public abstract CharSequence text();

    @NonNull
    public abstract TextView view();

    @CheckResult
    @NonNull
    public static TextViewTextChangeEvent create(@NonNull TextView textView, @NonNull CharSequence charSequence, int i, int i2, int i3) {
        AutoValue_TextViewTextChangeEvent autoValue_TextViewTextChangeEvent = new AutoValue_TextViewTextChangeEvent(textView, charSequence, i, i2, i3);
        return autoValue_TextViewTextChangeEvent;
    }

    TextViewTextChangeEvent() {
    }
}
