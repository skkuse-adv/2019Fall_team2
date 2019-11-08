package com.google.android.gms.internal.measurement;

public final class zzlf implements zzlg {
    private static final zzcm<Boolean> zzasp;
    private static final zzcm<Double> zzasq;
    private static final zzcm<Long> zzasr;
    private static final zzcm<Long> zzass;
    private static final zzcm<String> zzast;

    public final boolean zzzq() {
        return ((Boolean) zzasp.get()).booleanValue();
    }

    public final double zzzr() {
        return ((Double) zzasq.get()).doubleValue();
    }

    public final long zzzs() {
        return ((Long) zzasr.get()).longValue();
    }

    public final long zzzt() {
        return ((Long) zzass.get()).longValue();
    }

    public final String zzzu() {
        return (String) zzast.get();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzasp = zzct.zzb("measurement.test.boolean_flag", false);
        zzasq = zzct.zza("measurement.test.double_flag", -3.0d);
        zzasr = zzct.zze("measurement.test.int_flag", -2);
        zzass = zzct.zze("measurement.test.long_flag", -1);
        zzast = zzct.zzt("measurement.test.string_flag", "---");
    }
}
