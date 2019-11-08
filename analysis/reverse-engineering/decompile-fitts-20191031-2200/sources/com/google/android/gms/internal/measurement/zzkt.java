package com.google.android.gms.internal.measurement;

public final class zzkt implements zzku {
    private static final zzcm<Boolean> zzase;
    private static final zzcm<Boolean> zzasf;
    private static final zzcm<Boolean> zzasg;

    public final boolean zzzj() {
        return ((Boolean) zzase.get()).booleanValue();
    }

    public final boolean zzzk() {
        return ((Boolean) zzasf.get()).booleanValue();
    }

    public final boolean zzzl() {
        return ((Boolean) zzasg.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzase = zzct.zzb("measurement.sdk.collection.last_deep_link_referrer", false);
        zzasf = zzct.zzb("measurement.sdk.collection.last_deep_link_referrer_campaign", false);
        zzasg = zzct.zzb("measurement.sdk.collection.last_gclid_from_referrer", false);
    }
}
