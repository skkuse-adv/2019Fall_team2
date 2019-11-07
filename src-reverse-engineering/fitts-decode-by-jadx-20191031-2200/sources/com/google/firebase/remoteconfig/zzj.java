package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzj implements OnCompleteListener {
    private final FirebaseRemoteConfig zziz;

    zzj(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zziz = firebaseRemoteConfig;
    }

    public final void onComplete(Task task) {
        this.zziz.zzb(task);
    }
}
