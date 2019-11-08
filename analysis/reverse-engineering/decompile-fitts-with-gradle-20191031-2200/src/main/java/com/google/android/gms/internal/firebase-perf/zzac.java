package com.google.android.gms.internal.firebase-perf;

import java.util.Map.Entry;

final class zzac<K, V> extends zzx<Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient zzv<K, V> zzag;
    /* access modifiers changed from: private */
    public final transient Object[] zzz;

    zzac(zzv<K, V> zzv, Object[] objArr, int i, int i2) {
        this.zzag = zzv;
        this.zzz = objArr;
        this.size = i2;
    }

    /* renamed from: zzb */
    public final zzaf<Entry<K, V>> iterator() {
        return (zzaf) zzf().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        return zzf().zza(objArr, i);
    }

    /* access modifiers changed from: 0000 */
    public final zzr<Entry<K, V>> zzo() {
        return new zzab(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zzag.get(key))) {
                return true;
            }
        }
        return false;
    }

    public final int size() {
        return this.size;
    }
}
