package com.google.android.gms.phenotype;

import java.util.Comparator;

final class zzj implements Comparator<zzi> {
    zzj() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzi zzi = (zzi) obj;
        zzi zzi2 = (zzi) obj2;
        int i = zzi.zzah;
        int i2 = zzi2.zzah;
        return i == i2 ? zzi.name.compareTo(zzi2.name) : i - i2;
    }
}
