package com.google.android.gms.internal.firebase_remote_config;

final class zzkj extends IllegalArgumentException {
    zzkj(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
        super(sb.toString());
    }
}
