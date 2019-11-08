package com.google.android.gms.internal.measurement;

import java.util.Arrays;

final class zziy {
    final int tag;
    final byte[] zzado;

    zziy(int i, byte[] bArr) {
        this.tag = i;
        this.zzado = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zziy)) {
            return false;
        }
        zziy zziy = (zziy) obj;
        return this.tag == zziy.tag && Arrays.equals(this.zzado, zziy.zzado);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzado);
    }
}
