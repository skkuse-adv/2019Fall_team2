package com.google.android.gms.internal.measurement;

final class zzdc<T> implements zzdb<T> {
    private T value;
    private volatile zzdb<T> zzabs;
    private volatile boolean zzdh;

    zzdc(zzdb<T> zzdb) {
        this.zzabs = (zzdb) zzcz.checkNotNull(zzdb);
    }

    public final T get() {
        if (!this.zzdh) {
            synchronized (this) {
                if (!this.zzdh) {
                    T t = this.zzabs.get();
                    this.value = t;
                    this.zzdh = true;
                    this.zzabs = null;
                    return t;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object obj = this.zzabs;
        if (obj == null) {
            String valueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
