package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzh implements OnCompleteListener {
    private final FirebaseRemoteConfig zziz;

    zzh(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zziz = firebaseRemoteConfig;
    }

    public final void onComplete(Task task) {
        this.zziz.zzb(task);
    }
}
