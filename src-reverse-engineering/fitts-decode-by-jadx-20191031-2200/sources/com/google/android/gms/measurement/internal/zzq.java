package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzq extends AbstractSafeParcelable {
    public static final Creator<zzq> CREATOR = new zzt();
    public boolean active;
    public long creationTimestamp;
    public String origin;
    public String packageName;
    public long timeToLive;
    public String triggerEventName;
    public long triggerTimeout;
    public zzjn zzdw;
    public zzai zzdx;
    public zzai zzdy;
    public zzai zzdz;

    zzq(zzq zzq) {
        Preconditions.checkNotNull(zzq);
        this.packageName = zzq.packageName;
        this.origin = zzq.origin;
        this.zzdw = zzq.zzdw;
        this.creationTimestamp = zzq.creationTimestamp;
        this.active = zzq.active;
        this.triggerEventName = zzq.triggerEventName;
        this.zzdx = zzq.zzdx;
        this.triggerTimeout = zzq.triggerTimeout;
        this.zzdy = zzq.zzdy;
        this.timeToLive = zzq.timeToLive;
        this.zzdz = zzq.zzdz;
    }

    zzq(String str, String str2, zzjn zzjn, long j, boolean z, String str3, zzai zzai, long j2, zzai zzai2, long j3, zzai zzai3) {
        this.packageName = str;
        this.origin = str2;
        this.zzdw = zzjn;
        this.creationTimestamp = j;
        this.active = z;
        this.triggerEventName = str3;
        this.zzdx = zzai;
        this.triggerTimeout = j2;
        this.zzdy = zzai2;
        this.timeToLive = j3;
        this.zzdz = zzai3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.origin, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdw, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.creationTimestamp);
        SafeParcelWriter.writeBoolean(parcel, 6, this.active);
        SafeParcelWriter.writeString(parcel, 7, this.triggerEventName, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzdx, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.triggerTimeout);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdy, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.timeToLive);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzdz, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
