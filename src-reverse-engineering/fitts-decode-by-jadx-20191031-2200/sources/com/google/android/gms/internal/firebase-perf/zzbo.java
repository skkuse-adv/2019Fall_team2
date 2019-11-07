package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzbo extends zzep<zzbo, zza> implements zzfz {
    private static volatile zzgh<zzbo> zzij;
    /* access modifiers changed from: private */
    public static final zzbo zzim;
    private int zzie;
    private long zzik;
    private int zzil;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzbo, zza> implements zzfz {
        private zza() {
            super(zzbo.zzim);
        }

        public final zza zzr(long j) {
            zzhe();
            ((zzbo) this.zzqn).zzq(j);
            return this;
        }

        public final zza zze(int i) {
            zzhe();
            ((zzbo) this.zzqn).zzd(i);
            return this;
        }

        /* synthetic */ zza(zzbp zzbp) {
            this();
        }
    }

    private zzbo() {
    }

    /* access modifiers changed from: private */
    public final void zzq(long j) {
        this.zzie |= 1;
        this.zzik = j;
    }

    /* access modifiers changed from: private */
    public final void zzd(int i) {
        this.zzie |= 2;
        this.zzil = i;
    }

    public static zza zzcy() {
        return (zza) zzim.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbp.zzid[i - 1]) {
            case 1:
                return new zzbo();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzim, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001", new Object[]{"zzie", "zzik", "zzil"});
            case 4:
                return zzim;
            case 5:
                zzgh<zzbo> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzbo.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzim);
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
        zzbo zzbo = new zzbo();
        zzim = zzbo;
        zzep.zza(zzbo.class, zzbo);
    }
}
