package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewSystemUiVisibilityChangeObservable extends Observable<Integer> {
    private final View view;

    static final class Listener extends MainThreadDisposable implements OnSystemUiVisibilityChangeListener {
        private final Observer<? super Integer> observer;
        private final View view;

        Listener(View view2, Observer<? super Integer> observer2) {
            this.view = view2;
            this.observer = observer2;
        }

        public void onSystemUiVisibilityChange(int i) {
            if (!isDisposed()) {
                this.observer.onNext(Integer.valueOf(i));
            }
        }

        /* access modifiers changed from: protected */
        public void onDispose() {
            this.view.setOnSystemUiVisibilityChangeListener(null);
        }
    }

    ViewSystemUiVisibilityChangeObservable(View view2) {
        this.view = view2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Integer> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.setOnSystemUiVisibilityChangeListener(listener);
        }
    }
}
