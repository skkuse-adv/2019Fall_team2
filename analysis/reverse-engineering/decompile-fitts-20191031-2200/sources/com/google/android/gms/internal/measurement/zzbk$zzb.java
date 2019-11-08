package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;

public final class zzbk$zzb extends zzey<zzbk$zzb, zza> implements zzgk {
    private static volatile zzgr<zzbk$zzb> zzuo;
    /* access modifiers changed from: private */
    public static final zzbk$zzb zzut = new zzbk$zzb();
    private int zzue;
    private zzbk$zze zzup;
    private zzbk$zzc zzuq;
    private boolean zzur;
    private String zzus = "";

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbk$zzb, zza> implements zzgk {
        private zza() {
            super(zzbk$zzb.zzut);
        }

        public final zza zzbu(String str) {
            zzuc();
            ((zzbk$zzb) this.zzahx).zzbv(str);
            return this;
        }

        /* synthetic */ zza(zzbj zzbj) {
            this();
        }
    }

    private zzbk$zzb() {
    }

    public final boolean zzkl() {
        return (this.zzue & 1) != 0;
    }

    public final zzbk$zze zzkm() {
        zzbk$zze zzbk_zze = this.zzup;
        return zzbk_zze == null ? zzbk$zze.zzls() : zzbk_zze;
    }

    public final boolean zzkn() {
        return (this.zzue & 2) != 0;
    }

    public final zzbk$zzc zzko() {
        zzbk$zzc zzbk_zzc = this.zzuq;
        return zzbk_zzc == null ? zzbk$zzc.zzle() : zzbk_zzc;
    }

    public final boolean zzkp() {
        return (this.zzue & 4) != 0;
    }

    public final boolean zzkq() {
        return this.zzur;
    }

    public final String zzkr() {
        return this.zzus;
    }

    /* access modifiers changed from: private */
    public final void zzbv(String str) {
        if (str != null) {
            this.zzue |= 8;
            this.zzus = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbj.zzud[i - 1]) {
            case 1:
                return new zzbk$zzb();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzut, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u0007\u0002\u0004\b\u0003", new Object[]{"zzue", "zzup", "zzuq", "zzur", "zzus"});
            case 4:
                return zzut;
            case 5:
                zzgr<zzbk$zzb> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbk$zzb.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzut);
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

    public static zzbk$zzb zzks() {
        return zzut;
    }

    static {
        zzey.zza(zzbk$zzb.class, zzut);
    }
}
