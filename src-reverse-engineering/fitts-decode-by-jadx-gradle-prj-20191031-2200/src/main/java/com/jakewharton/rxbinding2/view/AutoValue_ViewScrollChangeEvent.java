package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.NonNull;

final class AutoValue_ViewScrollChangeEvent extends ViewScrollChangeEvent {
    private final int oldScrollX;
    private final int oldScrollY;
    private final int scrollX;
    private final int scrollY;
    private final View view;

    AutoValue_ViewScrollChangeEvent(View view2, int i, int i2, int i3, int i4) {
        if (view2 != null) {
            this.view = view2;
            this.scrollX = i;
            this.scrollY = i2;
            this.oldScrollX = i3;
            this.oldScrollY = i4;
            return;
        }
        throw new NullPointerException("Null view");
    }

    @NonNull
    public View view() {
        return this.view;
    }

    public int scrollX() {
        return this.scrollX;
    }

    public int scrollY() {
        return this.scrollY;
    }

    public int oldScrollX() {
        return this.oldScrollX;
    }

    public int oldScrollY() {
        return this.oldScrollY;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewScrollChangeEvent{view=");
        sb.append(this.view);
        sb.append(", scrollX=");
        sb.append(this.scrollX);
        sb.append(", scrollY=");
        sb.append(this.scrollY);
        sb.append(", oldScrollX=");
        sb.append(this.oldScrollX);
        sb.append(", oldScrollY=");
        sb.append(this.oldScrollY);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ViewScrollChangeEvent)) {
            return false;
        }
        ViewScrollChangeEvent viewScrollChangeEvent = (ViewScrollChangeEvent) obj;
        if (!(this.view.equals(viewScrollChangeEvent.view()) && this.scrollX == viewScrollChangeEvent.scrollX() && this.scrollY == viewScrollChangeEvent.scrollY() && this.oldScrollX == viewScrollChangeEvent.oldScrollX() && this.oldScrollY == viewScrollChangeEvent.oldScrollY())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((this.view.hashCode() ^ 1000003) * 1000003) ^ this.scrollX) * 1000003) ^ this.scrollY) * 1000003) ^ this.oldScrollX) * 1000003) ^ this.oldScrollY;
    }
}
