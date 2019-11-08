package com.google.android.gms.internal.firebase_remote_config;

final class zzge extends zzgh {
    private final int zzoz;
    private final int zzpa;

    zzge(byte[] bArr, int i, int i2) {
        super(bArr);
        zzfx.zzb(i, i + i2, bArr.length);
        this.zzoz = i;
        this.zzpa = i2;
    }

    public final byte zzv(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzpc[this.zzoz + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    public final byte zzw(int i) {
        return this.zzpc[this.zzoz + i];
    }

    public final int size() {
        return this.zzpa;
    }

    /* access modifiers changed from: protected */
    public final int zzey() {
        return this.zzoz;
    }
}
