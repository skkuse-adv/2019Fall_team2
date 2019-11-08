package com.google.firebase.remoteconfig;

import com.google.android.gms.internal.firebase_remote_config.zzen;
import com.google.android.gms.tasks.OnSuccessListener;

final /* synthetic */ class zzf implements OnSuccessListener {
    private final FirebaseRemoteConfig zziz;

    zzf(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zziz = firebaseRemoteConfig;
    }

    public final void onSuccess(Object obj) {
        this.zziz.zza((zzen) obj);
    }
}
