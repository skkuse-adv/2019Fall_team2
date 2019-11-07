package com.google.firebase.iid;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

final class zzr {
    private final String zza;
    /* access modifiers changed from: private */
    public final long zzb;

    zzr(String str, long j) {
        this.zza = (String) Preconditions.checkNotNull(str);
        this.zzb = j;
    }

    /* access modifiers changed from: 0000 */
    public final String zza() {
        return this.zza;
    }

    /* access modifiers changed from: 0000 */
    public final long zzb() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzr)) {
            return false;
        }
        zzr zzr = (zzr) obj;
        if (this.zzb != zzr.zzb || !this.zza.equals(zzr.zza)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb));
    }
}
