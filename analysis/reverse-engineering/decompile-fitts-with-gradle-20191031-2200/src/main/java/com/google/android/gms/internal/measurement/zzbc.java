package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbc extends zzb {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzc zzbw;

    zzbc(zzc zzc, Activity activity) {
        this.zzbw = zzc;
        this.val$activity = activity;
        super(zzz.this);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        zzz.this.zzar.onActivityStarted(ObjectWrapper.wrap(this.val$activity), this.zzbt);
    }
}
