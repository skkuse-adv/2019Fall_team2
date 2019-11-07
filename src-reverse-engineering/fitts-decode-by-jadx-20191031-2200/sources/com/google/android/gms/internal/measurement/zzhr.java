package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zzhr extends zzhp<zzhs, zzhs> {
    zzhr() {
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzgy zzgy) {
        return false;
    }

    private static void zza(Object obj, zzhs zzhs) {
        ((zzey) obj).zzahz = zzhs;
    }

    /* access modifiers changed from: 0000 */
    public final void zzj(Object obj) {
        ((zzey) obj).zzahz.zzry();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int zzt(Object obj) {
        return ((zzhs) obj).zzuk();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int zzz(Object obj) {
        return ((zzhs) obj).zzws();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzg(Object obj, Object obj2) {
        zzhs zzhs = (zzhs) obj;
        zzhs zzhs2 = (zzhs) obj2;
        if (zzhs2.equals(zzhs.zzwq())) {
            return zzhs;
        }
        return zzhs.zza(zzhs, zzhs2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(Object obj, zzim zzim) throws IOException {
        ((zzhs) obj).zza(zzim);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, zzim zzim) throws IOException {
        ((zzhs) obj).zzb(zzim);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzhs) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzy(Object obj) {
        zzhs zzhs = ((zzey) obj).zzahz;
        if (zzhs != zzhs.zzwq()) {
            return zzhs;
        }
        zzhs zzwr = zzhs.zzwr();
        zza(obj, zzwr);
        return zzwr;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzx(Object obj) {
        return ((zzey) obj).zzahz;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zze(Object obj, Object obj2) {
        zza(obj, (zzhs) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzp(Object obj) {
        zzhs zzhs = (zzhs) obj;
        zzhs.zzry();
        return zzhs;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzwp() {
        return zzhs.zzwr();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzhs) obj).zzb((i << 3) | 3, (Object) (zzhs) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, zzdp zzdp) {
        ((zzhs) obj).zzb((i << 3) | 2, (Object) zzdp);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzhs) obj).zzb((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzhs) obj).zzb((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzhs) obj).zzb(i << 3, (Object) Long.valueOf(j));
    }
}
