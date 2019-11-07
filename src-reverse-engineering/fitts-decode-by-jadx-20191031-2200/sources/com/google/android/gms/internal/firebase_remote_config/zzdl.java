package com.google.android.gms.internal.firebase_remote_config;

final class zzdl extends zzdm {
    private final char zzhd;

    zzdl(char c) {
        this.zzhd = c;
    }

    public final boolean zzb(char c) {
        return c == this.zzhd;
    }

    public final String toString() {
        String zzd = zzdj.zzc(this.zzhd);
        StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(zzd);
        sb.append("')");
        return sb.toString();
    }
}
