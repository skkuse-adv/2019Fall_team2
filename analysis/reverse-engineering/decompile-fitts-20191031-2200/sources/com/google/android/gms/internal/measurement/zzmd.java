package com.google.android.gms.internal.measurement;

public final class zzmd implements zzme {
    private static final zzcm<Boolean> zzatp;
    private static final zzcm<Boolean> zzatq;
    private static final zzcm<Boolean> zzats;
    private static final zzcm<Boolean> zzatt;

    public final boolean zzaai() {
        return ((Boolean) zzatp.get()).booleanValue();
    }

    public final boolean zzaaj() {
        return ((Boolean) zzatq.get()).booleanValue();
    }

    public final boolean zzaak() {
        return ((Boolean) zzats.get()).booleanValue();
    }

    public final boolean zzaal() {
        return ((Boolean) zzatt.get()).booleanValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzatp = zzct.zzb("measurement.client.sessions.background_sessions_enabled", true);
        zzatq = zzct.zzb("measurement.client.sessions.immediate_start_enabled_foreground", false);
        zzct.zzb("measurement.client.sessions.immediate_start_enabled", false);
        zzats = zzct.zzb("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zzatt = zzct.zzb("measurement.client.sessions.session_id_enabled", true);
        zzct.zze("measurement.id.sessionization_client", 0);
    }
}
