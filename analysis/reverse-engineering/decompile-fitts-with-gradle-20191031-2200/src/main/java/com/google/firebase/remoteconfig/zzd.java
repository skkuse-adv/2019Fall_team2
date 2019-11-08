package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzd implements Continuation {
    private final FirebaseRemoteConfig zziz;

    zzd(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zziz = firebaseRemoteConfig;
    }

    public final Object then(Task task) {
        return Boolean.valueOf(this.zziz.zzc(task));
    }
}
