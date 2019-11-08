package com.google.android.gms.internal.clearcut;

public enum zzge$zzv$zzb implements zzcj {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4);
    
    private static final zzck<zzge$zzv$zzb> zzbq = null;
    private final int value;

    static {
        zzbq = new zzgr();
    }

    private zzge$zzv$zzb(int i) {
        this.value = i;
    }

    public static zzge$zzv$zzb zzbc(int i) {
        if (i == 0) {
            return DEFAULT;
        }
        if (i == 1) {
            return UNMETERED_ONLY;
        }
        if (i == 2) {
            return UNMETERED_OR_DAILY;
        }
        if (i == 3) {
            return FAST_IF_RADIO_AWAKE;
        }
        if (i != 4) {
            return null;
        }
        return NEVER;
    }

    public static zzck<zzge$zzv$zzb> zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}
