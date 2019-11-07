package com.google.android.gms.internal.measurement;

public final class zzji implements zzjf {
    private static final zzcm<Boolean> zzapp = new zzct(zzcn.zzdh("com.google.android.gms.measurement")).zzb("measurement.module.collection.conditionally_omit_admob_app_id", true);

    public final boolean zzxi() {
        return ((Boolean) zzapp.get()).booleanValue();
    }
}
