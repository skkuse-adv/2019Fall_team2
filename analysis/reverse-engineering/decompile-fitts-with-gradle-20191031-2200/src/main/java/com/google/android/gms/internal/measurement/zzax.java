package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzax extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ zzl zzat;
    private final /* synthetic */ int zzbl;

    zzax(zzz zzz, zzl zzl, int i) {
        this.zzaa = zzz;
        this.zzat = zzl;
        this.zzbl = i;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.getTestFlag(this.zzat, this.zzbl);
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
