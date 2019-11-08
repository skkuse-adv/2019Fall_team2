package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class zzb implements Creator<zza> {
    zzb() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zza(parcel, null);
    }
}
