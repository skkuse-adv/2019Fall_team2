package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

abstract class zzjx<T, B> {
    zzjx() {
    }

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, zzfx zzfx);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zza(T t, zzku zzku) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract boolean zza(zzjg zzjg);

    /* access modifiers changed from: 0000 */
    public abstract T zzaa(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract B zzab(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract int zzac(T t);

    /* access modifiers changed from: 0000 */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(T t, zzku zzku) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zzg(Object obj, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zzh(Object obj, B b);

    /* access modifiers changed from: 0000 */
    public abstract T zzi(T t, T t2);

    /* access modifiers changed from: 0000 */
    public abstract B zziz();

    /* access modifiers changed from: 0000 */
    public abstract void zzm(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract T zzs(B b);

    /* access modifiers changed from: 0000 */
    public abstract int zzw(T t);

    /* access modifiers changed from: 0000 */
    public final boolean zza(B b, zzjg zzjg) throws IOException {
        int tag = zzjg.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzjg.zzfd());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzjg.zzff());
            return true;
        } else if (i2 == 2) {
            zza(b, i, zzjg.zzfj());
            return true;
        } else if (i2 == 3) {
            Object zziz = zziz();
            int i3 = 4 | (i << 3);
            while (zzjg.zzfz() != Integer.MAX_VALUE) {
                if (!zza((B) zziz, zzjg)) {
                    break;
                }
            }
            if (i3 == zzjg.getTag()) {
                zza(b, i, (T) zzs(zziz));
                return true;
            }
            throw zzhq.zzhi();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzjg.zzfg());
                return true;
            }
            throw zzhq.zzhj();
        }
    }
}
