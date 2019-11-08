package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicLong;

public class zza implements Parcelable {
    public static final Creator<zza> CREATOR = new zzb();
    private final String mName;
    private AtomicLong zzfv;

    public zza(@NonNull String str) {
        this.mName = str;
        this.zzfv = new AtomicLong(0);
    }

    public int describeContents() {
        return 0;
    }

    public final void zzn(long j) {
        this.zzfv.addAndGet(j);
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public final String getName() {
        return this.mName;
    }

    /* access modifiers changed from: 0000 */
    public final long getCount() {
        return this.zzfv.get();
    }

    /* access modifiers changed from: 0000 */
    public final void zzo(long j) {
        this.zzfv.set(j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeLong(this.zzfv.get());
    }

    private zza(Parcel parcel) {
        this.mName = parcel.readString();
        this.zzfv = new AtomicLong(parcel.readLong());
    }

    /* synthetic */ zza(Parcel parcel, zzb zzb) {
        this(parcel);
    }
}
