package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.List;

final class zzda extends zzcy {
    private static final Class<?> zzlv = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzda() {
        super();
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzfd.zzo(obj, j);
        if (list instanceof zzcx) {
            obj2 = ((zzcx) list).zzbu();
        } else if (!zzlv.isAssignableFrom(list.getClass())) {
            obj2 = Collections.unmodifiableList(list);
        } else {
            return;
        }
        zzfd.zza(obj, j, obj2);
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
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
            if (r2 == 0) goto L_0x0025
            boolean r1 = r1 instanceof com.google.android.gms.internal.clearcut.zzcx
            if (r1 == 0) goto L_0x001c
            com.google.android.gms.internal.clearcut.zzcw r1 = new com.google.android.gms.internal.clearcut.zzcw
            r1.<init>(r0)
            goto L_0x0021
        L_0x001c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0021:
            com.google.android.gms.internal.clearcut.zzfd.zza(r5, r7, r1)
            goto L_0x0057
        L_0x0025:
            java.lang.Class<?> r2 = zzlv
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0043
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
        L_0x003e:
            com.google.android.gms.internal.clearcut.zzfd.zza(r5, r7, r2)
            r1 = r2
            goto L_0x0057
        L_0x0043:
            boolean r2 = r1 instanceof com.google.android.gms.internal.clearcut.zzfa
            if (r2 == 0) goto L_0x0057
            com.google.android.gms.internal.clearcut.zzcw r2 = new com.google.android.gms.internal.clearcut.zzcw
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            com.google.android.gms.internal.clearcut.zzfa r1 = (com.google.android.gms.internal.clearcut.zzfa) r1
            r2.addAll(r1)
            goto L_0x003e
        L_0x0057:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x0066
            if (r2 <= 0) goto L_0x0066
            r1.addAll(r6)
        L_0x0066:
            if (r0 <= 0) goto L_0x0069
            r6 = r1
        L_0x0069:
            com.google.android.gms.internal.clearcut.zzfd.zza(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzda.zza(java.lang.Object, java.lang.Object, long):void");
    }
}
