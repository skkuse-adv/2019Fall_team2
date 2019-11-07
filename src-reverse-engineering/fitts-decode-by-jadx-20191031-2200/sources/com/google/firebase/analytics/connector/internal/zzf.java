package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;

final class zzf implements OnEventListener {
    private final /* synthetic */ zzc zzacs;

    public zzf(zzc zzc) {
        this.zzacs = zzc;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.zzacs.zzaci.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzd.zzdn(str2));
            this.zzacs.zzacj.onMessageTriggered(2, bundle2);
        }
    }
}
