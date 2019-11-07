package com.google.android.gms.internal.measurement;

public final class zzjb implements zzdb<zzje> {
    private static zzjb zzapk = new zzjb();
    private final zzdb<zzje> zzapj;

    public static boolean zzxh() {
        return ((zzje) zzapk.get()).zzxh();
    }

    private zzjb(zzdb<zzje> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzjb() {
        this(zzda.zzg(new zzjd()));
    }

    public final /* synthetic */ Object get() {
        return (zzje) this.zzapj.get();
    }
}
