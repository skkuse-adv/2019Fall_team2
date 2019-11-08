package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;

public final class zzbs$zzb extends zzey<zzbs$zzb, zza> implements zzgk {
    private static volatile zzgr<zzbs$zzb> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zzb zzwi = new zzbs$zzb();
    private int zzue;
    private int zzwg;
    private long zzwh;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zzb, zza> implements zzgk {
        private zza() {
            super(zzbs$zzb.zzwi);
        }

        public final zza zzk(int i) {
            zzuc();
            ((zzbs$zzb) this.zzahx).setIndex(i);
            return this;
        }

        public final zza zzae(long j) {
            zzuc();
            ((zzbs$zzb) this.zzahx).zzaf(j);
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zzb() {
    }

    public final boolean zzme() {
        return (this.zzue & 1) != 0;
    }

    public final int getIndex() {
        return this.zzwg;
    }

    /* access modifiers changed from: private */
    public final void setIndex(int i) {
        this.zzue |= 1;
        this.zzwg = i;
    }

    public final boolean zzmf() {
        return (this.zzue & 2) != 0;
    }

    public final long zzmg() {
        return this.zzwh;
    }

    /* access modifiers changed from: private */
    public final void zzaf(long j) {
        this.zzue |= 2;
        this.zzwh = j;
    }

    public static zza zzmh() {
        return (zza) zzwi.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zzb();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzwi, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001", new Object[]{"zzue", "zzwg", "zzwh"});
            case 4:
                return zzwi;
            case 5:
                zzgr<zzbs$zzb> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zzb.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzwi);
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
        zzey.zza(zzbs$zzb.class, zzwi);
    }
}
