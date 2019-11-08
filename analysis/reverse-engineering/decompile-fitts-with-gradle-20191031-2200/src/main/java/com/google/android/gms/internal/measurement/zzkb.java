package com.google.android.gms.internal.measurement;

public final class zzkb implements zzkc {
    private static final zzcm<Boolean> zzaro;
    private static final zzcm<Boolean> zzarp;
    private static final zzcm<Boolean> zzarq;

    public final boolean zzza() {
        return ((Boolean) zzaro.get()).booleanValue();
    }

    public final boolean zzzb() {
        return ((Boolean) zzarp.get()).booleanValue();
    }

    public final boolean zzzc() {
        return ((Boolean) zzarq.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzaro = zzct.zzb("measurement.sdk.dynamite.allow_remote_dynamite", false);
        zzarp = zzct.zzb("measurement.collection.init_params_control_enabled", true);
        zzarq = zzct.zzb("measurement.sdk.dynamite.use_dynamite", false);
        zzct.zzb("measurement.sdk.dynamite.use_dynamite2", false);
        zzct.zze("measurement.id.sdk.dynamite.use_dynamite", 0);
    }
}
