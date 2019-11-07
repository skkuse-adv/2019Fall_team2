package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.iid.FirebaseInstanceId;

final /* synthetic */ class zzr implements ComponentFactory {
    static final ComponentFactory zzkd = new zzr();

    private zzr() {
    }

    public final Object create(ComponentContainer componentContainer) {
        RemoteConfigComponent remoteConfigComponent = new RemoteConfigComponent((Context) componentContainer.get(Context.class), (FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class), ((AbtComponent) componentContainer.get(AbtComponent.class)).get("frc"), (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class));
        return remoteConfigComponent;
    }
}
