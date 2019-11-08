package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

public class ApiKey {
    /* access modifiers changed from: protected */
    public String buildApiKeyInstructions() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    @Deprecated
    public static String getApiKey(Context context) {
        Fabric.getLogger().w(Fabric.TAG, "getApiKey(context) is deprecated, please upgrade kit(s) to the latest version.");
        return new ApiKey().getValue(context);
    }

    @Deprecated
    public static String getApiKey(Context context, boolean z) {
        Fabric.getLogger().w(Fabric.TAG, "getApiKey(context, debug) is deprecated, please upgrade kit(s) to the latest version.");
        return new ApiKey().getValue(context);
    }

    public String getValue(Context context) {
        String apiKeyFromManifest = getApiKeyFromManifest(context);
        if (TextUtils.isEmpty(apiKeyFromManifest)) {
            apiKeyFromManifest = getApiKeyFromStrings(context);
        }
        if (TextUtils.isEmpty(apiKeyFromManifest)) {
            apiKeyFromManifest = getApiKeyFromFirebaseAppId(context);
        }
        if (TextUtils.isEmpty(apiKeyFromManifest)) {
            logErrorOrThrowException(context);
        }
        return apiKeyFromManifest;
    }

    /* access modifiers changed from: protected */
    public String getApiKeyFromFirebaseAppId(Context context) {
        return new FirebaseInfo().getApiKeyFromFirebaseAppId(context);
    }

    /* access modifiers changed from: protected */
    public String getApiKeyFromManifest(Context context) {
        String str = Fabric.TAG;
        String str2 = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    Fabric.getLogger().d(str, "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str2 = string;
                }
                if (str2 != null) {
                    return str2;
                }
                Fabric.getLogger().d(str, "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            } catch (Exception e) {
                e = e;
                str2 = string;
                Logger logger = Fabric.getLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("Caught non-fatal exception while retrieving apiKey: ");
                sb.append(e);
                logger.d(str, sb.toString());
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            Logger logger2 = Fabric.getLogger();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Caught non-fatal exception while retrieving apiKey: ");
            sb2.append(e);
            logger2.d(str, sb2.toString());
            return str2;
        }
    }

    /* access modifiers changed from: protected */
    public String getApiKeyFromStrings(Context context) {
        String str = "string";
        int resourcesIdentifier = CommonUtils.getResourcesIdentifier(context, "io.fabric.ApiKey", str);
        if (resourcesIdentifier == 0) {
            Fabric.getLogger().d(Fabric.TAG, "Falling back to Crashlytics key lookup from Strings");
            resourcesIdentifier = CommonUtils.getResourcesIdentifier(context, "com.crashlytics.ApiKey", str);
        }
        if (resourcesIdentifier != 0) {
            return context.getResources().getString(resourcesIdentifier);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void logErrorOrThrowException(Context context) {
        if (Fabric.isDebuggable() || CommonUtils.isAppDebuggable(context)) {
            throw new IllegalArgumentException(buildApiKeyInstructions());
        }
        Fabric.getLogger().e(Fabric.TAG, buildApiKeyInstructions());
    }
}
