package com.google.android.gms.internal.firebase_remote_config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzds {
    /* access modifiers changed from: private */
    public final int limit;
    /* access modifiers changed from: private */
    public final zzdj zzhg;
    private final zzdw zzhi;

    private zzds(zzdw zzdw) {
        this(zzdw, false, zzdn.zzhe, Integer.MAX_VALUE);
    }

    private zzds(zzdw zzdw, boolean z, zzdj zzdj, int i) {
        this.zzhi = zzdw;
        this.zzhg = zzdj;
        this.limit = Integer.MAX_VALUE;
    }

    public static zzds zza(zzdj zzdj) {
        zzdt.checkNotNull(zzdj);
        return new zzds(new zzdv(zzdj));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzdt.checkNotNull(charSequence);
        Iterator zza = this.zzhi.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza.hasNext()) {
            arrayList.add((String) zza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
