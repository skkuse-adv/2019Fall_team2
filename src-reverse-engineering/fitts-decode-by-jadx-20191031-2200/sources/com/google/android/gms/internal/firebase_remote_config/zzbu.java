package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

final class zzbu implements Iterator<Entry<String, Object>> {
    private int zzff = -1;
    private zzbz zzfg;
    private Object zzfh;
    private boolean zzfi;
    private boolean zzfj;
    private zzbz zzfk;
    private final /* synthetic */ zzbs zzfl;

    zzbu(zzbs zzbs) {
        this.zzfl = zzbs;
    }

    public final boolean hasNext() {
        if (!this.zzfj) {
            this.zzfj = true;
            this.zzfh = null;
            while (this.zzfh == null) {
                int i = this.zzff + 1;
                this.zzff = i;
                if (i >= this.zzfl.zzay.zzer.size()) {
                    break;
                }
                zzbr zzbr = this.zzfl.zzay;
                this.zzfg = zzbr.zzae((String) zzbr.zzer.get(this.zzff));
                this.zzfh = this.zzfg.zzh(this.zzfl.object);
            }
        }
        if (this.zzfh != null) {
            return true;
        }
        return false;
    }

    public final void remove() {
        zzdt.checkState(this.zzfk != null && !this.zzfi);
        this.zzfi = true;
        this.zzfk.zzb(this.zzfl.object, null);
    }

    public final /* synthetic */ Object next() {
        if (hasNext()) {
            this.zzfk = this.zzfg;
            Object obj = this.zzfh;
            this.zzfj = false;
            this.zzfi = false;
            this.zzfg = null;
            this.zzfh = null;
            return new zzbv(this.zzfl, this.zzfk, obj);
        }
        throw new NoSuchElementException();
    }
}
