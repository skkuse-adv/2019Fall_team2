package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzbr.zzb;
import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzcn extends zzep<zzcn, zza> implements zzfz {
    private static volatile zzgh<zzcn> zzij;
    /* access modifiers changed from: private */
    public static final zzcn zzll;
    private int zzie;
    private zzbr zzlh;
    private zzda zzli;
    private zzci zzlj;
    private zzcd zzlk;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzcn, zza> implements zzfz {
        private zza() {
            super(zzcn.zzll);
        }

        public final zza zzb(zzb zzb) {
            zzhe();
            ((zzcn) this.zzqn).zza(zzb);
            return this;
        }

        public final zza zzb(zzda zzda) {
            zzhe();
            ((zzcn) this.zzqn).zza(zzda);
            return this;
        }

        public final zza zze(zzci zzci) {
            zzhe();
            ((zzcn) this.zzqn).zzd(zzci);
            return this;
        }

        public final zza zzb(zzcd zzcd) {
            zzhe();
            ((zzcn) this.zzqn).zza(zzcd);
            return this;
        }

        /* synthetic */ zza(zzcp zzcp) {
            this();
        }
    }

    private zzcn() {
    }

    public final boolean zzfa() {
        return (this.zzie & 1) != 0;
    }

    public final zzbr zzfb() {
        zzbr zzbr = this.zzlh;
        return zzbr == null ? zzbr.zzdh() : zzbr;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb) {
        this.zzlh = (zzbr) zzb.zzhi();
        this.zzie |= 1;
    }

    public final boolean zzfc() {
        return (this.zzie & 2) != 0;
    }

    public final zzda zzfd() {
        zzda zzda = this.zzli;
        return zzda == null ? zzda.zzfv() : zzda;
    }

    /* access modifiers changed from: private */
    public final void zza(zzda zzda) {
        if (zzda != null) {
            this.zzli = zzda;
            this.zzie |= 2;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzfe() {
        return (this.zzie & 4) != 0;
    }

    public final zzci zzff() {
        zzci zzci = this.zzlj;
        return zzci == null ? zzci.zzev() : zzci;
    }

    /* access modifiers changed from: private */
    public final void zzd(zzci zzci) {
        if (zzci != null) {
            this.zzlj = zzci;
            this.zzie |= 4;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzfg() {
        return (this.zzie & 8) != 0;
    }

    public final zzcd zzfh() {
        zzcd zzcd = this.zzlk;
        return zzcd == null ? zzcd.zzdy() : zzcd;
    }

    /* access modifiers changed from: private */
    public final void zza(zzcd zzcd) {
        if (zzcd != null) {
            this.zzlk = zzcd;
            this.zzie |= 8;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzfi() {
        return (zza) zzll.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcp.zzid[i - 1]) {
            case 1:
                return new zzcn();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzll, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003", new Object[]{"zzie", "zzlh", "zzli", "zzlj", "zzlk"});
            case 4:
                return zzll;
            case 5:
                zzgh<zzcn> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzcn.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzll);
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
        zzcn zzcn = new zzcn();
        zzll = zzcn;
        zzep.zza(zzcn.class, zzcn);
    }
}
