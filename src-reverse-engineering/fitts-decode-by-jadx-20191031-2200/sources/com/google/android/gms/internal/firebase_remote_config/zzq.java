package com.google.android.gms.internal.firebase_remote_config;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class zzq extends BufferedOutputStream {
    zzq(zzr zzr, OutputStream outputStream) {
        super(outputStream);
    }

    public final void close() throws IOException {
        try {
            flush();
        } catch (IOException unused) {
        }
    }
}
