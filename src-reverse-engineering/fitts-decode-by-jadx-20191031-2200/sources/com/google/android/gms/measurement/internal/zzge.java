package com.google.android.gms.measurement.internal;

abstract class zzge extends zzgf {
    private boolean zzdh;

    zzge(zzfj zzfj) {
        super(zzfj);
        this.zzj.zzb(this);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzbk();

    /* access modifiers changed from: protected */
    public void zzbl() {
    }

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
        if (this.zzdh) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzbk()) {
            this.zzj.zzid();
            this.zzdh = true;
        }
    }

    public final void zzbj() {
        if (!this.zzdh) {
            zzbl();
            this.zzj.zzid();
            this.zzdh = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
