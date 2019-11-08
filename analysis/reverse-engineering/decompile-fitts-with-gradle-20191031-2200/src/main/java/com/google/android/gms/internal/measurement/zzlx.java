package com.google.android.gms.internal.measurement;

public final class zzlx implements zzly {
    private static final zzcm<Boolean> zzati;
    private static final zzcm<Boolean> zzatj;

    public final boolean zzaad() {
        return ((Boolean) zzati.get()).booleanValue();
    }

    public final boolean zzaae() {
        return ((Boolean) zzatj.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzati = zzct.zzb("measurement.audience.sequence_filters", false);
        zzatj = zzct.zzb("measurement.audience.sequence_filters_bundle_timestamp", false);
        zzct.zze("measurement.id.audience.sequence_filters", 0);
    }
}
