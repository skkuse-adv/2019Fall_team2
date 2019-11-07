package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

final class zzz {
    final zzbn zzaw;
    final StringBuilder zzax;
    final zzbr zzay;
    final List<Type> zzaz;

    public zzz(zzw zzw, StringBuilder sb) {
        Class cls = zzw.getClass();
        this.zzaz = Arrays.asList(new Type[]{cls});
        this.zzay = zzbr.zza(cls, true);
        this.zzax = sb;
        this.zzaw = new zzbn(zzw);
    }
}
