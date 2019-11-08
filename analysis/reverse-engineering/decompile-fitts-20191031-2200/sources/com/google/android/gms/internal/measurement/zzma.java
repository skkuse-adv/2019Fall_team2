package com.google.android.gms.internal.measurement;

public final class zzma implements zzdb<zzlz> {
    private static zzma zzatk = new zzma();
    private final zzdb<zzlz> zzapj;

    public static boolean zzaaf() {
        return ((zzlz) zzatk.get()).zzaaf();
    }

    public static boolean zzaag() {
        return ((zzlz) zzatk.get()).zzaag();
    }

    public static boolean zzaah() {
        return ((zzlz) zzatk.get()).zzaah();
    }

    private zzma(zzdb<zzlz> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzma() {
        this(zzda.zzg(new zzmc()));
    }

    public final /* synthetic */ Object get() {
        return (zzlz) this.zzapj.get();
    }
}
