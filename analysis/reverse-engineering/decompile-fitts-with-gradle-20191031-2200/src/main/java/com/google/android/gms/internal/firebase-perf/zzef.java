package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzb;
import java.io.IOException;
import java.util.Map.Entry;

final class zzef extends zzeg<Object> {
    zzef() {
    }

    /* access modifiers changed from: 0000 */
    public final boolean zze(zzfx zzfx) {
        return zzfx instanceof zzb;
    }

    /* access modifiers changed from: 0000 */
    public final zzeh<Object> zzc(Object obj) {
        return ((zzb) obj).zzqs;
    }

    /* access modifiers changed from: 0000 */
    public final zzeh<Object> zzd(Object obj) {
        zzb zzb = (zzb) obj;
        if (zzb.zzqs.isImmutable()) {
            zzb.zzqs = (zzeh) zzb.zzqs.clone();
        }
        return zzb.zzqs;
    }

    /* access modifiers changed from: 0000 */
    public final void zze(Object obj) {
        zzc(obj).zzgf();
    }

    /* access modifiers changed from: 0000 */
    public final int zzb(Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzia zzia, Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }
}
