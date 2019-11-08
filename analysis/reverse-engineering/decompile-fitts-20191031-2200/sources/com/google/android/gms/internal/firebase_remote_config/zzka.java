package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zze;
import java.io.IOException;
import java.util.Arrays;

public final class zzka {
    private static final zzka zzxg = new zzka(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzol;
    private int zztd;
    private Object[] zzvs;
    private int[] zzxh;

    public static zzka zzja() {
        return zzxg;
    }

    static zzka zzjb() {
        return new zzka();
    }

    static zzka zza(zzka zzka, zzka zzka2) {
        int i = zzka.count + zzka2.count;
        int[] copyOf = Arrays.copyOf(zzka.zzxh, i);
        System.arraycopy(zzka2.zzxh, 0, copyOf, zzka.count, zzka2.count);
        Object[] copyOf2 = Arrays.copyOf(zzka.zzvs, i);
        System.arraycopy(zzka2.zzvs, 0, copyOf2, zzka.count, zzka2.count);
        return new zzka(i, copyOf, copyOf2, true);
    }

    private zzka() {
        this(0, new int[8], new Object[8], true);
    }

    private zzka(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zztd = -1;
        this.count = i;
        this.zzxh = iArr;
        this.zzvs = objArr;
        this.zzol = z;
    }

    public final void zzes() {
        this.zzol = false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzku zzku) throws IOException {
        if (zzku.zzgd() == zze.zzty) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzku.zza(this.zzxh[i] >>> 3, this.zzvs[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzku.zza(this.zzxh[i2] >>> 3, this.zzvs[i2]);
        }
    }

    public final void zzb(zzku zzku) throws IOException {
        if (this.count != 0) {
            if (zzku.zzgd() == zze.zztx) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzxh[i], this.zzvs[i], zzku);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzxh[i2], this.zzvs[i2], zzku);
            }
        }
    }

    private static void zzb(int i, Object obj, zzku zzku) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzku.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzku.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzku.zza(i2, (zzfx) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzku.zzg(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzhq.zzhj());
        } else if (zzku.zzgd() == zze.zztx) {
            zzku.zzaz(i2);
            ((zzka) obj).zzb(zzku);
            zzku.zzba(i2);
        } else {
            zzku.zzba(i2);
            ((zzka) obj).zzb(zzku);
            zzku.zzaz(i2);
        }
    }

    public final int zzjc() {
        int i = this.zztd;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzgs.zzd(this.zzxh[i3] >>> 3, (zzfx) this.zzvs[i3]);
        }
        this.zztd = i2;
        return i2;
    }

    public final int zzgs() {
        int i;
        int i2 = this.zztd;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzxh[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzgs.zze(i6, ((Long) this.zzvs[i4]).longValue());
            } else if (i7 == 1) {
                i = zzgs.zzg(i6, ((Long) this.zzvs[i4]).longValue());
            } else if (i7 == 2) {
                i = zzgs.zzc(i6, (zzfx) this.zzvs[i4]);
            } else if (i7 == 3) {
                i = (zzgs.zzaq(i6) << 1) + ((zzka) this.zzvs[i4]).zzgs();
            } else if (i7 == 5) {
                i = zzgs.zzk(i6, ((Integer) this.zzvs[i4]).intValue());
            } else {
                throw new IllegalStateException(zzhq.zzhj());
            }
            i3 += i;
        }
        this.zztd = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzka)) {
            return false;
        }
        zzka zzka = (zzka) obj;
        int i = this.count;
        if (i == zzka.count) {
            int[] iArr = this.zzxh;
            int[] iArr2 = zzka.zzxh;
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
                Object[] objArr = this.zzvs;
                Object[] objArr2 = zzka.zzvs;
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
        int[] iArr = this.zzxh;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzvs;
        for (int i7 = 0; i7 < this.count; i7++) {
            i3 = (i3 * 31) + objArr[i7].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzir.zza(sb, i, String.valueOf(this.zzxh[i2] >>> 3), this.zzvs[i2]);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(int i, Object obj) {
        if (this.zzol) {
            int i2 = this.count;
            if (i2 == this.zzxh.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzxh = Arrays.copyOf(this.zzxh, i3);
                this.zzvs = Arrays.copyOf(this.zzvs, i3);
            }
            int[] iArr = this.zzxh;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzvs[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
