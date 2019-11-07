package com.google.android.gms.internal.firebase-perf;

import java.util.List;
import java.util.Map;

public final class zzci extends zzep<zzci, zza> implements zzfz {
    private static volatile zzgh<zzci> zzij;
    /* access modifiers changed from: private */
    public static final zzci zzks;
    private int zzie;
    private zzfr<String, String> zzit = zzfr.zzib();
    private String zzkg;
    private int zzkh;
    private long zzki;
    private long zzkj;
    private int zzkk;
    private int zzkl;
    private String zzkm;
    private long zzkn;
    private long zzko;
    private long zzkp;
    private long zzkq;
    private zzey<zzcr> zzkr;

    public static final class zza extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzci, zza> implements zzfz {
        private zza() {
            super(zzci.zzks);
        }

        public final zza zzaa(String str) {
            zzhe();
            ((zzci) this.zzqn).setUrl(str);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzhe();
            ((zzci) this.zzqn).zza(zzb);
            return this;
        }

        public final zza zzad(long j) {
            zzhe();
            ((zzci) this.zzqn).zzx(j);
            return this;
        }

        public final zza zzae(long j) {
            zzhe();
            ((zzci) this.zzqn).zzy(j);
            return this;
        }

        public final zza zzb(zzd zzd) {
            zzhe();
            ((zzci) this.zzqn).zza(zzd);
            return this;
        }

        public final boolean zzaf() {
            return ((zzci) this.zzqn).zzaf();
        }

        public final zza zzl(int i) {
            zzhe();
            ((zzci) this.zzqn).setHttpResponseCode(i);
            return this;
        }

        public final zza zzab(String str) {
            zzhe();
            ((zzci) this.zzqn).setResponseContentType(str);
            return this;
        }

        public final zza zzex() {
            zzhe();
            ((zzci) this.zzqn).zzej();
            return this;
        }

        public final boolean zzek() {
            return ((zzci) this.zzqn).zzek();
        }

        public final zza zzaf(long j) {
            zzhe();
            ((zzci) this.zzqn).zzz(j);
            return this;
        }

        public final zza zzag(long j) {
            zzhe();
            ((zzci) this.zzqn).zzaa(j);
            return this;
        }

        public final long zzep() {
            return ((zzci) this.zzqn).zzep();
        }

        public final zza zzah(long j) {
            zzhe();
            ((zzci) this.zzqn).zzab(j);
            return this;
        }

        public final boolean zzeq() {
            return ((zzci) this.zzqn).zzeq();
        }

        public final zza zzai(long j) {
            zzhe();
            ((zzci) this.zzqn).zzac(j);
            return this;
        }

        public final zza zzey() {
            zzhe();
            ((zzci) this.zzqn).zzdf().clear();
            return this;
        }

        public final zza zzd(Map<String, String> map) {
            zzhe();
            ((zzci) this.zzqn).zzdf().putAll(map);
            return this;
        }

        public final zza zzc(Iterable<? extends zzcr> iterable) {
            zzhe();
            ((zzci) this.zzqn).zzb(iterable);
            return this;
        }

        public final zza zzez() {
            zzhe();
            ((zzci) this.zzqn).zzet();
            return this;
        }

        /* synthetic */ zza(zzcj zzcj) {
            this();
        }
    }

    public enum zzb implements zzer {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);
        
        private final int value;

        public final int zzdj() {
            return this.value;
        }

        public static zzb zzm(int i) {
            switch (i) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return PATCH;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        public static zzet zzdk() {
            return zzck.zzjf;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zzb.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" number=");
            sb.append(this.value);
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        private zzb(int i) {
            this.value = i;
        }

        static {
            new zzcl();
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

    public enum zzd implements zzer {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);
        
        private final int value;

        public final int zzdj() {
            return this.value;
        }

        public static zzet zzdk() {
            return zzco.zzjf;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zzd.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" number=");
            sb.append(this.value);
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        private zzd(int i) {
            this.value = i;
        }

        static {
            new zzcm();
        }
    }

    private zzci() {
        String str = "";
        this.zzkg = str;
        this.zzkm = str;
        this.zzkr = zzep.zzho();
    }

    public final String getUrl() {
        return this.zzkg;
    }

    /* access modifiers changed from: private */
    public final void setUrl(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzkg = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzec() {
        return (this.zzie & 2) != 0;
    }

    public final zzb zzed() {
        zzb zzm = zzb.zzm(this.zzkh);
        return zzm == null ? zzb.HTTP_METHOD_UNKNOWN : zzm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            this.zzie |= 2;
            this.zzkh = zzb2.zzdj();
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzee() {
        return (this.zzie & 4) != 0;
    }

    public final long zzef() {
        return this.zzki;
    }

    /* access modifiers changed from: private */
    public final void zzx(long j) {
        this.zzie |= 4;
        this.zzki = j;
    }

    public final boolean zzeg() {
        return (this.zzie & 8) != 0;
    }

    public final long zzeh() {
        return this.zzkj;
    }

    /* access modifiers changed from: private */
    public final void zzy(long j) {
        this.zzie |= 8;
        this.zzkj = j;
    }

    /* access modifiers changed from: private */
    public final void zza(zzd zzd2) {
        if (zzd2 != null) {
            this.zzie |= 16;
            this.zzkk = zzd2.zzdj();
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzaf() {
        return (this.zzie & 32) != 0;
    }

    public final int zzei() {
        return this.zzkl;
    }

    /* access modifiers changed from: private */
    public final void setHttpResponseCode(int i) {
        this.zzie |= 32;
        this.zzkl = i;
    }

    /* access modifiers changed from: private */
    public final void setResponseContentType(String str) {
        if (str != null) {
            this.zzie |= 64;
            this.zzkm = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzej() {
        this.zzie &= -65;
        this.zzkm = zzks.zzkm;
    }

    public final boolean zzek() {
        return (this.zzie & 128) != 0;
    }

    public final long zzel() {
        return this.zzkn;
    }

    /* access modifiers changed from: private */
    public final void zzz(long j) {
        this.zzie |= 128;
        this.zzkn = j;
    }

    public final boolean zzem() {
        return (this.zzie & 256) != 0;
    }

    public final long zzen() {
        return this.zzko;
    }

    /* access modifiers changed from: private */
    public final void zzaa(long j) {
        this.zzie |= 256;
        this.zzko = j;
    }

    public final boolean zzeo() {
        return (this.zzie & 512) != 0;
    }

    public final long zzep() {
        return this.zzkp;
    }

    /* access modifiers changed from: private */
    public final void zzab(long j) {
        this.zzie |= 512;
        this.zzkp = j;
    }

    public final boolean zzeq() {
        return (this.zzie & 1024) != 0;
    }

    public final long zzer() {
        return this.zzkq;
    }

    /* access modifiers changed from: private */
    public final void zzac(long j) {
        this.zzie |= 1024;
        this.zzkq = j;
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

    /* access modifiers changed from: private */
    public final void zzb(Iterable<? extends zzcr> iterable) {
        if (!this.zzkr.zzge()) {
            this.zzkr = zzep.zza(this.zzkr);
        }
        zzdg.zza(iterable, this.zzkr);
    }

    /* access modifiers changed from: private */
    public final void zzet() {
        this.zzkr = zzep.zzho();
    }

    public static zza zzeu() {
        return (zza) zzks.zzhk();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcj.zzid[i - 1]) {
            case 1:
                return new zzci();
            case 2:
                return new zza(null);
            case 3:
                return zzep.zza((zzfx) zzks, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0004\u0005\u0006\b\u0006\u0007\u0002\u0007\b\u0002\b\t\u0002\t\n\u0002\n\u000b\f\u0004\f2\r\u001b", new Object[]{"zzie", "zzkg", "zzkh", zzb.zzdk(), "zzki", "zzkj", "zzkl", "zzkm", "zzkn", "zzko", "zzkp", "zzkq", "zzkk", zzd.zzdk(), "zzit", zzc.zziv, "zzkr", zzcr.class});
            case 4:
                return zzks;
            case 5:
                zzgh<zzci> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzci.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new com.google.android.gms.internal.firebase-perf.zzep.zzc<>(zzks);
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

    public static zzci zzev() {
        return zzks;
    }

    static {
        zzci zzci = new zzci();
        zzks = zzci;
        zzep.zza(zzci.class, zzci);
    }
}
