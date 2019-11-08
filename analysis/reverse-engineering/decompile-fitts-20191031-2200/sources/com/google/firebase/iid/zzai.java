package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

final /* synthetic */ class zzai implements ComponentFactory {
    static final ComponentFactory zza = new zzai();

    private zzai() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new zza((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }
}
