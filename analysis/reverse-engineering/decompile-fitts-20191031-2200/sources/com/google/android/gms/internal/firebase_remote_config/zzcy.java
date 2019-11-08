package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public final class zzcy extends zzl {
    zzcy(zzcx zzcx) {
        super(zzcx);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzf<?> zzf) throws IOException {
        super.zza(zzf);
    }

    static {
        Object[] objArr = {zzb.VERSION};
        if (!(zzb.zzb.intValue() == 1 && zzb.zzc.intValue() >= 15)) {
            throw new IllegalStateException(zzdy.zza("You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0-SNAPSHOT of the Firebase Remote Config API library.", objArr));
        }
    }
}
