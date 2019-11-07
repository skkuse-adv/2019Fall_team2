package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class zzn extends AbstractSafeParcelable {
    public static final Creator<zzn> CREATOR = new zzm();
    public final String packageName;
    public final String zzcg;
    public final String zzci;
    public final String zzcm;
    public final long zzcn;
    public final String zzco;
    public final long zzcp;
    public final boolean zzcq;
    public final long zzcr;
    public final boolean zzcs;
    public final boolean zzct;
    public final String zzcu;
    public final Boolean zzcv;
    public final List<String> zzcw;
    public final String zzdp;
    public final boolean zzdq;
    public final long zzdr;
    public final int zzds;
    public final boolean zzdt;
    public final long zzr;
    public final long zzs;

    zzn(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j6, List<String> list) {
        Preconditions.checkNotEmpty(str);
        this.packageName = str;
        this.zzcg = TextUtils.isEmpty(str2) ? null : str2;
        this.zzcm = str3;
        this.zzcn = j;
        this.zzco = str4;
        this.zzr = j2;
        this.zzcp = j3;
        this.zzdp = str5;
        this.zzcq = z;
        this.zzdq = z2;
        this.zzci = str6;
        this.zzcr = j4;
        this.zzdr = j5;
        this.zzds = i;
        this.zzcs = z3;
        this.zzct = z4;
        this.zzdt = z5;
        this.zzcu = str7;
        this.zzcv = bool;
        this.zzs = j6;
        this.zzcw = list;
    }

    zzn(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j6, List<String> list) {
        this.packageName = str;
        this.zzcg = str2;
        this.zzcm = str3;
        this.zzcn = j3;
        this.zzco = str4;
        this.zzr = j;
        this.zzcp = j2;
        this.zzdp = str5;
        this.zzcq = z;
        this.zzdq = z2;
        this.zzci = str6;
        this.zzcr = j4;
        this.zzdr = j5;
        this.zzds = i;
        this.zzcs = z3;
        this.zzct = z4;
        this.zzdt = z5;
        this.zzcu = str7;
        this.zzcv = bool;
        this.zzs = j6;
        this.zzcw = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcg, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzcm, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzco, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzr);
        SafeParcelWriter.writeLong(parcel, 7, this.zzcp);
        SafeParcelWriter.writeString(parcel, 8, this.zzdp, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzcq);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzdq);
        SafeParcelWriter.writeLong(parcel, 11, this.zzcn);
        SafeParcelWriter.writeString(parcel, 12, this.zzci, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzcr);
        SafeParcelWriter.writeLong(parcel, 14, this.zzdr);
        SafeParcelWriter.writeInt(parcel, 15, this.zzds);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzcs);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzct);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzdt);
        SafeParcelWriter.writeString(parcel, 19, this.zzcu, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzcv, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzs);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzcw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
