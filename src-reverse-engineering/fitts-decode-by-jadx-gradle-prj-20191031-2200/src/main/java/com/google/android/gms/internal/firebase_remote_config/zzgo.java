package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;

final class zzgo extends zzgj {
    private final byte[] buffer;
    private int pos;
    private int zzpj;
    private int zzpl;
    private int zzpm;
    private final InputStream zzpn;
    private int zzpo;
    private int zzpp;

    private zzgo(InputStream inputStream, int i) {
        super();
        this.zzpm = Integer.MAX_VALUE;
        zzhm.zza(inputStream, "input");
        this.zzpn = inputStream;
        this.buffer = new byte[i];
        this.zzpo = 0;
        this.pos = 0;
        this.zzpp = 0;
    }

    public final int zzfb() throws IOException {
        if (zzfr()) {
            this.zzpl = 0;
            return 0;
        }
        this.zzpl = zzft();
        int i = this.zzpl;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzhq.zzhh();
    }

    public final void zzy(int i) throws zzhq {
        if (this.zzpl != i) {
            throw zzhq.zzhi();
        }
    }

    public final boolean zzz(int i) throws IOException {
        int zzfb;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzpo - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzhq.zzhg();
            }
            while (i3 < 10) {
                if (zzfy() < 0) {
                    i3++;
                }
            }
            throw zzhq.zzhg();
            return true;
        } else if (i2 == 1) {
            zzad(8);
            return true;
        } else if (i2 == 2) {
            zzad(zzft());
            return true;
        } else if (i2 == 3) {
            do {
                zzfb = zzfb();
                if (zzfb == 0) {
                    break;
                }
            } while (zzz(zzfb));
            zzy(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzad(4);
                return true;
            }
            throw zzhq.zzhj();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzfw());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzfv());
    }

    public final long zzfc() throws IOException {
        return zzfu();
    }

    public final long zzfd() throws IOException {
        return zzfu();
    }

    public final int zzfe() throws IOException {
        return zzft();
    }

    public final long zzff() throws IOException {
        return zzfw();
    }

    public final int zzfg() throws IOException {
        return zzfv();
    }

    public final boolean zzfh() throws IOException {
        return zzfu() != 0;
    }

    public final String readString() throws IOException {
        int zzft = zzft();
        if (zzft > 0) {
            int i = this.zzpo;
            int i2 = this.pos;
            if (zzft <= i - i2) {
                String str = new String(this.buffer, i2, zzft, zzhm.UTF_8);
                this.pos += zzft;
                return str;
            }
        }
        if (zzft == 0) {
            return "";
        }
        if (zzft > this.zzpo) {
            return new String(zzb(zzft, false), zzhm.UTF_8);
        }
        zzae(zzft);
        String str2 = new String(this.buffer, this.pos, zzft, zzhm.UTF_8);
        this.pos += zzft;
        return str2;
    }

    public final String zzfi() throws IOException {
        byte[] bArr;
        int zzft = zzft();
        int i = this.pos;
        int i2 = 0;
        if (zzft <= this.zzpo - i && zzft > 0) {
            bArr = this.buffer;
            this.pos = i + zzft;
            i2 = i;
        } else if (zzft == 0) {
            return "";
        } else {
            if (zzft <= this.zzpo) {
                zzae(zzft);
                bArr = this.buffer;
                this.pos = zzft;
            } else {
                bArr = zzb(zzft, false);
            }
        }
        return zzkg.zzg(bArr, i2, zzft);
    }

    public final zzfx zzfj() throws IOException {
        int zzft = zzft();
        int i = this.zzpo;
        int i2 = this.pos;
        if (zzft <= i - i2 && zzft > 0) {
            zzfx zza = zzfx.zza(this.buffer, i2, zzft);
            this.pos += zzft;
            return zza;
        } else if (zzft == 0) {
            return zzfx.zzov;
        } else {
            byte[] zzag = zzag(zzft);
            if (zzag != null) {
                return zzfx.zza(zzag);
            }
            int i3 = this.pos;
            int i4 = this.zzpo;
            int i5 = i4 - i3;
            this.zzpp += i4;
            this.pos = 0;
            this.zzpo = 0;
            List<byte[]> zzah = zzah(zzft - i5);
            byte[] bArr = new byte[zzft];
            System.arraycopy(this.buffer, i3, bArr, 0, i5);
            for (byte[] bArr2 : zzah) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return zzfx.zzb(bArr);
        }
    }

    public final int zzfk() throws IOException {
        return zzft();
    }

    public final int zzfl() throws IOException {
        return zzft();
    }

    public final int zzfm() throws IOException {
        return zzfv();
    }

    public final long zzfn() throws IOException {
        return zzfw();
    }

    public final int zzfo() throws IOException {
        return zzgj.zzac(zzft());
    }

    public final long zzfp() throws IOException {
        return zzgj.zze(zzfu());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzft() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzpo
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
            long r0 = r5.zzfq()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzgo.zzft():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzfu() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.zzpo
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
            long r0 = r11.zzfq()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzgo.zzfu():long");
    }

    /* access modifiers changed from: 0000 */
    public final long zzfq() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzfy = zzfy();
            j |= ((long) (zzfy & Byte.MAX_VALUE)) << i;
            if ((zzfy & 128) == 0) {
                return j;
            }
        }
        throw zzhq.zzhg();
    }

    private final int zzfv() throws IOException {
        int i = this.pos;
        if (this.zzpo - i < 4) {
            zzae(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    private final long zzfw() throws IOException {
        int i = this.pos;
        if (this.zzpo - i < 8) {
            zzae(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int zzaa(int i) throws zzhq {
        if (i >= 0) {
            int i2 = i + this.zzpp + this.pos;
            int i3 = this.zzpm;
            if (i2 <= i3) {
                this.zzpm = i2;
                zzfx();
                return i3;
            }
            throw zzhq.zzhe();
        }
        throw zzhq.zzhf();
    }

    private final void zzfx() {
        this.zzpo += this.zzpj;
        int i = this.zzpp;
        int i2 = this.zzpo;
        int i3 = i + i2;
        int i4 = this.zzpm;
        if (i3 > i4) {
            this.zzpj = i3 - i4;
            this.zzpo = i2 - this.zzpj;
            return;
        }
        this.zzpj = 0;
    }

    public final void zzab(int i) {
        this.zzpm = i;
        zzfx();
    }

    public final boolean zzfr() throws IOException {
        return this.pos == this.zzpo && !zzaf(1);
    }

    public final int zzfs() {
        return this.zzpp + this.pos;
    }

    private final void zzae(int i) throws IOException {
        if (zzaf(i)) {
            return;
        }
        if (i > (this.zzpf - this.zzpp) - this.pos) {
            throw zzhq.zzhk();
        }
        throw zzhq.zzhe();
    }

    private final boolean zzaf(int i) throws IOException {
        do {
            int i2 = this.pos;
            int i3 = i2 + i;
            int i4 = this.zzpo;
            if (i3 > i4) {
                int i5 = this.zzpf;
                int i6 = this.zzpp;
                if (i > (i5 - i6) - i2 || i6 + i2 + i > this.zzpm) {
                    return false;
                }
                if (i2 > 0) {
                    if (i4 > i2) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                    }
                    this.zzpp += i2;
                    this.zzpo -= i2;
                    this.pos = 0;
                }
                InputStream inputStream = this.zzpn;
                byte[] bArr2 = this.buffer;
                int i7 = this.zzpo;
                int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.zzpf - this.zzpp) - i7));
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    String valueOf = String.valueOf(this.zzpn.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                    sb.append(valueOf);
                    sb.append("#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzpo += read;
                    zzfx();
                }
            } else {
                StringBuilder sb2 = new StringBuilder(77);
                sb2.append("refillBuffer() called when ");
                sb2.append(i);
                sb2.append(" bytes were already available in buffer");
                throw new IllegalStateException(sb2.toString());
            }
        } while (this.zzpo < i);
        return true;
    }

    private final byte zzfy() throws IOException {
        if (this.pos == this.zzpo) {
            zzae(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzb(int i, boolean z) throws IOException {
        byte[] zzag = zzag(i);
        if (zzag != null) {
            return zzag;
        }
        int i2 = this.pos;
        int i3 = this.zzpo;
        int i4 = i3 - i2;
        this.zzpp += i3;
        this.pos = 0;
        this.zzpo = 0;
        List<byte[]> zzah = zzah(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzah) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzag(int i) throws IOException {
        if (i == 0) {
            return zzhm.zzua;
        }
        if (i >= 0) {
            int i2 = this.zzpp;
            int i3 = this.pos;
            int i4 = i2 + i3 + i;
            if (i4 - this.zzpf <= 0) {
                int i5 = this.zzpm;
                if (i4 <= i5) {
                    int i6 = this.zzpo - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096 && i7 > this.zzpn.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, this.pos, bArr, 0, i6);
                    this.zzpp += this.zzpo;
                    this.pos = 0;
                    this.zzpo = 0;
                    while (i6 < bArr.length) {
                        int read = this.zzpn.read(bArr, i6, i - i6);
                        if (read != -1) {
                            this.zzpp += read;
                            i6 += read;
                        } else {
                            throw zzhq.zzhe();
                        }
                    }
                    return bArr;
                }
                zzad((i5 - i2) - i3);
                throw zzhq.zzhe();
            }
            throw zzhq.zzhk();
        }
        throw zzhq.zzhf();
    }

    private final List<byte[]> zzah(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.zzpn.read(bArr, i2, bArr.length - i2);
                if (read != -1) {
                    this.zzpp += read;
                    i2 += read;
                } else {
                    throw zzhq.zzhe();
                }
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzad(int i) throws IOException {
        int i2;
        int i3 = this.zzpo;
        int i4 = this.pos;
        if (i <= i3 - i4 && i >= 0) {
            this.pos = i4 + i;
        } else if (i >= 0) {
            int i5 = this.zzpp;
            int i6 = this.pos;
            int i7 = i5 + i6 + i;
            int i8 = this.zzpm;
            if (i7 <= i8) {
                this.zzpp = i5 + i6;
                int i9 = this.zzpo - i6;
                this.zzpo = 0;
                this.pos = 0;
                while (i9 < i) {
                    try {
                        long j = (long) (i - i9);
                        long skip = this.zzpn.skip(j);
                        if (skip >= 0 && skip <= j) {
                            if (skip == 0) {
                                break;
                            }
                            i9 += (int) skip;
                        } else {
                            String valueOf = String.valueOf(this.zzpn.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                    } catch (Throwable th) {
                        this.zzpp += i9;
                        zzfx();
                        throw th;
                    }
                }
                this.zzpp += i9;
                zzfx();
                if (i9 < i) {
                    int i10 = this.zzpo;
                    int i11 = i10 - this.pos;
                    this.pos = i10;
                    zzae(1);
                    while (true) {
                        i2 = i - i11;
                        int i12 = this.zzpo;
                        if (i2 <= i12) {
                            break;
                        }
                        i11 += i12;
                        this.pos = i12;
                        zzae(1);
                    }
                    this.pos = i2;
                }
                return;
            }
            zzad((i8 - i5) - i6);
            throw zzhq.zzhe();
        } else {
            throw zzhq.zzhf();
        }
    }
}
