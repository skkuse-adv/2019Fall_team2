package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import com.google.android.gms.internal.measurement.zzey.zzd;

public final class zzbq$zza extends zzey<zzbq$zza, zza> implements zzgk {
    private static volatile zzgr<zzbq$zza> zzuo;
    /* access modifiers changed from: private */
    public static final zzbq$zza zzwa = new zzbq$zza();
    private int zzue;
    private String zzvy;
    private String zzvz;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbq$zza, zza> implements zzgk {
        private zza() {
            super(zzbq$zza.zzwa);
        }

        /* synthetic */ zza(zzbp zzbp) {
            this();
        }
    }

    private zzbq$zza() {
        String str = "";
        this.zzvy = str;
        this.zzvz = str;
    }

    public final String getKey() {
        return this.zzvy;
    }

    public final String getValue() {
        return this.zzvz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbp.zzud[i - 1]) {
            case 1:
                return new zzbq$zza();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzwa, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzue", "zzvy", "zzvz"});
            case 4:
                return zzwa;
            case 5:
                zzgr<zzbq$zza> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbq$zza.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzwa);
                            zzuo = zzgr;
                        }
                    }
                }
                return zzgr;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzgr<zzbq$zza> zzkj() {
        return (zzgr) zzwa.zza(zzd.zzaij, null, null);
    }

    static {
        zzey.zza(zzbq$zza.class, zzwa);
    }
}
