package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzcg implements zzcm {
    private final Logger logger;
    private final zzcm zzan;
    private final int zzbf;
    private final Level zzgd;

    public zzcg(zzcm zzcm, Logger logger2, Level level, int i) {
        this.zzan = zzcm;
        this.logger = logger2;
        this.zzgd = level;
        this.zzbf = i;
    }

    /* JADX INFO: finally extract failed */
    public final void writeTo(OutputStream outputStream) throws IOException {
        zzcd zzcd = new zzcd(outputStream, this.logger, this.zzgd, this.zzbf);
        try {
            this.zzan.writeTo(zzcd);
            zzcd.zzcc().close();
            outputStream.flush();
        } catch (Throwable th) {
            zzcd.zzcc().close();
            throw th;
        }
    }
}
