package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.OutputStream;

public final class zzav extends zzp {
    private final Object data;
    private final zzaw zzda;
    private String zzdb;

    public zzav(zzaw zzaw, Object obj) {
        super("application/json; charset=UTF-8");
        this.zzda = (zzaw) zzdt.checkNotNull(zzaw);
        this.data = zzdt.checkNotNull(obj);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        zzaz zza = this.zzda.zza(outputStream, zzo());
        if (this.zzdb != null) {
            zza.zzau();
            zza.zzad(this.zzdb);
        }
        zza.zzd(this.data);
        if (this.zzdb != null) {
            zza.zzav();
        }
        zza.flush();
    }

    public final zzav zzab(String str) {
        this.zzdb = str;
        return this;
    }
}
