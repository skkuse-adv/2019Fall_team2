package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzaj extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzbb;

    zzaj(zzz zzz, String str) {
        this.zzaa = zzz;
        this.zzbb = str;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.beginAdUnitExposure(this.zzbb, this.zzbt);
    }
}
