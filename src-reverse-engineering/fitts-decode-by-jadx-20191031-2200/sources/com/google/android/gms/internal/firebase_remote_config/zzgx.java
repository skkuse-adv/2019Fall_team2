package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zzc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzgx {
    private static volatile zzgx zzqc;
    static final zzgx zzqd = new zzgx(true);
    private final Map<zza, zzc<?, ?>> zzqe;

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    private static Class<?> zzgg() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzgx zzgh() {
        zzgx zzgx = zzqc;
        if (zzgx == null) {
            synchronized (zzgx.class) {
                zzgx = zzqc;
                if (zzgx == null) {
                    zzgx = zzgv.zzgf();
                    zzqc = zzgx;
                }
            }
        }
        return zzgx;
    }

    public final <ContainingType extends zziq> zzc<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzc) this.zzqe.get(new zza(containingtype, i));
    }

    zzgx() {
        this.zzqe = new HashMap();
    }

    private zzgx(boolean z) {
        this.zzqe = Collections.emptyMap();
    }

    static {
        zzgg();
    }
}
