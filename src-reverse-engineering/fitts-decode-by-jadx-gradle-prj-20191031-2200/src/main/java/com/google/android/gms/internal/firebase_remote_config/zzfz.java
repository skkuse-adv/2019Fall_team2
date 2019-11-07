package com.google.android.gms.internal.firebase_remote_config;

import java.util.Comparator;

final class zzfz implements Comparator<zzfx> {
    zzfz() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzfx zzfx = (zzfx) obj;
        zzfx zzfx2 = (zzfx) obj2;
        zzgg zzgg = (zzgg) zzfx.iterator();
        zzgg zzgg2 = (zzgg) zzfx2.iterator();
        while (zzgg.hasNext() && zzgg2.hasNext()) {
            int compare = Integer.compare(zzfx.zza(zzgg.nextByte()), zzfx.zza(zzgg2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzfx.size(), zzfx2.size());
    }
}
