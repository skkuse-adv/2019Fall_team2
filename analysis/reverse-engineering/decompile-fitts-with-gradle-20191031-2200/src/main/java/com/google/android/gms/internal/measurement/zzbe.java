package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbe extends zzb {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzc zzbw;

    zzbe(zzc zzc, Activity activity) {
        this.zzbw = zzc;
        this.val$activity = activity;
        super(zzz.this);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        zzz.this.zzar.onActivityPaused(ObjectWrapper.wrap(this.val$activity), this.zzbt);
    }
}
