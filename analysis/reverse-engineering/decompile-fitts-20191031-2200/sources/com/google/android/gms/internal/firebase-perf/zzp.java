package com.google.android.gms.internal.firebase-perf;

import java.util.Arrays;

class zzp<E> extends zzs<E> {
    int size = 0;
    Object[] zzo = new Object[4];
    boolean zzp;

    zzp(int i) {
        zzo.zza(4, "initialCapacity");
    }

    public zzp<E> zzb(E e) {
        zzf.checkNotNull(e);
        int i = this.size + 1;
        Object[] objArr = this.zzo;
        if (objArr.length < i) {
            this.zzo = Arrays.copyOf(objArr, zzs.zzd(objArr.length, i));
            this.zzp = false;
        } else if (this.zzp) {
            this.zzo = (Object[]) objArr.clone();
            this.zzp = false;
        }
        Object[] objArr2 = this.zzo;
        int i2 = this.size;
        this.size = i2 + 1;
        objArr2[i2] = e;
        return this;
    }
}
