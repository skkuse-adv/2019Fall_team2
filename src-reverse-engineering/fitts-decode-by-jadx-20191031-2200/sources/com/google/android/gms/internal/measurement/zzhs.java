package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzd;
import java.io.IOException;
import java.util.Arrays;

public final class zzhs {
    private static final zzhs zzaly = new zzhs(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzacz;
    private int zzaia;
    private Object[] zzakk;
    private int[] zzalz;

    public static zzhs zzwq() {
        return zzaly;
    }

    static zzhs zzwr() {
        return new zzhs();
    }

    static zzhs zza(zzhs zzhs, zzhs zzhs2) {
        int i = zzhs.count + zzhs2.count;
        int[] copyOf = Arrays.copyOf(zzhs.zzalz, i);
        System.arraycopy(zzhs2.zzalz, 0, copyOf, zzhs.count, zzhs2.count);
        Object[] copyOf2 = Arrays.copyOf(zzhs.zzakk, i);
        System.arraycopy(zzhs2.zzakk, 0, copyOf2, zzhs.count, zzhs2.count);
        return new zzhs(i, copyOf, copyOf2, true);
    }

    private zzhs() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhs(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzaia = -1;
        this.count = i;
        this.zzalz = iArr;
        this.zzakk = objArr;
        this.zzacz = z;
    }

    public final void zzry() {
        this.zzacz = false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzim zzim) throws IOException {
        if (zzim.zztk() == zzd.zzaip) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzim.zza(this.zzalz[i] >>> 3, this.zzakk[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzim.zza(this.zzalz[i2] >>> 3, this.zzakk[i2]);
        }
    }

    public final void zzb(zzim zzim) throws IOException {
        if (this.count != 0) {
            if (zzim.zztk() == zzd.zzaio) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzalz[i], this.zzakk[i], zzim);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzalz[i2], this.zzakk[i2], zzim);
            }
        }
    }

    private static void zzb(int i, Object obj, zzim zzim) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzim.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzim.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzim.zza(i2, (zzdp) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzim.zzf(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfi.zzuy());
        } else if (zzim.zztk() == zzd.zzaio) {
            zzim.zzbr(i2);
            ((zzhs) obj).zzb(zzim);
            zzim.zzbs(i2);
        } else {
            zzim.zzbs(i2);
            ((zzhs) obj).zzb(zzim);
            zzim.zzbr(i2);
        }
    }

    public final int zzws() {
        int i = this.zzaia;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzee.zzd(this.zzalz[i3] >>> 3, (zzdp) this.zzakk[i3]);
        }
        this.zzaia = i2;
        return i2;
    }

    public final int zzuk() {
        int i;
        int i2 = this.zzaia;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzalz[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzee.zze(i6, ((Long) this.zzakk[i4]).longValue());
            } else if (i7 == 1) {
                i = zzee.zzg(i6, ((Long) this.zzakk[i4]).longValue());
            } else if (i7 == 2) {
                i = zzee.zzc(i6, (zzdp) this.zzakk[i4]);
            } else if (i7 == 3) {
                i = (zzee.zzbi(i6) << 1) + ((zzhs) this.zzakk[i4]).zzuk();
            } else if (i7 == 5) {
                i = zzee.zzj(i6, ((Integer) this.zzakk[i4]).intValue());
            } else {
                throw new IllegalStateException(zzfi.zzuy());
            }
            i3 += i;
        }
        this.zzaia = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhs)) {
            return false;
        }
        zzhs zzhs = (zzhs) obj;
        int i = this.count;
        if (i == zzhs.count) {
            int[] iArr = this.zzalz;
            int[] iArr2 = zzhs.zzalz;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzakk;
                Object[] objArr2 = zzhs.zzakk;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzalz;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzakk;
        for (int i7 = 0; i7 < this.count; i7++) {
            i3 = (i3 * 31) + objArr[i7].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzgj.zzb(sb, i, String.valueOf(this.zzalz[i2] >>> 3), this.zzakk[i2]);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(int i, Object obj) {
        if (this.zzacz) {
            int i2 = this.count;
            if (i2 == this.zzalz.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzalz = Arrays.copyOf(this.zzalz, i3);
                this.zzakk = Arrays.copyOf(this.zzakk, i3);
            }
            int[] iArr = this.zzalz;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzakk[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
