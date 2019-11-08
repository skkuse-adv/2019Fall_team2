package com.google.android.gms.internal.firebase-perf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzge<T> implements zzgo<T> {
    private final boolean zztg;
    private final zzhg<?, ?> zztp;
    private final zzeg<?> zztq;

    private zzge(zzhg<?, ?> zzhg, zzeg<?> zzeg, zzfx zzfx) {
        this.zztp = zzhg;
        this.zztg = zzeg.zze(zzfx);
        this.zztq = zzeg;
    }

    static <T> zzge<T> zza(zzhg<?, ?> zzhg, zzeg<?> zzeg, zzfx zzfx) {
        return new zzge<>(zzhg, zzeg, zzfx);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zztp.zzo(t).equals(this.zztp.zzo(t2))) {
            return false;
        }
        if (this.zztg) {
            return this.zztq.zzc(t).equals(this.zztq.zzc(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zztp.zzo(t).hashCode();
        return this.zztg ? (hashCode * 53) + this.zztq.zzc(t).hashCode() : hashCode;
    }

    public final void zze(T t, T t2) {
        zzgq.zza(this.zztp, t, t2);
        if (this.zztg) {
            zzgq.zza(this.zztq, t, t2);
        }
    }

    public final void zza(T t, zzia zzia) throws IOException {
        Iterator it = this.zztq.zzc(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzej zzej = (zzej) entry.getKey();
            if (zzej.zzha() != zzhx.MESSAGE || zzej.zzhb() || zzej.zzhc()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzfe) {
                zzia.zza(zzej.zzdj(), (Object) ((zzfe) entry).zzhu().zzfz());
            } else {
                zzia.zza(zzej.zzdj(), entry.getValue());
            }
        }
        zzhg<?, ?> zzhg = this.zztp;
        zzhg.zzc(zzhg.zzo(t), zzia);
    }

    public final void zze(T t) {
        this.zztp.zze(t);
        this.zztq.zze((Object) t);
    }

    public final boolean zzm(T t) {
        return this.zztq.zzc(t).isInitialized();
    }

    public final int zzl(T t) {
        zzhg<?, ?> zzhg = this.zztp;
        int zzp = zzhg.zzp(zzhg.zzo(t)) + 0;
        return this.zztg ? zzp + this.zztq.zzc(t).zzgv() : zzp;
    }
}
