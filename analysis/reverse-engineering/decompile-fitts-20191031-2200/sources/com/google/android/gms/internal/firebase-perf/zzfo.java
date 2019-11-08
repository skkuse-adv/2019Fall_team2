package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzd;

final class zzfo implements zzgn {
    private static final zzfy zzso = new zzfn();
    private final zzfy zzsn;

    public zzfo() {
        this(new zzfq(zzen.zzhd(), zzhz()));
    }

    private zzfo(zzfy zzfy) {
        zzes.zza(zzfy, "messageInfoFactory");
        this.zzsn = zzfy;
    }

    public final <T> zzgo<T> zzd(Class<T> cls) {
        Class<zzep> cls2 = zzep.class;
        zzgq.zzf(cls);
        zzfv zzb = this.zzsn.zzb(cls);
        if (zzb.zzif()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzge.zza(zzgq.zziz(), zzei.zzgx(), zzb.zzig());
            }
            return zzge.zza(zzgq.zzix(), zzei.zzgy(), zzb.zzig());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzgb.zza(cls, zzb, zzgi.zzim(), zzfh.zzhy(), zzgq.zziz(), zzei.zzgx(), zzfw.zzii());
            }
            return zzgb.zza(cls, zzb, zzgi.zzim(), zzfh.zzhy(), zzgq.zziz(), null, zzfw.zzii());
        } else if (zza(zzb)) {
            return zzgb.zza(cls, zzb, zzgi.zzil(), zzfh.zzhx(), zzgq.zzix(), zzei.zzgy(), zzfw.zzih());
        } else {
            return zzgb.zza(cls, zzb, zzgi.zzil(), zzfh.zzhx(), zzgq.zziy(), null, zzfw.zzih());
        }
    }

    private static boolean zza(zzfv zzfv) {
        return zzfv.zzie() == zzd.zzrd;
    }

    private static zzfy zzhz() {
        try {
            return (zzfy) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzso;
        }
    }
}
