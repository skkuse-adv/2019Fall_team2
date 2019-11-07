package com.google.android.gms.internal.measurement;

public final class zzkh implements zzki {
    private static final zzcm<Boolean> zzarv;

    public final boolean zzze() {
        return ((Boolean) zzarv.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzarv = zzct.zzb("measurement.fetch_config_with_admob_app_id", true);
        zzct.zze("measurement.id.fetch_config_with_admob_app_id", 0);
    }
}
