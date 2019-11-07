package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbg extends zzb {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzl zzat;
    private final /* synthetic */ zzc zzbw;

    zzbg(zzc zzc, Activity activity, zzl zzl) {
        this.zzbw = zzc;
        this.val$activity = activity;
        this.zzat = zzl;
        super(zzz.this);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        zzz.this.zzar.onActivitySaveInstanceState(ObjectWrapper.wrap(this.val$activity), this.zzat, this.zzbt);
    }
}
