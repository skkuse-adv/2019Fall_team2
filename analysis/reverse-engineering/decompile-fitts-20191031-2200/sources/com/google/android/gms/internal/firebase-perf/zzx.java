package com.google.android.gms.internal.firebase-perf;

import java.util.Iterator;
import java.util.Set;

public abstract class zzx<E> extends zzq<E> implements Set<E> {
    private transient zzr<E> zzy;

    zzx() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return zzag.zza(this, obj);
    }

    public int hashCode() {
        return zzag.zza(this);
    }

    public zzr<E> zzf() {
        zzr<E> zzr = this.zzy;
        if (zzr != null) {
            return zzr;
        }
        zzr<E> zzo = zzo();
        this.zzy = zzo;
        return zzo;
    }

    /* access modifiers changed from: 0000 */
    public zzr<E> zzo() {
        return zzr.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
