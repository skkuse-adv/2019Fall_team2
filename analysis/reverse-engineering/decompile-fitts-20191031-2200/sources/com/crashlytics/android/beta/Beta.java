package com.crashlytics.android.beta;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.DeviceIdentifierProvider;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Collections;
import java.util.Map;

public class Beta extends Kit<Boolean> implements DeviceIdentifierProvider {
    public static final String TAG = "Beta";

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getVersion() {
        return "1.2.10.27";
    }

    public static Beta getInstance() {
        return (Beta) Fabric.getKit(Beta.class);
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground() {
        Fabric.getLogger().d(TAG, "Beta kit initializing...");
        return Boolean.valueOf(true);
    }

    public Map<DeviceIdentifierType, String> getDeviceIdentifiers() {
        return Collections.emptyMap();
    }
}
