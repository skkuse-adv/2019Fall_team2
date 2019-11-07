package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;

final class zzy extends zzb {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzx;
    private final /* synthetic */ String zzy;
    private final /* synthetic */ Bundle zzz;

    zzy(zzz zzz2, String str, String str2, Context context, Bundle bundle) {
        this.zzaa = zzz2;
        this.zzx = str;
        this.zzy = str2;
        this.val$context = context;
        this.zzz = bundle;
        super(zzz2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r4 < r3) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ RemoteException -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a A[Catch:{ RemoteException -> 0x0098 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzz r2 = r14.zzaa     // Catch:{ RemoteException -> 0x0098 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ RemoteException -> 0x0098 }
            r3.<init>()     // Catch:{ RemoteException -> 0x0098 }
            r2.zzaf = r3     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzz r2 = r14.zzaa     // Catch:{ RemoteException -> 0x0098 }
            java.lang.String r3 = r14.zzx     // Catch:{ RemoteException -> 0x0098 }
            java.lang.String r4 = r14.zzy     // Catch:{ RemoteException -> 0x0098 }
            boolean r2 = com.google.android.gms.internal.measurement.zzz.zza(r3, r4)     // Catch:{ RemoteException -> 0x0098 }
            r3 = 0
            if (r2 == 0) goto L_0x0027
            java.lang.String r3 = r14.zzy     // Catch:{ RemoteException -> 0x0098 }
            java.lang.String r2 = r14.zzx     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzz r4 = r14.zzaa     // Catch:{ RemoteException -> 0x0098 }
            java.lang.String r4 = r4.zzu     // Catch:{ RemoteException -> 0x0098 }
            r10 = r2
            r11 = r3
            r9 = r4
            goto L_0x002a
        L_0x0027:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x002a:
            android.content.Context r2 = r14.val$context     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzz.zze(r2)     // Catch:{ RemoteException -> 0x0098 }
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzz.zzai     // Catch:{ RemoteException -> 0x0098 }
            boolean r2 = r2.booleanValue()     // Catch:{ RemoteException -> 0x0098 }
            if (r2 != 0) goto L_0x003e
            if (r10 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r2 = 0
            goto L_0x003f
        L_0x003e:
            r2 = 1
        L_0x003f:
            com.google.android.gms.internal.measurement.zzz r3 = r14.zzaa     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzz r4 = r14.zzaa     // Catch:{ RemoteException -> 0x0098 }
            android.content.Context r5 = r14.val$context     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzk r4 = r4.zza(r5, r2)     // Catch:{ RemoteException -> 0x0098 }
            r3.zzar = r4     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzz r3 = r14.zzaa     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzk r3 = r3.zzar     // Catch:{ RemoteException -> 0x0098 }
            if (r3 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzz r2 = r14.zzaa     // Catch:{ RemoteException -> 0x0098 }
            r2.zzu     // Catch:{ RemoteException -> 0x0098 }
            return
        L_0x005a:
            android.content.Context r3 = r14.val$context     // Catch:{ RemoteException -> 0x0098 }
            int r3 = com.google.android.gms.internal.measurement.zzz.zzd(r3)     // Catch:{ RemoteException -> 0x0098 }
            android.content.Context r4 = r14.val$context     // Catch:{ RemoteException -> 0x0098 }
            int r4 = com.google.android.gms.internal.measurement.zzz.zzc(r4)     // Catch:{ RemoteException -> 0x0098 }
            if (r2 == 0) goto L_0x0073
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ RemoteException -> 0x0098 }
            if (r4 >= r3) goto L_0x0070
        L_0x006e:
            r3 = 1
            goto L_0x0071
        L_0x0070:
            r3 = 0
        L_0x0071:
            r8 = r3
            goto L_0x007b
        L_0x0073:
            if (r3 <= 0) goto L_0x0077
            r2 = r3
            goto L_0x0078
        L_0x0077:
            r2 = r4
        L_0x0078:
            if (r3 <= 0) goto L_0x0070
            goto L_0x006e
        L_0x007b:
            com.google.android.gms.internal.measurement.zzx r13 = new com.google.android.gms.internal.measurement.zzx     // Catch:{ RemoteException -> 0x0098 }
            r4 = 16250(0x3f7a, double:8.0286E-320)
            long r6 = (long) r2     // Catch:{ RemoteException -> 0x0098 }
            android.os.Bundle r12 = r14.zzz     // Catch:{ RemoteException -> 0x0098 }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzz r2 = r14.zzaa     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzk r2 = r2.zzar     // Catch:{ RemoteException -> 0x0098 }
            android.content.Context r3 = r14.val$context     // Catch:{ RemoteException -> 0x0098 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ RemoteException -> 0x0098 }
            long r4 = r14.timestamp     // Catch:{ RemoteException -> 0x0098 }
            r2.initialize(r3, r13, r4)     // Catch:{ RemoteException -> 0x0098 }
            return
        L_0x0098:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzz r3 = r14.zzaa
            r3.zza(r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzy.zzf():void");
    }
}
