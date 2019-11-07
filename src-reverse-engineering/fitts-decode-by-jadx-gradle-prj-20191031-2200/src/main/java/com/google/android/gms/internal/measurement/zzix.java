package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzix {
    public static final byte[] zzaph = new byte[0];

    public static final int zzb(zzil zzil, int i) throws IOException {
        int position = zzil.getPosition();
        zzil.zzau(i);
        int i2 = 1;
        while (zzil.zzsg() == i) {
            zzil.zzau(i);
            i2++;
        }
        zzil.zzu(position, i);
        return i2;
    }
}
