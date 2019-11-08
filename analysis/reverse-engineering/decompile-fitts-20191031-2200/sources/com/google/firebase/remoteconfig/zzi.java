package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzi implements Continuation {
    private final FirebaseRemoteConfig zziz;
    private final Task zzjl;
    private final Task zzjm;

    zzi(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        this.zziz = firebaseRemoteConfig;
        this.zzjl = task;
        this.zzjm = task2;
    }

    public final Object then(Task task) {
        return this.zziz.zza(this.zzjl, this.zzjm, task);
    }
}
