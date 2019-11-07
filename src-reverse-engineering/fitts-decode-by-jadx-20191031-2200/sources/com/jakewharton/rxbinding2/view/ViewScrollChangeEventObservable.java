package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.View.OnScrollChangeListener;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

@RequiresApi(23)
final class ViewScrollChangeEventObservable extends Observable<ViewScrollChangeEvent> {
    private final View view;

    static final class Listener extends MainThreadDisposable implements OnScrollChangeListener {
        private final Observer<? super ViewScrollChangeEvent> observer;
        private final View view;

        Listener(View view2, Observer<? super ViewScrollChangeEvent> observer2) {
            this.view = view2;
            this.observer = observer2;
        }

        public void onScrollChange(View view2, int i, int i2, int i3, int i4) {
            if (!isDisposed()) {
                this.observer.onNext(ViewScrollChangeEvent.create(view2, i, i2, i3, i4));
            }
        }

        /* access modifiers changed from: protected */
        public void onDispose() {
            this.view.setOnScrollChangeListener(null);
        }
    }

    ViewScrollChangeEventObservable(View view2) {
        this.view = view2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super ViewScrollChangeEvent> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.setOnScrollChangeListener(listener);
        }
    }
}
