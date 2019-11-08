package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzbs$zzk extends zzey<zzbs$zzk, zza> implements zzgk {
    private static volatile zzgr<zzbs$zzk> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zzk zzzd = new zzbs$zzk();
    private int zzue;
    private String zzwk;
    private long zzwp;
    private String zzwr;
    private float zzws;
    private double zzwt;
    private long zzzc;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zzk, zza> implements zzgk {
        private zza() {
            super(zzbs$zzk.zzzd);
        }

        public final zza zzbk(long j) {
            zzuc();
            ((zzbs$zzk) this.zzahx).zzbi(j);
            return this;
        }

        public final zza zzdb(String str) {
            zzuc();
            ((zzbs$zzk) this.zzahx).setName(str);
            return this;
        }

        public final zza zzdc(String str) {
            zzuc();
            ((zzbs$zzk) this.zzahx).zzcb(str);
            return this;
        }

        public final zza zzqz() {
            zzuc();
            ((zzbs$zzk) this.zzahx).zzmz();
            return this;
        }

        public final zza zzbl(long j) {
            zzuc();
            ((zzbs$zzk) this.zzahx).zzal(j);
            return this;
        }

        public final zza zzra() {
            zzuc();
            ((zzbs$zzk) this.zzahx).zznc();
            return this;
        }

        public final zza zzc(double d) {
            zzuc();
            ((zzbs$zzk) this.zzahx).zzb(d);
            return this;
        }

        public final zza zzrb() {
            zzuc();
            ((zzbs$zzk) this.zzahx).zznf();
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zzk() {
        String str = "";
        this.zzwk = str;
        this.zzwr = str;
    }

    public final boolean zzqs() {
        return (this.zzue & 1) != 0;
    }

    public final long zzqt() {
        return this.zzzc;
    }

    /* access modifiers changed from: private */
    public final void zzbi(long j) {
        this.zzue |= 1;
        this.zzzc = j;
    }

    public final String getName() {
        return this.zzwk;
    }

    /* access modifiers changed from: private */
    public final void setName(String str) {
        if (str != null) {
            this.zzue |= 2;
            this.zzwk = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzmx() {
        return (this.zzue & 4) != 0;
    }

    public final String zzmy() {
        return this.zzwr;
    }

    /* access modifiers changed from: private */
    public final void zzcb(String str) {
        if (str != null) {
            this.zzue |= 4;
            this.zzwr = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzmz() {
        this.zzue &= -5;
        this.zzwr = zzzd.zzwr;
    }

    public final boolean zzna() {
        return (this.zzue & 8) != 0;
    }

    public final long zznb() {
        return this.zzwp;
    }

    /* access modifiers changed from: private */
    public final void zzal(long j) {
        this.zzue |= 8;
        this.zzwp = j;
    }

    /* access modifiers changed from: private */
    public final void zznc() {
        this.zzue &= -9;
        this.zzwp = 0;
    }

    public final boolean zznd() {
        return (this.zzue & 32) != 0;
    }

    public final double zzne() {
        return this.zzwt;
    }

    /* access modifiers changed from: private */
    public final void zzb(double d) {
        this.zzue |= 32;
        this.zzwt = d;
    }

    /* access modifiers changed from: private */
    public final void zznf() {
        this.zzue &= -33;
        this.zzwt = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static zza zzqu() {
        return (zza) zzzd.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zzk();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzzd, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0001\u0004\u0006\u0000\u0005", new Object[]{"zzue", "zzzc", "zzwk", "zzwr", "zzwp", "zzws", "zzwt"});
            case 4:
                return zzzd;
            case 5:
                zzgr<zzbs$zzk> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zzk.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzzd);
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
        zzey.zza(zzbs$zzk.class, zzzd);
    }
}
