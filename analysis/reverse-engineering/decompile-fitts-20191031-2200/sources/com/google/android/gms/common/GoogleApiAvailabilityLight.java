package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;

public class GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    private static final GoogleApiAvailabilityLight zzm = new GoogleApiAvailabilityLight();

    public static GoogleApiAvailabilityLight getInstance() {
        return zzm;
    }

    GoogleApiAvailabilityLight() {
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public int isGooglePlayServicesAvailable(Context context, int i) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    public void verifyGooglePlayServicesIsAvailable(Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, i);
    }

    public boolean isUserResolvableError(int i) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i);
    }

    @Deprecated
    @Nullable
    public Intent getErrorResolutionIntent(int i) {
        return getErrorResolutionIntent(null, i, null);
    }

    @Nullable
    public Intent getErrorResolutionIntent(Context context, int i, @Nullable String str) {
        String str2 = "com.google.android.gms";
        if (i == 1 || i == 2) {
            if (context == null || !DeviceProperties.isWearableWithoutPlayStore(context)) {
                return zzg.zza(str2, zza(context, str));
            }
            return zzg.zzs();
        } else if (i != 3) {
            return null;
        } else {
            return zzg.zzg(str2);
        }
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return getErrorResolutionPendingIntent(context, i, i2, null);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2, @Nullable String str) {
        Intent errorResolutionIntent = getErrorResolutionIntent(context, i, str);
        if (errorResolutionIntent == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, errorResolutionIntent, 134217728);
    }

    public void cancelAvailabilityErrorNotifications(Context context) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
    }

    public int getClientVersion(Context context) {
        return GooglePlayServicesUtilLight.getClientVersion(context);
    }

    public int getApkVersion(Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    public boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i);
    }

    public boolean isPlayStorePossiblyUpdating(Context context, int i) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i);
    }

    public boolean isUninstalledAppPossiblyUpdating(Context context, String str) {
        return GooglePlayServicesUtilLight.isUninstalledAppPossiblyUpdating(context, str);
    }

    public String getErrorString(int i) {
        return GooglePlayServicesUtilLight.getErrorString(i);
    }

    private static String zza(@Nullable Context context, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        String str2 = "-";
        sb.append(str2);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(str2);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(str2);
        if (context != null) {
            try {
                sb.append(Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }
}
