package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

final class zzde<T> implements zzdb<T>, Serializable {
    private final T zzaby;

    zzde(T t) {
        this.zzaby = t;
    }

    public final T get() {
        return this.zzaby;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzde)) {
            return false;
        }
        zzde zzde = (zzde) obj;
        T t = this.zzaby;
        T t2 = zzde.zzaby;
        if (t == t2 || (t != null && t.equals(t2))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzaby});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzaby);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
