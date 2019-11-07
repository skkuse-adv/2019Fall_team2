package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.nio.charset.Charset;

class zzgh extends zzgi {
    protected final byte[] zzpc;

    zzgh(byte[] bArr) {
        if (bArr != null) {
            this.zzpc = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzey() {
        return 0;
    }

    public byte zzv(int i) {
        return this.zzpc[i];
    }

    /* access modifiers changed from: 0000 */
    public byte zzw(int i) {
        return this.zzpc[i];
    }

    public int size() {
        return this.zzpc.length;
    }

    public final zzfx zzb(int i, int i2) {
        int zzb = zzfx.zzb(0, i2, size());
        if (zzb == 0) {
            return zzfx.zzov;
        }
        return new zzge(this.zzpc, zzey(), zzb);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzfy zzfy) throws IOException {
        zzfy.zzb(this.zzpc, zzey(), size());
    }

    /* access modifiers changed from: protected */
    public final String zzc(Charset charset) {
        return new String(this.zzpc, zzey(), size(), charset);
    }

    public final boolean zzew() {
        int zzey = zzey();
        return zzkg.zze(this.zzpc, zzey, size() + zzey);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx) || size() != ((zzfx) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzgh)) {
            return obj.equals(this);
        }
        zzgh zzgh = (zzgh) obj;
        int zzex = zzex();
        int zzex2 = zzgh.zzex();
        if (zzex == 0 || zzex2 == 0 || zzex == zzex2) {
            return zza((zzfx) zzgh, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzfx zzfx, int i, int i2) {
        if (i2 > zzfx.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzfx.size()) {
            int size2 = zzfx.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzfx instanceof zzgh)) {
            return zzfx.zzb(0, i2).equals(zzb(0, i2));
        } else {
            zzgh zzgh = (zzgh) zzfx;
            byte[] bArr = this.zzpc;
            byte[] bArr2 = zzgh.zzpc;
            int zzey = zzey() + i2;
            int zzey2 = zzey();
            int zzey3 = zzgh.zzey();
            while (zzey2 < zzey) {
                if (bArr[zzey2] != bArr2[zzey3]) {
                    return false;
                }
                zzey2++;
                zzey3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzhm.zza(i, this.zzpc, zzey(), i3);
    }
}
