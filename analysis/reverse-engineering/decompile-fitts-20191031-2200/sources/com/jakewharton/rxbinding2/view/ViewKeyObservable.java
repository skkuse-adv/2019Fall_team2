package com.jakewharton.rxbinding2.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

final class ViewKeyObservable extends Observable<KeyEvent> {
    private final Predicate<? super KeyEvent> handled;
    private final View view;

    static final class Listener extends MainThreadDisposable implements OnKeyListener {
        private final Predicate<? super KeyEvent> handled;
        private final Observer<? super KeyEvent> observer;
        private final View view;

        Listener(View view2, Predicate<? super KeyEvent> predicate, Observer<? super KeyEvent> observer2) {
            this.view = view2;
            this.handled = predicate;
            this.observer = observer2;
        }

        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            if (!isDisposed()) {
                try {
                    if (this.handled.test(keyEvent)) {
                        this.observer.onNext(keyEvent);
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
            this.view.setOnKeyListener(null);
        }
    }

    ViewKeyObservable(View view2, Predicate<? super KeyEvent> predicate) {
        this.view = view2;
        this.handled = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super KeyEvent> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, this.handled, observer);
            observer.onSubscribe(listener);
            this.view.setOnKeyListener(listener);
        }
    }
}
