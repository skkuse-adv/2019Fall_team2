package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzag extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ long zzba;

    zzag(zzz zzz, long j) {
        this.zzaa = zzz;
        this.zzba = j;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.setSessionTimeoutDuration(this.zzba);
    }
}
