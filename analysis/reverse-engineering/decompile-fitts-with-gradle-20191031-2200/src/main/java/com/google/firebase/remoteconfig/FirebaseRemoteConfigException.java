package com.google.firebase.remoteconfig;

import com.google.firebase.FirebaseException;

public class FirebaseRemoteConfigException extends FirebaseException {
    public FirebaseRemoteConfigException(String str) {
        super(str);
    }

    public FirebaseRemoteConfigException(String str, Throwable th) {
        super(str, th);
    }
}
