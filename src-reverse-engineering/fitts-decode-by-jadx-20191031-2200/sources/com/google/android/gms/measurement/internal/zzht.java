package com.google.android.gms.measurement.internal;

final class zzht implements Runnable {
    private final /* synthetic */ zzhq zzqz;
    private final /* synthetic */ boolean zzra;
    private final /* synthetic */ zzhr zzrb;
    private final /* synthetic */ zzhr zzrc;

    zzht(zzhq zzhq, boolean z, zzhr zzhr, zzhr zzhr2) {
        this.zzqz = zzhq;
        this.zzra = z;
        this.zzrb = zzhr;
        this.zzrc = zzhr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (com.google.android.gms.measurement.internal.zzjs.zzs(r10.zzrb.zzqu, r10.zzrc.zzqu) != false) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzhq r0 = r10.zzqz
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzad()
            com.google.android.gms.measurement.internal.zzhq r1 = r10.zzqz
            com.google.android.gms.measurement.internal.zzdy r1 = r1.zzr()
            java.lang.String r1 = r1.zzag()
            boolean r0 = r0.zzz(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x002f
            boolean r0 = r10.zzra
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.measurement.internal.zzhq r0 = r10.zzqz
            com.google.android.gms.measurement.internal.zzhr r0 = r0.zzqo
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r0 == 0) goto L_0x003d
            com.google.android.gms.measurement.internal.zzhq r3 = r10.zzqz
            com.google.android.gms.measurement.internal.zzhr r4 = r3.zzqo
            r3.zza(r4, r2)
            goto L_0x003d
        L_0x002f:
            boolean r0 = r10.zzra
            if (r0 == 0) goto L_0x003c
            com.google.android.gms.measurement.internal.zzhq r0 = r10.zzqz
            com.google.android.gms.measurement.internal.zzhr r3 = r0.zzqo
            if (r3 == 0) goto L_0x003c
            r0.zza(r3, r2)
        L_0x003c:
            r0 = 0
        L_0x003d:
            com.google.android.gms.measurement.internal.zzhr r3 = r10.zzrb
            if (r3 == 0) goto L_0x0063
            long r4 = r3.zzqw
            com.google.android.gms.measurement.internal.zzhr r6 = r10.zzrc
            long r7 = r6.zzqw
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0063
            java.lang.String r3 = r3.zzqv
            java.lang.String r4 = r6.zzqv
            boolean r3 = com.google.android.gms.measurement.internal.zzjs.zzs(r3, r4)
            if (r3 == 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzhr r3 = r10.zzrb
            java.lang.String r3 = r3.zzqu
            com.google.android.gms.measurement.internal.zzhr r4 = r10.zzrc
            java.lang.String r4 = r4.zzqu
            boolean r3 = com.google.android.gms.measurement.internal.zzjs.zzs(r3, r4)
            if (r3 != 0) goto L_0x0064
        L_0x0063:
            r1 = 1
        L_0x0064:
            if (r1 == 0) goto L_0x00cd
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            com.google.android.gms.measurement.internal.zzhr r3 = r10.zzrc
            com.google.android.gms.measurement.internal.zzhq.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzhr r2 = r10.zzrb
            if (r2 == 0) goto L_0x008f
            java.lang.String r2 = r2.zzqu
            if (r2 == 0) goto L_0x007d
            java.lang.String r3 = "_pn"
            r1.putString(r3, r2)
        L_0x007d:
            com.google.android.gms.measurement.internal.zzhr r2 = r10.zzrb
            java.lang.String r2 = r2.zzqv
            java.lang.String r3 = "_pc"
            r1.putString(r3, r2)
            com.google.android.gms.measurement.internal.zzhr r2 = r10.zzrb
            long r2 = r2.zzqw
            java.lang.String r4 = "_pi"
            r1.putLong(r4, r2)
        L_0x008f:
            com.google.android.gms.measurement.internal.zzhq r2 = r10.zzqz
            com.google.android.gms.measurement.internal.zzs r2 = r2.zzad()
            com.google.android.gms.measurement.internal.zzhq r3 = r10.zzqz
            com.google.android.gms.measurement.internal.zzdy r3 = r3.zzr()
            java.lang.String r3 = r3.zzag()
            boolean r2 = r2.zzz(r3)
            if (r2 == 0) goto L_0x00c0
            if (r0 == 0) goto L_0x00c0
            com.google.android.gms.measurement.internal.zzhq r0 = r10.zzqz
            com.google.android.gms.measurement.internal.zziw r0 = r0.zzv()
            long r2 = r0.zzjb()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c0
            com.google.android.gms.measurement.internal.zzhq r0 = r10.zzqz
            com.google.android.gms.measurement.internal.zzjs r0 = r0.zzz()
            r0.zzb(r1, r2)
        L_0x00c0:
            com.google.android.gms.measurement.internal.zzhq r0 = r10.zzqz
            com.google.android.gms.measurement.internal.zzgp r0 = r0.zzq()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_vs"
            r0.zza(r2, r3, r1)
        L_0x00cd:
            com.google.android.gms.measurement.internal.zzhq r0 = r10.zzqz
            com.google.android.gms.measurement.internal.zzhr r1 = r10.zzrc
            r0.zzqo = r1
            com.google.android.gms.measurement.internal.zzhv r0 = r0.zzs()
            com.google.android.gms.measurement.internal.zzhr r1 = r10.zzrc
            r0.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzht.run():void");
    }
}
