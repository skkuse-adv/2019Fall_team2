package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public final class zzfb {
    private long zzlw;
    private int zzlx;
    private FirebaseRemoteConfigSettings zzly;

    private zzfb() {
    }

    public final zzfb zzc(long j) {
        this.zzlw = j;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public final zzfb zzn(int i) {
        this.zzlx = i;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public final zzfb zzc(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zzly = firebaseRemoteConfigSettings;
        return this;
    }

    public final zzez zzdf() {
        zzez zzez = new zzez(this.zzlw, this.zzlx, this.zzly);
        return zzez;
    }
}
