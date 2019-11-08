package com.google.android.gms.internal.firebase-perf;

public enum zzcv implements zzer {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);
    
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzcv zzo(int i) {
        if (i == 0) {
            return SESSION_VERBOSITY_NONE;
        }
        if (i != 1) {
            return null;
        }
        return GAUGES_AND_SYSTEM_EVENTS;
    }

    public static zzet zzdk() {
        return zzcx.zzjf;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzcv.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=");
        sb.append(this.value);
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    private zzcv(int i) {
        this.value = i;
    }

    static {
        new zzcy();
    }
}
