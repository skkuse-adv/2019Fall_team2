package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzbz extends zzep<zzbz, zza> implements zzfz {
    private static volatile zzgh<zzbz> zzij;
    /* access modifiers changed from: private */
    public static final zzbz zzjs;
    private int zzie;
    private String zzjm = "";
    private int zzjn;
    private int zzjo;
    private int zzjp;
    private int zzjq;
    private int zzjr;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzbz, zza> implements zzfz {
        private zza() {
            super(zzbz.zzjs);
        }

        public final zza zzx(String str) {
            zzhe();
            ((zzbz) this.zzqn).zzw(str);
            return this;
        }

        public final zza zzi(int i) {
            zzhe();
            ((zzbz) this.zzqn).zzf(i);
            return this;
        }

        public final zza zzj(int i) {
            zzhe();
            ((zzbz) this.zzqn).zzg(i);
            return this;
        }

        public final zza zzk(int i) {
            zzhe();
            ((zzbz) this.zzqn).zzh(i);
            return this;
        }

        /* synthetic */ zza(zzcb zzcb) {
            this();
        }
    }

    private zzbz() {
    }

    /* access modifiers changed from: private */
    public final void zzw(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzjm = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzf(int i) {
        this.zzie |= 8;
        this.zzjp = i;
    }

    public final boolean zzdn() {
        return (this.zzie & 16) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzg(int i) {
        this.zzie |= 16;
        this.zzjq = i;
    }

    /* access modifiers changed from: private */
    public final void zzh(int i) {
        this.zzie |= 32;
        this.zzjr = i;
    }

    public static zza zzdo() {
        return (zza) zzjs.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcb.zzid[i - 1]) {
            case 1:
                return new zzbz();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzjs, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0005\u0006\u0004\u0002", new Object[]{"zzie", "zzjm", "zzjn", "zzjp", "zzjq", "zzjr", "zzjo"});
            case 4:
                return zzjs;
            case 5:
                zzgh<zzbz> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzbz.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzjs);
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

    public static zzbz zzdp() {
        return zzjs;
    }

    static {
        zzbz zzbz = new zzbz();
        zzjs = zzbz;
        zzep.zza(zzbz.class, zzbz);
    }
}
