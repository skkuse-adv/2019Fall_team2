package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzc extends AbstractSafeParcelable {
    public static final Creator<zzc> CREATOR = new zzd();
    private final boolean zzad;
    private final long zzae;
    private final long zzaf;

    public zzc(boolean z, long j, long j2) {
        this.zzad = z;
        this.zzae = j;
        this.zzaf = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzc = (zzc) obj;
            return this.zzad == zzc.zzad && this.zzae == zzc.zzae && this.zzaf == zzc.zzaf;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zzad), Long.valueOf(this.zzae), Long.valueOf(this.zzaf));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CollectForDebugParcelable[skipPersistentStorage: ");
        sb.append(this.zzad);
        sb.append(",collectForDebugStartTimeMillis: ");
        sb.append(this.zzae);
        sb.append(",collectForDebugExpiryTimeMillis: ");
        sb.append(this.zzaf);
        sb.append("]");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzad);
        SafeParcelWriter.writeLong(parcel, 2, this.zzaf);
        SafeParcelWriter.writeLong(parcel, 3, this.zzae);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
