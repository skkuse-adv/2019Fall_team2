package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public class zzj implements zzi {
    private final String key;

    public zzj() {
        this(null);
    }

    public zzj(String str) {
        this(str, null);
    }

    private zzj(String str, String str2) {
        this.key = str;
    }

    public final void zza(zzf<?> zzf) throws IOException {
        String str = this.key;
        if (str != null) {
            zzf.put("key", str);
        }
    }
}
