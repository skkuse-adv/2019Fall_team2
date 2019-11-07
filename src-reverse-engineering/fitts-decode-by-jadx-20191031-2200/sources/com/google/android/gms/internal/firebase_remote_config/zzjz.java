package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

final class zzjz extends zzjx<zzka, zzka> {
    zzjz() {
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzjg zzjg) {
        return false;
    }

    private static void zza(Object obj, zzka zzka) {
        ((zzhi) obj).zztc = zzka;
    }

    /* access modifiers changed from: 0000 */
    public final void zzm(Object obj) {
        ((zzhi) obj).zztc.zzes();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int zzw(Object obj) {
        return ((zzka) obj).zzgs();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int zzac(Object obj) {
        return ((zzka) obj).zzjc();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzi(Object obj, Object obj2) {
        zzka zzka = (zzka) obj;
        zzka zzka2 = (zzka) obj2;
        if (zzka2.equals(zzka.zzja())) {
            return zzka;
        }
        return zzka.zza(zzka, zzka2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(Object obj, zzku zzku) throws IOException {
        ((zzka) obj).zza(zzku);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, zzku zzku) throws IOException {
        ((zzka) obj).zzb(zzku);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        zza(obj, (zzka) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzab(Object obj) {
        zzka zzka = ((zzhi) obj).zztc;
        if (zzka != zzka.zzja()) {
            return zzka;
        }
        zzka zzjb = zzka.zzjb();
        zza(obj, zzjb);
        return zzjb;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzaa(Object obj) {
        return ((zzhi) obj).zztc;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzg(Object obj, Object obj2) {
        zza(obj, (zzka) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzs(Object obj) {
        zzka zzka = (zzka) obj;
        zzka.zzes();
        return zzka;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zziz() {
        return zzka.zzjb();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzka) obj).zzb((i << 3) | 3, (Object) (zzka) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, zzfx zzfx) {
        ((zzka) obj).zzb((i << 3) | 2, (Object) zzfx);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzka) obj).zzb((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzka) obj).zzb((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzka) obj).zzb(i << 3, (Object) Long.valueOf(j));
    }
}
