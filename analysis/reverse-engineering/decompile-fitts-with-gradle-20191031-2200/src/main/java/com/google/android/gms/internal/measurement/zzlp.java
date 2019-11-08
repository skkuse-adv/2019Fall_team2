package com.google.android.gms.internal.measurement;

public final class zzlp implements zzdb<zzls> {
    private static zzlp zzasz = new zzlp();
    private final zzdb<zzls> zzapj;

    public static boolean zzzy() {
        return ((zzls) zzasz.get()).zzzy();
    }

    private zzlp(zzdb<zzls> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzlp() {
        this(zzda.zzg(new zzlr()));
    }

    public final /* synthetic */ Object get() {
        return (zzls) this.zzapj.get();
    }
}
