package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface zzjg {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzjf<T> zzjf, zzgx zzgx) throws IOException;

    <T> void zza(List<T> list, zzjf<T> zzjf, zzgx zzgx) throws IOException;

    <K, V> void zza(Map<K, V> map, zzih<K, V> zzih, zzgx zzgx) throws IOException;

    @Deprecated
    <T> T zzb(zzjf<T> zzjf, zzgx zzgx) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzjf<T> zzjf, zzgx zzgx) throws IOException;

    void zzc(List<Double> list) throws IOException;

    void zzd(List<Float> list) throws IOException;

    void zze(List<Long> list) throws IOException;

    void zzf(List<Long> list) throws IOException;

    long zzfc() throws IOException;

    long zzfd() throws IOException;

    int zzfe() throws IOException;

    long zzff() throws IOException;

    int zzfg() throws IOException;

    boolean zzfh() throws IOException;

    String zzfi() throws IOException;

    zzfx zzfj() throws IOException;

    int zzfk() throws IOException;

    int zzfl() throws IOException;

    int zzfm() throws IOException;

    long zzfn() throws IOException;

    int zzfo() throws IOException;

    long zzfp() throws IOException;

    int zzfz() throws IOException;

    void zzg(List<Integer> list) throws IOException;

    boolean zzga() throws IOException;

    void zzh(List<Long> list) throws IOException;

    void zzi(List<Integer> list) throws IOException;

    void zzj(List<Boolean> list) throws IOException;

    void zzk(List<String> list) throws IOException;

    void zzl(List<zzfx> list) throws IOException;

    void zzm(List<Integer> list) throws IOException;

    void zzn(List<Integer> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Long> list) throws IOException;

    void zzq(List<Integer> list) throws IOException;

    void zzr(List<Long> list) throws IOException;
}
