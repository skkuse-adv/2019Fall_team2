package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import java.util.List;

public final class zzbs$zzf extends zzey<zzbs$zzf, zza> implements zzgk {
    private static volatile zzgr<zzbs$zzf> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zzf zzww = new zzbs$zzf();
    private zzff<zzbs$zzg> zzwv = zzey.zzun();

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zzf, zza> implements zzgk {
        private zza() {
            super(zzbs$zzf.zzww);
        }

        public final zzbs$zzg zzo(int i) {
            return ((zzbs$zzf) this.zzahx).zzo(0);
        }

        public final zza zza(com.google.android.gms.internal.measurement.zzbs$zzg.zza zza) {
            zzuc();
            ((zzbs$zzf) this.zzahx).zzb(zza);
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zzf() {
    }

    public final List<zzbs$zzg> zzni() {
        return this.zzwv;
    }

    public final zzbs$zzg zzo(int i) {
        return (zzbs$zzg) this.zzwv.get(0);
    }

    /* access modifiers changed from: private */
    public final void zzb(com.google.android.gms.internal.measurement.zzbs$zzg.zza zza2) {
        if (!this.zzwv.zzrx()) {
            this.zzwv = zzey.zza(this.zzwv);
        }
        this.zzwv.add((zzbs$zzg) zza2.zzug());
    }

    public static zza zznj() {
        return (zza) zzww.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zzf();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzww, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzwv", zzbs$zzg.class});
            case 4:
                return zzww;
            case 5:
                zzgr<zzbs$zzf> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zzf.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzww);
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
        zzey.zza(zzbs$zzf.class, zzww);
    }
}
