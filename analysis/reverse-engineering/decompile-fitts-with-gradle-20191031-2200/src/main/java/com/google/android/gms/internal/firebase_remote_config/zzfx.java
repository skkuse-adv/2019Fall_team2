package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.UByte;

public abstract class zzfx implements Serializable, Iterable<Byte> {
    public static final zzfx zzov = new zzgh(zzhm.zzua);
    private static final zzgd zzow = (zzfu.zzeu() ? new zzgk(null) : new zzgb(null));
    private int zziy = 0;

    zzfx() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    /* access modifiers changed from: 0000 */
    public abstract void zza(zzfy zzfy) throws IOException;

    public abstract zzfx zzb(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zzc(Charset charset);

    public abstract boolean zzew();

    public abstract byte zzv(int i);

    /* access modifiers changed from: 0000 */
    public abstract byte zzw(int i);

    public static zzfx zza(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzgh(zzow.zzc(bArr, i, i2));
    }

    public static zzfx zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    static zzfx zzb(byte[] bArr) {
        return new zzgh(bArr);
    }

    public static zzfx zzbj(String str) {
        return new zzgh(str.getBytes(zzhm.UTF_8));
    }

    public final String zzb(Charset charset) {
        return size() == 0 ? "" : zzc(charset);
    }

    public final int hashCode() {
        int i = this.zziy;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zziy = i;
        }
        return i;
    }

    static zzgf zzx(int i) {
        return new zzgf(i, null);
    }

    /* access modifiers changed from: protected */
    public final int zzex() {
        return this.zziy;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new zzga(this);
    }

    static {
        new zzfz();
    }
}
