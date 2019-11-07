package com.google.android.gms.internal.firebase-perf;

final class zzae<K> extends zzx<K> {
    private final transient zzv<K, ?> zzag;
    private final transient zzr<K> zzs;

    zzae(zzv<K, ?> zzv, zzr<K> zzr) {
        this.zzag = zzv;
        this.zzs = zzr;
    }

    /* renamed from: zzb */
    public final zzaf<K> iterator() {
        return (zzaf) zzf().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        return zzf().zza(objArr, i);
    }

    public final zzr<K> zzf() {
        return this.zzs;
    }

    public final boolean contains(Object obj) {
        return this.zzag.get(obj) != null;
    }

    public final int size() {
        return this.zzag.size();
    }
}
