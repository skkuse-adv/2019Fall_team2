package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;

public final class zzbs$zza extends zzey<zzbs$zza, zza> implements zzgk {
    private static volatile zzgr<zzbs$zza> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zza zzwf = new zzbs$zza();
    private int zzue;
    private int zzwb;
    private zzbs$zzi zzwc;
    private zzbs$zzi zzwd;
    private boolean zzwe;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zza, zza> implements zzgk {
        private zza() {
            super(zzbs$zza.zzwf);
        }

        public final zza zzi(int i) {
            zzuc();
            ((zzbs$zza) this.zzahx).zzj(i);
            return this;
        }

        public final zzbs$zzi zzlv() {
            return ((zzbs$zza) this.zzahx).zzlv();
        }

        public final zza zza(com.google.android.gms.internal.measurement.zzbs$zzi.zza zza) {
            zzuc();
            ((zzbs$zza) this.zzahx).zzb(zza);
            return this;
        }

        public final boolean zzlw() {
            return ((zzbs$zza) this.zzahx).zzlw();
        }

        public final zzbs$zzi zzlx() {
            return ((zzbs$zza) this.zzahx).zzlx();
        }

        public final zza zza(zzbs$zzi zzbs_zzi) {
            zzuc();
            ((zzbs$zza) this.zzahx).zzb(zzbs_zzi);
            return this;
        }

        public final zza zzk(boolean z) {
            zzuc();
            ((zzbs$zza) this.zzahx).zzl(z);
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zza() {
    }

    public final boolean zzly() {
        return (this.zzue & 1) != 0;
    }

    public final int zzlz() {
        return this.zzwb;
    }

    /* access modifiers changed from: private */
    public final void zzj(int i) {
        this.zzue |= 1;
        this.zzwb = i;
    }

    public final zzbs$zzi zzlv() {
        zzbs$zzi zzbs_zzi = this.zzwc;
        return zzbs_zzi == null ? zzbs$zzi.zzqi() : zzbs_zzi;
    }

    /* access modifiers changed from: private */
    public final void zzb(com.google.android.gms.internal.measurement.zzbs$zzi.zza zza2) {
        this.zzwc = (zzbs$zzi) zza2.zzug();
        this.zzue |= 2;
    }

    public final boolean zzlw() {
        return (this.zzue & 4) != 0;
    }

    public final zzbs$zzi zzlx() {
        zzbs$zzi zzbs_zzi = this.zzwd;
        return zzbs_zzi == null ? zzbs$zzi.zzqi() : zzbs_zzi;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzbs$zzi zzbs_zzi) {
        if (zzbs_zzi != null) {
            this.zzwd = zzbs_zzi;
            this.zzue |= 4;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzma() {
        return (this.zzue & 8) != 0;
    }

    public final boolean zzmb() {
        return this.zzwe;
    }

    /* access modifiers changed from: private */
    public final void zzl(boolean z) {
        this.zzue |= 8;
        this.zzwe = z;
    }

    public static zza zzmc() {
        return (zza) zzwf.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zza();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzwf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzue", "zzwb", "zzwc", "zzwd", "zzwe"});
            case 4:
                return zzwf;
            case 5:
                zzgr<zzbs$zza> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zza.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzwf);
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

    static {
        zzey.zza(zzbs$zza.class, zzwf);
    }
}
