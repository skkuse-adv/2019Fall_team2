package com.google.android.gms.internal.firebase-perf;

import java.util.Map.Entry;
import kotlin.UByte;
import kotlin.UShort;

final class zzz<K, V> extends zzv<K, V> {
    static final zzv<Object, Object> zzab = new zzz(null, new Object[0], 0);
    private final transient int size;
    private final transient Object zzac;
    private final transient Object[] zzz;

    /* access modifiers changed from: 0000 */
    public final boolean zzn() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bf, code lost:
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f4, code lost:
        r2[r7] = r4;
        r1 = r1 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> com.google.android.gms.internal.firebase-perf.zzz<K, V> zza(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.gms.internal.firebase-perf.zzv<java.lang.Object, java.lang.Object> r10 = zzab
            com.google.android.gms.internal.firebase-perf.zzz r10 = (com.google.android.gms.internal.firebase-perf.zzz) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            com.google.android.gms.internal.firebase-perf.zzo.zza(r10, r1)
            com.google.android.gms.internal.firebase-perf.zzz r10 = new com.google.android.gms.internal.firebase-perf.zzz
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            com.google.android.gms.internal.firebase-perf.zzf.zzb(r10, r3)
            r3 = 2
            int r3 = java.lang.Math.max(r10, r3)
            r4 = 751619276(0x2ccccccc, float:5.8207657E-12)
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 >= r4) goto L_0x0045
            int r4 = r3 + -1
            int r4 = java.lang.Integer.highestOneBit(r4)
            int r4 = r4 << r2
            r5 = r4
        L_0x0032:
            double r6 = (double) r5
            r8 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r8
            double r8 = (double) r3
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x004c
            int r5 = r5 << 1
            goto L_0x0032
        L_0x0045:
            if (r3 >= r5) goto L_0x0049
            r3 = 1
            goto L_0x004a
        L_0x0049:
            r3 = 0
        L_0x004a:
            if (r3 == 0) goto L_0x010f
        L_0x004c:
            if (r10 != r2) goto L_0x0058
            r1 = r11[r1]
            r2 = r11[r2]
            com.google.android.gms.internal.firebase-perf.zzo.zza(r1, r2)
            r2 = r0
            goto L_0x0109
        L_0x0058:
            int r0 = r5 + -1
            r2 = 128(0x80, float:1.794E-43)
            r3 = -1
            if (r5 > r2) goto L_0x0097
            byte[] r2 = new byte[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x0064:
            if (r1 >= r10) goto L_0x0109
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.firebase-perf.zzo.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.firebase-perf.zzn.zza(r6)
        L_0x0079:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x0087
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0064
        L_0x0087:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0092
            int r6 = r6 + 1
            goto L_0x0079
        L_0x0092:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x0097:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r5 > r2) goto L_0x00d5
            short[] r2 = new short[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00a1:
            if (r1 >= r10) goto L_0x0109
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.firebase-perf.zzo.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.firebase-perf.zzn.zza(r6)
        L_0x00b6:
            r6 = r6 & r0
            short r7 = r2[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x00c5
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x00a1
        L_0x00c5:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00d0
            int r6 = r6 + 1
            goto L_0x00b6
        L_0x00d0:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x00d5:
            int[] r2 = new int[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00da:
            if (r1 >= r10) goto L_0x0109
            int r4 = r1 * 2
            r5 = r11[r4]
            r6 = r4 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.firebase-perf.zzo.zza(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.firebase-perf.zzn.zza(r7)
        L_0x00ef:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r3) goto L_0x00f9
            r2[r7] = r4
            int r1 = r1 + 1
            goto L_0x00da
        L_0x00f9:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0104
            int r7 = r7 + 1
            goto L_0x00ef
        L_0x0104:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x0109:
            com.google.android.gms.internal.firebase-perf.zzz r0 = new com.google.android.gms.internal.firebase-perf.zzz
            r0.<init>(r2, r11, r10)
            return r0
        L_0x010f:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "collection too large"
            r10.<init>(r11)
            goto L_0x0118
        L_0x0117:
            throw r10
        L_0x0118:
            goto L_0x0117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzz.zza(int, java.lang.Object[]):com.google.android.gms.internal.firebase-perf.zzz");
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        String str = "=";
        sb.append(str);
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append(str);
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private zzz(Object obj, Object[] objArr, int i) {
        this.zzac = obj;
        this.zzz = objArr;
        this.size = i;
    }

    public final int size() {
        return this.size;
    }

    public final V get(Object obj) {
        Object obj2 = this.zzac;
        V[] vArr = this.zzz;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zza = zzn.zza(obj.hashCode());
                while (true) {
                    int i2 = zza & length;
                    byte b = bArr[i2] & UByte.MAX_VALUE;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zza = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zza2 = zzn.zza(obj.hashCode());
                while (true) {
                    int i3 = zza2 & length2;
                    short s = sArr[i3] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    zza2 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zza3 = zzn.zza(obj.hashCode());
                while (true) {
                    int i4 = zza3 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zza3 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final zzx<Entry<K, V>> zzk() {
        return new zzac(this, this.zzz, 0, this.size);
    }

    /* access modifiers changed from: 0000 */
    public final zzx<K> zzl() {
        return new zzae(this, new zzad(this.zzz, 0, this.size));
    }

    /* access modifiers changed from: 0000 */
    public final zzq<V> zzm() {
        return new zzad(this.zzz, 1, this.size);
    }
}
