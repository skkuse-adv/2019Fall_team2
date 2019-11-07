package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzch extends zzep<zzch, zza> implements zzfz {
    private static volatile zzgh<zzch> zzij;
    /* access modifiers changed from: private */
    public static final zzch zzkf;
    private int zzie;
    private long zzik;
    private int zzkd;
    private int zzke;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzch, zza> implements zzfz {
        private zza() {
            super(zzch.zzkf);
        }

        /* synthetic */ zza(zzcg zzcg) {
            this();
        }
    }

    private zzch() {
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcg.zzid[i - 1]) {
            case 1:
                return new zzch();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzkf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzie", "zzik", "zzkd", "zzke"});
            case 4:
                return zzkf;
            case 5:
                zzgh<zzch> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzch.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzkf);
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
        zzch zzch = new zzch();
        zzkf = zzch;
        zzep.zza(zzch.class, zzch);
    }
}
