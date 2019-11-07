package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    private final int zzjp;

    public FirebaseRemoteConfigServerException(int i, String str) {
        super(str);
        this.zzjp = i;
    }

    public FirebaseRemoteConfigServerException(int i, String str, Throwable th) {
        super(str, th);
        this.zzjp = i;
    }

    public int getHttpStatusCode() {
        return this.zzjp;
    }
}
