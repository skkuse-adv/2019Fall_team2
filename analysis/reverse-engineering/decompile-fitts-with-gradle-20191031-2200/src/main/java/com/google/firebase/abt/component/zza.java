package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

final /* synthetic */ class zza implements ComponentFactory {
    static final ComponentFactory zzm = new zza();

    private zza() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new AbtComponent((Context) componentContainer.get(Context.class), (AnalyticsConnector) componentContainer.get(AnalyticsConnector.class));
    }
}
