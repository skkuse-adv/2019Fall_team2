package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractMap;
import java.util.Set;

final class zzbs extends AbstractMap<String, Object> {
    final Object object;
    final zzbr zzay;

    zzbs(Object obj, boolean z) {
        this.object = obj;
        this.zzay = zzbr.zza(obj.getClass(), z);
        if (!(!this.zzay.isEnum())) {
            throw new IllegalArgumentException();
        }
    }

    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        zzbz zzae = this.zzay.zzae((String) obj);
        if (zzae == null) {
            return null;
        }
        return zzae.zzh(this.object);
    }

    public final /* synthetic */ Set entrySet() {
        return new zzbx(this);
    }

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        String str = (String) obj;
        zzbz zzae = this.zzay.zzae(str);
        String valueOf = String.valueOf(str);
        String str2 = "no field of key ";
        String concat = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        if (zzae != null) {
            Object zzh = zzae.zzh(this.object);
            zzae.zzb(this.object, zzdt.checkNotNull(obj2));
            return zzh;
        }
        throw new NullPointerException(String.valueOf(concat));
    }
}
