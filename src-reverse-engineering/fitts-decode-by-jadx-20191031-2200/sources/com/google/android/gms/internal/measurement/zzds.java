package com.google.android.gms.internal.measurement;

final class zzds extends zzdz {
    private final int zzadl;
    private final int zzadm;

    zzds(byte[] bArr, int i, int i2) {
        super(bArr);
        zzdp.zzb(i, i + i2, bArr.length);
        this.zzadl = i;
        this.zzadm = i2;
    }

    public final byte zzaq(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzado[this.zzadl + i];
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
    public final byte zzar(int i) {
        return this.zzado[this.zzadl + i];
    }

    public final int size() {
        return this.zzadm;
    }

    /* access modifiers changed from: protected */
    public final int zzsd() {
        return this.zzadl;
    }
}
