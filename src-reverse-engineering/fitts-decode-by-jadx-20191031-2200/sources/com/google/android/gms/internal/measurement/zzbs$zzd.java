package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;

public final class zzbs$zzd extends zzey<zzbs$zzd, zza> implements zzgk {
    private static volatile zzgr<zzbs$zzd> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zzd zzwq = new zzbs$zzd();
    private int zzue;
    private String zzwk = "";
    private long zzwp;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zzd, zza> implements zzgk {
        private zza() {
            super(zzbs$zzd.zzwq);
        }

        public final zza zzby(String str) {
            zzuc();
            ((zzbs$zzd) this.zzahx).setName(str);
            return this;
        }

        public final zza zzak(long j) {
            zzuc();
            ((zzbs$zzd) this.zzahx).zzal(j);
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zzd() {
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

    /* access modifiers changed from: private */
    public final void zzal(long j) {
        this.zzue |= 2;
        this.zzwp = j;
    }

    public static zza zzms() {
        return (zza) zzwq.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zzd();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzwq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zzue", "zzwk", "zzwp"});
            case 4:
                return zzwq;
            case 5:
                zzgr<zzbs$zzd> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zzd.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzwq);
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
        zzey.zza(zzbs$zzd.class, zzwq);
    }
}
