package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable upstream;

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.validate(this.upstream, disposable, getClass())) {
            this.upstream = disposable;
            onStart();
        }
    }
}
