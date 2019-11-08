package com.google.android.gms.internal.firebase-perf;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;

public class zzbg implements Parcelable {
    public static final Creator<zzbg> CREATOR = new zzbj();
    private long zzhy;
    private long zzhz;

    public zzbg() {
        this.zzhy = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.zzhz = System.nanoTime();
    }

    public int describeContents() {
        return 0;
    }

    public final void reset() {
        this.zzhy = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.zzhz = System.nanoTime();
    }

    public final long zzcr() {
        return this.zzhy;
    }

    public final long zzcs() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.zzhz);
    }

    public final long zza(@NonNull zzbg zzbg) {
        return TimeUnit.NANOSECONDS.toMicros(zzbg.zzhz - this.zzhz);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zzhy);
        parcel.writeLong(this.zzhz);
    }

    private zzbg(Parcel parcel) {
        this.zzhy = parcel.readLong();
        this.zzhz = parcel.readLong();
    }

    /* synthetic */ zzbg(Parcel parcel, zzbj zzbj) {
        this(parcel);
    }
}
