package com.google.android.gms.internal.firebase_remote_config;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzef extends WeakReference<Throwable> {
    private final int zziy;

    public zzef(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zziy = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.zziy;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzef.class) {
            if (this == obj) {
                return true;
            }
            zzef zzef = (zzef) obj;
            return this.zziy == zzef.zziy && get() == zzef.get();
        }
    }
}
