package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzaa extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzas;
    private final /* synthetic */ zzl zzat;
    private final /* synthetic */ String zzx;

    zzaa(zzz zzz, String str, String str2, zzl zzl) {
        this.zzaa = zzz;
        this.zzx = str;
        this.zzas = str2;
        this.zzat = zzl;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.getConditionalUserProperties(this.zzx, this.zzas, this.zzat);
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
