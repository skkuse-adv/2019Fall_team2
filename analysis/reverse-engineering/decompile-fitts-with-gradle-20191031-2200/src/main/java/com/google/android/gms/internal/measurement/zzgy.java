package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface zzgy {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzgx<T> zzgx, zzel zzel) throws IOException;

    <T> void zza(List<T> list, zzgx<T> zzgx, zzel zzel) throws IOException;

    <K, V> void zza(Map<K, V> map, zzfz<K, V> zzfz, zzel zzel) throws IOException;

    @Deprecated
    <T> T zzb(zzgx<T> zzgx, zzel zzel) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzgx<T> zzgx, zzel zzel) throws IOException;

    void zze(List<Double> list) throws IOException;

    void zzf(List<Float> list) throws IOException;

    void zzg(List<Long> list) throws IOException;

    void zzh(List<Long> list) throws IOException;

    void zzi(List<Integer> list) throws IOException;

    void zzj(List<Long> list) throws IOException;

    void zzk(List<Integer> list) throws IOException;

    void zzl(List<Boolean> list) throws IOException;

    void zzm(List<String> list) throws IOException;

    void zzn(List<zzdp> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Integer> list) throws IOException;

    void zzq(List<Integer> list) throws IOException;

    void zzr(List<Long> list) throws IOException;

    void zzs(List<Integer> list) throws IOException;

    long zzsh() throws IOException;

    long zzsi() throws IOException;

    int zzsj() throws IOException;

    long zzsk() throws IOException;

    int zzsl() throws IOException;

    boolean zzsm() throws IOException;

    String zzsn() throws IOException;

    zzdp zzso() throws IOException;

    int zzsp() throws IOException;

    int zzsq() throws IOException;

    int zzsr() throws IOException;

    long zzss() throws IOException;

    int zzst() throws IOException;

    long zzsu() throws IOException;

    int zzsy() throws IOException;

    boolean zzsz() throws IOException;

    void zzt(List<Long> list) throws IOException;
}
