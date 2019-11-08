package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public final class zzez implements FirebaseRemoteConfigInfo {
    private final long zzlt;
    private final int zzlu;
    private final FirebaseRemoteConfigSettings zzlv;

    private zzez(long j, int i, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zzlt = j;
        this.zzlu = i;
        this.zzlv = firebaseRemoteConfigSettings;
    }

    public final long getFetchTimeMillis() {
        return this.zzlt;
    }

    public final int getLastFetchStatus() {
        return this.zzlu;
    }

    public final FirebaseRemoteConfigSettings getConfigSettings() {
        return this.zzlv;
    }
}
