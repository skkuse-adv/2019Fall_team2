package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzhd extends zzhj {
    private final /* synthetic */ zzhc zzalq;

    private zzhd(zzhc zzhc) {
        this.zzalq = zzhc;
        super(zzhc, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzhe(this.zzalq, null);
    }

    /* synthetic */ zzhd(zzhc zzhc, zzhb zzhb) {
        this(zzhc);
    }
}
