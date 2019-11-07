package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import org.jetbrains.anko.DimensionsKt;

final class zzfj extends zzfg {
    zzfj() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzff.zzam(i);
        }
        if (i2 == 1) {
            return zzff.zzp(i, zzfd.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzff.zzd(i, zzfd.zza(bArr, j), zzfd.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b9, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r16, byte[] r17, int r18, int r19) {
        /*
            r15 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r1 | r2
            int r4 = r0.length
            int r4 = r4 - r2
            r3 = r3 | r4
            r4 = 2
            r5 = 3
            r6 = 0
            if (r3 < 0) goto L_0x00ba
            long r7 = (long) r1
            long r1 = (long) r2
            long r1 = r1 - r7
            int r2 = (int) r1
            r1 = 16
            r9 = 1
            if (r2 >= r1) goto L_0x001c
            r1 = 0
            goto L_0x002e
        L_0x001c:
            r11 = r7
            r1 = 0
        L_0x001e:
            if (r1 >= r2) goto L_0x002d
            long r13 = r11 + r9
            byte r3 = com.google.android.gms.internal.clearcut.zzfd.zza(r0, r11)
            if (r3 >= 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            int r1 = r1 + 1
            r11 = r13
            goto L_0x001e
        L_0x002d:
            r1 = r2
        L_0x002e:
            int r2 = r2 - r1
            long r11 = (long) r1
            long r7 = r7 + r11
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r2 <= 0) goto L_0x0040
            long r11 = r7 + r9
            byte r1 = com.google.android.gms.internal.clearcut.zzfd.zza(r0, r7)
            if (r1 < 0) goto L_0x0041
            int r2 = r2 + -1
            r7 = r11
            goto L_0x0032
        L_0x0040:
            r11 = r7
        L_0x0041:
            if (r2 != 0) goto L_0x0044
            return r6
        L_0x0044:
            int r2 = r2 + -1
            r3 = -32
            r7 = -65
            r8 = -1
            if (r1 >= r3) goto L_0x0062
            if (r2 != 0) goto L_0x0050
            return r1
        L_0x0050:
            int r2 = r2 + -1
            r3 = -62
            if (r1 < r3) goto L_0x0061
            long r13 = r11 + r9
            byte r1 = com.google.android.gms.internal.clearcut.zzfd.zza(r0, r11)
            if (r1 <= r7) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r7 = r13
            goto L_0x0031
        L_0x0061:
            return r8
        L_0x0062:
            r13 = -16
            if (r1 >= r13) goto L_0x008f
            if (r2 >= r4) goto L_0x006d
            int r0 = zza(r0, r1, r11, r2)
            return r0
        L_0x006d:
            int r2 = r2 + -2
            long r13 = r11 + r9
            byte r11 = com.google.android.gms.internal.clearcut.zzfd.zza(r0, r11)
            if (r11 > r7) goto L_0x008e
            r12 = -96
            if (r1 != r3) goto L_0x007d
            if (r11 < r12) goto L_0x008e
        L_0x007d:
            r3 = -19
            if (r1 != r3) goto L_0x0083
            if (r11 >= r12) goto L_0x008e
        L_0x0083:
            long r11 = r13 + r9
            byte r1 = com.google.android.gms.internal.clearcut.zzfd.zza(r0, r13)
            if (r1 <= r7) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r7 = r11
            goto L_0x0031
        L_0x008e:
            return r8
        L_0x008f:
            if (r2 >= r5) goto L_0x0096
            int r0 = zza(r0, r1, r11, r2)
            return r0
        L_0x0096:
            int r2 = r2 + -3
            long r13 = r11 + r9
            byte r3 = com.google.android.gms.internal.clearcut.zzfd.zza(r0, r11)
            if (r3 > r7) goto L_0x00b9
            int r1 = r1 << 28
            int r3 = r3 + 112
            int r1 = r1 + r3
            int r1 = r1 >> 30
            if (r1 != 0) goto L_0x00b9
            long r11 = r13 + r9
            byte r1 = com.google.android.gms.internal.clearcut.zzfd.zza(r0, r13)
            if (r1 > r7) goto L_0x00b9
            long r13 = r11 + r9
            byte r1 = com.google.android.gms.internal.clearcut.zzfd.zza(r0, r11)
            if (r1 <= r7) goto L_0x005f
        L_0x00b9:
            return r8
        L_0x00ba:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.Object[] r5 = new java.lang.Object[r5]
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5[r6] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            r1 = 1
            r5[r1] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            r5[r4] = r0
            java.lang.String r0 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            r3.<init>(r0)
            goto L_0x00dd
        L_0x00dc:
            throw r3
        L_0x00dd:
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzfj.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: 0000 */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        long j4 = (long) i3;
        long j5 = ((long) i4) + j4;
        int length = charSequence.length();
        String str = " at index ";
        String str2 = "Failed writing ";
        if (length > i4 || bArr2.length - i4 < i3) {
            char charAt = charSequence2.charAt(length - 1);
            int i5 = i3 + i4;
            StringBuilder sb = new StringBuilder(37);
            sb.append(str2);
            sb.append(charAt);
            sb.append(str);
            sb.append(i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i6 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i6 >= length) {
                break;
            }
            char charAt2 = charSequence2.charAt(i6);
            if (charAt2 >= 128) {
                break;
            }
            long j6 = 1 + j4;
            zzfd.zza(bArr2, j4, (byte) charAt2);
            i6++;
            j4 = j6;
        }
        if (i6 == length) {
            return (int) j4;
        }
        while (i6 < length) {
            char charAt3 = charSequence2.charAt(i6);
            if (charAt3 < c && j4 < j5) {
                long j7 = j4 + j;
                zzfd.zza(bArr2, j4, (byte) charAt3);
                j3 = j;
                j2 = j7;
            } else if (charAt3 < 2048 && j4 <= j5 - 2) {
                long j8 = j4 + j;
                zzfd.zza(bArr2, j4, (byte) ((charAt3 >>> 6) | 960));
                long j9 = j8 + j;
                zzfd.zza(bArr2, j8, (byte) ((charAt3 & '?') | 128));
                j2 = j9;
                j3 = j;
                i6++;
                c = 128;
                long j10 = j3;
                j4 = j2;
                j = j10;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j4 <= j5 - 3) {
                long j11 = j4 + j;
                zzfd.zza(bArr2, j4, (byte) ((charAt3 >>> 12) | DimensionsKt.XXHDPI));
                long j12 = j11 + j;
                zzfd.zza(bArr2, j11, (byte) (((charAt3 >>> 6) & 63) | 128));
                long j13 = j12 + 1;
                zzfd.zza(bArr2, j12, (byte) ((charAt3 & '?') | 128));
                j2 = j13;
                j3 = 1;
            } else if (j4 <= j5 - 4) {
                int i7 = i6 + 1;
                if (i7 != length) {
                    char charAt4 = charSequence2.charAt(i7);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j14 = j4 + 1;
                        zzfd.zza(bArr2, j4, (byte) ((codePoint >>> 18) | DimensionsKt.HDPI));
                        long j15 = j14 + 1;
                        zzfd.zza(bArr2, j14, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j16 = j15 + 1;
                        zzfd.zza(bArr2, j15, (byte) (((codePoint >>> 6) & 63) | 128));
                        j3 = 1;
                        j2 = j16 + 1;
                        zzfd.zza(bArr2, j16, (byte) ((codePoint & 63) | 128));
                        i6 = i7;
                        i6++;
                        c = 128;
                        long j102 = j3;
                        j4 = j2;
                        j = j102;
                    } else {
                        i6 = i7;
                    }
                }
                throw new zzfi(i6 - 1, length);
            } else {
                if (55296 <= charAt3 && charAt3 <= 57343) {
                    int i8 = i6 + 1;
                    if (i8 == length || !Character.isSurrogatePair(charAt3, charSequence2.charAt(i8))) {
                        throw new zzfi(i6, length);
                    }
                }
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append(str2);
                sb2.append(charAt3);
                sb2.append(str);
                sb2.append(j4);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            }
            i6++;
            c = 128;
            long j1022 = j3;
            j4 = j2;
            j = j1022;
        }
        return (int) j4;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j;
        char c;
        int i;
        long j2;
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        long zzb = zzfd.zzb(byteBuffer);
        long position = ((long) byteBuffer.position()) + zzb;
        long limit = ((long) byteBuffer.limit()) + zzb;
        int length = charSequence.length();
        String str = " at index ";
        String str2 = "Failed writing ";
        if (((long) length) <= limit - position) {
            int i2 = 0;
            while (true) {
                c = 128;
                if (i2 >= length) {
                    break;
                }
                char charAt = charSequence2.charAt(i2);
                if (charAt >= 128) {
                    break;
                }
                long j3 = 1 + j;
                zzfd.zza(j, (byte) charAt);
                i2++;
                position = j3;
            }
            if (i2 == length) {
                i = (int) (j - zzb);
            } else {
                while (i2 < length) {
                    char charAt2 = charSequence2.charAt(i2);
                    if (charAt2 < c && j < limit) {
                        long j4 = j + 1;
                        zzfd.zza(j, (byte) charAt2);
                        j = j4;
                        j2 = zzb;
                    } else if (charAt2 >= 2048 || j > limit - 2) {
                        j2 = zzb;
                        if ((charAt2 < 55296 || 57343 < charAt2) && j <= limit - 3) {
                            long j5 = j + 1;
                            zzfd.zza(j, (byte) ((charAt2 >>> 12) | DimensionsKt.XXHDPI));
                            long j6 = j5 + 1;
                            zzfd.zza(j5, (byte) (((charAt2 >>> 6) & 63) | 128));
                            long j7 = j6 + 1;
                            zzfd.zza(j6, (byte) ((charAt2 & '?') | 128));
                            j = j7;
                        } else if (j <= limit - 4) {
                            int i3 = i2 + 1;
                            if (i3 != length) {
                                char charAt3 = charSequence2.charAt(i3);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j8 = j + 1;
                                    zzfd.zza(j, (byte) ((codePoint >>> 18) | DimensionsKt.HDPI));
                                    long j9 = j8 + 1;
                                    zzfd.zza(j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j10 = j9 + 1;
                                    zzfd.zza(j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                    long j11 = j10 + 1;
                                    zzfd.zza(j10, (byte) ((codePoint & 63) | 128));
                                    i2 = i3;
                                    j = j11;
                                }
                            } else {
                                i3 = i2;
                            }
                            throw new zzfi(i3 - 1, length);
                        } else {
                            if (55296 <= charAt2 && charAt2 <= 57343) {
                                int i4 = i2 + 1;
                                if (i4 == length || !Character.isSurrogatePair(charAt2, charSequence2.charAt(i4))) {
                                    throw new zzfi(i2, length);
                                }
                            }
                            StringBuilder sb = new StringBuilder(46);
                            sb.append(str2);
                            sb.append(charAt2);
                            sb.append(str);
                            sb.append(j);
                            throw new ArrayIndexOutOfBoundsException(sb.toString());
                        }
                    } else {
                        j2 = zzb;
                        long j12 = j + 1;
                        zzfd.zza(j, (byte) ((charAt2 >>> 6) | 960));
                        long j13 = j12 + 1;
                        zzfd.zza(j12, (byte) ((charAt2 & '?') | 128));
                        j = j13;
                    }
                    i2++;
                    ByteBuffer byteBuffer3 = byteBuffer;
                    zzb = j2;
                    c = 128;
                }
                i = (int) (j - zzb);
                byteBuffer2 = byteBuffer;
            }
            byteBuffer2.position(i);
            return;
        }
        char charAt4 = charSequence2.charAt(length - 1);
        int limit2 = byteBuffer.limit();
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append(str2);
        sb2.append(charAt4);
        sb2.append(str);
        sb2.append(limit2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }
}
