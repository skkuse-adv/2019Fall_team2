package com.jakewharton.rxbinding2.internal;

import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposables;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class Preconditions {
    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static boolean checkMainThread(Observer<?> observer) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        observer.onSubscribe(Disposables.empty());
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to be called on the main thread but was ");
        sb.append(Thread.currentThread().getName());
        observer.onError(new IllegalStateException(sb.toString()));
        return false;
    }
}
