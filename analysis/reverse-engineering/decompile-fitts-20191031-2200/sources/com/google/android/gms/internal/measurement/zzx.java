package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzx extends AbstractSafeParcelable {
    public static final Creator<zzx> CREATOR = new zzw();
    public final String origin;
    public final long zzr;
    public final long zzs;
    public final boolean zzt;
    public final String zzu;
    public final String zzv;
    public final Bundle zzw;

    public zzx(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.zzr = j;
        this.zzs = j2;
        this.zzt = z;
        this.zzu = str;
        this.origin = str2;
        this.zzv = str3;
        this.zzw = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzr);
        SafeParcelWriter.writeLong(parcel, 2, this.zzs);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzt);
        SafeParcelWriter.writeString(parcel, 4, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 5, this.origin, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzv, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
