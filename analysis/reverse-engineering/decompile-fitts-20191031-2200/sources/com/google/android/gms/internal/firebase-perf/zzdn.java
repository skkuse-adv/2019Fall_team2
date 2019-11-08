package com.google.android.gms.internal.firebase-perf;

import java.util.Comparator;

final class zzdn implements Comparator<zzdl> {
    zzdn() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdl zzdl = (zzdl) obj;
        zzdl zzdl2 = (zzdl) obj2;
        zzdu zzdu = (zzdu) zzdl.iterator();
        zzdu zzdu2 = (zzdu) zzdl2.iterator();
        while (zzdu.hasNext() && zzdu2.hasNext()) {
            int compare = Integer.compare(zzdl.zza(zzdu.nextByte()), zzdl.zza(zzdu2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdl.size(), zzdl2.size());
    }
}
