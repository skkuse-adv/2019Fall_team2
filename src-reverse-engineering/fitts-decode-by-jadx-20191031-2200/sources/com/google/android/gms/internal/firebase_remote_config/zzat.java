package com.google.android.gms.internal.firebase_remote_config;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class zzat extends FilterInputStream {
    private long zzcy = 0;
    private final /* synthetic */ zzaq zzcz;

    public zzat(zzaq zzaq, InputStream inputStream) {
        this.zzcz = zzaq;
        super(inputStream);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read == -1) {
            zzap();
        } else {
            this.zzcy += (long) read;
        }
        return read;
    }

    public final int read() throws IOException {
        int read = this.in.read();
        if (read == -1) {
            zzap();
        } else {
            this.zzcy++;
        }
        return read;
    }

    public final long skip(long j) throws IOException {
        long skip = this.in.skip(j);
        this.zzcy += skip;
        return skip;
    }

    private final void zzap() throws IOException {
        long contentLength = this.zzcz.getContentLength();
        if (contentLength != -1) {
            long j = this.zzcy;
            if (j != 0 && j < contentLength) {
                StringBuilder sb = new StringBuilder(102);
                sb.append("Connection closed prematurely: bytesRead = ");
                sb.append(j);
                sb.append(", Content-Length = ");
                sb.append(contentLength);
                throw new IOException(sb.toString());
            }
        }
    }
}
