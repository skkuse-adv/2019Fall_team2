package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class zzim implements zzij {
    zzim() {
    }

    public final Map<?, ?> zzp(Object obj) {
        return (zzik) obj;
    }

    public final zzih<?, ?> zzu(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzq(Object obj) {
        return (zzik) obj;
    }

    public final boolean zzr(Object obj) {
        return !((zzik) obj).isMutable();
    }

    public final Object zzs(Object obj) {
        ((zzik) obj).zzes();
        return obj;
    }

    public final Object zzt(Object obj) {
        return zzik.zzhv().zzhw();
    }

    public final Object zzd(Object obj, Object obj2) {
        zzik zzik = (zzik) obj;
        zzik zzik2 = (zzik) obj2;
        if (!zzik2.isEmpty()) {
            if (!zzik.isMutable()) {
                zzik = zzik.zzhw();
            }
            zzik.zza(zzik2);
        }
        return zzik;
    }

    public final int zzc(int i, Object obj, Object obj2) {
        zzik zzik = (zzik) obj;
        if (zzik.isEmpty()) {
            return 0;
        }
        Iterator it = zzik.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
