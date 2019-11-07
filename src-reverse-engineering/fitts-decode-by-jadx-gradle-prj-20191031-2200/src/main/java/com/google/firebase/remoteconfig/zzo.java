package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

final /* synthetic */ class zzo implements Callable {
    private final RemoteConfigComponent zzjt;

    zzo(RemoteConfigComponent remoteConfigComponent) {
        this.zzjt = remoteConfigComponent;
    }

    public final Object call() {
        return this.zzjt.get("firebase");
    }
}
