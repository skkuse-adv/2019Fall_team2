package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

final class zzh implements zzah {
    private final /* synthetic */ zzah zzab;
    private final /* synthetic */ zzab zzac;
    private final /* synthetic */ zzf zzad;

    zzh(zzf zzf, zzah zzah, zzab zzab2) {
        this.zzad = zzf;
        this.zzab = zzah;
        this.zzac = zzab2;
    }

    public final void zzb(zzac zzac2) throws IOException {
        zzah zzah = this.zzab;
        if (zzah != null) {
            zzah.zzb(zzac2);
        }
        if (!zzac2.zzad() && this.zzac.zzab()) {
            throw this.zzad.zza(zzac2);
        }
    }
}
