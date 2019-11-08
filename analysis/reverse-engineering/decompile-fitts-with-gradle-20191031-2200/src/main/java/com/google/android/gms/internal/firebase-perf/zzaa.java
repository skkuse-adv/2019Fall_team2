package com.google.android.gms.internal.firebase-perf;

final class zzaa<E> extends zzr<E> {
    static final zzr<Object> zzad = new zzaa(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzae;

    zzaa(Object[] objArr, int i) {
        this.zzae = objArr;
        this.size = i;
    }

    /* access modifiers changed from: 0000 */
    public final int zzd() {
        return 0;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzc() {
        return this.zzae;
    }

    /* access modifiers changed from: 0000 */
    public final int zze() {
        return this.size;
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzae, 0, objArr, i, this.size);
        return i + this.size;
    }

    public final E get(int i) {
        zzf.zza(i, this.size);
        return this.zzae[i];
    }
}
