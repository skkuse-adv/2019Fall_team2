package com.google.android.gms.internal.firebase-perf;

public final class zzbb {
    private static final zzv<String, String> zzhw;
    private static final zzv<String, String> zzhx;

    public static String zzk(String str) {
        return (String) zzhw.getOrDefault(str, str);
    }

    public static String zzl(String str) {
        return (String) zzhx.getOrDefault(str, str);
    }

    static {
        String str = "sampling";
        String str2 = "trace_sampling_rate";
        String str3 = "network_sampling_rate";
        zzhw = new zzy().zzb(str2, str).zzb(str3, str).zzp();
        zzhx = new zzy().zzb("sessions_sampling_percentage", "fpr_vc_session_sampling_rate").zzb(str2, "fpr_vc_trace_sampling_rate").zzb(str3, "fpr_vc_network_request_sampling_rate").zzp();
    }
}
