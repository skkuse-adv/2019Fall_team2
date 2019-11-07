package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzc;
import java.util.List;

public final class zzbk$zze extends zzey<zzbk$zze, zzb> implements zzgk {
    private static volatile zzgr<zzbk$zze> zzuo;
    /* access modifiers changed from: private */
    public static final zzbk$zze zzvp = new zzbk$zze();
    private int zzue;
    private int zzvl;
    private String zzvm = "";
    private boolean zzvn;
    private zzff<String> zzvo = zzey.zzun();

    public enum zza implements zzfc {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);
        
        private final int value;

        public final int zzlg() {
            return this.value;
        }

        public static zza zzh(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        public static zzfe zzlh() {
            return zzbn.zzvk;
        }

        private zza(int i) {
            this.value = i;
        }

        static {
            new zzbo();
        }
    }

    public static final class zzb extends com.google.android.gms.internal.measurement.zzey.zza<zzbk$zze, zzb> implements zzgk {
        private zzb() {
            super(zzbk$zze.zzvp);
        }

        /* synthetic */ zzb(zzbj zzbj) {
            this();
        }
    }

    private zzbk$zze() {
    }

    public final boolean zzlk() {
        return (this.zzue & 1) != 0;
    }

    public final zza zzll() {
        zza zzh = zza.zzh(this.zzvl);
        return zzh == null ? zza.UNKNOWN_MATCH_TYPE : zzh;
    }

    public final boolean zzlm() {
        return (this.zzue & 2) != 0;
    }

    public final String zzln() {
        return this.zzvm;
    }

    public final boolean zzlo() {
        return (this.zzue & 4) != 0;
    }

    public final boolean zzlp() {
        return this.zzvn;
    }

    public final List<String> zzlq() {
        return this.zzvo;
    }

    public final int zzlr() {
        return this.zzvo.size();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbj.zzud[i - 1]) {
            case 1:
                return new zzbk$zze();
            case 2:
                return new zzb(null);
            case 3:
                return zzey.zza((zzgi) zzvp, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u001a", new Object[]{"zzue", "zzvl", zza.zzlh(), "zzvm", "zzvn", "zzvo"});
            case 4:
                return zzvp;
            case 5:
                zzgr<zzbk$zze> zzgr = zzuo;
                if (zzgr == null) {
                    synchronized (zzbk$zze.class) {
                        zzgr = zzuo;
                        if (zzgr == null) {
                            zzgr = new zzc<>(zzvp);
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

    public static zzbk$zze zzls() {
        return zzvp;
    }

    static {
        zzey.zza(zzbk$zze.class, zzvp);
    }
}
