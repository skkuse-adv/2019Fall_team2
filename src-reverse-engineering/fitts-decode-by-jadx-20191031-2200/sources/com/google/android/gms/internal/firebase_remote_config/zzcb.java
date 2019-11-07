package com.google.android.gms.internal.firebase_remote_config;

import com.kakao.network.ServerProtocol;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzcb extends ByteArrayOutputStream {
    private boolean closed;
    private final Logger logger;
    private int zzgb;
    private final int zzgc;
    private final Level zzgd;

    public zzcb(Logger logger2, Level level, int i) {
        this.logger = (Logger) zzdt.checkNotNull(logger2);
        this.zzgd = (Level) zzdt.checkNotNull(level);
        if (i >= 0) {
            this.zzgc = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final synchronized void write(int i) {
        if (!this.closed) {
            this.zzgb++;
            if (this.count < this.zzgc) {
                super.write(i);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (!this.closed) {
            this.zzgb += i2;
            if (this.count < this.zzgc) {
                int i3 = this.count + i2;
                if (i3 > this.zzgc) {
                    i2 += this.zzgc - i3;
                }
                super.write(bArr, i, i2);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final synchronized void close() throws IOException {
        if (!this.closed) {
            if (this.zzgb != 0) {
                StringBuilder sb = new StringBuilder("Total: ");
                zza(sb, this.zzgb);
                if (this.count != 0 && this.count < this.zzgb) {
                    sb.append(" (logging first ");
                    zza(sb, this.count);
                    sb.append(")");
                }
                this.logger.logp(Level.CONFIG, "com.google.api.client.util.LoggingByteArrayOutputStream", "close", sb.toString());
                if (this.count != 0) {
                    this.logger.logp(this.zzgd, "com.google.api.client.util.LoggingByteArrayOutputStream", "close", toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", ServerProtocol.AUTHORIZATION_HEADER_DELIMITER));
                }
            }
            this.closed = true;
        }
    }

    private static void zza(StringBuilder sb, int i) {
        if (i == 1) {
            sb.append("1 byte");
            return;
        }
        sb.append(NumberFormat.getInstance().format((long) i));
        sb.append(" bytes");
    }
}
