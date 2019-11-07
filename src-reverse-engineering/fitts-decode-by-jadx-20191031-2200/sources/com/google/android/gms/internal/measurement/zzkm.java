package com.google.android.gms.internal.measurement;

public final class zzkm implements zzkj {
    private static final zzcm<Boolean> zzary;
    private static final zzcm<Boolean> zzarz;

    public final boolean zzzf() {
        return ((Boolean) zzary.get()).booleanValue();
    }

    public final boolean zzzg() {
        return ((Boolean) zzarz.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzary = zzct.zzb("measurement.collection.efficient_engagement_reporting_enabled", false);
        zzarz = zzct.zzb("measurement.collection.redundant_engagement_removal_enabled", false);
    }
}
