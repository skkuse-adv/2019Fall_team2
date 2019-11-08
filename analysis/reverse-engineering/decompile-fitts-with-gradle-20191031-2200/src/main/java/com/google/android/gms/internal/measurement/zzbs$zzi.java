package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import java.util.List;

public final class zzbs$zzi extends zzey<zzbs$zzi, zza> implements zzgk {
    private static volatile zzgr<zzbs$zzi> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zzi zzyz = new zzbs$zzi();
    private zzfg zzyv = zzey.zzum();
    private zzfg zzyw = zzey.zzum();
    private zzff<zzbs$zzb> zzyx = zzey.zzun();
    private zzff<zzbs$zzj> zzyy = zzey.zzun();

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zzi, zza> implements zzgk {
        private zza() {
            super(zzbs$zzi.zzyz);
        }

        public final zza zzn(Iterable<? extends Long> iterable) {
            zzuc();
            ((zzbs$zzi) this.zzahx).zzi(iterable);
            return this;
        }

        public final zza zzqq() {
            zzuc();
            ((zzbs$zzi) this.zzahx).zzpx();
            return this;
        }

        public final zza zzo(Iterable<? extends Long> iterable) {
            zzuc();
            ((zzbs$zzi) this.zzahx).zzj(iterable);
            return this;
        }

        public final zza zzqr() {
            zzuc();
            ((zzbs$zzi) this.zzahx).zzqa();
            return this;
        }

        public final zza zzp(Iterable<? extends zzbs$zzb> iterable) {
            zzuc();
            ((zzbs$zzi) this.zzahx).zzk(iterable);
            return this;
        }

        public final zza zzaj(int i) {
            zzuc();
            ((zzbs$zzi) this.zzahx).zzaf(i);
            return this;
        }

        public final zza zzq(Iterable<? extends zzbs$zzj> iterable) {
            zzuc();
            ((zzbs$zzi) this.zzahx).zzl(iterable);
            return this;
        }

        public final zza zzak(int i) {
            zzuc();
            ((zzbs$zzi) this.zzahx).zzah(i);
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zzi() {
    }

    public final List<Long> zzpv() {
        return this.zzyv;
    }

    public final int zzpw() {
        return this.zzyv.size();
    }

    /* access modifiers changed from: private */
    public final void zzi(Iterable<? extends Long> iterable) {
        if (!this.zzyv.zzrx()) {
            this.zzyv = zzey.zza(this.zzyv);
        }
        zzdf.zza(iterable, this.zzyv);
    }

    /* access modifiers changed from: private */
    public final void zzpx() {
        this.zzyv = zzey.zzum();
    }

    public final List<Long> zzpy() {
        return this.zzyw;
    }

    public final int zzpz() {
        return this.zzyw.size();
    }

    /* access modifiers changed from: private */
    public final void zzj(Iterable<? extends Long> iterable) {
        if (!this.zzyw.zzrx()) {
            this.zzyw = zzey.zza(this.zzyw);
        }
        zzdf.zza(iterable, this.zzyw);
    }

    /* access modifiers changed from: private */
    public final void zzqa() {
        this.zzyw = zzey.zzum();
    }

    public final List<zzbs$zzb> zzqb() {
        return this.zzyx;
    }

    public final int zzqc() {
        return this.zzyx.size();
    }

    public final zzbs$zzb zzae(int i) {
        return (zzbs$zzb) this.zzyx.get(i);
    }

    private final void zzqd() {
        if (!this.zzyx.zzrx()) {
            this.zzyx = zzey.zza(this.zzyx);
        }
    }

    /* access modifiers changed from: private */
    public final void zzk(Iterable<? extends zzbs$zzb> iterable) {
        zzqd();
        zzdf.zza(iterable, this.zzyx);
    }

    /* access modifiers changed from: private */
    public final void zzaf(int i) {
        zzqd();
        this.zzyx.remove(i);
    }

    public final List<zzbs$zzj> zzqe() {
        return this.zzyy;
    }

    public final int zzqf() {
        return this.zzyy.size();
    }

    public final zzbs$zzj zzag(int i) {
        return (zzbs$zzj) this.zzyy.get(i);
    }

    private final void zzqg() {
        if (!this.zzyy.zzrx()) {
            this.zzyy = zzey.zza(this.zzyy);
        }
    }

    /* access modifiers changed from: private */
    public final void zzl(Iterable<? extends zzbs$zzj> iterable) {
        zzqg();
        zzdf.zza(iterable, this.zzyy);
    }

    /* access modifiers changed from: private */
    public final void zzah(int i) {
        zzqg();
        this.zzyy.remove(i);
    }

    public static zzbs$zzi zze(byte[] bArr, zzel zzel) throws zzfi {
        return (zzbs$zzi) zzey.zza(zzyz, bArr, zzel);
    }

    public static zza zzqh() {
        return (zza) zzyz.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zzi();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzyz, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzyv", "zzyw", "zzyx", zzbs$zzb.class, "zzyy", zzbs$zzj.class});
            case 4:
                return zzyz;
            case 5:
                zzgr<zzbs$zzi> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zzi.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzyz);
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

    public static zzbs$zzi zzqi() {
        return zzyz;
    }

    static {
        zzey.zza(zzbs$zzi.class, zzyz);
    }
}
