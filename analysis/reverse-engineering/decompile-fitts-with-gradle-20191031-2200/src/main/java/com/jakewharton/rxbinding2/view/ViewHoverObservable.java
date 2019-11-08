package com.jakewharton.rxbinding2.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class ViewHoverObservable extends Observable<MotionEvent> {
    private final Predicate<? super MotionEvent> handled;
    private final View view;

    static final class Listener extends MainThreadDisposable implements OnHoverListener {
        private final Predicate<? super MotionEvent> handled;
        private final Observer<? super MotionEvent> observer;
        private final View view;

        Listener(View view2, Predicate<? super MotionEvent> predicate, Observer<? super MotionEvent> observer2) {
            this.view = view2;
            this.handled = predicate;
            this.observer = observer2;
        }

        public boolean onHover(View view2, MotionEvent motionEvent) {
            if (!isDisposed()) {
                try {
                    if (this.handled.test(motionEvent)) {
                        this.observer.onNext(motionEvent);
                        return true;
                    }
                } catch (Exception e) {
                    this.observer.onError(e);
                    dispose();
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void onDispose() {
            this.view.setOnHoverListener(null);
        }
    }

    ViewHoverObservable(View view2, Predicate<? super MotionEvent> predicate) {
        this.view = view2;
        this.handled = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super MotionEvent> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, this.handled, observer);
            observer.onSubscribe(listener);
            this.view.setOnHoverListener(listener);
        }
    }
}
