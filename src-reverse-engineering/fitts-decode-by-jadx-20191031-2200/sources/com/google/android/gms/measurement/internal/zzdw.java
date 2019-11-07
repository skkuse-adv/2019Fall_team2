package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzd;
import java.util.List;

public abstract class zzdw extends zza implements zzdx {
    public zzdw() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzai) zzd.zza(parcel, zzai.CREATOR), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                zza((zzjn) zzd.zza(parcel, zzjn.CREATOR), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                zza((zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                zza((zzai) zzd.zza(parcel, zzai.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                zzb((zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                List zza = zza((zzn) zzd.zza(parcel, zzn.CREATOR), zzd.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 9:
                byte[] zza2 = zza((zzai) zzd.zza(parcel, zzai.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                break;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                String zzc = zzc((zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                break;
            case 12:
                zza((zzq) zzd.zza(parcel, zzq.CREATOR), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzb((zzq) zzd.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                List zza3 = zza(parcel.readString(), parcel.readString(), zzd.zza(parcel), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                break;
            case 15:
                List zza4 = zza(parcel.readString(), parcel.readString(), parcel.readString(), zzd.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                break;
            case 16:
                List zza5 = zza(parcel.readString(), parcel.readString(), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                break;
            case 17:
                List zzc2 = zzc(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zzc2);
                break;
            case 18:
                zzd((zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
