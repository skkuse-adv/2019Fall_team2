package com.google.android.gms.internal.firebase-perf;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzal extends WeakReference<Throwable> {
    private final int zzal;

    public zzal(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zzal = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.zzal;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzal.class) {
            if (this == obj) {
                return true;
            }
            zzal zzal2 = (zzal) obj;
            return this.zzal == zzal2.zzal && get() == zzal2.get();
        }
    }
}
