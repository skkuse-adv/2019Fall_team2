package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

final /* synthetic */ class zzl implements Callable {
    private final FirebaseRemoteConfig zziz;
    private final FirebaseRemoteConfigSettings zzjn;

    zzl(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zziz = firebaseRemoteConfig;
        this.zzjn = firebaseRemoteConfigSettings;
    }

    public final Object call() {
        return this.zziz.zza(this.zzjn);
    }
}
