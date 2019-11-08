package com.google.android.gms.internal.firebase-perf;

import java.io.IOException;
import java.nio.charset.Charset;

class zzdv extends zzdw {
    protected final byte[] zzna;

    zzdv(byte[] bArr) {
        if (bArr != null) {
            this.zzna = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzgk() {
        return 0;
    }

    public byte zzq(int i) {
        return this.zzna[i];
    }

    /* access modifiers changed from: 0000 */
    public byte zzr(int i) {
        return this.zzna[i];
    }

    public int size() {
        return this.zzna.length;
    }

    public final zzdl zze(int i, int i2) {
        int zzc = zzdl.zzc(0, i2, size());
        if (zzc == 0) {
            return zzdl.zzmt;
        }
        return new zzds(this.zzna, zzgk(), zzc);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzdm zzdm) throws IOException {
        zzdm.zza(this.zzna, zzgk(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzna, zzgk(), size(), charset);
    }

    public final boolean zzgi() {
        int zzgk = zzgk();
        return zzho.zzc(this.zzna, zzgk, size() + zzgk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdl) || size() != ((zzdl) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzdv)) {
            return obj.equals(this);
        }
        zzdv zzdv = (zzdv) obj;
        int zzgj = zzgj();
        int zzgj2 = zzdv.zzgj();
        if (zzgj == 0 || zzgj2 == 0 || zzgj == zzgj2) {
            return zza(zzdv, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzdl zzdl, int i, int i2) {
        if (i2 > zzdl.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdl.size()) {
            int size2 = zzdl.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdl instanceof zzdv)) {
            return zzdl.zze(0, i2).equals(zze(0, i2));
        } else {
            zzdv zzdv = (zzdv) zzdl;
            byte[] bArr = this.zzna;
            byte[] bArr2 = zzdv.zzna;
            int zzgk = zzgk() + i2;
            int zzgk2 = zzgk();
            int zzgk3 = zzdv.zzgk();
            while (zzgk2 < zzgk) {
                if (bArr[zzgk2] != bArr2[zzgk3]) {
                    return false;
                }
                zzgk2++;
                zzgk3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        return zzes.zza(i, this.zzna, zzgk(), i3);
    }
}
