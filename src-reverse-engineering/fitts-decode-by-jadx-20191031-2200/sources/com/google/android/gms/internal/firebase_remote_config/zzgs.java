package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzgs extends zzfy {
    private static final Logger logger = Logger.getLogger(zzgs.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzpv = zzkd.zzjd();
    zzgu zzpw = this;

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

    static class zzb extends zzgs {
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

        public final void zzc(int i, int i2) throws IOException {
            zzan((i << 3) | i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzam(i2);
        }

        public final void zze(int i, int i2) throws IOException {
            zzc(i, 0);
            zzan(i2);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzc(i, 5);
            zzap(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzc(i, 0);
            zzf(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzc(i, 1);
            zzh(j);
        }

        public final void zzc(int i, boolean z) throws IOException {
            zzc(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzc(i, 2);
            zzbk(str);
        }

        public final void zza(int i, zzfx zzfx) throws IOException {
            zzc(i, 2);
            zzb(zzfx);
        }

        public final void zzb(zzfx zzfx) throws IOException {
            zzan(zzfx.size());
            zzfx.zza((zzfy) this);
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzan(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zziq zziq, zzjf zzjf) throws IOException {
            zzc(i, 2);
            zzfq zzfq = (zzfq) zziq;
            int zzeq = zzfq.zzeq();
            if (zzeq == -1) {
                zzeq = zzjf.zzw(zzfq);
                zzfq.zzr(zzeq);
            }
            zzan(zzeq);
            zzjf.zza(zziq, this.zzpw);
        }

        public final void zza(int i, zziq zziq) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zzc(3, 2);
            zzb(zziq);
            zzc(1, 4);
        }

        public final void zzb(int i, zzfx zzfx) throws IOException {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzfx);
            zzc(1, 4);
        }

        public final void zzb(zziq zziq) throws IOException {
            zzan(zziq.zzgs());
            zziq.zzb(this);
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

        public final void zzam(int i) throws IOException {
            if (i >= 0) {
                zzan(i);
            } else {
                zzf((long) i);
            }
        }

        public final void zzan(int i) throws IOException {
            if (!zzgs.zzpv || zzfu.zzeu() || zzgb() < 5) {
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
                zzkd.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzkd.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzkd.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzkd.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzkd.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzkd.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzkd.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzkd.zza(bArr10, (long) i14, (byte) (i12 | 128));
                int i15 = i12 >>> 7;
                byte[] bArr11 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                zzkd.zza(bArr11, (long) i16, (byte) i15);
            }
        }

        public final void zzap(int i) throws IOException {
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

        public final void zzf(long j) throws IOException {
            if (!zzgs.zzpv || zzgb() < 10) {
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
                    zzkd.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzkd.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzh(long j) throws IOException {
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

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzbk(String str) throws IOException {
            int i = this.position;
            try {
                int zzas = zzgs.zzas(str.length() * 3);
                int zzas2 = zzgs.zzas(str.length());
                if (zzas2 == zzas) {
                    this.position = i + zzas2;
                    int zza = zzkg.zza(str, this.buffer, this.position, zzgb());
                    this.position = i;
                    zzan((zza - i) - zzas2);
                    this.position = zza;
                    return;
                }
                zzan(zzkg.zzb(str));
                this.position = zzkg.zza(str, this.buffer, this.position, zzgb());
            } catch (zzkj e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        public final int zzgb() {
            return this.limit - this.position;
        }
    }

    public static int zzas(int i) {
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

    public static int zzau(int i) {
        return 4;
    }

    public static int zzav(int i) {
        return 4;
    }

    private static int zzax(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzc(float f) {
        return 4;
    }

    public static zzgs zzc(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzd(double d) {
        return 8;
    }

    public static int zze(boolean z) {
        return 1;
    }

    public static int zzj(long j) {
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

    public static int zzl(long j) {
        return 8;
    }

    public static int zzm(long j) {
        return 8;
    }

    private static long zzn(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzfx zzfx) throws IOException;

    public abstract void zza(int i, zziq zziq) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(int i, zziq zziq, zzjf zzjf) throws IOException;

    public abstract void zzam(int i) throws IOException;

    public abstract void zzan(int i) throws IOException;

    public abstract void zzap(int i) throws IOException;

    public abstract void zzb(int i, zzfx zzfx) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(zzfx zzfx) throws IOException;

    public abstract void zzb(zziq zziq) throws IOException;

    public abstract void zzbk(String str) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(int i, boolean z) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zzd(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract int zzgb();

    public abstract void zzh(long j) throws IOException;

    private zzgs() {
    }

    public final void zzf(int i, int i2) throws IOException {
        zze(i, zzax(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzn(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzao(int i) throws IOException {
        zzan(zzax(i));
    }

    public final void zzg(long j) throws IOException {
        zzf(zzn(j));
    }

    public final void zzb(float f) throws IOException {
        zzap(Float.floatToRawIntBits(f));
    }

    public final void zzc(double d) throws IOException {
        zzh(Double.doubleToRawLongBits(d));
    }

    public final void zzd(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzh(int i, int i2) {
        return zzaq(i) + zzar(i2);
    }

    public static int zzi(int i, int i2) {
        return zzaq(i) + zzas(i2);
    }

    public static int zzj(int i, int i2) {
        return zzaq(i) + zzas(zzax(i2));
    }

    public static int zzk(int i, int i2) {
        return zzaq(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzaq(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzaq(i) + zzj(j);
    }

    public static int zze(int i, long j) {
        return zzaq(i) + zzj(j);
    }

    public static int zzf(int i, long j) {
        return zzaq(i) + zzj(zzn(j));
    }

    public static int zzg(int i, long j) {
        return zzaq(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzaq(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzaq(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzaq(i) + 8;
    }

    public static int zzd(int i, boolean z) {
        return zzaq(i) + 1;
    }

    public static int zzm(int i, int i2) {
        return zzaq(i) + zzar(i2);
    }

    public static int zzc(int i, String str) {
        return zzaq(i) + zzbl(str);
    }

    public static int zzc(int i, zzfx zzfx) {
        int zzaq = zzaq(i);
        int size = zzfx.size();
        return zzaq + zzas(size) + size;
    }

    public static int zza(int i, zzhv zzhv) {
        int zzaq = zzaq(i);
        int zzgs = zzhv.zzgs();
        return zzaq + zzas(zzgs) + zzgs;
    }

    static int zzb(int i, zziq zziq, zzjf zzjf) {
        return zzaq(i) + zza(zziq, zzjf);
    }

    public static int zzb(int i, zziq zziq) {
        return (zzaq(1) << 1) + zzi(2, i) + zzaq(3) + zzc(zziq);
    }

    public static int zzd(int i, zzfx zzfx) {
        return (zzaq(1) << 1) + zzi(2, i) + zzc(3, zzfx);
    }

    public static int zzb(int i, zzhv zzhv) {
        return (zzaq(1) << 1) + zzi(2, i) + zza(3, zzhv);
    }

    public static int zzaq(int i) {
        return zzas(i << 3);
    }

    public static int zzar(int i) {
        if (i >= 0) {
            return zzas(i);
        }
        return 10;
    }

    public static int zzat(int i) {
        return zzas(zzax(i));
    }

    public static int zzi(long j) {
        return zzj(j);
    }

    public static int zzk(long j) {
        return zzj(zzn(j));
    }

    public static int zzaw(int i) {
        return zzar(i);
    }

    public static int zzbl(String str) {
        int i;
        try {
            i = zzkg.zzb(str);
        } catch (zzkj unused) {
            i = str.getBytes(zzhm.UTF_8).length;
        }
        return zzas(i) + i;
    }

    public static int zza(zzhv zzhv) {
        int zzgs = zzhv.zzgs();
        return zzas(zzgs) + zzgs;
    }

    public static int zzc(zzfx zzfx) {
        int size = zzfx.size();
        return zzas(size) + size;
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzas(length) + length;
    }

    public static int zzc(zziq zziq) {
        int zzgs = zziq.zzgs();
        return zzas(zzgs) + zzgs;
    }

    static int zza(zziq zziq, zzjf zzjf) {
        zzfq zzfq = (zzfq) zziq;
        int zzeq = zzfq.zzeq();
        if (zzeq == -1) {
            zzeq = zzjf.zzw(zzfq);
            zzfq.zzr(zzeq);
        }
        return zzas(zzeq) + zzeq;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(String str, zzkj zzkj) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzkj);
        byte[] bytes = str.getBytes(zzhm.UTF_8);
        try {
            zzan(bytes.length);
            zzb(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zziq zziq, zzjf zzjf) {
        int zzaq = zzaq(i) << 1;
        zzfq zzfq = (zzfq) zziq;
        int zzeq = zzfq.zzeq();
        if (zzeq == -1) {
            zzeq = zzjf.zzw(zzfq);
            zzfq.zzr(zzeq);
        }
        return zzaq + zzeq;
    }

    @Deprecated
    public static int zzd(zziq zziq) {
        return zziq.zzgs();
    }

    @Deprecated
    public static int zzay(int i) {
        return zzas(i);
    }
}
