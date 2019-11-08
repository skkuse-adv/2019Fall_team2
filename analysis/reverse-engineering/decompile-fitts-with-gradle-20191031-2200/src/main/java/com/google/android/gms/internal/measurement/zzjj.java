package com.google.android.gms.internal.measurement;

public final class zzjj implements zzjk {
    private static final zzcm<Boolean> zzapq;
    private static final zzcm<Boolean> zzapr;
    private static final zzcm<Boolean> zzaps;

    public final boolean zzxj() {
        return ((Boolean) zzapq.get()).booleanValue();
    }

    public final boolean zzxk() {
        return ((Boolean) zzapr.get()).booleanValue();
    }

    public final boolean zzxl() {
        return ((Boolean) zzaps.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzapq = zzct.zzb("measurement.log_installs_enabled", false);
        zzapr = zzct.zzb("measurement.log_third_party_store_events_enabled", false);
        zzaps = zzct.zzb("measurement.log_upgrades_enabled", false);
    }
}
