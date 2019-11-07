package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;

public final class zzbk$zzc extends zzey<zzbk$zzc, zza> implements zzgk {
    private static volatile zzgr<zzbk$zzc> zzuo;
    /* access modifiers changed from: private */
    public static final zzbk$zzc zzuz = new zzbk$zzc();
    private int zzue;
    private int zzuu;
    private boolean zzuv;
    private String zzuw;
    private String zzux;
    private String zzuy;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbk$zzc, zza> implements zzgk {
        private zza() {
            super(zzbk$zzc.zzuz);
        }

        /* synthetic */ zza(zzbj zzbj) {
            this();
        }
    }

    public enum zzb implements zzfc {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);
        
        private final int value;

        public final int zzlg() {
            return this.value;
        }

        public static zzb zzf(int i) {
            if (i == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i == 1) {
                return LESS_THAN;
            }
            if (i == 2) {
                return GREATER_THAN;
            }
            if (i == 3) {
                return EQUAL;
            }
            if (i != 4) {
                return null;
            }
            return BETWEEN;
        }

        public static zzfe zzlh() {
            return zzbm.zzvk;
        }

        private zzb(int i) {
            this.value = i;
        }

        static {
            new zzbl();
        }
    }

    private zzbk$zzc() {
        String str = "";
        this.zzuw = str;
        this.zzux = str;
        this.zzuy = str;
    }

    public final boolean zzku() {
        return (this.zzue & 1) != 0;
    }

    public final zzb zzkv() {
        zzb zzf = zzb.zzf(this.zzuu);
        return zzf == null ? zzb.UNKNOWN_COMPARISON_TYPE : zzf;
    }

    public final boolean zzkw() {
        return (this.zzue & 2) != 0;
    }

    public final boolean zzkx() {
        return this.zzuv;
    }

    public final boolean zzky() {
        return (this.zzue & 4) != 0;
    }

    public final String zzkz() {
        return this.zzuw;
    }

    public final boolean zzla() {
        return (this.zzue & 8) != 0;
    }

    public final String zzlb() {
        return this.zzux;
    }

    public final boolean zzlc() {
        return (this.zzue & 16) != 0;
    }

    public final String zzld() {
        return this.zzuy;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbj.zzud[i - 1]) {
            case 1:
                return new zzbk$zzc();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzuz, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"zzue", "zzuu", zzb.zzlh(), "zzuv", "zzuw", "zzux", "zzuy"});
            case 4:
                return zzuz;
            case 5:
                zzgr<zzbk$zzc> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbk$zzc.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzuz);
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

    public static zzbk$zzc zzle() {
        return zzuz;
    }

    static {
        zzey.zza(zzbk$zzc.class, zzuz);
    }
}
