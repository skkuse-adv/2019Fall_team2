package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzdf extends zzep<zzdf, zza> implements zzfz {
    private static volatile zzgh<zzdf> zzij;
    /* access modifiers changed from: private */
    public static final zzdf zzmn;
    private int zzie;
    private String zzig;
    private String zzmj;
    private int zzmk;
    private int zzml;
    private int zzmm;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzdf, zza> implements zzfz {
        private zza() {
            super(zzdf.zzmn);
        }

        /* synthetic */ zza(zzde zzde) {
            this();
        }
    }

    private zzdf() {
        String str = "";
        this.zzig = str;
        this.zzmj = str;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzde.zzid[i - 1]) {
            case 1:
                return new zzdf();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzmn, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\f\u0002\u0004\f\u0003\u0005\f\u0004", new Object[]{"zzie", "zzig", "zzmj", "zzmk", zzcu.zzdk(), "zzml", zzdb.zzdk(), "zzmm", zzby.zzdk()});
            case 4:
                return zzmn;
            case 5:
                zzgh<zzdf> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzdf.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzmn);
                            zzij = zzgh;
                        }
                    }
                }
                return zzgh;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzdf zzdf = new zzdf();
        zzmn = zzdf;
        zzep.zza(zzdf.class, zzdf);
    }
}
