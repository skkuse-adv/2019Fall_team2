package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
import kotlin.UByte;

final class zzed extends zzeb {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int zzady;
    private int zzadz;
    private int zzaea;
    private int zzaeb;

    private zzed(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzaeb = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzadz = this.pos;
    }

    public final int zzsg() throws IOException {
        if (zzsw()) {
            this.zzaea = 0;
            return 0;
        }
        this.zzaea = zzta();
        int i = this.zzaea;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzfi.zzuw();
    }

    public final void zzat(int i) throws zzfi {
        if (this.zzaea != i) {
            throw zzfi.zzux();
        }
    }

    public final boolean zzau(int i) throws IOException {
        int zzsg;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzfi.zzuv();
            }
            while (i3 < 10) {
                if (zztf() < 0) {
                    i3++;
                }
            }
            throw zzfi.zzuv();
            return true;
        } else if (i2 == 1) {
            zzay(8);
            return true;
        } else if (i2 == 2) {
            zzay(zzta());
            return true;
        } else if (i2 == 3) {
            do {
                zzsg = zzsg();
                if (zzsg == 0) {
                    break;
                }
            } while (zzau(zzsg));
            zzat(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzay(4);
                return true;
            }
            throw zzfi.zzuy();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zztd());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zztc());
    }

    public final long zzsh() throws IOException {
        return zztb();
    }

    public final long zzsi() throws IOException {
        return zztb();
    }

    public final int zzsj() throws IOException {
        return zzta();
    }

    public final long zzsk() throws IOException {
        return zztd();
    }

    public final int zzsl() throws IOException {
        return zztc();
    }

    public final boolean zzsm() throws IOException {
        return zztb() != 0;
    }

    public final String readString() throws IOException {
        int zzta = zzta();
        if (zzta > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzta <= i - i2) {
                String str = new String(this.buffer, i2, zzta, zzez.UTF_8);
                this.pos += zzta;
                return str;
            }
        }
        if (zzta == 0) {
            return "";
        }
        if (zzta < 0) {
            throw zzfi.zzuu();
        }
        throw zzfi.zzut();
    }

    public final String zzsn() throws IOException {
        int zzta = zzta();
        if (zzta > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzta <= i - i2) {
                String zzh = zzhy.zzh(this.buffer, i2, zzta);
                this.pos += zzta;
                return zzh;
            }
        }
        if (zzta == 0) {
            return "";
        }
        if (zzta <= 0) {
            throw zzfi.zzuu();
        }
        throw zzfi.zzut();
    }

    public final <T extends zzgi> T zza(zzgr<T> zzgr, zzel zzel) throws IOException {
        int zzta = zzta();
        if (this.zzadp < this.zzadq) {
            int zzaw = zzaw(zzta);
            this.zzadp++;
            T t = (zzgi) zzgr.zzc(this, zzel);
            zzat(0);
            this.zzadp--;
            zzax(zzaw);
            return t;
        }
        throw zzfi.zzuz();
    }

    public final zzdp zzso() throws IOException {
        byte[] bArr;
        int zzta = zzta();
        if (zzta > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzta <= i - i2) {
                zzdp zzb = zzdp.zzb(this.buffer, i2, zzta);
                this.pos += zzta;
                return zzb;
            }
        }
        if (zzta == 0) {
            return zzdp.zzadh;
        }
        if (zzta > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzta <= i3 - i4) {
                this.pos = zzta + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzdp.zze(bArr);
            }
        }
        if (zzta > 0) {
            throw zzfi.zzut();
        } else if (zzta == 0) {
            bArr = zzez.zzair;
            return zzdp.zze(bArr);
        } else {
            throw zzfi.zzuu();
        }
    }

    public final int zzsp() throws IOException {
        return zzta();
    }

    public final int zzsq() throws IOException {
        return zzta();
    }

    public final int zzsr() throws IOException {
        return zztc();
    }

    public final long zzss() throws IOException {
        return zztd();
    }

    public final int zzst() throws IOException {
        return zzeb.zzaz(zzta());
    }

    public final long zzsu() throws IOException {
        return zzeb.zzbm(zztb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzta() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzsv()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzed.zzta():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zztb() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.limit
            if (r1 == r0) goto L_0x00b5
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b5
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0026
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            r3 = r2
            goto L_0x00b2
        L_0x0026:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0037
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r3 = r9
            goto L_0x00b2
        L_0x0037:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0045
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0045:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005c
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0058:
            long r1 = r1 ^ r3
            r3 = r1
        L_0x005a:
            r1 = r0
            goto L_0x00b2
        L_0x005c:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006e:
            long r3 = r3 ^ r5
            goto L_0x00b2
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0058
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006e
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x005a
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b5
        L_0x00b2:
            r11.pos = r1
            return r3
        L_0x00b5:
            long r0 = r11.zzsv()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzed.zztb():long");
    }

    /* access modifiers changed from: 0000 */
    public final long zzsv() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zztf = zztf();
            j |= ((long) (zztf & Byte.MAX_VALUE)) << i;
            if ((zztf & 128) == 0) {
                return j;
            }
        }
        throw zzfi.zzuv();
    }

    private final int zztc() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        }
        throw zzfi.zzut();
    }

    private final long zztd() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzfi.zzut();
    }

    public final int zzaw(int i) throws zzfi {
        if (i >= 0) {
            int zzsx = i + zzsx();
            int i2 = this.zzaeb;
            if (zzsx <= i2) {
                this.zzaeb = zzsx;
                zzte();
                return i2;
            }
            throw zzfi.zzut();
        }
        throw zzfi.zzuu();
    }

    private final void zzte() {
        this.limit += this.zzady;
        int i = this.limit;
        int i2 = i - this.zzadz;
        int i3 = this.zzaeb;
        if (i2 > i3) {
            this.zzady = i2 - i3;
            this.limit = i - this.zzady;
            return;
        }
        this.zzady = 0;
    }

    public final void zzax(int i) {
        this.zzaeb = i;
        zzte();
    }

    public final boolean zzsw() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzsx() {
        return this.pos - this.zzadz;
    }

    private final byte zztf() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzfi.zzut();
    }

    public final void zzay(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzfi.zzuu();
        }
        throw zzfi.zzut();
    }
}
