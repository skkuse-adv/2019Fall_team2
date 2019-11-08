package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzac extends zzb {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzax;
    private final /* synthetic */ String zzay;

    zzac(zzz zzz, Activity activity, String str, String str2) {
        this.zzaa = zzz;
        this.val$activity = activity;
        this.zzax = str;
        this.zzay = str2;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.setCurrentScreen(ObjectWrapper.wrap(this.val$activity), this.zzax, this.zzay, this.timestamp);
    }
}
