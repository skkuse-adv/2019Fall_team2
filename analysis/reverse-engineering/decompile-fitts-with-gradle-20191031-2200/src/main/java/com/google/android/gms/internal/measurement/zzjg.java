package com.google.android.gms.internal.measurement;

public final class zzjg implements zzdb<zzjf> {
    private static zzjg zzapn = new zzjg();
    private final zzdb<zzjf> zzapj;

    public static boolean zzxi() {
        return ((zzjf) zzapn.get()).zzxi();
    }

    private zzjg(zzdb<zzjf> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzjg() {
        this(zzda.zzg(new zzji()));
    }

    public final /* synthetic */ Object get() {
        return (zzjf) this.zzapj.get();
    }
}
