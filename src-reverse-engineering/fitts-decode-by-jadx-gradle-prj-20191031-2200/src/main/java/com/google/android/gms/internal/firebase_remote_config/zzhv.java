package com.google.android.gms.internal.firebase_remote_config;

public class zzhv {
    private volatile zziq zzuu;
    private volatile zzfx zzuv;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhv)) {
            return false;
        }
        zzhv zzhv = (zzhv) obj;
        zziq zziq = this.zzuu;
        zziq zziq2 = zzhv.zzuu;
        if (zziq == null && zziq2 == null) {
            return zzep().equals(zzhv.zzep());
        }
        if (zziq != null && zziq2 != null) {
            return zziq.equals(zziq2);
        }
        if (zziq != null) {
            return zziq.equals(zzhv.zzh(zziq.zzgw()));
        }
        return zzh(zziq2.zzgw()).equals(zziq2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase_remote_config.zziq zzh(com.google.android.gms.internal.firebase_remote_config.zziq r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase_remote_config.zziq r0 = r1.zzuu
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase_remote_config.zziq r0 = r1.zzuu     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzuu = r2     // Catch:{ zzhq -> 0x0012 }
            com.google.android.gms.internal.firebase_remote_config.zzfx r0 = com.google.android.gms.internal.firebase_remote_config.zzfx.zzov     // Catch:{ zzhq -> 0x0012 }
            r1.zzuv = r0     // Catch:{ zzhq -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzuu = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase_remote_config.zzfx r2 = com.google.android.gms.internal.firebase_remote_config.zzfx.zzov     // Catch:{ all -> 0x001a }
            r1.zzuv = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase_remote_config.zziq r2 = r1.zzuu
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzhv.zzh(com.google.android.gms.internal.firebase_remote_config.zziq):com.google.android.gms.internal.firebase_remote_config.zziq");
    }

    public final zziq zzi(zziq zziq) {
        zziq zziq2 = this.zzuu;
        this.zzuv = null;
        this.zzuu = zziq;
        return zziq2;
    }

    public final int zzgs() {
        if (this.zzuv != null) {
            return this.zzuv.size();
        }
        if (this.zzuu != null) {
            return this.zzuu.zzgs();
        }
        return 0;
    }

    public final zzfx zzep() {
        if (this.zzuv != null) {
            return this.zzuv;
        }
        synchronized (this) {
            if (this.zzuv != null) {
                zzfx zzfx = this.zzuv;
                return zzfx;
            }
            if (this.zzuu == null) {
                this.zzuv = zzfx.zzov;
            } else {
                this.zzuv = this.zzuu.zzep();
            }
            zzfx zzfx2 = this.zzuv;
            return zzfx2;
        }
    }

    static {
        zzgx.zzgh();
    }
}
