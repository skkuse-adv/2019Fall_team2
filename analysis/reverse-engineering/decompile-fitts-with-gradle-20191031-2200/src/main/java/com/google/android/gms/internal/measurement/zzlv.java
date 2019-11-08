package com.google.android.gms.internal.measurement;

public final class zzlv implements zzdb<zzly> {
    private static zzlv zzatd = new zzlv();
    private final zzdb<zzly> zzapj;

    public static boolean zzaad() {
        return ((zzly) zzatd.get()).zzaad();
    }

    public static boolean zzaae() {
        return ((zzly) zzatd.get()).zzaae();
    }

    private zzlv(zzdb<zzly> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzlv() {
        this(zzda.zzg(new zzlx()));
    }

    public final /* synthetic */ Object get() {
        return (zzly) this.zzapj.get();
    }
}
