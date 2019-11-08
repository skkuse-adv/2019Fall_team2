package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzaf extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ boolean zzaz;

    zzaf(zzz zzz, boolean z) {
        this.zzaa = zzz;
        this.zzaz = z;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.setMeasurementEnabled(this.zzaz, this.timestamp);
    }
}
