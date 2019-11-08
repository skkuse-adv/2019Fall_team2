package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzbx extends AbstractSet<Entry<String, Object>> {
    private final /* synthetic */ zzbs zzfl;

    zzbx(zzbs zzbs) {
        this.zzfl = zzbs;
    }

    public final int size() {
        int i = 0;
        for (String zzae : this.zzfl.zzay.zzer) {
            if (this.zzfl.zzay.zzae(zzae).zzh(this.zzfl.object) != null) {
                i++;
            }
        }
        return i;
    }

    public final void clear() {
        for (String zzae : this.zzfl.zzay.zzer) {
            this.zzfl.zzay.zzae(zzae).zzb(this.zzfl.object, null);
        }
    }

    public final boolean isEmpty() {
        for (String zzae : this.zzfl.zzay.zzer) {
            if (this.zzfl.zzay.zzae(zzae).zzh(this.zzfl.object) != null) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzbu(this.zzfl);
    }
}
