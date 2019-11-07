package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import androidx.annotation.NonNull;

final class AutoValue_TextViewBeforeTextChangeEvent extends TextViewBeforeTextChangeEvent {
    private final int after;
    private final int count;
    private final int start;
    private final CharSequence text;
    private final TextView view;

    AutoValue_TextViewBeforeTextChangeEvent(TextView textView, CharSequence charSequence, int i, int i2, int i3) {
        if (textView != null) {
            this.view = textView;
            if (charSequence != null) {
                this.text = charSequence;
                this.start = i;
                this.count = i2;
                this.after = i3;
                return;
            }
            throw new NullPointerException("Null text");
        }
        throw new NullPointerException("Null view");
    }

    @NonNull
    public TextView view() {
        return this.view;
    }

    @NonNull
    public CharSequence text() {
        return this.text;
    }

    public int start() {
        return this.start;
    }

    public int count() {
        return this.count;
    }

    public int after() {
        return this.after;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewBeforeTextChangeEvent{view=");
        sb.append(this.view);
        sb.append(", text=");
        sb.append(this.text);
        sb.append(", start=");
        sb.append(this.start);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(", after=");
        sb.append(this.after);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextViewBeforeTextChangeEvent)) {
            return false;
        }
        TextViewBeforeTextChangeEvent textViewBeforeTextChangeEvent = (TextViewBeforeTextChangeEvent) obj;
        if (!(this.view.equals(textViewBeforeTextChangeEvent.view()) && this.text.equals(textViewBeforeTextChangeEvent.text()) && this.start == textViewBeforeTextChangeEvent.start() && this.count == textViewBeforeTextChangeEvent.count() && this.after == textViewBeforeTextChangeEvent.after())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((this.view.hashCode() ^ 1000003) * 1000003) ^ this.text.hashCode()) * 1000003) ^ this.start) * 1000003) ^ this.count) * 1000003) ^ this.after;
    }
}
