package com.google.android.gms.internal.measurement;

public final class zzlc implements zzdb<zzlb> {
    private static zzlc zzasm = new zzlc();
    private final zzdb<zzlb> zzapj;

    public static boolean zzzp() {
        return ((zzlb) zzasm.get()).zzzp();
    }

    private zzlc(zzdb<zzlb> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzlc() {
        this(zzda.zzg(new zzle()));
    }

    public final /* synthetic */ Object get() {
        return (zzlb) this.zzapj.get();
    }
}
