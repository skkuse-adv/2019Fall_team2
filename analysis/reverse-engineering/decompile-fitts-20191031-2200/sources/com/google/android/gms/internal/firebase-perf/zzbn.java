package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzc;

public final class zzbn extends zzep<zzbn, zza> implements zzfz {
    /* access modifiers changed from: private */
    public static final zzbn zzii;
    private static volatile zzgh<zzbn> zzij;
    private int zzie;
    private String zzif;
    private String zzig;
    private String zzih;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzbn, zza> implements zzfz {
        private zza() {
            super(zzbn.zzii);
        }

        public final zza zzp(String str) {
            zzhe();
            ((zzbn) this.zzqn).zzm(str);
            return this;
        }

        public final zza zzq(String str) {
            zzhe();
            ((zzbn) this.zzqn).zzn(str);
            return this;
        }

        public final zza zzr(String str) {
            zzhe();
            ((zzbn) this.zzqn).zzo(str);
            return this;
        }

        /* synthetic */ zza(zzbm zzbm) {
            this();
        }
    }

    private zzbn() {
        String str = "";
        this.zzif = str;
        this.zzig = str;
        this.zzih = str;
    }

    public final boolean zzct() {
        return (this.zzie & 1) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzm(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzif = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzcu() {
        return (this.zzie & 2) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzn(String str) {
        if (str != null) {
            this.zzie |= 2;
            this.zzig = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzo(String str) {
        if (str != null) {
            this.zzie |= 4;
            this.zzih = str;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzcv() {
        return (zza) zzii.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbm.zzid[i - 1]) {
            case 1:
                return new zzbn();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzii, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzie", "zzif", "zzig", "zzih"});
            case 4:
                return zzii;
            case 5:
                zzgh<zzbn> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzbn.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new zzc<>(zzii);
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

    public static zzbn zzcw() {
        return zzii;
    }

    static {
        zzbn zzbn = new zzbn();
        zzii = zzbn;
        zzep.zza(zzbn.class, zzbn);
    }
}
