package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class RatingBarRatingChangeObservable extends InitialValueObservable<Float> {
    private final RatingBar view;

    static final class Listener extends MainThreadDisposable implements OnRatingBarChangeListener {
        private final Observer<? super Float> observer;
        private final RatingBar view;

        Listener(RatingBar ratingBar, Observer<? super Float> observer2) {
            this.view = ratingBar;
            this.observer = observer2;
        }

        public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
            if (!isDisposed()) {
                this.observer.onNext(Float.valueOf(f));
            }
        }

        /* access modifiers changed from: protected */
        public void onDispose() {
            this.view.setOnRatingBarChangeListener(null);
        }
    }

    RatingBarRatingChangeObservable(RatingBar ratingBar) {
        this.view = ratingBar;
    }

    /* access modifiers changed from: protected */
    public void subscribeListener(Observer<? super Float> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            this.view.setOnRatingBarChangeListener(listener);
            observer.onSubscribe(listener);
        }
    }

    /* access modifiers changed from: protected */
    public Float getInitialValue() {
        return Float.valueOf(this.view.getRating());
    }
}
