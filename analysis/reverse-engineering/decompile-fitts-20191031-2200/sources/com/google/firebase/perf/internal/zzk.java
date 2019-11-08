package com.google.firebase.perf.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase-perf.zzda;
import java.util.Iterator;

final class zzk extends zzr {
    private zzda zzdi;

    zzk(@NonNull zzda zzda) {
        this.zzdi = zzda;
    }

    public final boolean zzbe() {
        boolean z;
        boolean z2;
        if (!zza(this.zzdi, 0)) {
            String str = "Invalid Trace:";
            String valueOf = String.valueOf(this.zzdi.getName());
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
            return false;
        }
        zzda zzda = this.zzdi;
        if (zzda.zzfn() > 0) {
            z = true;
        } else {
            Iterator it = zzda.zzfq().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (((zzda) it.next()).zzfn() > 0) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            z = true;
        }
        if (!z || zzb(this.zzdi, 0)) {
            return true;
        }
        String str2 = "Invalid Counters for Trace:";
        String valueOf2 = String.valueOf(this.zzdi.getName());
        if (valueOf2.length() != 0) {
            str2.concat(valueOf2);
        } else {
            new String(str2);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(@androidx.annotation.Nullable com.google.android.gms.internal.firebase-perf.zzda r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            if (r9 <= r1) goto L_0x0008
            return r0
        L_0x0008:
            java.lang.String r2 = r8.getName()
            if (r2 == 0) goto L_0x0022
            java.lang.String r2 = r2.trim()
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0022
            int r2 = r2.length()
            r3 = 100
            if (r2 > r3) goto L_0x0022
            r2 = 1
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            if (r2 != 0) goto L_0x003f
            java.lang.String r9 = "invalid TraceId:"
            java.lang.String r8 = r8.getName()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L_0x0039
            r9.concat(r8)
            goto L_0x003e
        L_0x0039:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r9)
        L_0x003e:
            return r0
        L_0x003f:
            if (r8 == 0) goto L_0x004d
            long r2 = r8.getDurationUs()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x004d
            r2 = 1
            goto L_0x004e
        L_0x004d:
            r2 = 0
        L_0x004e:
            if (r2 != 0) goto L_0x0067
            long r8 = r8.getDurationUs()
            r1 = 42
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "invalid TraceDuration:"
            r2.append(r1)
            r2.append(r8)
            r2.toString()
            return r0
        L_0x0067:
            boolean r2 = r8.zzek()
            if (r2 != 0) goto L_0x006e
            return r0
        L_0x006e:
            java.util.List r2 = r8.zzfq()
            java.util.Iterator r2 = r2.iterator()
        L_0x0076:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x008b
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.firebase-perf.zzda r3 = (com.google.android.gms.internal.firebase-perf.zzda) r3
            int r4 = r9 + 1
            boolean r3 = r7.zza(r3, r4)
            if (r3 != 0) goto L_0x0076
            return r0
        L_0x008b:
            java.util.Map r8 = r8.zzfs()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0097:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00ab
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.String r9 = com.google.firebase.perf.internal.zzr.zza(r9)
            if (r9 == 0) goto L_0x0097
            r8 = 0
            goto L_0x00ac
        L_0x00ab:
            r8 = 1
        L_0x00ac:
            if (r8 != 0) goto L_0x00af
            return r0
        L_0x00af:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.zzk.zza(com.google.android.gms.internal.firebase-perf.zzda, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0041 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(@androidx.annotation.Nullable com.google.android.gms.internal.firebase-perf.zzda r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            if (r8 <= r1) goto L_0x0008
            return r0
        L_0x0008:
            java.util.Map r2 = r7.zzfo()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0014:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x002a
        L_0x0028:
            r4 = 0
            goto L_0x003f
        L_0x002a:
            java.lang.String r4 = r4.trim()
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0035
            goto L_0x0028
        L_0x0035:
            int r4 = r4.length()
            r5 = 100
            if (r4 <= r5) goto L_0x003e
            goto L_0x0028
        L_0x003e:
            r4 = 1
        L_0x003f:
            if (r4 != 0) goto L_0x005d
            java.lang.String r7 = "invalid CounterId:"
            java.lang.Object r8 = r3.getKey()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L_0x0057
            r7.concat(r8)
            goto L_0x005c
        L_0x0057:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r7)
        L_0x005c:
            return r0
        L_0x005d:
            java.lang.Object r4 = r3.getValue()
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x0067
            r4 = 1
            goto L_0x0068
        L_0x0067:
            r4 = 0
        L_0x0068:
            if (r4 != 0) goto L_0x0014
            java.lang.Object r7 = r3.getValue()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = java.lang.String.valueOf(r7)
            int r8 = r8.length()
            int r8 = r8 + 21
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            java.lang.String r8 = "invalid CounterValue:"
            r1.append(r8)
            r1.append(r7)
            r1.toString()
            return r0
        L_0x008d:
            java.util.List r7 = r7.zzfq()
            java.util.Iterator r7 = r7.iterator()
        L_0x0095:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x00aa
            java.lang.Object r2 = r7.next()
            com.google.android.gms.internal.firebase-perf.zzda r2 = (com.google.android.gms.internal.firebase-perf.zzda) r2
            int r3 = r8 + 1
            boolean r2 = r6.zzb(r2, r3)
            if (r2 != 0) goto L_0x0095
            return r0
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.zzk.zzb(com.google.android.gms.internal.firebase-perf.zzda, int):boolean");
    }
}
