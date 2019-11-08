package com.google.android.gms.internal.firebase-perf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzda extends zzep<zzda, zzb> implements zzfz {
    private static volatile zzgh<zzda> zzij;
    /* access modifiers changed from: private */
    public static final zzda zzmc;
    private int zzie;
    private zzfr<String, String> zzit = zzfr.zzib();
    private long zzkn;
    private zzey<zzcr> zzkr = zzep.zzho();
    private String zzlx = "";
    private boolean zzly;
    private long zzlz;
    private zzfr<String, Long> zzma = zzfr.zzib();
    private zzey<zzda> zzmb = zzep.zzho();

    static final class zza {
        static final zzfp<String, Long> zziv = zzfp.zza(zzhu.STRING, "", zzhu.INT64, Long.valueOf(0));
    }

    public static final class zzb extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzda, zzb> implements zzfz {
        private zzb() {
            super(zzda.zzmc);
        }

        public final zzb zzad(String str) {
            zzhe();
            ((zzda) this.zzqn).setName(str);
            return this;
        }

        public final zzb zzak(long j) {
            zzhe();
            ((zzda) this.zzqn).zzz(j);
            return this;
        }

        public final zzb zzal(long j) {
            zzhe();
            ((zzda) this.zzqn).zzaj(j);
            return this;
        }

        public final zzb zzd(String str, long j) {
            if (str != null) {
                zzhe();
                ((zzda) this.zzqn).zzfp().put(str, Long.valueOf(j));
                return this;
            }
            throw new NullPointerException();
        }

        public final zzb zze(Map<String, Long> map) {
            zzhe();
            ((zzda) this.zzqn).zzfp().putAll(map);
            return this;
        }

        public final zzb zzg(zzda zzda) {
            zzhe();
            ((zzda) this.zzqn).zzc(zzda);
            return this;
        }

        public final zzb zze(Iterable<? extends zzda> iterable) {
            zzhe();
            ((zzda) this.zzqn).zzd(iterable);
            return this;
        }

        public final zzb zzf(Map<String, String> map) {
            zzhe();
            ((zzda) this.zzqn).zzdf().putAll(map);
            return this;
        }

        public final zzb zzb(zzcr zzcr) {
            zzhe();
            ((zzda) this.zzqn).zza(zzcr);
            return this;
        }

        public final zzb zzf(Iterable<? extends zzcr> iterable) {
            zzhe();
            ((zzda) this.zzqn).zzb(iterable);
            return this;
        }

        public final zzb zzfx() {
            zzhe();
            ((zzda) this.zzqn).zzet();
            return this;
        }

        /* synthetic */ zzb(zzcz zzcz) {
            this();
        }
    }

    static final class zzc {
        static final zzfp<String, String> zziv;

        static {
            zzhu zzhu = zzhu.STRING;
            String str = "";
            zziv = zzfp.zza(zzhu, str, zzhu, str);
        }
    }

    private zzda() {
    }

    public final String getName() {
        return this.zzlx;
    }

    /* access modifiers changed from: private */
    public final void setName(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzlx = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzek() {
        return (this.zzie & 4) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzz(long j) {
        this.zzie |= 4;
        this.zzkn = j;
    }

    public final long getDurationUs() {
        return this.zzlz;
    }

    /* access modifiers changed from: private */
    public final void zzaj(long j) {
        this.zzie |= 8;
        this.zzlz = j;
    }

    public final int zzfn() {
        return this.zzma.size();
    }

    public final Map<String, Long> zzfo() {
        return Collections.unmodifiableMap(this.zzma);
    }

    /* access modifiers changed from: private */
    public final Map<String, Long> zzfp() {
        if (!this.zzma.isMutable()) {
            this.zzma = this.zzma.zzic();
        }
        return this.zzma;
    }

    public final List<zzda> zzfq() {
        return this.zzmb;
    }

    private final void zzfr() {
        if (!this.zzmb.zzge()) {
            this.zzmb = zzep.zza(this.zzmb);
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(zzda zzda) {
        if (zzda != null) {
            zzfr();
            this.zzmb.add(zzda);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzd(Iterable<? extends zzda> iterable) {
        zzfr();
        zzdg.zza(iterable, this.zzmb);
    }

    public final Map<String, String> zzfs() {
        return Collections.unmodifiableMap(this.zzit);
    }

    /* access modifiers changed from: private */
    public final Map<String, String> zzdf() {
        if (!this.zzit.isMutable()) {
            this.zzit = this.zzit.zzic();
        }
        return this.zzit;
    }

    public final List<zzcr> zzes() {
        return this.zzkr;
    }

    private final void zzft() {
        if (!this.zzkr.zzge()) {
            this.zzkr = zzep.zza(this.zzkr);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzcr zzcr) {
        if (zzcr != null) {
            zzft();
            this.zzkr.add(zzcr);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzb(Iterable<? extends zzcr> iterable) {
        zzft();
        zzdg.zza(iterable, this.zzkr);
    }

    /* access modifiers changed from: private */
    public final void zzet() {
        this.zzkr = zzep.zzho();
    }

    public static zzb zzfu() {
        return (zzb) zzmc.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        Class<zzda> cls = zzda.class;
        switch (zzcz.zzid[i - 1]) {
            case 1:
                return new zzda();
            case 2:
                return new zzb(null);
            case 3:
                return zzep.zza((zzfx) zzmc, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001\b\u0000\u0002\u0007\u0001\u0004\u0002\u0002\u0005\u0002\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"zzie", "zzlx", "zzly", "zzkn", "zzlz", "zzma", zza.zziv, "zzmb", cls, "zzit", zzc.zziv, "zzkr", zzcr.class});
            case 4:
                return zzmc;
            case 5:
                zzgh<zzda> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (cls) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new com.google.android.gms.internal.firebase-perf.zzep.zzc<>(zzmc);
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

    public static zzda zzfv() {
        return zzmc;
    }

    static {
        zzda zzda = new zzda();
        zzmc = zzda;
        zzep.zza(zzda.class, zzda);
    }
}
