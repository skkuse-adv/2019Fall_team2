package com.google.android.gms.internal.firebase-perf;

final class zzw extends zzr<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzr zzx;

    zzw(zzr zzr, int i, int i2) {
        this.zzx = zzr;
        this.offset = i;
        this.length = i2;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzc() {
        return this.zzx.zzc();
    }

    /* access modifiers changed from: 0000 */
    public final int zzd() {
        return this.zzx.zzd() + this.offset;
    }

    /* access modifiers changed from: 0000 */
    public final int zze() {
        return this.zzx.zzd() + this.offset + this.length;
    }

    public final E get(int i) {
        zzf.zza(i, this.length);
        return this.zzx.get(i + this.offset);
    }

    /* renamed from: zzc */
    public final zzr<E> subList(int i, int i2) {
        zzf.zza(i, i2, this.length);
        zzr zzr = this.zzx;
        int i3 = this.offset;
        return (zzr) zzr.subList(i + i3, i2 + i3);
    }
}
