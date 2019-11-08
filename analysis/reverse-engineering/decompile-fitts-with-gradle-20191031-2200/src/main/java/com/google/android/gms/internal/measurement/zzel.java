package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzel {
    private static volatile zzel zzaet;
    private static volatile zzel zzaeu;
    static final zzel zzaev = new zzel(true);
    private final Map<zza, zze<?, ?>> zzaew;

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

    private static Class<?> zzto() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzel zztp() {
        zzel zzel = zzaet;
        if (zzel == null) {
            synchronized (zzel.class) {
                zzel = zzaet;
                if (zzel == null) {
                    zzel = zzej.zztm();
                    zzaet = zzel;
                }
            }
        }
        return zzel;
    }

    public static zzel zztq() {
        zzel zzel = zzaeu;
        if (zzel == null) {
            synchronized (zzel.class) {
                zzel = zzaeu;
                if (zzel == null) {
                    zzel = zzej.zztn();
                    zzaeu = zzel;
                }
            }
        }
        return zzel;
    }

    static zzel zztn() {
        return zzex.zzc(zzel.class);
    }

    public final <ContainingType extends zzgi> zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zze) this.zzaew.get(new zza(containingtype, i));
    }

    zzel() {
        this.zzaew = new HashMap();
    }

    private zzel(boolean z) {
        this.zzaew = Collections.emptyMap();
    }

    static {
        zzto();
    }
}
