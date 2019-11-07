package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class AutoValue_TextViewAfterTextChangeEvent extends TextViewAfterTextChangeEvent {
    private final Editable editable;
    private final TextView view;

    AutoValue_TextViewAfterTextChangeEvent(TextView textView, @Nullable Editable editable2) {
        if (textView != null) {
            this.view = textView;
            this.editable = editable2;
            return;
        }
        throw new NullPointerException("Null view");
    }

    @NonNull
    public TextView view() {
        return this.view;
    }

    @Nullable
    public Editable editable() {
        return this.editable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewAfterTextChangeEvent{view=");
        sb.append(this.view);
        sb.append(", editable=");
        sb.append(this.editable);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextViewAfterTextChangeEvent)) {
            return false;
        }
        TextViewAfterTextChangeEvent textViewAfterTextChangeEvent = (TextViewAfterTextChangeEvent) obj;
        if (this.view.equals(textViewAfterTextChangeEvent.view())) {
            Editable editable2 = this.editable;
            if (editable2 != null) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int hashCode = (this.view.hashCode() ^ 1000003) * 1000003;
        Editable editable2 = this.editable;
        return hashCode ^ (editable2 == null ? 0 : editable2.hashCode());
    }
}
