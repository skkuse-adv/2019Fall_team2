package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzbs$zze extends zzey<zzbs$zze, zza> implements zzgk {
    private static volatile zzgr<zzbs$zze> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zze zzwu = new zzbs$zze();
    private int zzue;
    private String zzwk;
    private long zzwp;
    private String zzwr;
    private float zzws;
    private double zzwt;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zze, zza> implements zzgk {
        private zza() {
            super(zzbs$zze.zzwu);
        }

        public final zza zzbz(String str) {
            zzuc();
            ((zzbs$zze) this.zzahx).setName(str);
            return this;
        }

        public final zza zzca(String str) {
            zzuc();
            ((zzbs$zze) this.zzahx).zzcb(str);
            return this;
        }

        public final zza zzmu() {
            zzuc();
            ((zzbs$zze) this.zzahx).zzmz();
            return this;
        }

        public final zza zzam(long j) {
            zzuc();
            ((zzbs$zze) this.zzahx).zzal(j);
            return this;
        }

        public final zza zzmv() {
            zzuc();
            ((zzbs$zze) this.zzahx).zznc();
            return this;
        }

        public final zza zza(double d) {
            zzuc();
            ((zzbs$zze) this.zzahx).zzb(d);
            return this;
        }

        public final zza zzmw() {
            zzuc();
            ((zzbs$zze) this.zzahx).zznf();
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zze() {
        String str = "";
        this.zzwk = str;
        this.zzwr = str;
    }

    public final String getName() {
        return this.zzwk;
    }

    /* access modifiers changed from: private */
    public final void setName(String str) {
        if (str != null) {
            this.zzue |= 1;
            this.zzwk = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzmx() {
        return (this.zzue & 2) != 0;
    }

    public final String zzmy() {
        return this.zzwr;
    }

    /* access modifiers changed from: private */
    public final void zzcb(String str) {
        if (str != null) {
            this.zzue |= 2;
            this.zzwr = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzmz() {
        this.zzue &= -3;
        this.zzwr = zzwu.zzwr;
    }

    public final boolean zzna() {
        return (this.zzue & 4) != 0;
    }

    public final long zznb() {
        return this.zzwp;
    }

    /* access modifiers changed from: private */
    public final void zzal(long j) {
        this.zzue |= 4;
        this.zzwp = j;
    }

    /* access modifiers changed from: private */
    public final void zznc() {
        this.zzue &= -5;
        this.zzwp = 0;
    }

    public final boolean zznd() {
        return (this.zzue & 16) != 0;
    }

    public final double zzne() {
        return this.zzwt;
    }

    /* access modifiers changed from: private */
    public final void zzb(double d) {
        this.zzue |= 16;
        this.zzwt = d;
    }

    /* access modifiers changed from: private */
    public final void zznf() {
        this.zzue &= -17;
        this.zzwt = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static zza zzng() {
        return (zza) zzwu.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zze();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzwu, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0001\u0003\u0005\u0000\u0004", new Object[]{"zzue", "zzwk", "zzwr", "zzwp", "zzws", "zzwt"});
            case 4:
                return zzwu;
            case 5:
                zzgr<zzbs$zze> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zze.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzwu);
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
        zzey.zza(zzbs$zze.class, zzwu);
    }
}
