package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.firebase-perf.zzax;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.android.gms.internal.firebase-perf.zzcr;
import com.google.android.gms.internal.firebase-perf.zzcr.zza;
import com.google.android.gms.internal.firebase-perf.zzcv;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class zzq implements Parcelable {
    public static final Creator<zzq> CREATOR = new zzt();
    private String zzec;
    private boolean zzed;
    private zzbg zzee;

    public static zzq zzbm() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("\\-", "");
        zzq zzq = new zzq(replaceAll, new zzax());
        zzq.zzed = zza(FeatureControl.zzao().zzap(), FeatureControl.zzao().zzas());
        Object[] objArr = new Object[2];
        objArr[0] = zzq.zzed ? "Verbose" : "Non Verbose";
        objArr[1] = replaceAll;
        String.format("Creating a new %s Session: %s", objArr);
        return zzq;
    }

    public int describeContents() {
        return 0;
    }

    @VisibleForTesting
    private zzq(String str, zzax zzax) {
        this.zzed = false;
        this.zzec = str;
        this.zzee = new zzbg();
    }

    public final String zzbn() {
        return this.zzec;
    }

    public final boolean zzbo() {
        return this.zzed;
    }

    public final boolean isExpired() {
        return TimeUnit.MICROSECONDS.toMinutes(this.zzee.zzcs()) > FeatureControl.zzao().zzax();
    }

    public final zzcr zzbp() {
        zza zzac = zzcr.zzfl().zzac(this.zzec);
        if (this.zzed) {
            zzac.zzb(zzcv.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (zzcr) zzac.zzhi();
    }

    @Nullable
    public static zzcr[] zza(@NonNull List<zzq> list) {
        if (list.isEmpty()) {
            return null;
        }
        zzcr[] zzcrArr = new zzcr[list.size()];
        zzcr zzbp = ((zzq) list.get(0)).zzbp();
        boolean z = false;
        for (int i = 1; i < list.size(); i++) {
            zzcr zzbp2 = ((zzq) list.get(i)).zzbp();
            if (z || !((zzq) list.get(i)).zzed) {
                zzcrArr[i] = zzbp2;
            } else {
                zzcrArr[0] = zzbp2;
                zzcrArr[i] = zzbp;
                z = true;
            }
        }
        if (!z) {
            zzcrArr[0] = zzbp;
        }
        return zzcrArr;
    }

    private static boolean zza(boolean z, float f) {
        return z && Math.random() * 100.0d < ((double) f);
    }

    public static boolean zzbq() {
        return zza(true, 1.0f);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.zzec);
        parcel.writeByte(this.zzed ? (byte) 1 : 0);
        parcel.writeParcelable(this.zzee, 0);
    }

    private zzq(@NonNull Parcel parcel) {
        boolean z = false;
        this.zzed = false;
        this.zzec = parcel.readString();
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.zzed = z;
        this.zzee = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
    }

    /* synthetic */ zzq(Parcel parcel, zzt zzt) {
        this(parcel);
    }
}
