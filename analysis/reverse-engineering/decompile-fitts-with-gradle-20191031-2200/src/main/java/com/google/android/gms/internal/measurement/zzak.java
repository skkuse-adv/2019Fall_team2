package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzak extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ zzl zzat;

    zzak(zzz zzz, zzl zzl) {
        this.zzaa = zzz;
        this.zzat = zzl;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.getGmpAppId(this.zzat);
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
