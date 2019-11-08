package com.google.android.gms.measurement.internal;

final class zzad implements Runnable {
    private final /* synthetic */ zzgh zzfe;
    private final /* synthetic */ zzaa zzff;

    zzad(zzaa zzaa, zzgh zzgh) {
        this.zzff = zzaa;
        this.zzfe = zzgh;
    }

    public final void run() {
        this.zzfe.zzae();
        if (zzr.isMainThread()) {
            this.zzfe.zzaa().zza((Runnable) this);
            return;
        }
        boolean zzcp = this.zzff.zzcp();
        this.zzff.zzex = 0;
        if (zzcp) {
            this.zzff.run();
        }
    }
}
