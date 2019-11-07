package com.google.android.gms.internal.firebase-perf;

public enum zzby implements zzer {
    EFFECTIVE_CONNECTION_TYPE_UNKNOWN(0),
    EFFECTIVE_CONNECTION_TYPE_SLOW_2G(1),
    EFFECTIVE_CONNECTION_TYPE_2G(2),
    EFFECTIVE_CONNECTION_TYPE_3G(3),
    EFFECTIVE_CONNECTION_TYPE_4G(4);
    
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzet zzdk() {
        return zzca.zzjf;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzby.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=");
        sb.append(this.value);
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    private zzby(int i) {
        this.value = i;
    }

    static {
        new zzbx();
    }
}
