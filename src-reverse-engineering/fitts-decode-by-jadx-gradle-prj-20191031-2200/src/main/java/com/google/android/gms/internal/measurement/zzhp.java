package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class zzhp<T, B> {
    zzhp() {
    }

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, zzdp zzdp);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zza(T t, zzim zzim) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract boolean zza(zzgy zzgy);

    /* access modifiers changed from: 0000 */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(T t, zzim zzim) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zze(Object obj, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zzf(Object obj, B b);

    /* access modifiers changed from: 0000 */
    public abstract T zzg(T t, T t2);

    /* access modifiers changed from: 0000 */
    public abstract void zzj(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract T zzp(B b);

    /* access modifiers changed from: 0000 */
    public abstract int zzt(T t);

    /* access modifiers changed from: 0000 */
    public abstract B zzwp();

    /* access modifiers changed from: 0000 */
    public abstract T zzx(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract B zzy(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract int zzz(T t);

    /* access modifiers changed from: 0000 */
    public final boolean zza(B b, zzgy zzgy) throws IOException {
        int tag = zzgy.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzgy.zzsi());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzgy.zzsk());
            return true;
        } else if (i2 == 2) {
            zza(b, i, zzgy.zzso());
            return true;
        } else if (i2 == 3) {
            Object zzwp = zzwp();
            int i3 = 4 | (i << 3);
            while (zzgy.zzsy() != Integer.MAX_VALUE) {
                if (!zza((B) zzwp, zzgy)) {
                    break;
                }
            }
            if (i3 == zzgy.getTag()) {
                zza(b, i, (T) zzp(zzwp));
                return true;
            }
            throw zzfi.zzux();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzgy.zzsl());
                return true;
            }
            throw zzfi.zzuy();
        }
    }
}
