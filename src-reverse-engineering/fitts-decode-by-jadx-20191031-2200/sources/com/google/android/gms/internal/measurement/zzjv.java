package com.google.android.gms.internal.measurement;

public final class zzjv implements zzjw {
    private static final zzcm<Boolean> zzark;

    public final boolean zzyy() {
        return ((Boolean) zzark.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzark = zzct.zzb("measurement.upload_dsid_enabled", false);
        zzct.zze("measurement.id.upload_dsid_enabled", 0);
    }
}
