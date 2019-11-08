package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class AutoValue_TextViewEditorActionEvent extends TextViewEditorActionEvent {
    private final int actionId;
    private final KeyEvent keyEvent;
    private final TextView view;

    AutoValue_TextViewEditorActionEvent(TextView textView, int i, @Nullable KeyEvent keyEvent2) {
        if (textView != null) {
            this.view = textView;
            this.actionId = i;
            this.keyEvent = keyEvent2;
            return;
        }
        throw new NullPointerException("Null view");
    }

    @NonNull
    public TextView view() {
        return this.view;
    }

    public int actionId() {
        return this.actionId;
    }

    @Nullable
    public KeyEvent keyEvent() {
        return this.keyEvent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewEditorActionEvent{view=");
        sb.append(this.view);
        sb.append(", actionId=");
        sb.append(this.actionId);
        sb.append(", keyEvent=");
        sb.append(this.keyEvent);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextViewEditorActionEvent)) {
            return false;
        }
        TextViewEditorActionEvent textViewEditorActionEvent = (TextViewEditorActionEvent) obj;
        if (this.view.equals(textViewEditorActionEvent.view()) && this.actionId == textViewEditorActionEvent.actionId()) {
            KeyEvent keyEvent2 = this.keyEvent;
            if (keyEvent2 != null) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int hashCode = (((this.view.hashCode() ^ 1000003) * 1000003) ^ this.actionId) * 1000003;
        KeyEvent keyEvent2 = this.keyEvent;
        return hashCode ^ (keyEvent2 == null ? 0 : keyEvent2.hashCode());
    }
}
