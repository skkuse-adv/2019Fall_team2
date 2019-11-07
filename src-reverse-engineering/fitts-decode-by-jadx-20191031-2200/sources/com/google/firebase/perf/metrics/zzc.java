package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class zzc implements Creator<Trace> {
    zzc() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Trace[i];
    }

    public final /* synthetic */ Object createFromParcel(@NonNull Parcel parcel) {
        return new Trace(parcel, false, null);
    }
}
