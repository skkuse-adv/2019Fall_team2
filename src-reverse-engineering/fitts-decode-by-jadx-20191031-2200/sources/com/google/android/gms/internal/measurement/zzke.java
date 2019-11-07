package com.google.android.gms.internal.measurement;

public final class zzke implements zzdb<zzkd> {
    private static zzke zzars = new zzke();
    private final zzdb<zzkd> zzapj;

    public static boolean zzzd() {
        return ((zzkd) zzars.get()).zzzd();
    }

    private zzke(zzdb<zzkd> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzke() {
        this(zzda.zzg(new zzkg()));
    }

    public final /* synthetic */ Object get() {
        return (zzkd) this.zzapj.get();
    }
}
