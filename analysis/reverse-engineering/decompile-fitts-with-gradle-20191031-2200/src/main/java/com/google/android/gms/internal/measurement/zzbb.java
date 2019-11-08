package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbb extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzbn;
    private final /* synthetic */ boolean zzbp;
    private final /* synthetic */ Object zzbr;
    private final /* synthetic */ String zzx;

    zzbb(zzz zzz, String str, String str2, Object obj, boolean z) {
        this.zzaa = zzz;
        this.zzx = str;
        this.zzbn = str2;
        this.zzbr = obj;
        this.zzbp = z;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.setUserProperty(this.zzx, this.zzbn, ObjectWrapper.wrap(this.zzbr), this.zzbp, this.timestamp);
    }
}
