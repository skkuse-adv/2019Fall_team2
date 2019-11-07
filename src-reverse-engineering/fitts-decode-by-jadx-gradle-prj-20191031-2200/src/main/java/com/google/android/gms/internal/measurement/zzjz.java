package com.google.android.gms.internal.measurement;

public final class zzjz implements zzdb<zzkc> {
    private static zzjz zzarm = new zzjz();
    private final zzdb<zzkc> zzapj;

    public static boolean zzza() {
        return ((zzkc) zzarm.get()).zzza();
    }

    public static boolean zzzb() {
        return ((zzkc) zzarm.get()).zzzb();
    }

    public static boolean zzzc() {
        return ((zzkc) zzarm.get()).zzzc();
    }

    private zzjz(zzdb<zzkc> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzjz() {
        this(zzda.zzg(new zzkb()));
    }

    public final /* synthetic */ Object get() {
        return (zzkc) this.zzapj.get();
    }
}
