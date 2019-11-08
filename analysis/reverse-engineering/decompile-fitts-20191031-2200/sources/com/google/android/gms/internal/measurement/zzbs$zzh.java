package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;

public final class zzbs$zzh extends zzey<zzbs$zzh, zza> implements zzgk {
    private static volatile zzgr<zzbs$zzh> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zzh zzyr = new zzbs$zzh();
    private int zzue;
    private int zzyp = 1;
    private zzff<zzbs$zzd> zzyq = zzey.zzun();

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zzh, zza> implements zzgk {
        private zza() {
            super(zzbs$zzh.zzyr);
        }

        public final zza zza(com.google.android.gms.internal.measurement.zzbs$zzd.zza zza) {
            zzuc();
            ((zzbs$zzh) this.zzahx).zzb(zza);
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    public enum zzb implements zzfc {
        RADS(1),
        PROVISIONING(2);
        
        private final int value;

        public final int zzlg() {
            return this.value;
        }

        public static zzb zzad(int i) {
            if (i == 1) {
                return RADS;
            }
            if (i != 2) {
                return null;
            }
            return PROVISIONING;
        }

        public static zzfe zzlh() {
            return zzbu.zzvk;
        }

        private zzb(int i) {
            this.value = i;
        }

        static {
            new zzbt();
        }
    }

    private zzbs$zzh() {
    }

    /* access modifiers changed from: private */
    public final void zzb(com.google.android.gms.internal.measurement.zzbs$zzd.zza zza2) {
        if (!this.zzyq.zzrx()) {
            this.zzyq = zzey.zza(this.zzyq);
        }
        this.zzyq.add((zzbs$zzd) zza2.zzug());
    }

    public static zza zzpt() {
        return (zza) zzyr.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zzh();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzyr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzue", "zzyp", zzb.zzlh(), "zzyq", zzbs$zzd.class});
            case 4:
                return zzyr;
            case 5:
                zzgr<zzbs$zzh> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zzh.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzyr);
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
        zzey.zza(zzbs$zzh.class, zzyr);
    }
}
