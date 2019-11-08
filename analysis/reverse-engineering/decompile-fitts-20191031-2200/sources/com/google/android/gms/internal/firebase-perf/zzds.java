package com.google.android.gms.internal.firebase-perf;

final class zzds extends zzdv {
    private final int zzmx;
    private final int zzmy;

    zzds(byte[] bArr, int i, int i2) {
        super(bArr);
        zzdl.zzc(i, i + i2, bArr.length);
        this.zzmx = i;
        this.zzmy = i2;
    }

    public final byte zzq(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzna[this.zzmx + i];
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
    public final byte zzr(int i) {
        return this.zzna[this.zzmx + i];
    }

    public final int size() {
        return this.zzmy;
    }

    /* access modifiers changed from: protected */
    public final int zzgk() {
        return this.zzmx;
    }
}
