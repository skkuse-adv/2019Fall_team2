package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzg implements SuccessContinuation {
    private final FirebaseRemoteConfig zziz;

    zzg(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zziz = firebaseRemoteConfig;
    }

    public final Task then(Object obj) {
        return this.zziz.activate();
    }
}
