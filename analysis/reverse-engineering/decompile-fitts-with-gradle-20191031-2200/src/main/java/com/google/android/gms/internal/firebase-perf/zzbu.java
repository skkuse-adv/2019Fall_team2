package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzbu extends zzep<zzbu, zza> implements zzfz {
    private static volatile zzgh<zzbu> zzij;
    /* access modifiers changed from: private */
    public static final zzbu zzje;
    private int zzie;
    private long zzik;
    private long zzjc;
    private long zzjd;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzbu, zza> implements zzfz {
        private zza() {
            super(zzbu.zzje);
        }

        public final zza zzu(long j) {
            zzhe();
            ((zzbu) this.zzqn).zzq(j);
            return this;
        }

        public final zza zzv(long j) {
            zzhe();
            ((zzbu) this.zzqn).zzs(j);
            return this;
        }

        public final zza zzw(long j) {
            zzhe();
            ((zzbu) this.zzqn).zzt(j);
            return this;
        }

        /* synthetic */ zza(zzbw zzbw) {
            this();
        }
    }

    private zzbu() {
    }

    /* access modifiers changed from: private */
    public final void zzq(long j) {
        this.zzie |= 1;
        this.zzik = j;
    }

    /* access modifiers changed from: private */
    public final void zzs(long j) {
        this.zzie |= 2;
        this.zzjc = j;
    }

    /* access modifiers changed from: private */
    public final void zzt(long j) {
        this.zzie |= 4;
        this.zzjd = j;
    }

    public static zza zzdl() {
        return (zza) zzje.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbw.zzid[i - 1]) {
            case 1:
                return new zzbu();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzje, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002", new Object[]{"zzie", "zzik", "zzjc", "zzjd"});
            case 4:
                return zzje;
            case 5:
                zzgh<zzbu> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzbu.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzje);
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
        zzbu zzbu = new zzbu();
        zzje = zzbu;
        zzep.zza(zzbu.class, zzbu);
    }
}
