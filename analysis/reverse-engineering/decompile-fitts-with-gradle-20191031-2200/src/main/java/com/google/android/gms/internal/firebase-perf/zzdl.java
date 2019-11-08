package com.google.android.gms.internal.firebase-perf;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.UByte;

public abstract class zzdl implements Serializable, Iterable<Byte> {
    public static final zzdl zzmt = new zzdv(zzes.EMPTY_BYTE_ARRAY);
    private int zzal = 0;

    zzdl() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: 0000 */
    public abstract void zza(zzdm zzdm) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int zzb(int i, int i2, int i3);

    public abstract zzdl zze(int i, int i2);

    public abstract boolean zzgi();

    public abstract byte zzq(int i);

    /* access modifiers changed from: 0000 */
    public abstract byte zzr(int i);

    public static zzdl zzaf(String str) {
        return new zzdv(str.getBytes(zzes.UTF_8));
    }

    public final String zzgh() {
        return size() == 0 ? "" : zza(zzes.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzal;
        if (i == 0) {
            int size = size();
            i = zzb(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzal = i;
        }
        return i;
    }

    static zzdt zzs(int i) {
        return new zzdt(i, null);
    }

    /* access modifiers changed from: protected */
    public final int zzgj() {
        return this.zzal;
    }

    static int zzc(int i, int i2, int i3) {
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
        return new zzdo(this);
    }

    static {
        if (zzdj.zzgc()) {
            new zzdy(null);
        } else {
            new zzdp(null);
        }
        new zzdn();
    }
}
