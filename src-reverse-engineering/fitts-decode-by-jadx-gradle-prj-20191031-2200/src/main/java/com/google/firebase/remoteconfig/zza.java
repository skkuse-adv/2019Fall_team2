package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

final /* synthetic */ class zza implements Callable {
    private final FirebaseRemoteConfig zziz;

    zza(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zziz = firebaseRemoteConfig;
    }

    public final Object call() {
        return this.zziz.getInfo();
    }
}
