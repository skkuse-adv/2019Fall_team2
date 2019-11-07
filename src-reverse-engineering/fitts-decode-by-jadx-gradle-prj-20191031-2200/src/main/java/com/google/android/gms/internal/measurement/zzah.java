package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzah extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ long zzba;

    zzah(zzz zzz, long j) {
        this.zzaa = zzz;
        this.zzba = j;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.setMinimumSessionDuration(this.zzba);
    }
}
