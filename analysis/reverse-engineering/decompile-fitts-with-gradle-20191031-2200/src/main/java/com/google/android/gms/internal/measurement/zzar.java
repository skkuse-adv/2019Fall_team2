package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzar extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzas;
    private final /* synthetic */ zzl zzat;
    private final /* synthetic */ boolean zzbi;
    private final /* synthetic */ String zzx;

    zzar(zzz zzz, String str, String str2, boolean z, zzl zzl) {
        this.zzaa = zzz;
        this.zzx = str;
        this.zzas = str2;
        this.zzbi = z;
        this.zzat = zzl;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.getUserProperties(this.zzx, this.zzas, this.zzbi, this.zzat);
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
