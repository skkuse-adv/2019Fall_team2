package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxRatingBar {
    @CheckResult
    @NonNull
    public static InitialValueObservable<Float> ratingChanges(@NonNull RatingBar ratingBar) {
        Preconditions.checkNotNull(ratingBar, "view == null");
        return new RatingBarRatingChangeObservable(ratingBar);
    }

    @CheckResult
    @NonNull
    public static InitialValueObservable<RatingBarChangeEvent> ratingChangeEvents(@NonNull RatingBar ratingBar) {
        Preconditions.checkNotNull(ratingBar, "view == null");
        return new RatingBarRatingChangeEventObservable(ratingBar);
    }

    @CheckResult
    @NonNull
    public static Consumer<? super Float> rating(@NonNull final RatingBar ratingBar) {
        Preconditions.checkNotNull(ratingBar, "view == null");
        return new Consumer<Float>() {
            public void accept(Float f) {
                ratingBar.setRating(f.floatValue());
            }
        };
    }

    @CheckResult
    @NonNull
    public static Consumer<? super Boolean> isIndicator(@NonNull final RatingBar ratingBar) {
        Preconditions.checkNotNull(ratingBar, "view == null");
        return new Consumer<Boolean>() {
            public void accept(Boolean bool) {
                ratingBar.setIsIndicator(bool.booleanValue());
            }
        };
    }
}
