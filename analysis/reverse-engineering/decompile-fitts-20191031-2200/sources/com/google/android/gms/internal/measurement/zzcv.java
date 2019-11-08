package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

final /* synthetic */ class zzcv implements OnSharedPreferenceChangeListener {
    private final zzcs zzabq;

    zzcv(zzcs zzcs) {
        this.zzabq = zzcs;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zzabq.zza(sharedPreferences, str);
    }
}
