package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class TextViewAfterTextChangeEvent {
    @Nullable
    public abstract Editable editable();

    @NonNull
    public abstract TextView view();

    @CheckResult
    @NonNull
    public static TextViewAfterTextChangeEvent create(@NonNull TextView textView, @Nullable Editable editable) {
        return new AutoValue_TextViewAfterTextChangeEvent(textView, editable);
    }

    TextViewAfterTextChangeEvent() {
    }
}
