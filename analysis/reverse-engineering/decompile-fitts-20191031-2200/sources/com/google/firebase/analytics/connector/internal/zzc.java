package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.HashSet;
import java.util.Set;

public final class zzc implements zza {
    private AppMeasurement zzacc;
    Set<String> zzaci;
    /* access modifiers changed from: private */
    public AnalyticsConnectorListener zzacj;
    private zzf zzack = new zzf(this);

    public zzc(AppMeasurement appMeasurement, AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzacj = analyticsConnectorListener;
        this.zzacc = appMeasurement;
        this.zzacc.registerOnMeasurementEventListener(this.zzack);
        this.zzaci = new HashSet();
    }

    public final AnalyticsConnectorListener zzrr() {
        return this.zzacj;
    }

    public final void registerEventNames(Set<String> set) {
        this.zzaci.clear();
        Set<String> set2 = this.zzaci;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzd.zzdm(str) && zzd.zzdl(str)) {
                hashSet.add(zzd.zzdo(str));
            }
        }
        set2.addAll(hashSet);
    }

    public final void unregisterEventNames() {
        this.zzaci.clear();
    }
}
