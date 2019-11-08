package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public final class zzca {
    /* JADX INFO: finally extract failed */
    public static long zzb(zzcm zzcm) throws IOException {
        zzbp zzbp = new zzbp();
        try {
            zzcm.writeTo(zzbp);
            zzbp.close();
            return zzbp.zzel;
        } catch (Throwable th) {
            zzbp.close();
            throw th;
        }
    }
}
