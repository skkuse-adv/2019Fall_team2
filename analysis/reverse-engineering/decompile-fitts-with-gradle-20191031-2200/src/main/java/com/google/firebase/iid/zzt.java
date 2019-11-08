package com.google.firebase.iid;

final class zzt implements InstanceIdResult {
    private final String zza;
    private final String zzb;

    zzt(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final String getId() {
        return this.zza;
    }

    public final String getToken() {
        return this.zzb;
    }
}
