package com.google.android.gms.internal.measurement;

public final class zzkr implements zzdb<zzku> {
    private static zzkr zzasc = new zzkr();
    private final zzdb<zzku> zzapj;

    public static boolean zzzj() {
        return ((zzku) zzasc.get()).zzzj();
    }

    public static boolean zzzk() {
        return ((zzku) zzasc.get()).zzzk();
    }

    public static boolean zzzl() {
        return ((zzku) zzasc.get()).zzzl();
    }

    private zzkr(zzdb<zzku> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzkr() {
        this(zzda.zzg(new zzkt()));
    }

    public final /* synthetic */ Object get() {
        return (zzku) this.zzapj.get();
    }
}
