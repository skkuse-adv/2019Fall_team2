package com.google.android.gms.internal.firebase_remote_config;

import java.util.Collection;
import java.util.HashSet;

public final class zzbb {
    final zzaw zzda;
    Collection<String> zzdf = new HashSet();

    public zzbb(zzaw zzaw) {
        this.zzda = (zzaw) zzdt.checkNotNull(zzaw);
    }

    public final zzay zzbm() {
        return new zzay(this);
    }

    public final zzbb zza(Collection<String> collection) {
        this.zzdf = collection;
        return this;
    }
}
