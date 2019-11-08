package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class zzt implements Creator<zzq> {
    zzt() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzq[i];
    }

    public final /* synthetic */ Object createFromParcel(@NonNull Parcel parcel) {
        return new zzq(parcel, (zzt) null);
    }
}
