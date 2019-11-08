package com.google.android.gms.internal.measurement;

public final class zzkx implements zzdb<zzla> {
    private static zzkx zzasi = new zzkx();
    private final zzdb<zzla> zzapj;

    public static boolean zzzo() {
        return ((zzla) zzasi.get()).zzzo();
    }

    private zzkx(zzdb<zzla> zzdb) {
        this.zzapj = zzda.zza(zzdb);
    }

    public zzkx() {
        this(zzda.zzg(new zzkz()));
    }

    public final /* synthetic */ Object get() {
        return (zzla) this.zzapj.get();
    }
}
