package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzd;
import java.io.IOException;
import java.util.Arrays;

public final class zzhf {
    private static final zzhf zzuq = new zzhf(0, new int[0], new Object[0], false);
    private int count;
    private int zzqq;
    private Object[] zztc;
    private int[] zzur;

    public static zzhf zzjf() {
        return zzuq;
    }

    public final void zzgf() {
    }

    static zzhf zza(zzhf zzhf, zzhf zzhf2) {
        int i = zzhf.count + zzhf2.count;
        int[] copyOf = Arrays.copyOf(zzhf.zzur, i);
        System.arraycopy(zzhf2.zzur, 0, copyOf, zzhf.count, zzhf2.count);
        Object[] copyOf2 = Arrays.copyOf(zzhf.zztc, i);
        System.arraycopy(zzhf2.zztc, 0, copyOf2, zzhf.count, zzhf2.count);
        return new zzhf(i, copyOf, copyOf2, true);
    }

    private zzhf() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhf(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzqq = -1;
        this.count = i;
        this.zzur = iArr;
        this.zztc = objArr;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzia zzia) throws IOException {
        if (zzia.zzgt() == zzd.zzrh) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzia.zza(this.zzur[i] >>> 3, this.zztc[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzia.zza(this.zzur[i2] >>> 3, this.zztc[i2]);
        }
    }

    public final void zzb(zzia zzia) throws IOException {
        if (this.count != 0) {
            if (zzia.zzgt() == zzd.zzrg) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzur[i], this.zztc[i], zzia);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzur[i2], this.zztc[i2], zzia);
            }
        }
    }

    private static void zzb(int i, Object obj, zzia zzia) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzia.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzia.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzia.zza(i2, (zzdl) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzia.zzj(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzex.zzhr());
        } else if (zzia.zzgt() == zzd.zzrg) {
            zzia.zzai(i2);
            ((zzhf) obj).zzb(zzia);
            zzia.zzaj(i2);
        } else {
            zzia.zzaj(i2);
            ((zzhf) obj).zzb(zzia);
            zzia.zzai(i2);
        }
    }

    public final int zzjg() {
        int i = this.zzqq;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzec.zzd(this.zzur[i3] >>> 3, (zzdl) this.zztc[i3]);
        }
        this.zzqq = i2;
        return i2;
    }

    public final int zzhm() {
        int i;
        int i2 = this.zzqq;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzur[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzec.zze(i6, ((Long) this.zztc[i4]).longValue());
            } else if (i7 == 1) {
                i = zzec.zzg(i6, ((Long) this.zztc[i4]).longValue());
            } else if (i7 == 2) {
                i = zzec.zzc(i6, (zzdl) this.zztc[i4]);
            } else if (i7 == 3) {
                i = (zzec.zzy(i6) << 1) + ((zzhf) this.zztc[i4]).zzhm();
            } else if (i7 == 5) {
                i = zzec.zzn(i6, ((Integer) this.zztc[i4]).intValue());
            } else {
                throw new IllegalStateException(zzex.zzhr());
            }
            i3 += i;
        }
        this.zzqq = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhf)) {
            return false;
        }
        zzhf zzhf = (zzhf) obj;
        int i = this.count;
        if (i == zzhf.count) {
            int[] iArr = this.zzur;
            int[] iArr2 = zzhf.zzur;
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
                Object[] objArr = this.zztc;
                Object[] objArr2 = zzhf.zztc;
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
        int[] iArr = this.zzur;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zztc;
        for (int i7 = 0; i7 < this.count; i7++) {
            i3 = (i3 * 31) + objArr[i7].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzgc.zza(sb, i, String.valueOf(this.zzur[i2] >>> 3), this.zztc[i2]);
        }
    }
}
