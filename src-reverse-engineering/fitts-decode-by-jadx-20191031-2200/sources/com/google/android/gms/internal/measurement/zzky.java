package com.google.android.gms.internal.measurement;

public final class zzky implements zzkv {
    private static final zzcm<Boolean> zzasj;
    private static final zzcm<Boolean> zzask;

    public final boolean zzzm() {
        return ((Boolean) zzasj.get()).booleanValue();
    }

    public final boolean zzzn() {
        return ((Boolean) zzask.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzasj = zzct.zzb("measurement.personalized_ads_signals_collection_enabled", true);
        zzask = zzct.zzb("measurement.personalized_ads_property_translation_enabled", true);
    }
}
