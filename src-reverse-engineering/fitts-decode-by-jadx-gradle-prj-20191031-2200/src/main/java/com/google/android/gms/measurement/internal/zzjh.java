package com.google.android.gms.measurement.internal;

abstract class zzjh extends zzje {
    private boolean zzdh;

    zzjh(zzjg zzjg) {
        super(zzjg);
        this.zzkz.zzb(this);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzbk();

    /* access modifiers changed from: 0000 */
    public final boolean isInitialized() {
        return this.zzdh;
    }

    /* access modifiers changed from: protected */
    public final void zzbi() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void initialize() {
        if (!this.zzdh) {
            zzbk();
            this.zzkz.zzjs();
            this.zzdh = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
