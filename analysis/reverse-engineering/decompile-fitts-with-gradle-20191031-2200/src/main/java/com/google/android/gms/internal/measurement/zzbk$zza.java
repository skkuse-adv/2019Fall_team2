package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import com.google.android.gms.internal.measurement.zzey.zzd;
import java.util.List;

public final class zzbk$zza extends zzey<zzbk$zza, zza> implements zzgk {
    /* access modifiers changed from: private */
    public static final zzbk$zza zzun = new zzbk$zza();
    private static volatile zzgr<zzbk$zza> zzuo;
    private int zzue;
    private int zzuf;
    private String zzug = "";
    private zzff<zzbk$zzb> zzuh = zzey.zzun();
    private boolean zzui;
    private zzbk$zzc zzuj;
    private boolean zzuk;
    private boolean zzul;
    private boolean zzum;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbk$zza, zza> implements zzgk {
        private zza() {
            super(zzbk$zza.zzun);
        }

        public final String zzjz() {
            return ((zzbk$zza) this.zzahx).zzjz();
        }

        public final zza zzbs(String str) {
            zzuc();
            ((zzbk$zza) this.zzahx).zzbt(str);
            return this;
        }

        public final int zzka() {
            return ((zzbk$zza) this.zzahx).zzka();
        }

        public final zzbk$zzb zze(int i) {
            return ((zzbk$zza) this.zzahx).zze(i);
        }

        public final zza zza(int i, zzbk$zzb zzbk_zzb) {
            zzuc();
            ((zzbk$zza) this.zzahx).zzb(i, zzbk_zzb);
            return this;
        }

        /* synthetic */ zza(zzbj zzbj) {
            this();
        }
    }

    private zzbk$zza() {
    }

    public final boolean zzkb() {
        return (this.zzue & 1) != 0;
    }

    public final int getId() {
        return this.zzuf;
    }

    public final String zzjz() {
        return this.zzug;
    }

    /* access modifiers changed from: private */
    public final void zzbt(String str) {
        if (str != null) {
            this.zzue |= 2;
            this.zzug = str;
            return;
        }
        throw new NullPointerException();
    }

    public final List<zzbk$zzb> zzkc() {
        return this.zzuh;
    }

    public final int zzka() {
        return this.zzuh.size();
    }

    public final zzbk$zzb zze(int i) {
        return (zzbk$zzb) this.zzuh.get(i);
    }

    /* access modifiers changed from: private */
    public final void zzb(int i, zzbk$zzb zzbk_zzb) {
        if (zzbk_zzb != null) {
            if (!this.zzuh.zzrx()) {
                this.zzuh = zzey.zza(this.zzuh);
            }
            this.zzuh.set(i, zzbk_zzb);
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzkd() {
        return (this.zzue & 8) != 0;
    }

    public final zzbk$zzc zzke() {
        zzbk$zzc zzbk_zzc = this.zzuj;
        return zzbk_zzc == null ? zzbk$zzc.zzle() : zzbk_zzc;
    }

    public final boolean zzkf() {
        return this.zzuk;
    }

    public final boolean zzkg() {
        return this.zzul;
    }

    public final boolean zzkh() {
        return (this.zzue & 64) != 0;
    }

    public final boolean zzki() {
        return this.zzum;
    }

    public static zzbk$zza zza(byte[] bArr, zzel zzel) throws zzfi {
        return (zzbk$zza) zzey.zza(zzun, bArr, zzel);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbj.zzud[i - 1]) {
            case 1:
                return new zzbk$zza();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzun, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u001b\u0004\u0007\u0002\u0005\t\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\u0007\u0006", new Object[]{"zzue", "zzuf", "zzug", "zzuh", zzbk$zzb.class, "zzui", "zzuj", "zzuk", "zzul", "zzum"});
            case 4:
                return zzun;
            case 5:
                zzgr<zzbk$zza> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbk$zza.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzun);
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

    public static zzgr<zzbk$zza> zzkj() {
        return (zzgr) zzun.zza(zzd.zzaij, (Object) null, (Object) null);
    }

    static {
        zzey.zza(zzbk$zza.class, zzun);
    }
}
