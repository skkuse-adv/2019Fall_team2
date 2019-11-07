package com.google.android.gms.internal.measurement;

public final class zzlw implements zzlt {
    private static final zzcm<Boolean> zzate;
    private static final zzcm<Boolean> zzatf;
    private static final zzcm<Boolean> zzatg;
    private static final zzcm<Boolean> zzath;

    public final boolean zzzz() {
        return ((Boolean) zzate.get()).booleanValue();
    }

    public final boolean zzaaa() {
        return ((Boolean) zzatf.get()).booleanValue();
    }

    public final boolean zzaab() {
        return ((Boolean) zzatg.get()).booleanValue();
    }

    public final boolean zzaac() {
        return ((Boolean) zzath.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzate = zzct.zzb("measurement.service.audience.scoped_filters_v27", false);
        zzatf = zzct.zzb("measurement.service.audience.session_scoped_user_engagement", false);
        zzatg = zzct.zzb("measurement.service.audience.session_scoped_event_aggregates", false);
        zzath = zzct.zzb("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false);
    }
}
