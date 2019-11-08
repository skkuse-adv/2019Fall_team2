package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.NonNull;

final class AutoValue_ViewAttachAttachedEvent extends ViewAttachAttachedEvent {
    private final View view;

    AutoValue_ViewAttachAttachedEvent(View view2) {
        if (view2 != null) {
            this.view = view2;
            return;
        }
        throw new NullPointerException("Null view");
    }

    @NonNull
    public View view() {
        return this.view;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewAttachAttachedEvent{view=");
        sb.append(this.view);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ViewAttachAttachedEvent)) {
            return false;
        }
        return this.view.equals(((ViewAttachAttachedEvent) obj).view());
    }

    public int hashCode() {
        return this.view.hashCode() ^ 1000003;
    }
}
