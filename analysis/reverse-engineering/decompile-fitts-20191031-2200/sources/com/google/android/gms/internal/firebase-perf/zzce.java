package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzce extends zzep<zzce, zza> implements zzfz {
    private static volatile zzgh<zzce> zzij;
    /* access modifiers changed from: private */
    public static final zzce zzkc;
    private int zzie;
    private String zzig;
    private String zzjz;
    private String zzka;
    private zzhz$zza zzkb;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzce, zza> implements zzfz {
        private zza() {
            super(zzce.zzkc);
        }

        /* synthetic */ zza(zzcf zzcf) {
            this();
        }
    }

    private zzce() {
        String str = "";
        this.zzig = str;
        this.zzjz = str;
        this.zzka = str;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcf.zzid[i - 1]) {
            case 1:
                return new zzce();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzkc, "\u0001\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\t\u0003", new Object[]{"zzie", "zzig", "zzjz", "zzka", "zzkb"});
            case 4:
                return zzkc;
            case 5:
                zzgh<zzce> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzce.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzkc);
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
        zzce zzce = new zzce();
        zzkc = zzce;
        zzep.zza(zzce.class, zzce);
    }
}
