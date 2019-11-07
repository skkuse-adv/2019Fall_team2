package com.google.android.gms.internal.measurement;

public final class zzja implements zzdb<zziz> {
    private static zzja zzapi = new zzja();
    private final zzdb<zziz> zzapj;

    public static boolean zzxg() {
        return ((zziz) zzapi.get()).zzxg();
    }

    private zzja(zzdb<zziz> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzja() {
        this(zzda.zzg(new zzjc()));
    }

    public final /* synthetic */ Object get() {
        return (zziz) this.zzapj.get();
    }
}
