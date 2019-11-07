package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzjl extends zzjr {
    private final /* synthetic */ zzjk zzwy;

    private zzjl(zzjk zzjk) {
        this.zzwy = zzjk;
        super(zzjk, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzjm(this.zzwy, null);
    }

    /* synthetic */ zzjl(zzjk zzjk, zzjj zzjj) {
        this(zzjk);
    }
}
