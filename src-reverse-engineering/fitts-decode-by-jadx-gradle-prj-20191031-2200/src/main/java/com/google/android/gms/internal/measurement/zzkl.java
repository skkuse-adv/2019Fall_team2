package com.google.android.gms.internal.measurement;

public final class zzkl implements zzdb<zzko> {
    private static zzkl zzarx = new zzkl();
    private final zzdb<zzko> zzapj;

    public static boolean zzzh() {
        return ((zzko) zzarx.get()).zzzh();
    }

    private zzkl(zzdb<zzko> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzkl() {
        this(zzda.zzg(new zzkn()));
    }

    public final /* synthetic */ Object get() {
        return (zzko) this.zzapj.get();
    }
}
