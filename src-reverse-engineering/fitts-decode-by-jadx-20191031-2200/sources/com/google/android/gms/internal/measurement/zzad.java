package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzad extends zzb {
    private final /* synthetic */ String val$id;
    private final /* synthetic */ zzz zzaa;

    zzad(zzz zzz, String str) {
        this.zzaa = zzz;
        this.val$id = str;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.setUserId(this.val$id, this.timestamp);
    }
}
