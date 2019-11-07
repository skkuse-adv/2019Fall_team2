package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import com.google.android.gms.internal.measurement.zzey.zzd;

public final class zzbk$zzd extends zzey<zzbk$zzd, zza> implements zzgk {
    private static volatile zzgr<zzbk$zzd> zzuo;
    /* access modifiers changed from: private */
    public static final zzbk$zzd zzvj = new zzbk$zzd();
    private int zzue;
    private int zzuf;
    private boolean zzuk;
    private boolean zzul;
    private boolean zzum;
    private String zzvh = "";
    private zzbk$zzb zzvi;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbk$zzd, zza> implements zzgk {
        private zza() {
            super(zzbk$zzd.zzvj);
        }

        public final zza zzbw(String str) {
            zzuc();
            ((zzbk$zzd) this.zzahx).setPropertyName(str);
            return this;
        }

        /* synthetic */ zza(zzbj zzbj) {
            this();
        }
    }

    private zzbk$zzd() {
    }

    public final boolean zzkb() {
        return (this.zzue & 1) != 0;
    }

    public final int getId() {
        return this.zzuf;
    }

    public final String getPropertyName() {
        return this.zzvh;
    }

    /* access modifiers changed from: private */
    public final void setPropertyName(String str) {
        if (str != null) {
            this.zzue |= 2;
            this.zzvh = str;
            return;
        }
        throw new NullPointerException();
    }

    public final zzbk$zzb zzli() {
        zzbk$zzb zzbk_zzb = this.zzvi;
        return zzbk_zzb == null ? zzbk$zzb.zzks() : zzbk_zzb;
    }

    public final boolean zzkf() {
        return this.zzuk;
    }

    public final boolean zzkg() {
        return this.zzul;
    }

    public final boolean zzkh() {
        return (this.zzue & 32) != 0;
    }

    public final boolean zzki() {
        return this.zzum;
    }

    public static zzbk$zzd zzb(byte[] bArr, zzel zzel) throws zzfi {
        return (zzbk$zzd) zzey.zza(zzvj, bArr, zzel);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbj.zzud[i - 1]) {
            case 1:
                return new zzbk$zzd();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzvj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\t\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzue", "zzuf", "zzvh", "zzvi", "zzuk", "zzul", "zzum"});
            case 4:
                return zzvj;
            case 5:
                zzgr<zzbk$zzd> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbk$zzd.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzvj);
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

    public static zzgr<zzbk$zzd> zzkj() {
        return (zzgr) zzvj.zza(zzd.zzaij, null, null);
    }

    static {
        zzey.zza(zzbk$zzd.class, zzvj);
    }
}
