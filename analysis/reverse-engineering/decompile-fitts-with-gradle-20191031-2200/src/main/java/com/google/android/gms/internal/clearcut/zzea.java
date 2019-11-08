package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzea {
    private static final zzea zznc = new zzea();
    private final zzeg zznd;
    private final ConcurrentMap<Class<?>, zzef<?>> zzne = new ConcurrentHashMap();

    private zzea() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzeg zzeg = null;
        for (int i = 0; i <= 0; i++) {
            zzeg = zzk(strArr[0]);
            if (zzeg != null) {
                break;
            }
        }
        if (zzeg == null) {
            zzeg = new zzdd();
        }
        this.zznd = zzeg;
    }

    public static zzea zzcm() {
        return zznc;
    }

    private static zzeg zzk(String str) {
        try {
            return (zzeg) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> zzef<T> zze(Class<T> cls) {
        String str = "messageType";
        zzci.zza(cls, str);
        zzef<T> zzef = (zzef) this.zzne.get(cls);
        if (zzef != null) {
            return zzef;
        }
        zzef<T> zzd = this.zznd.zzd(cls);
        zzci.zza(cls, str);
        zzci.zza(zzd, "schema");
        zzef zzef2 = (zzef) this.zzne.putIfAbsent(cls, zzd);
        return zzef2 != null ? zzef2 : zzd;
    }

    public final <T> zzef<T> zzp(T t) {
        return zze(t.getClass());
    }
}
