package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public final class zzaa {
    private final zzad zzba;
    private final zzag zzx;

    zzaa(zzag zzag, zzad zzad) {
        this.zzx = zzag;
        this.zzba = zzad;
    }

    public final zzab zza(String str, zzt zzt, zzs zzs) throws IOException {
        zzab zzab = new zzab(this.zzx, null);
        zzad zzad = this.zzba;
        if (zzad != null) {
            zzad.zza(zzab);
        }
        zzab.zzw(str);
        zzab.zza(zzt);
        if (zzs != null) {
            zzab.zza(zzs);
        }
        return zzab;
    }
}
