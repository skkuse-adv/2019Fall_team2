package com.google.android.gms.internal.firebase_remote_config;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzce extends FilterInputStream {
    private final zzcb zzge;

    public zzce(InputStream inputStream, Logger logger, Level level, int i) {
        super(inputStream);
        this.zzge = new zzcb(logger, level, i);
    }

    public final int read() throws IOException {
        int read = super.read();
        this.zzge.write(read);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.zzge.write(bArr, i, read);
        }
        return read;
    }

    public final void close() throws IOException {
        this.zzge.close();
        super.close();
    }
}
