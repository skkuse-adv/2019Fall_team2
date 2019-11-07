package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;
import java.util.Map;

public final class zzbr extends zzep<zzbr, zzb> implements zzfz {
    private static volatile zzgh<zzbr> zzij;
    /* access modifiers changed from: private */
    public static final zzbr zziu;
    private int zzie;
    private String zzin;
    private String zzio;
    private zzbn zzip;
    private zzce zziq;
    private zzdf zzir;
    private int zzis;
    private zzfr<String, String> zzit = zzfr.zzib();

    static final class zza {
        static final zzfp<String, String> zziv;

        static {
            zzhu zzhu = zzhu.STRING;
            String str = "";
            zziv = zzfp.zza(zzhu, str, zzhu, str);
        }
    }

    public static final class zzb extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzbr, zzb> implements zzfz {
        private zzb() {
            super(zzbr.zziu);
        }

        public final zzb zzu(String str) {
            zzhe();
            ((zzbr) this.zzqn).zzs(str);
            return this;
        }

        public final boolean zzdb() {
            return ((zzbr) this.zzqn).zzdb();
        }

        public final zzb zzv(String str) {
            zzhe();
            ((zzbr) this.zzqn).zzt(str);
            return this;
        }

        public final zzb zzb(com.google.android.gms.internal.firebase-perf.zzbn.zza zza) {
            zzhe();
            ((zzbr) this.zzqn).zza(zza);
            return this;
        }

        public final zzb zzf(zzbt zzbt) {
            zzhe();
            ((zzbr) this.zzqn).zze(zzbt);
            return this;
        }

        public final zzb zzc(Map<String, String> map) {
            zzhe();
            ((zzbr) this.zzqn).zzdf().putAll(map);
            return this;
        }

        /* synthetic */ zzb(zzbq zzbq) {
            this();
        }
    }

    private zzbr() {
        String str = "";
        this.zzin = str;
        this.zzio = str;
    }

    public final boolean zzda() {
        return (this.zzie & 1) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzs(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzin = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzdb() {
        return (this.zzie & 2) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzt(String str) {
        if (str != null) {
            this.zzie |= 2;
            this.zzio = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzdc() {
        return (this.zzie & 4) != 0;
    }

    public final zzbn zzdd() {
        zzbn zzbn = this.zzip;
        return zzbn == null ? zzbn.zzcw() : zzbn;
    }

    /* access modifiers changed from: private */
    public final void zza(com.google.android.gms.internal.firebase-perf.zzbn.zza zza2) {
        this.zzip = (zzbn) zza2.zzhi();
        this.zzie |= 4;
    }

    public final boolean zzde() {
        return (this.zzie & 32) != 0;
    }

    /* access modifiers changed from: private */
    public final void zze(zzbt zzbt) {
        if (zzbt != null) {
            this.zzie |= 32;
            this.zzis = zzbt.zzdj();
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final Map<String, String> zzdf() {
        if (!this.zzit.isMutable()) {
            this.zzit = this.zzit.zzic();
        }
        return this.zzit;
    }

    public static zzb zzdg() {
        return (zzb) zziu.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbq.zzid[i - 1]) {
            case 1:
                return new zzbr();
            case 2:
                return new zzb(null);
            case 3:
                return zzep.zza((zzfx) zziu, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\t\u0002\u0004\t\u0003\u0005\f\u0005\u00062\u0007\t\u0004", new Object[]{"zzie", "zzin", "zzio", "zzip", "zziq", "zzis", zzbt.zzdk(), "zzit", zza.zziv, "zzir"});
            case 4:
                return zziu;
            case 5:
                zzgh<zzbr> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzbr.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zziu);
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

    public static zzbr zzdh() {
        return zziu;
    }

    static {
        zzbr zzbr = new zzbr();
        zziu = zzbr;
        zzep.zza(zzbr.class, zzbr);
    }
}
