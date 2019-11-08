package com.google.android.gms.internal.firebase-perf;

public final class zzhz$zza extends zzep<zzhz$zza, zzb> implements zzfz {
    private static volatile zzgh<zzhz$zza> zzij;
    /* access modifiers changed from: private */
    public static final zzhz$zza zzxa;
    private int zzie;
    private int zzwy = -1;
    private int zzwz;

    public enum zza implements zzer {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        
        private final int value;

        public final int zzdj() {
            return this.value;
        }

        public static zzet zzdk() {
            return zzic.zzjf;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zza.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" number=");
            sb.append(this.value);
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        private zza(int i) {
            this.value = i;
        }

        static {
            new zzid();
        }
    }

    public static final class zzb extends com.google.android.gms.internal.firebase-perf.zzep.zza<zzhz$zza, zzb> implements zzfz {
        private zzb() {
            super(zzhz$zza.zzxa);
        }

        /* synthetic */ zzb(zzib zzib) {
            this();
        }
    }

    public enum zzc implements zzer {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);
        
        private final int value;

        public final int zzdj() {
            return this.value;
        }

        public static zzet zzdk() {
            return zzif.zzjf;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zzc.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" number=");
            sb.append(this.value);
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        private zzc(int i) {
            this.value = i;
        }

        static {
            new zzie();
        }
    }

    private zzhz$zza() {
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzib.zzid[i - 1]) {
            case 1:
                return new zzhz$zza();
            case 2:
                return new zzb(null);
            case 3:
                return zzep.zza((zzfx) zzxa, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzie", "zzwy", zzc.zzdk(), "zzwz", zza.zzdk()});
            case 4:
                return zzxa;
            case 5:
                zzgh<zzhz$zza> zzgh = zzij;
                if (zzgh == null) {
                    synchronized (zzhz$zza.class) {
                        zzgh = zzij;
                        if (zzgh == null) {
                            zzgh = new com.google.android.gms.internal.firebase-perf.zzep.zzc<>(zzxa);
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
        zzhz$zza zzhz_zza = new zzhz$zza();
        zzxa = zzhz_zza;
        zzep.zza(zzhz$zza.class, zzhz_zza);
    }
}
