package com.google.android.gms.internal.firebase_remote_config;

import java.util.Locale;
import java.util.Map.Entry;

final class zzbv implements Entry<String, Object> {
    private final /* synthetic */ zzbs zzfl;
    private Object zzfm;
    private final zzbz zzfn;

    zzbv(zzbs zzbs, zzbz zzbz, Object obj) {
        this.zzfl = zzbs;
        this.zzfn = zzbz;
        this.zzfm = zzdt.checkNotNull(obj);
    }

    public final Object getValue() {
        return this.zzfm;
    }

    public final Object setValue(Object obj) {
        Object obj2 = this.zzfm;
        this.zzfm = zzdt.checkNotNull(obj);
        this.zzfn.zzb(this.zzfl.object, obj);
        return obj2;
    }

    public final int hashCode() {
        return ((String) getKey()).hashCode() ^ getValue().hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return ((String) getKey()).equals(entry.getKey()) && getValue().equals(entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        String name = this.zzfn.getName();
        return this.zzfl.zzay.zzbv() ? name.toLowerCase(Locale.US) : name;
    }
}
