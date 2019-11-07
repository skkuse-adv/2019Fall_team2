package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface zzdx extends IInterface {
    List<zzjn> zza(zzn zzn, boolean z) throws RemoteException;

    List<zzq> zza(String str, String str2, zzn zzn) throws RemoteException;

    List<zzjn> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzjn> zza(String str, String str2, boolean z, zzn zzn) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(zzai zzai, zzn zzn) throws RemoteException;

    void zza(zzai zzai, String str, String str2) throws RemoteException;

    void zza(zzjn zzjn, zzn zzn) throws RemoteException;

    void zza(zzn zzn) throws RemoteException;

    void zza(zzq zzq, zzn zzn) throws RemoteException;

    byte[] zza(zzai zzai, String str) throws RemoteException;

    void zzb(zzn zzn) throws RemoteException;

    void zzb(zzq zzq) throws RemoteException;

    String zzc(zzn zzn) throws RemoteException;

    List<zzq> zzc(String str, String str2, String str3) throws RemoteException;

    void zzd(zzn zzn) throws RemoteException;
}
