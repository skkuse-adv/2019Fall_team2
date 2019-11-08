package com.google.firebase.perf.internal;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class zzx implements OnFailureListener {
    private final RemoteConfigManager zzfa;

    zzx(RemoteConfigManager remoteConfigManager) {
        this.zzfa = remoteConfigManager;
    }

    public final void onFailure(Exception exc) {
        this.zzfa.zza(exc);
    }
}
