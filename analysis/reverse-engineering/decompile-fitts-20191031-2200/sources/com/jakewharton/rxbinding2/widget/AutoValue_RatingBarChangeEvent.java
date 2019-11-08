package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import androidx.annotation.NonNull;

final class AutoValue_RatingBarChangeEvent extends RatingBarChangeEvent {
    private final boolean fromUser;
    private final float rating;
    private final RatingBar view;

    AutoValue_RatingBarChangeEvent(RatingBar ratingBar, float f, boolean z) {
        if (ratingBar != null) {
            this.view = ratingBar;
            this.rating = f;
            this.fromUser = z;
            return;
        }
        throw new NullPointerException("Null view");
    }

    @NonNull
    public RatingBar view() {
        return this.view;
    }

    public float rating() {
        return this.rating;
    }

    public boolean fromUser() {
        return this.fromUser;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RatingBarChangeEvent{view=");
        sb.append(this.view);
        sb.append(", rating=");
        sb.append(this.rating);
        sb.append(", fromUser=");
        sb.append(this.fromUser);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RatingBarChangeEvent)) {
            return false;
        }
        RatingBarChangeEvent ratingBarChangeEvent = (RatingBarChangeEvent) obj;
        if (!(this.view.equals(ratingBarChangeEvent.view()) && Float.floatToIntBits(this.rating) == Float.floatToIntBits(ratingBarChangeEvent.rating()) && this.fromUser == ratingBarChangeEvent.fromUser())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((this.view.hashCode() ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.rating)) * 1000003) ^ (this.fromUser ? 1231 : 1237);
    }
}
