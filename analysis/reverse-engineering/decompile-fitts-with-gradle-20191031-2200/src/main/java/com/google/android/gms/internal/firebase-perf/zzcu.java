package com.google.android.gms.internal.firebase-perf;

public enum zzcu implements zzer {
    SERVICE_WORKER_STATUS_UNKNOWN(0),
    UNSUPPORTED(1),
    CONTROLLED(2),
    UNCONTROLLED(3);
    
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzet zzdk() {
        return zzcw.zzjf;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzcu.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=");
        sb.append(this.value);
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    private zzcu(int i) {
        this.value = i;
    }

    static {
        new zzct();
    }
}
