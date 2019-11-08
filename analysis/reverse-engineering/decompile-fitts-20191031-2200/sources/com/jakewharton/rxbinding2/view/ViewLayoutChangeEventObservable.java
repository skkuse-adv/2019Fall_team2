package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewLayoutChangeEventObservable extends Observable<ViewLayoutChangeEvent> {
    private final View view;

    static final class Listener extends MainThreadDisposable implements OnLayoutChangeListener {
        private final Observer<? super ViewLayoutChangeEvent> observer;
        private final View view;

        Listener(View view2, Observer<? super ViewLayoutChangeEvent> observer2) {
            this.view = view2;
            this.observer = observer2;
        }

        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (!isDisposed()) {
                this.observer.onNext(ViewLayoutChangeEvent.create(view2, i, i2, i3, i4, i5, i6, i7, i8));
            }
        }

        /* access modifiers changed from: protected */
        public void onDispose() {
            this.view.removeOnLayoutChangeListener(this);
        }
    }

    ViewLayoutChangeEventObservable(View view2) {
        this.view = view2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super ViewLayoutChangeEvent> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.addOnLayoutChangeListener(listener);
        }
    }
}
