package com.google.android.gms.internal.firebase-perf;

import java.util.Collections;
import java.util.List;

final class zzfj extends zzfh {
    private static final Class<?> zzsk = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfj() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzhm.zzo(obj, j);
        if (list instanceof zzfi) {
            obj2 = ((zzfi) list).zzhw();
        } else if (!zzsk.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzgk) || !(list instanceof zzey)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzey zzey = (zzey) list;
                if (zzey.zzge()) {
                    zzey.zzgf();
                }
                return;
            }
        } else {
            return;
        }
        zzhm.zza(obj, j, obj2);
    }

    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E> void zza(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.util.List r6 = zzb(r6, r7)
            int r0 = r6.size()
            java.util.List r1 = zzb(r5, r7)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0034
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase-perf.zzfi
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.firebase-perf.zzff r1 = new com.google.android.gms.internal.firebase-perf.zzff
            r1.<init>(r0)
            goto L_0x0030
        L_0x001c:
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase-perf.zzgk
            if (r2 == 0) goto L_0x002b
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase-perf.zzey
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.internal.firebase-perf.zzey r1 = (com.google.android.gms.internal.firebase-perf.zzey) r1
            com.google.android.gms.internal.firebase-perf.zzey r1 = r1.zzao(r0)
            goto L_0x0030
        L_0x002b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0030:
            com.google.android.gms.internal.firebase-perf.zzhm.zza(r5, r7, r1)
            goto L_0x0087
        L_0x0034:
            java.lang.Class<?> r2 = zzsk
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0052
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
            com.google.android.gms.internal.firebase-perf.zzhm.zza(r5, r7, r2)
        L_0x0050:
            r1 = r2
            goto L_0x0087
        L_0x0052:
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase-perf.zzhh
            if (r2 == 0) goto L_0x0069
            com.google.android.gms.internal.firebase-perf.zzff r2 = new com.google.android.gms.internal.firebase-perf.zzff
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            com.google.android.gms.internal.firebase-perf.zzhh r1 = (com.google.android.gms.internal.firebase-perf.zzhh) r1
            r2.addAll(r1)
            com.google.android.gms.internal.firebase-perf.zzhm.zza(r5, r7, r2)
            goto L_0x0050
        L_0x0069:
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase-perf.zzgk
            if (r2 == 0) goto L_0x0087
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase-perf.zzey
            if (r2 == 0) goto L_0x0087
            r2 = r1
            com.google.android.gms.internal.firebase-perf.zzey r2 = (com.google.android.gms.internal.firebase-perf.zzey) r2
            boolean r3 = r2.zzge()
            if (r3 != 0) goto L_0x0087
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.firebase-perf.zzey r0 = r2.zzao(r1)
            com.google.android.gms.internal.firebase-perf.zzhm.zza(r5, r7, r0)
            r1 = r0
        L_0x0087:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x0096
            if (r2 <= 0) goto L_0x0096
            r1.addAll(r6)
        L_0x0096:
            if (r0 <= 0) goto L_0x0099
            r6 = r1
        L_0x0099:
            com.google.android.gms.internal.firebase-perf.zzhm.zza(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzfj.zza(java.lang.Object, java.lang.Object, long):void");
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zzhm.zzo(obj, j);
    }
}
