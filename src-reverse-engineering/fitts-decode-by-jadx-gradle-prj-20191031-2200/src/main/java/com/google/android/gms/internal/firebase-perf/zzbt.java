package com.google.android.gms.internal.firebase-perf;

public enum zzbt implements zzer {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzet zzdk() {
        return zzbv.zzjf;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzbt.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=");
        sb.append(this.value);
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    private zzbt(int i) {
        this.value = i;
    }

    static {
        new zzbs();
    }
}
