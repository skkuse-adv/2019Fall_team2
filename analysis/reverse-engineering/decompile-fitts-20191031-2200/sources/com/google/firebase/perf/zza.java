package com.google.firebase.perf;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.remoteconfig.RemoteConfigComponent;

final /* synthetic */ class zza implements ComponentFactory {
    static final ComponentFactory zzat = new zza();

    private zza() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new FirebasePerformance((FirebaseApp) componentContainer.get(FirebaseApp.class), ((RemoteConfigComponent) componentContainer.get(RemoteConfigComponent.class)).get("fireperf"));
    }
}
