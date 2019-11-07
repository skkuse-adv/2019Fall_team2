package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzay extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ Long zzbm;
    private final /* synthetic */ String zzbn;
    private final /* synthetic */ Bundle zzbo;
    private final /* synthetic */ boolean zzbp;
    private final /* synthetic */ boolean zzbq;
    private final /* synthetic */ String zzx;

    zzay(zzz zzz, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        this.zzaa = zzz;
        this.zzbm = l;
        this.zzx = str;
        this.zzbn = str2;
        this.zzbo = bundle;
        this.zzbp = z;
        this.zzbq = z2;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        Long l = this.zzbm;
        this.zzaa.zzar.logEvent(this.zzx, this.zzbn, this.zzbo, this.zzbp, this.zzbq, l == null ? this.timestamp : l.longValue());
    }
}
