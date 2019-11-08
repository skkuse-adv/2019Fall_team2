package com.google.android.gms.internal.clearcut;

final class zzfi extends IllegalArgumentException {
    zzfi(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
        super(sb.toString());
    }
}
