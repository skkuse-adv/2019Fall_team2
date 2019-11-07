package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.Set;

public final class zze implements zza {
    private AppMeasurement zzacc;
    /* access modifiers changed from: private */
    public AnalyticsConnectorListener zzacj;
    private zzg zzacr = new zzg(this);

    public zze(AppMeasurement appMeasurement, AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzacj = analyticsConnectorListener;
        this.zzacc = appMeasurement;
        this.zzacc.registerOnMeasurementEventListener(this.zzacr);
    }

    public final void registerEventNames(Set<String> set) {
    }

    public final void unregisterEventNames() {
    }

    public final AnalyticsConnectorListener zzrr() {
        return this.zzacj;
    }
}
