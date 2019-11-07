package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzba extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ Bundle zzbj;

    zzba(zzz zzz, Bundle bundle) {
        this.zzaa = zzz;
        this.zzbj = bundle;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.setConditionalUserProperty(this.zzbj, this.timestamp);
    }
}
