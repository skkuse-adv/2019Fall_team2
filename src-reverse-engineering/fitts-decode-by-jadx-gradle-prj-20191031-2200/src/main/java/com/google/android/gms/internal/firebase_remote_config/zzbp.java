package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.OutputStream;

final class zzbp extends OutputStream {
    long zzel;

    zzbp() {
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.zzel += (long) i2;
    }

    public final void write(int i) throws IOException {
        this.zzel++;
    }
}
