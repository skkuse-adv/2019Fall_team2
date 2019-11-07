package com.google.android.gms.internal.firebase-perf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzec extends zzdm {
    private static final Logger logger = Logger.getLogger(zzec.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zznh = zzhm.zzjh();
    zzee zzni = this;

    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zza(String str, Throwable th) {
            String valueOf = String.valueOf(str);
            String str2 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
            super(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    static class zzb extends zzec {
        private final byte[] buffer;
        private final int limit;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.position = 0;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void zzf(int i, int i2) throws IOException {
            zzv((i << 3) | i2);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzf(i, 0);
            zzu(i2);
        }

        public final void zzh(int i, int i2) throws IOException {
            zzf(i, 0);
            zzv(i2);
        }

        public final void zzj(int i, int i2) throws IOException {
            zzf(i, 5);
            zzx(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzf(i, 0);
            zzam(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzf(i, 1);
            zzao(j);
        }

        public final void zza(int i, boolean z) throws IOException {
            zzf(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzf(i, 2);
            zzag(str);
        }

        public final void zza(int i, zzdl zzdl) throws IOException {
            zzf(i, 2);
            zza(zzdl);
        }

        public final void zza(zzdl zzdl) throws IOException {
            zzv(zzdl.size());
            zzdl.zza((zzdm) this);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzv(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzfx zzfx, zzgo zzgo) throws IOException {
            zzf(i, 2);
            zzdg zzdg = (zzdg) zzfx;
            int zzga = zzdg.zzga();
            if (zzga == -1) {
                zzga = zzgo.zzl(zzdg);
                zzdg.zzp(zzga);
            }
            zzv(zzga);
            zzgo.zza(zzfx, this.zzni);
        }

        public final void zza(int i, zzfx zzfx) throws IOException {
            zzf(1, 3);
            zzh(2, i);
            zzf(3, 2);
            zzb(zzfx);
            zzf(1, 4);
        }

        public final void zzb(int i, zzdl zzdl) throws IOException {
            zzf(1, 3);
            zzh(2, i);
            zza(3, zzdl);
            zzf(1, 4);
        }

        public final void zzb(zzfx zzfx) throws IOException {
            zzv(zzfx.zzhm());
            zzfx.zzb(this);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzu(int i) throws IOException {
            if (i >= 0) {
                zzv(i);
            } else {
                zzam((long) i);
            }
        }

        public final void zzv(int i) throws IOException {
            if (!zzec.zznh || zzdj.zzgc() || zzgo() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzhm.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzhm.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzhm.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzhm.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzhm.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzhm.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzhm.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzhm.zza(bArr10, (long) i14, (byte) (i12 | 128));
                int i15 = i12 >>> 7;
                byte[] bArr11 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                zzhm.zza(bArr11, (long) i16, (byte) i15);
            }
        }

        public final void zzx(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzam(long j) throws IOException {
            if (!zzec.zznh || zzgo() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzhm.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzhm.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzao(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzag(String str) throws IOException {
            int i = this.position;
            try {
                int zzaa = zzec.zzaa(str.length() * 3);
                int zzaa2 = zzec.zzaa(str.length());
                if (zzaa2 == zzaa) {
                    this.position = i + zzaa2;
                    int zzb = zzho.zzb(str, this.buffer, this.position, zzgo());
                    this.position = i;
                    zzv((zzb - i) - zzaa2);
                    this.position = zzb;
                    return;
                }
                zzv(zzho.zza(str));
                this.position = zzho.zzb(str, this.buffer, this.position, zzgo());
            } catch (zzhp e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        public final int zzgo() {
            return this.limit - this.position;
        }
    }

    public static int zzaa(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzac(int i) {
        return 4;
    }

    public static int zzad(int i) {
        return 4;
    }

    private static int zzag(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzaq(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    public static int zzas(long j) {
        return 8;
    }

    public static int zzat(long j) {
        return 8;
    }

    private static long zzau(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static zzec zzb(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zze(boolean z) {
        return 1;
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzdl zzdl) throws IOException;

    public abstract void zza(int i, zzfx zzfx) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(int i, zzfx zzfx, zzgo zzgo) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(zzdl zzdl) throws IOException;

    public abstract void zzag(String str) throws IOException;

    public abstract void zzam(long j) throws IOException;

    public abstract void zzao(long j) throws IOException;

    public abstract void zzb(int i, zzdl zzdl) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(zzfx zzfx) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract int zzgo();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzu(int i) throws IOException;

    public abstract void zzv(int i) throws IOException;

    public abstract void zzx(int i) throws IOException;

    private zzec() {
    }

    public final void zzi(int i, int i2) throws IOException {
        zzh(i, zzag(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzau(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzj(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzw(int i) throws IOException {
        zzv(zzag(i));
    }

    public final void zzan(long j) throws IOException {
        zzam(zzau(j));
    }

    public final void zza(float f) throws IOException {
        zzx(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) throws IOException {
        zzao(Double.doubleToRawLongBits(d));
    }

    public final void zzd(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzk(int i, int i2) {
        return zzy(i) + zzz(i2);
    }

    public static int zzl(int i, int i2) {
        return zzy(i) + zzaa(i2);
    }

    public static int zzm(int i, int i2) {
        return zzy(i) + zzaa(zzag(i2));
    }

    public static int zzn(int i, int i2) {
        return zzy(i) + 4;
    }

    public static int zzo(int i, int i2) {
        return zzy(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzy(i) + zzaq(j);
    }

    public static int zze(int i, long j) {
        return zzy(i) + zzaq(j);
    }

    public static int zzf(int i, long j) {
        return zzy(i) + zzaq(zzau(j));
    }

    public static int zzg(int i, long j) {
        return zzy(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzy(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzy(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzy(i) + 8;
    }

    public static int zzb(int i, boolean z) {
        return zzy(i) + 1;
    }

    public static int zzp(int i, int i2) {
        return zzy(i) + zzz(i2);
    }

    public static int zzc(int i, String str) {
        return zzy(i) + zzah(str);
    }

    public static int zzc(int i, zzdl zzdl) {
        int zzy = zzy(i);
        int size = zzdl.size();
        return zzy + zzaa(size) + size;
    }

    public static int zza(int i, zzfg zzfg) {
        int zzy = zzy(i);
        int zzhm = zzfg.zzhm();
        return zzy + zzaa(zzhm) + zzhm;
    }

    static int zzb(int i, zzfx zzfx, zzgo zzgo) {
        return zzy(i) + zza(zzfx, zzgo);
    }

    public static int zzb(int i, zzfx zzfx) {
        return (zzy(1) << 1) + zzl(2, i) + zzy(3) + zzc(zzfx);
    }

    public static int zzd(int i, zzdl zzdl) {
        return (zzy(1) << 1) + zzl(2, i) + zzc(3, zzdl);
    }

    public static int zzb(int i, zzfg zzfg) {
        return (zzy(1) << 1) + zzl(2, i) + zza(3, zzfg);
    }

    public static int zzy(int i) {
        return zzaa(i << 3);
    }

    public static int zzz(int i) {
        if (i >= 0) {
            return zzaa(i);
        }
        return 10;
    }

    public static int zzab(int i) {
        return zzaa(zzag(i));
    }

    public static int zzap(long j) {
        return zzaq(j);
    }

    public static int zzar(long j) {
        return zzaq(zzau(j));
    }

    public static int zzae(int i) {
        return zzz(i);
    }

    public static int zzah(String str) {
        int i;
        try {
            i = zzho.zza(str);
        } catch (zzhp unused) {
            i = str.getBytes(zzes.UTF_8).length;
        }
        return zzaa(i) + i;
    }

    public static int zza(zzfg zzfg) {
        int zzhm = zzfg.zzhm();
        return zzaa(zzhm) + zzhm;
    }

    public static int zzb(zzdl zzdl) {
        int size = zzdl.size();
        return zzaa(size) + size;
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return zzaa(length) + length;
    }

    public static int zzc(zzfx zzfx) {
        int zzhm = zzfx.zzhm();
        return zzaa(zzhm) + zzhm;
    }

    static int zza(zzfx zzfx, zzgo zzgo) {
        zzdg zzdg = (zzdg) zzfx;
        int zzga = zzdg.zzga();
        if (zzga == -1) {
            zzga = zzgo.zzl(zzdg);
            zzdg.zzp(zzga);
        }
        return zzaa(zzga) + zzga;
    }

    static int zzaf(int i) {
        return zzaa(i) + i;
    }

    public final void zzgp() {
        if (zzgo() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(String str, zzhp zzhp) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzhp);
        byte[] bytes = str.getBytes(zzes.UTF_8);
        try {
            zzv(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzfx zzfx, zzgo zzgo) {
        int zzy = zzy(i) << 1;
        zzdg zzdg = (zzdg) zzfx;
        int zzga = zzdg.zzga();
        if (zzga == -1) {
            zzga = zzgo.zzl(zzdg);
            zzdg.zzp(zzga);
        }
        return zzy + zzga;
    }

    @Deprecated
    public static int zzd(zzfx zzfx) {
        return zzfx.zzhm();
    }

    @Deprecated
    public static int zzah(int i) {
        return zzaa(i);
    }
}
