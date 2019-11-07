package com.google.android.gms.internal.measurement;

public final class zzjo implements zzjl {
    private static final zzcm<Boolean> zzapv;

    public final boolean zzxm() {
        return ((Boolean) zzapv.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzapv = zzct.zzb("measurement.app_launch.event_ordering_fix", false);
        zzct.zze("measurement.id.app_launch.event_ordering_fix", 0);
    }
}
