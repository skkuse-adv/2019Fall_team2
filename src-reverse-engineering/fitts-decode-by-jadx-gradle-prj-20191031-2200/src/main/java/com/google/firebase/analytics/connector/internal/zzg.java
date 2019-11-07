package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;

final class zzg implements OnEventListener {
    private final /* synthetic */ zze zzacv;

    public zzg(zze zze) {
        this.zzacv = zze;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str != null && !str.equals("crash") && zzd.zzdk(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
            this.zzacv.zzacj.onMessageTriggered(3, bundle2);
        }
    }
}
