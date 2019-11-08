package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zze;

final class zzid implements zzji {
    private static final zzin zzve = new zzig();
    private final zzin zzvd;

    public zzid() {
        this(new zzif(zzhj.zzgx(), zzhu()));
    }

    private zzid(zzin zzin) {
        zzhm.zza(zzin, "messageInfoFactory");
        this.zzvd = zzin;
    }

    public final <T> zzjf<T> zzj(Class<T> cls) {
        Class<zzhi> cls2 = zzhi.class;
        zzjh.zzl(cls);
        zzio zzi = this.zzvd.zzi(cls);
        if (zzi.zzic()) {
            if (cls2.isAssignableFrom(cls)) {
                return zziw.zza(zzjh.zzio(), zzhb.zzgl(), zzi.zzid());
            }
            return zziw.zza(zzjh.zzim(), zzhb.zzgm(), zzi.zzid());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zza(zzi)) {
                return zziu.zza(cls, zzi, zzja.zzig(), zzia.zzht(), zzjh.zzio(), zzhb.zzgl(), zzil.zzhz());
            }
            return zziu.zza(cls, zzi, zzja.zzig(), zzia.zzht(), zzjh.zzio(), null, zzil.zzhz());
        } else if (zza(zzi)) {
            return zziu.zza(cls, zzi, zzja.zzif(), zzia.zzhs(), zzjh.zzim(), zzhb.zzgm(), zzil.zzhy());
        } else {
            return zziu.zza(cls, zzi, zzja.zzif(), zzia.zzhs(), zzjh.zzin(), null, zzil.zzhy());
        }
    }

    private static boolean zza(zzio zzio) {
        return zzio.zzib() == zze.zztu;
    }

    private static zzin zzhu() {
        try {
            return (zzin) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzve;
        }
    }
}
