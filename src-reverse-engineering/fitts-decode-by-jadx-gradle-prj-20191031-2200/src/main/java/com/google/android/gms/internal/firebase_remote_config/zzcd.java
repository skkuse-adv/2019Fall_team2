package com.google.android.gms.internal.firebase_remote_config;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzcd extends FilterOutputStream {
    private final zzcb zzge;

    public zzcd(OutputStream outputStream, Logger logger, Level level, int i) {
        super(outputStream);
        this.zzge = new zzcb(logger, level, i);
    }

    public final void write(int i) throws IOException {
        this.out.write(i);
        this.zzge.write(i);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.zzge.write(bArr, i, i2);
    }

    public final void close() throws IOException {
        this.zzge.close();
        super.close();
    }

    public final zzcb zzcc() {
        return this.zzge;
    }
}
