package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzgk;

final class zzal extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ zzgk zzbc;

    zzal(zzz zzz, zzgk zzgk) {
        this.zzaa = zzz;
        this.zzbc = zzgk;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.setEventInterceptor(new zza(this.zzbc));
    }
}
