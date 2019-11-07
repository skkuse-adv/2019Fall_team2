package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

class zzdz extends zzdw {
    protected final byte[] zzado;

    zzdz(byte[] bArr) {
        if (bArr != null) {
            this.zzado = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzsd() {
        return 0;
    }

    public byte zzaq(int i) {
        return this.zzado[i];
    }

    /* access modifiers changed from: 0000 */
    public byte zzar(int i) {
        return this.zzado[i];
    }

    public int size() {
        return this.zzado.length;
    }

    public final zzdp zza(int i, int i2) {
        int zzb = zzdp.zzb(0, i2, size());
        if (zzb == 0) {
            return zzdp.zzadh;
        }
        return new zzds(this.zzado, zzsd(), zzb);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzdm zzdm) throws IOException {
        zzdm.zza(this.zzado, zzsd(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzado, zzsd(), size(), charset);
    }

    public final boolean zzsb() {
        int zzsd = zzsd();
        return zzhy.zzf(this.zzado, zzsd, size() + zzsd);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdp) || size() != ((zzdp) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzdz)) {
            return obj.equals(this);
        }
        zzdz zzdz = (zzdz) obj;
        int zzsc = zzsc();
        int zzsc2 = zzdz.zzsc();
        if (zzsc == 0 || zzsc2 == 0 || zzsc == zzsc2) {
            return zza((zzdp) zzdz, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzdp zzdp, int i, int i2) {
        if (i2 > zzdp.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdp.size()) {
            int size2 = zzdp.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdp instanceof zzdz)) {
            return zzdp.zza(0, i2).equals(zza(0, i2));
        } else {
            zzdz zzdz = (zzdz) zzdp;
            byte[] bArr = this.zzado;
            byte[] bArr2 = zzdz.zzado;
            int zzsd = zzsd() + i2;
            int zzsd2 = zzsd();
            int zzsd3 = zzdz.zzsd();
            while (zzsd2 < zzsd) {
                if (bArr[zzsd2] != bArr2[zzsd3]) {
                    return false;
                }
                zzsd2++;
                zzsd3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzez.zza(i, this.zzado, zzsd(), i3);
    }
}
