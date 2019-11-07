package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import java.util.Collections;
import java.util.List;

public final class zzbs$zzc extends zzey<zzbs$zzc, zza> implements zzgk {
    private static volatile zzgr<zzbs$zzc> zzuo;
    /* access modifiers changed from: private */
    public static final zzbs$zzc zzwo = new zzbs$zzc();
    private int zzue;
    private zzff<zzbs$zze> zzwj = zzey.zzun();
    private String zzwk = "";
    private long zzwl;
    private long zzwm;
    private int zzwn;

    public static final class zza extends com.google.android.gms.internal.measurement.zzey.zza<zzbs$zzc, zza> implements zzgk {
        private zza() {
            super(zzbs$zzc.zzwo);
        }

        public final List<zzbs$zze> zzmj() {
            return Collections.unmodifiableList(((zzbs$zzc) this.zzahx).zzmj());
        }

        public final int zzmk() {
            return ((zzbs$zzc) this.zzahx).zzmk();
        }

        public final zzbs$zze zzl(int i) {
            return ((zzbs$zzc) this.zzahx).zzl(i);
        }

        public final zza zza(int i, zzbs$zze zzbs_zze) {
            zzuc();
            ((zzbs$zzc) this.zzahx).zzb(i, zzbs_zze);
            return this;
        }

        public final zza zza(int i, com.google.android.gms.internal.measurement.zzbs$zze.zza zza) {
            zzuc();
            ((zzbs$zzc) this.zzahx).zzb(i, zza);
            return this;
        }

        public final zza zza(zzbs$zze zzbs_zze) {
            zzuc();
            ((zzbs$zzc) this.zzahx).zzb(zzbs_zze);
            return this;
        }

        public final zza zza(com.google.android.gms.internal.measurement.zzbs$zze.zza zza) {
            zzuc();
            ((zzbs$zzc) this.zzahx).zzb(zza);
            return this;
        }

        public final zza zzm(int i) {
            zzuc();
            ((zzbs$zzc) this.zzahx).zzn(i);
            return this;
        }

        public final String getName() {
            return ((zzbs$zzc) this.zzahx).getName();
        }

        public final zza zzbx(String str) {
            zzuc();
            ((zzbs$zzc) this.zzahx).setName(str);
            return this;
        }

        public final boolean zzml() {
            return ((zzbs$zzc) this.zzahx).zzml();
        }

        public final long getTimestampMillis() {
            return ((zzbs$zzc) this.zzahx).getTimestampMillis();
        }

        public final zza zzag(long j) {
            zzuc();
            ((zzbs$zzc) this.zzahx).zzai(j);
            return this;
        }

        public final long zzmm() {
            return ((zzbs$zzc) this.zzahx).zzmm();
        }

        public final zza zzah(long j) {
            zzuc();
            ((zzbs$zzc) this.zzahx).zzaj(j);
            return this;
        }

        /* synthetic */ zza(zzbr zzbr) {
            this();
        }
    }

    private zzbs$zzc() {
    }

    public final List<zzbs$zze> zzmj() {
        return this.zzwj;
    }

    public final int zzmk() {
        return this.zzwj.size();
    }

    public final zzbs$zze zzl(int i) {
        return (zzbs$zze) this.zzwj.get(i);
    }

    private final void zzmn() {
        if (!this.zzwj.zzrx()) {
            this.zzwj = zzey.zza(this.zzwj);
        }
    }

    /* access modifiers changed from: private */
    public final void zzb(int i, zzbs$zze zzbs_zze) {
        if (zzbs_zze != null) {
            zzmn();
            this.zzwj.set(i, zzbs_zze);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzb(int i, com.google.android.gms.internal.measurement.zzbs$zze.zza zza2) {
        zzmn();
        this.zzwj.set(i, (zzbs$zze) zza2.zzug());
    }

    /* access modifiers changed from: private */
    public final void zzb(zzbs$zze zzbs_zze) {
        if (zzbs_zze != null) {
            zzmn();
            this.zzwj.add(zzbs_zze);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzb(com.google.android.gms.internal.measurement.zzbs$zze.zza zza2) {
        zzmn();
        this.zzwj.add((zzbs$zze) zza2.zzug());
    }

    /* access modifiers changed from: private */
    public final void zzn(int i) {
        zzmn();
        this.zzwj.remove(i);
    }

    public final String getName() {
        return this.zzwk;
    }

    /* access modifiers changed from: private */
    public final void setName(String str) {
        if (str != null) {
            this.zzue |= 1;
            this.zzwk = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzml() {
        return (this.zzue & 2) != 0;
    }

    public final long getTimestampMillis() {
        return this.zzwl;
    }

    /* access modifiers changed from: private */
    public final void zzai(long j) {
        this.zzue |= 2;
        this.zzwl = j;
    }

    public final boolean zzmo() {
        return (this.zzue & 4) != 0;
    }

    public final long zzmm() {
        return this.zzwm;
    }

    /* access modifiers changed from: private */
    public final void zzaj(long j) {
        this.zzue |= 4;
        this.zzwm = j;
    }

    public final boolean zzmp() {
        return (this.zzue & 8) != 0;
    }

    public final int getCount() {
        return this.zzwn;
    }

    public static zzbs$zzc zzc(byte[] bArr, zzel zzel) throws zzfi {
        return (zzbs$zzc) zzey.zza(zzwo, bArr, zzel);
    }

    public static zza zzmq() {
        return (zza) zzwo.zzui();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbr.zzud[i - 1]) {
            case 1:
                return new zzbs$zzc();
            case 2:
                return new zza(null);
            case 3:
                return zzey.zza((zzgi) zzwo, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\b\u0000\u0003\u0002\u0001\u0004\u0002\u0002\u0005\u0004\u0003", new Object[]{"zzue", "zzwj", zzbs$zze.class, "zzwk", "zzwl", "zzwm", "zzwn"});
            case 4:
                return zzwo;
            case 5:
                zzgr<zzbs$zzc> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbs$zzc.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzwo);
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
        zzey.zza(zzbs$zzc.class, zzwo);
    }
}
