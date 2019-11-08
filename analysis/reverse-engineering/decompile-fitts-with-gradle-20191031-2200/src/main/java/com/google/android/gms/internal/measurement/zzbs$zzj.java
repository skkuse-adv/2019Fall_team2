package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import java.util.List;

public final class zzbs$zzj extends zzey<zzbs$zzj, zza> implements zzgk {
    private static volatile zzgr<zzbs$zzj> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zzj zzzb = new zzbs$zzj();
    private int zzue;
    private int zzwg;
    private zzfg zzza = zzey.zzum();

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zzj, zza> implements zzgk {
        private zza() {
            super(zzbs$zzj.zzzb);
        }

        public final zza zzal(int i) {
            zzuc();
            ((zzbs$zzj) this.zzahx).setIndex(i);
            return this;
        }

        public final zza zzbj(long j) {
            zzuc();
            ((zzbs$zzj) this.zzahx).zzbh(j);
            return this;
        }

        public final zza zzr(Iterable<? extends Long> iterable) {
            zzuc();
            ((zzbs$zzj) this.zzahx).zzm(iterable);
            return this;
        }

        public final zza zzqw() {
            zzuc();
            ((zzbs$zzj) this.zzahx).zzqn();
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zzj() {
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

    public final List<Long> zzqk() {
        return this.zzza;
    }

    public final int zzql() {
        return this.zzza.size();
    }

    public final long zzai(int i) {
        return this.zzza.getLong(i);
    }

    private final void zzqm() {
        if (!this.zzza.zzrx()) {
            this.zzza = zzey.zza(this.zzza);
        }
    }

    /* access modifiers changed from: private */
    public final void zzbh(long j) {
        zzqm();
        this.zzza.zzby(j);
    }

    /* access modifiers changed from: private */
    public final void zzm(Iterable<? extends Long> iterable) {
        zzqm();
        zzdf.zza(iterable, this.zzza);
    }

    /* access modifiers changed from: private */
    public final void zzqn() {
        this.zzza = zzey.zzum();
    }

    public static zza zzqo() {
        return (zza) zzzb.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zzj();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0014", new Object[]{"zzue", "zzwg", "zzza"});
            case 4:
                return zzzb;
            case 5:
                zzgr<zzbs$zzj> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zzj.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzzb);
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
        zzey.zza(zzbs$zzj.class, zzzb);
    }
}
