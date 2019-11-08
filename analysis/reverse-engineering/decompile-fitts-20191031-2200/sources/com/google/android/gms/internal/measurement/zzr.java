package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzr extends zzb implements zzp {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        zza(1, obtainAndWriteInterfaceToken);
    }
}
