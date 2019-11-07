package com.google.android.gms.internal.firebase-perf;

public enum zzdb implements zzer {
    VISIBILITY_STATE_UNKNOWN(0),
    VISIBLE(1),
    HIDDEN(2),
    PRERENDER(3),
    UNLOADED(4);
    
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzet zzdk() {
        return zzdc.zzjf;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzdb.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=");
        sb.append(this.value);
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    private zzdb(int i) {
        this.value = i;
    }

    static {
        new zzdd();
    }
}
