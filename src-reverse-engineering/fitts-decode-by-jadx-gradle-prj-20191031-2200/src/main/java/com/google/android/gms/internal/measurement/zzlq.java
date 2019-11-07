package com.google.android.gms.internal.measurement;

public final class zzlq implements zzln {
    private static final zzcm<Boolean> zzata;

    public final boolean zzzx() {
        return ((Boolean) zzata.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzata = zzct.zzb("measurement.reset_analytics.persist_time", false);
        zzct.zze("measurement.id.reset_analytics.persist_time", 0);
    }
}
