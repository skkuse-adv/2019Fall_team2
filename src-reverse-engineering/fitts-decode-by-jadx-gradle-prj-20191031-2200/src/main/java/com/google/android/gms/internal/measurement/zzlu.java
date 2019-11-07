package com.google.android.gms.internal.measurement;

public final class zzlu implements zzdb<zzlt> {
    private static zzlu zzatc = new zzlu();
    private final zzdb<zzlt> zzapj;

    public static boolean zzzz() {
        return ((zzlt) zzatc.get()).zzzz();
    }

    public static boolean zzaaa() {
        return ((zzlt) zzatc.get()).zzaaa();
    }

    public static boolean zzaab() {
        return ((zzlt) zzatc.get()).zzaab();
    }

    public static boolean zzaac() {
        return ((zzlt) zzatc.get()).zzaac();
    }

    private zzlu(zzdb<zzlt> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzlu() {
        this(zzda.zzg(new zzlw()));
    }

    public final /* synthetic */ Object get() {
        return (zzlt) this.zzapj.get();
    }
}
