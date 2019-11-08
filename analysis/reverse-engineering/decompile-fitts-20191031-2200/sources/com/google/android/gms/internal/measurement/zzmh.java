package com.google.android.gms.internal.measurement;

public final class zzmh implements zzdb<zzmk> {
    private static zzmh zzatv = new zzmh();
    private final zzdb<zzmk> zzapj;

    public static boolean zzaan() {
        return ((zzmk) zzatv.get()).zzaan();
    }

    private zzmh(zzdb<zzmk> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzmh() {
        this(zzda.zzg(new zzmj()));
    }

    public final /* synthetic */ Object get() {
        return (zzmk) this.zzapj.get();
    }
}
