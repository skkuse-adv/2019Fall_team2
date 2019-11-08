package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public final class zzb {
    private SharedPreferences zzs;

    public zzb(Context context) {
        try {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            this.zzs = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable unused) {
            this.zzs = null;
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        try {
            if (this.zzs == null) {
                return false;
            }
            return this.zzs.getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final float getFloat(String str, float f) {
        try {
            if (this.zzs == null) {
                return 0.0f;
            }
            return this.zzs.getFloat(str, 0.0f);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    /* access modifiers changed from: 0000 */
    public final String getString(String str, String str2) {
        try {
            return this.zzs == null ? str2 : this.zzs.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
