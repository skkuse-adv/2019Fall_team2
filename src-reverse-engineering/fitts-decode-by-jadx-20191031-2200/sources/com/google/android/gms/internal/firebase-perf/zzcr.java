package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzcr extends zzep<zzcr, zza> implements zzfz {
    private static volatile zzgh<zzcr> zzij;
    private static final zzev<Integer, zzcv> zzln = new zzcq();
    /* access modifiers changed from: private */
    public static final zzcr zzlo;
    private int zzie;
    private String zzjt = "";
    private zzew zzlm = zzep.zzhn();

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzcr, zza> implements zzfz {
        private zza() {
            super(zzcr.zzlo);
        }

        public final zza zzac(String str) {
            zzhe();
            ((zzcr) this.zzqn).zzy(str);
            return this;
        }

        public final zza zzb(zzcv zzcv) {
            zzhe();
            ((zzcr) this.zzqn).zza(zzcv);
            return this;
        }

        /* synthetic */ zza(zzcq zzcq) {
            this();
        }
    }

    private zzcr() {
    }

    /* access modifiers changed from: private */
    public final void zzy(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzjt = str;
            return;
        }
        throw new NullPointerException();
    }

    public final int zzfk() {
        return this.zzlm.size();
    }

    public final zzcv zzn(int i) {
        return (zzcv) zzln.convert(Integer.valueOf(this.zzlm.getInt(0)));
    }

    /* access modifiers changed from: private */
    public final void zza(zzcv zzcv) {
        if (zzcv != null) {
            if (!this.zzlm.zzge()) {
                zzew zzew = this.zzlm;
                int size = zzew.size();
                this.zzlm = zzew.zzak(size == 0 ? 10 : size << 1);
            }
            this.zzlm.zzal(zzcv.zzdj());
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzfl() {
        return (zza) zzlo.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcs.zzid[i - 1]) {
            case 1:
                return new zzcr();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzlo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001e", new Object[]{"zzie", "zzjt", "zzlm", zzcv.zzdk()});
            case 4:
                return zzlo;
            case 5:
                zzgh<zzcr> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzcr.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzlo);
                            zzij = zzgh;
                        }
                    }
                }
                return zzgh;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzcr zzcr = new zzcr();
        zzlo = zzcr;
        zzep.zza(zzcr.class, zzcr);
    }
}
