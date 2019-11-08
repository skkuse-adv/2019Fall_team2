package com.google.android.gms.internal.measurement;

public class zzfn {
    private volatile zzgi zzajn;
    private volatile zzdp zzajo;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfn)) {
            return false;
        }
        zzfn zzfn = (zzfn) obj;
        zzgi zzgi = this.zzajn;
        zzgi zzgi2 = zzfn.zzajn;
        if (zzgi == null && zzgi2 == null) {
            return zzrs().equals(zzfn.zzrs());
        }
        if (zzgi != null && zzgi2 != null) {
            return zzgi.equals(zzgi2);
        }
        if (zzgi != null) {
            return zzgi.equals(zzfn.zzh(zzgi.zzuh()));
        }
        return zzh(zzgi2.zzuh()).equals(zzgi2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzgi zzh(com.google.android.gms.internal.measurement.zzgi r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzgi r0 = r1.zzajn
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzgi r0 = r1.zzajn     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzajn = r2     // Catch:{ zzfi -> 0x0012 }
            com.google.android.gms.internal.measurement.zzdp r0 = com.google.android.gms.internal.measurement.zzdp.zzadh     // Catch:{ zzfi -> 0x0012 }
            r1.zzajo = r0     // Catch:{ zzfi -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzajn = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzdp r2 = com.google.android.gms.internal.measurement.zzdp.zzadh     // Catch:{ all -> 0x001a }
            r1.zzajo = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzgi r2 = r1.zzajn
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfn.zzh(com.google.android.gms.internal.measurement.zzgi):com.google.android.gms.internal.measurement.zzgi");
    }

    public final zzgi zzi(zzgi zzgi) {
        zzgi zzgi2 = this.zzajn;
        this.zzajo = null;
        this.zzajn = zzgi;
        return zzgi2;
    }

    public final int zzuk() {
        if (this.zzajo != null) {
            return this.zzajo.size();
        }
        if (this.zzajn != null) {
            return this.zzajn.zzuk();
        }
        return 0;
    }

    public final zzdp zzrs() {
        if (this.zzajo != null) {
            return this.zzajo;
        }
        synchronized (this) {
            if (this.zzajo != null) {
                zzdp zzdp = this.zzajo;
                return zzdp;
            }
            if (this.zzajn == null) {
                this.zzajo = zzdp.zzadh;
            } else {
                this.zzajo = this.zzajn.zzrs();
            }
            zzdp zzdp2 = this.zzajo;
            return zzdp2;
        }
    }

    static {
        zzel.zztp();
    }
}
