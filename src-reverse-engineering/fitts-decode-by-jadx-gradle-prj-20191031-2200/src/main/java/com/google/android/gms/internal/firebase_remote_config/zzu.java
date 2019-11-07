package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.OutputStream;

public final class zzu implements zzcm {
    private final zzcm zzan;
    private final zzv zzao;

    public zzu(zzcm zzcm, zzv zzv) {
        this.zzan = (zzcm) zzdt.checkNotNull(zzcm);
        this.zzao = (zzv) zzdt.checkNotNull(zzv);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        this.zzao.zza(this.zzan, outputStream);
    }
}
