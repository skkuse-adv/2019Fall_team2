package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzat extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ zzl zzat;
    private final /* synthetic */ Bundle zzbj;

    zzat(zzz zzz, Bundle bundle, zzl zzl) {
        this.zzaa = zzz;
        this.zzbj = bundle;
        this.zzat = zzl;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.performAction(this.zzbj, this.zzat, this.timestamp);
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
