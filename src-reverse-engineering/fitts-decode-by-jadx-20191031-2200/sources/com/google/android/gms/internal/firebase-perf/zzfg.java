package com.google.android.gms.internal.firebase-perf;

public class zzfg {
    private volatile zzfx zzsg;
    private volatile zzdl zzsh;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfg)) {
            return false;
        }
        zzfg zzfg = (zzfg) obj;
        zzfx zzfx = this.zzsg;
        zzfx zzfx2 = zzfg.zzsg;
        if (zzfx == null && zzfx2 == null) {
            return zzfz().equals(zzfg.zzfz());
        }
        if (zzfx != null && zzfx2 != null) {
            return zzfx.equals(zzfx2);
        }
        if (zzfx != null) {
            return zzfx.equals(zzfg.zzg(zzfx.zzhj()));
        }
        return zzg(zzfx2.zzhj()).equals(zzfx2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase-perf.zzfx zzg(com.google.android.gms.internal.firebase-perf.zzfx r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-perf.zzfx r0 = r1.zzsg
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-perf.zzfx r0 = r1.zzsg     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzsg = r2     // Catch:{ zzex -> 0x0012 }
            com.google.android.gms.internal.firebase-perf.zzdl r0 = com.google.android.gms.internal.firebase-perf.zzdl.zzmt     // Catch:{ zzex -> 0x0012 }
            r1.zzsh = r0     // Catch:{ zzex -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzsg = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase-perf.zzdl r2 = com.google.android.gms.internal.firebase-perf.zzdl.zzmt     // Catch:{ all -> 0x001a }
            r1.zzsh = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase-perf.zzfx r2 = r1.zzsg
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzfg.zzg(com.google.android.gms.internal.firebase-perf.zzfx):com.google.android.gms.internal.firebase-perf.zzfx");
    }

    public final zzfx zzh(zzfx zzfx) {
        zzfx zzfx2 = this.zzsg;
        this.zzsh = null;
        this.zzsg = zzfx;
        return zzfx2;
    }

    public final int zzhm() {
        if (this.zzsh != null) {
            return this.zzsh.size();
        }
        if (this.zzsg != null) {
            return this.zzsg.zzhm();
        }
        return 0;
    }

    public final zzdl zzfz() {
        if (this.zzsh != null) {
            return this.zzsh;
        }
        synchronized (this) {
            if (this.zzsh != null) {
                zzdl zzdl = this.zzsh;
                return zzdl;
            }
            if (this.zzsg == null) {
                this.zzsh = zzdl.zzmt;
            } else {
                this.zzsh = this.zzsg.zzfz();
            }
            zzdl zzdl2 = this.zzsh;
            return zzdl2;
        }
    }

    static {
        zzed.zzgs();
    }
}
