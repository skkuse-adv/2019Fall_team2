package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzc implements Continuation {
    private final Task zzjj;

    zzc(Task task) {
        this.zzjj = task;
    }

    public final Object then(Task task) {
        return (FirebaseRemoteConfigInfo) this.zzjj.getResult();
    }
}
