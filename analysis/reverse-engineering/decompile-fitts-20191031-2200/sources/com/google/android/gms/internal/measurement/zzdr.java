package com.google.android.gms.internal.measurement;

import java.util.Comparator;

final class zzdr implements Comparator<zzdp> {
    zzdr() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdp zzdp = (zzdp) obj;
        zzdp zzdp2 = (zzdp) obj2;
        zzdu zzdu = (zzdu) zzdp.iterator();
        zzdu zzdu2 = (zzdu) zzdp2.iterator();
        while (zzdu.hasNext() && zzdu2.hasNext()) {
            int compare = Integer.compare(zzdp.zza(zzdu.nextByte()), zzdp.zza(zzdu2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdp.size(), zzdp2.size());
    }
}
