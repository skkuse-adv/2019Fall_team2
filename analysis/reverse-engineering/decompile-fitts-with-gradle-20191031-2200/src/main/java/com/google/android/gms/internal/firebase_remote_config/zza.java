package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;

public final class zza implements zzad, zzx {
    public zza() {
        this(false);
    }

    private zza(boolean z) {
    }

    public final void zza(zzab zzab) {
        zzab.zza((zzx) this);
    }

    public final void zzb(zzab zzab) throws IOException {
        String requestMethod = zzab.getRequestMethod();
        String str = HttpRequest.METHOD_POST;
        boolean equals = requestMethod.equals(str);
        boolean z = true;
        String str2 = HttpRequest.METHOD_GET;
        if (equals || ((!requestMethod.equals(str2) || zzab.zzt().zzp().length() <= 2048) && zzab.zzs().zzz(requestMethod))) {
            z = false;
        }
        if (z) {
            String requestMethod2 = zzab.getRequestMethod();
            zzab.zzw(str);
            zzab.zzx().zzb("X-HTTP-Method-Override", requestMethod2);
            if (requestMethod2.equals(str2)) {
                zzab.zza((zzs) new zzan((zzt) zzab.zzt().clone()));
                zzab.zzt().clear();
            } else if (zzab.zzu() == null) {
                zzab.zza((zzs) new zzo());
            }
        }
    }
}
