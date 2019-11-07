package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzee extends zzdm {
    private static final Logger logger = Logger.getLogger(zzee.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzaec = zzhv.zzwt();
    zzei zzaed = this;

    static class zza extends zzee {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i;
                    this.position = i;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final void zzb(int i, int i2) throws IOException {
            zzbf((i << 3) | i2);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbe(i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbf(i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzbh(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzbn(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzbp(j);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzb(i, 2);
            zzdr(str);
        }

        public final void zza(int i, zzdp zzdp) throws IOException {
            zzb(i, 2);
            zza(zzdp);
        }

        public final void zza(zzdp zzdp) throws IOException {
            zzbf(zzdp.size());
            zzdp.zza((zzdm) this);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzbf(i2);
            write(bArr, 0, i2);
        }

        public final void zza(int i, zzgi zzgi) throws IOException {
            zzb(i, 2);
            zzb(zzgi);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzgi zzgi, zzgx zzgx) throws IOException {
            zzb(i, 2);
            zzdf zzdf = (zzdf) zzgi;
            int zzrt = zzdf.zzrt();
            if (zzrt == -1) {
                zzrt = zzgx.zzt(zzdf);
                zzdf.zzam(zzrt);
            }
            zzbf(zzrt);
            zzgx.zza(zzgi, this.zzaed);
        }

        public final void zzb(int i, zzgi zzgi) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzgi);
            zzb(1, 4);
        }

        public final void zzb(int i, zzdp zzdp) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdp);
            zzb(1, 4);
        }

        public final void zzb(zzgi zzgi) throws IOException {
            zzbf(zzgi.zzuk());
            zzgi.zzb(this);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzbe(int i) throws IOException {
            if (i >= 0) {
                zzbf(i);
            } else {
                zzbn((long) i);
            }
        }

        public final void zzbf(int i) throws IOException {
            if (!zzee.zzaec || zzdi.zzrv() || zztg() < 5) {
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
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzhv.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzhv.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzhv.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzhv.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzhv.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzhv.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzhv.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzhv.zza(bArr10, (long) i14, (byte) (i12 | 128));
                int i15 = i12 >>> 7;
                byte[] bArr11 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                zzhv.zza(bArr11, (long) i16, (byte) i15);
            }
        }

        public final void zzbh(int i) throws IOException {
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
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzbn(long j) throws IOException {
            if (!zzee.zzaec || zztg() < 10) {
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
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzhv.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzhv.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzbp(long j) throws IOException {
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
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzdr(String str) throws IOException {
            int i = this.position;
            try {
                int zzbk = zzee.zzbk(str.length() * 3);
                int zzbk2 = zzee.zzbk(str.length());
                if (zzbk2 == zzbk) {
                    this.position = i + zzbk2;
                    int zza = zzhy.zza(str, this.buffer, this.position, zztg());
                    this.position = i;
                    zzbf((zza - i) - zzbk2);
                    this.position = zza;
                    return;
                }
                zzbf(zzhy.zza(str));
                this.position = zzhy.zza(str, this.buffer, this.position, zztg());
            } catch (zzib e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final int zztg() {
            return this.limit - this.position;
        }

        public final int zztj() {
            return this.position - this.offset;
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(String str) {
            String valueOf = String.valueOf(str);
            String str2 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
            super(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzb(String str, Throwable th) {
            String valueOf = String.valueOf(str);
            String str2 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
            super(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    static final class zzc extends zza {
        private final ByteBuffer zzaef;
        private int zzaeg;

        zzc(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzaef = byteBuffer;
            this.zzaeg = byteBuffer.position();
        }

        public final void flush() {
            this.zzaef.position(this.zzaeg + zztj());
        }
    }

    static final class zzd extends zzee {
        private final ByteBuffer zzaeh;
        private final ByteBuffer zzaei;
        private final long zzaej;
        private final long zzaek;
        private final long zzael;
        private final long zzaem = (this.zzael - 10);
        private long zzaen = this.zzaek;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zzaeh = byteBuffer;
            this.zzaei = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzaej = zzhv.zzb(byteBuffer);
            this.zzaek = this.zzaej + ((long) byteBuffer.position());
            this.zzael = this.zzaej + ((long) byteBuffer.limit());
        }

        public final void zzb(int i, int i2) throws IOException {
            zzbf((i << 3) | i2);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbe(i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbf(i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzbh(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzbn(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzbp(j);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzb(i, 2);
            zzdr(str);
        }

        public final void zza(int i, zzdp zzdp) throws IOException {
            zzb(i, 2);
            zza(zzdp);
        }

        public final void zza(int i, zzgi zzgi) throws IOException {
            zzb(i, 2);
            zzb(zzgi);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzgi zzgi, zzgx zzgx) throws IOException {
            zzb(i, 2);
            zza(zzgi, zzgx);
        }

        public final void zzb(int i, zzgi zzgi) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzgi);
            zzb(1, 4);
        }

        public final void zzb(int i, zzdp zzdp) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdp);
            zzb(1, 4);
        }

        public final void zzb(zzgi zzgi) throws IOException {
            zzbf(zzgi.zzuk());
            zzgi.zzb(this);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzgi zzgi, zzgx zzgx) throws IOException {
            zzdf zzdf = (zzdf) zzgi;
            int zzrt = zzdf.zzrt();
            if (zzrt == -1) {
                zzrt = zzgx.zzt(zzdf);
                zzdf.zzam(zzrt);
            }
            zzbf(zzrt);
            zzgx.zza(zzgi, this.zzaed);
        }

        public final void zzc(byte b) throws IOException {
            long j = this.zzaen;
            if (j < this.zzael) {
                this.zzaen = 1 + j;
                zzhv.zza(j, b);
                return;
            }
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.zzael), Integer.valueOf(1)}));
        }

        public final void zza(zzdp zzdp) throws IOException {
            zzbf(zzdp.size());
            zzdp.zza((zzdm) this);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzbf(i2);
            write(bArr, 0, i2);
        }

        public final void zzbe(int i) throws IOException {
            if (i >= 0) {
                zzbf(i);
            } else {
                zzbn((long) i);
            }
        }

        public final void zzbf(int i) throws IOException {
            if (this.zzaen <= this.zzaem) {
                while ((i & -128) != 0) {
                    long j = this.zzaen;
                    this.zzaen = j + 1;
                    zzhv.zza(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.zzaen;
                this.zzaen = 1 + j2;
                zzhv.zza(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.zzaen;
                if (j3 >= this.zzael) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j3), Long.valueOf(this.zzael), Integer.valueOf(1)}));
                } else if ((i & -128) == 0) {
                    this.zzaen = 1 + j3;
                    zzhv.zza(j3, (byte) i);
                    return;
                } else {
                    this.zzaen = j3 + 1;
                    zzhv.zza(j3, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
        }

        public final void zzbh(int i) throws IOException {
            this.zzaei.putInt((int) (this.zzaen - this.zzaej), i);
            this.zzaen += 4;
        }

        public final void zzbn(long j) throws IOException {
            if (this.zzaen <= this.zzaem) {
                while ((j & -128) != 0) {
                    long j2 = this.zzaen;
                    this.zzaen = j2 + 1;
                    zzhv.zza(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.zzaen;
                this.zzaen = 1 + j3;
                zzhv.zza(j3, (byte) ((int) j));
                return;
            }
            while (true) {
                long j4 = this.zzaen;
                if (j4 >= this.zzael) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j4), Long.valueOf(this.zzael), Integer.valueOf(1)}));
                } else if ((j & -128) == 0) {
                    this.zzaen = 1 + j4;
                    zzhv.zza(j4, (byte) ((int) j));
                    return;
                } else {
                    this.zzaen = j4 + 1;
                    zzhv.zza(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        public final void zzbp(long j) throws IOException {
            this.zzaei.putLong((int) (this.zzaen - this.zzaej), j);
            this.zzaen += 8;
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                long j2 = this.zzael - j;
                long j3 = this.zzaen;
                if (j2 >= j3) {
                    zzhv.zza(bArr, (long) i, j3, j);
                    this.zzaen += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzaen), Long.valueOf(this.zzael), Integer.valueOf(i2)}));
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzdr(String str) throws IOException {
            long j = this.zzaen;
            try {
                int zzbk = zzee.zzbk(str.length() * 3);
                int zzbk2 = zzee.zzbk(str.length());
                if (zzbk2 == zzbk) {
                    int i = ((int) (this.zzaen - this.zzaej)) + zzbk2;
                    this.zzaei.position(i);
                    zzhy.zza(str, this.zzaei);
                    int position = this.zzaei.position() - i;
                    zzbf(position);
                    this.zzaen += (long) position;
                    return;
                }
                int zza = zzhy.zza(str);
                zzbf(zza);
                zzbw(this.zzaen);
                zzhy.zza(str, this.zzaei);
                this.zzaen += (long) zza;
            } catch (zzib e) {
                this.zzaen = j;
                zzbw(this.zzaen);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzb((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzb((Throwable) e3);
            }
        }

        public final void flush() {
            this.zzaeh.position((int) (this.zzaen - this.zzaej));
        }

        public final int zztg() {
            return (int) (this.zzael - this.zzaen);
        }

        private final void zzbw(long j) {
            this.zzaei.position((int) (j - this.zzaej));
        }
    }

    static final class zze extends zzee {
        private final ByteBuffer zzaeh;
        private final ByteBuffer zzaei;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzaeh = byteBuffer;
            this.zzaei = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.position();
        }

        public final void zzb(int i, int i2) throws IOException {
            zzbf((i << 3) | i2);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbe(i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzbf(i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzbh(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzbn(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzbp(j);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zzb(int i, String str) throws IOException {
            zzb(i, 2);
            zzdr(str);
        }

        public final void zza(int i, zzdp zzdp) throws IOException {
            zzb(i, 2);
            zza(zzdp);
        }

        public final void zza(int i, zzgi zzgi) throws IOException {
            zzb(i, 2);
            zzb(zzgi);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzgi zzgi, zzgx zzgx) throws IOException {
            zzb(i, 2);
            zza(zzgi, zzgx);
        }

        public final void zzb(int i, zzgi zzgi) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzgi);
            zzb(1, 4);
        }

        public final void zzb(int i, zzdp zzdp) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdp);
            zzb(1, 4);
        }

        public final void zzb(zzgi zzgi) throws IOException {
            zzbf(zzgi.zzuk());
            zzgi.zzb(this);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(zzgi zzgi, zzgx zzgx) throws IOException {
            zzdf zzdf = (zzdf) zzgi;
            int zzrt = zzdf.zzrt();
            if (zzrt == -1) {
                zzrt = zzgx.zzt(zzdf);
                zzdf.zzam(zzrt);
            }
            zzbf(zzrt);
            zzgx.zza(zzgi, this.zzaed);
        }

        public final void zzc(byte b) throws IOException {
            try {
                this.zzaei.put(b);
            } catch (BufferOverflowException e) {
                throw new zzb((Throwable) e);
            }
        }

        public final void zza(zzdp zzdp) throws IOException {
            zzbf(zzdp.size());
            zzdp.zza((zzdm) this);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzbf(i2);
            write(bArr, 0, i2);
        }

        public final void zzbe(int i) throws IOException {
            if (i >= 0) {
                zzbf(i);
            } else {
                zzbn((long) i);
            }
        }

        public final void zzbf(int i) throws IOException {
            while ((i & -128) != 0) {
                this.zzaei.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.zzaei.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new zzb((Throwable) e);
            }
        }

        public final void zzbh(int i) throws IOException {
            try {
                this.zzaei.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzb((Throwable) e);
            }
        }

        public final void zzbn(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.zzaei.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.zzaei.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new zzb((Throwable) e);
            }
        }

        public final void zzbp(long j) throws IOException {
            try {
                this.zzaei.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzb((Throwable) e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzaei.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzdr(String str) throws IOException {
            int position = this.zzaei.position();
            try {
                int zzbk = zzee.zzbk(str.length() * 3);
                int zzbk2 = zzee.zzbk(str.length());
                if (zzbk2 == zzbk) {
                    int position2 = this.zzaei.position() + zzbk2;
                    this.zzaei.position(position2);
                    zzdt(str);
                    int position3 = this.zzaei.position();
                    this.zzaei.position(position);
                    zzbf(position3 - position2);
                    this.zzaei.position(position3);
                    return;
                }
                zzbf(zzhy.zza(str));
                zzdt(str);
            } catch (zzib e) {
                this.zzaei.position(position);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final void flush() {
            this.zzaeh.position(this.zzaei.position());
        }

        public final int zztg() {
            return this.zzaei.remaining();
        }

        private final void zzdt(String str) throws IOException {
            try {
                zzhy.zza(str, this.zzaei);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb((Throwable) e);
            }
        }
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzbk(int i) {
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

    public static int zzbm(int i) {
        return 4;
    }

    public static int zzbn(int i) {
        return 4;
    }

    private static int zzbp(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzbr(long j) {
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

    public static int zzbt(long j) {
        return 8;
    }

    public static int zzbu(long j) {
        return 8;
    }

    private static long zzbv(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zze(double d) {
        return 8;
    }

    public static zzee zzf(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzr(boolean z) {
        return 1;
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzdp zzdp) throws IOException;

    public abstract void zza(int i, zzgi zzgi) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(int i, zzgi zzgi, zzgx zzgx) throws IOException;

    public abstract void zza(zzdp zzdp) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, zzdp zzdp) throws IOException;

    public abstract void zzb(int i, zzgi zzgi) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzgi zzgi) throws IOException;

    public abstract void zzbe(int i) throws IOException;

    public abstract void zzbf(int i) throws IOException;

    public abstract void zzbh(int i) throws IOException;

    public abstract void zzbn(long j) throws IOException;

    public abstract void zzbp(long j) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zzdr(String str) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract int zztg();

    public static zzee zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzc(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (zzhv.zzwu()) {
            return new zzd(byteBuffer);
        } else {
            return new zze(byteBuffer);
        }
    }

    private zzee() {
    }

    public final void zze(int i, int i2) throws IOException {
        zzd(i, zzbp(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzbv(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzbg(int i) throws IOException {
        zzbf(zzbp(i));
    }

    public final void zzbo(long j) throws IOException {
        zzbn(zzbv(j));
    }

    public final void zza(float f) throws IOException {
        zzbh(Float.floatToRawIntBits(f));
    }

    public final void zzd(double d) throws IOException {
        zzbp(Double.doubleToRawLongBits(d));
    }

    public final void zzq(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzg(int i, int i2) {
        return zzbi(i) + zzbj(i2);
    }

    public static int zzh(int i, int i2) {
        return zzbi(i) + zzbk(i2);
    }

    public static int zzi(int i, int i2) {
        return zzbi(i) + zzbk(zzbp(i2));
    }

    public static int zzj(int i, int i2) {
        return zzbi(i) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzbi(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzbi(i) + zzbr(j);
    }

    public static int zze(int i, long j) {
        return zzbi(i) + zzbr(j);
    }

    public static int zzf(int i, long j) {
        return zzbi(i) + zzbr(zzbv(j));
    }

    public static int zzg(int i, long j) {
        return zzbi(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzbi(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzbi(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzbi(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzbi(i) + 1;
    }

    public static int zzl(int i, int i2) {
        return zzbi(i) + zzbj(i2);
    }

    public static int zzc(int i, String str) {
        return zzbi(i) + zzds(str);
    }

    public static int zzc(int i, zzdp zzdp) {
        int zzbi = zzbi(i);
        int size = zzdp.size();
        return zzbi + zzbk(size) + size;
    }

    public static int zza(int i, zzfn zzfn) {
        int zzbi = zzbi(i);
        int zzuk = zzfn.zzuk();
        return zzbi + zzbk(zzuk) + zzuk;
    }

    public static int zzc(int i, zzgi zzgi) {
        return zzbi(i) + zzc(zzgi);
    }

    static int zzb(int i, zzgi zzgi, zzgx zzgx) {
        return zzbi(i) + zzb(zzgi, zzgx);
    }

    public static int zzd(int i, zzgi zzgi) {
        return (zzbi(1) << 1) + zzh(2, i) + zzc(3, zzgi);
    }

    public static int zzd(int i, zzdp zzdp) {
        return (zzbi(1) << 1) + zzh(2, i) + zzc(3, zzdp);
    }

    public static int zzb(int i, zzfn zzfn) {
        return (zzbi(1) << 1) + zzh(2, i) + zza(3, zzfn);
    }

    public static int zzbi(int i) {
        return zzbk(i << 3);
    }

    public static int zzbj(int i) {
        if (i >= 0) {
            return zzbk(i);
        }
        return 10;
    }

    public static int zzbl(int i) {
        return zzbk(zzbp(i));
    }

    public static int zzbq(long j) {
        return zzbr(j);
    }

    public static int zzbs(long j) {
        return zzbr(zzbv(j));
    }

    public static int zzbo(int i) {
        return zzbj(i);
    }

    public static int zzds(String str) {
        int i;
        try {
            i = zzhy.zza(str);
        } catch (zzib unused) {
            i = str.getBytes(zzez.UTF_8).length;
        }
        return zzbk(i) + i;
    }

    public static int zza(zzfn zzfn) {
        int zzuk = zzfn.zzuk();
        return zzbk(zzuk) + zzuk;
    }

    public static int zzb(zzdp zzdp) {
        int size = zzdp.size();
        return zzbk(size) + size;
    }

    public static int zzg(byte[] bArr) {
        int length = bArr.length;
        return zzbk(length) + length;
    }

    public static int zzc(zzgi zzgi) {
        int zzuk = zzgi.zzuk();
        return zzbk(zzuk) + zzuk;
    }

    static int zzb(zzgi zzgi, zzgx zzgx) {
        zzdf zzdf = (zzdf) zzgi;
        int zzrt = zzdf.zzrt();
        if (zzrt == -1) {
            zzrt = zzgx.zzt(zzdf);
            zzdf.zzam(zzrt);
        }
        return zzbk(zzrt) + zzrt;
    }

    public final void zzth() {
        if (zztg() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(String str, zzib zzib) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzib);
        byte[] bytes = str.getBytes(zzez.UTF_8);
        try {
            zzbf(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb((Throwable) e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzgi zzgi, zzgx zzgx) {
        int zzbi = zzbi(i) << 1;
        zzdf zzdf = (zzdf) zzgi;
        int zzrt = zzdf.zzrt();
        if (zzrt == -1) {
            zzrt = zzgx.zzt(zzdf);
            zzdf.zzam(zzrt);
        }
        return zzbi + zzrt;
    }

    @Deprecated
    public static int zzd(zzgi zzgi) {
        return zzgi.zzuk();
    }

    @Deprecated
    public static int zzbq(int i) {
        return zzbk(i);
    }
}
