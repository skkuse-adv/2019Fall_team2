package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class zzge implements zzgb {
    zzge() {
    }

    public final Map<?, ?> zzm(Object obj) {
        return (zzgc) obj;
    }

    public final zzfz<?, ?> zzr(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzn(Object obj) {
        return (zzgc) obj;
    }

    public final boolean zzo(Object obj) {
        return !((zzgc) obj).isMutable();
    }

    public final Object zzp(Object obj) {
        ((zzgc) obj).zzry();
        return obj;
    }

    public final Object zzq(Object obj) {
        return zzgc.zzvl().zzvm();
    }

    public final Object zzb(Object obj, Object obj2) {
        zzgc zzgc = (zzgc) obj;
        zzgc zzgc2 = (zzgc) obj2;
        if (!zzgc2.isEmpty()) {
            if (!zzgc.isMutable()) {
                zzgc = zzgc.zzvm();
            }
            zzgc.zza(zzgc2);
        }
        return zzgc;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzgc zzgc = (zzgc) obj;
        if (zzgc.isEmpty()) {
            return 0;
        }
        Iterator it = zzgc.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
