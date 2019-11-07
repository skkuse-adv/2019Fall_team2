package com.google.firebase.remoteconfig;

@Deprecated
public class FirebaseRemoteConfigFetchException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigFetchException(String str) {
        super(str);
    }

    public FirebaseRemoteConfigFetchException(String str, Throwable th) {
        super(str, th);
    }
}
