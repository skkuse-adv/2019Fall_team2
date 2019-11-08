package com.google.android.gms.internal.measurement;

public final class zzjy implements zzdb<zzjx> {
    private static zzjy zzarl = new zzjy();
    private final zzdb<zzjx> zzapj;

    public static boolean zzyz() {
        return ((zzjx) zzarl.get()).zzyz();
    }

    private zzjy(zzdb<zzjx> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzjy() {
        this(zzda.zzg(new zzka()));
    }

    public final /* synthetic */ Object get() {
        return (zzjx) this.zzapj.get();
    }
}
