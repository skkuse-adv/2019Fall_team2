package com.facebook;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class UserSettingsManager {
    private static final String TAG = "com.facebook.UserSettingsManager";
    /* access modifiers changed from: private */
    public static UserSetting advertiserIDCollectionEnabled;
    private static UserSetting autoLogAppEventsEnabled;
    /* access modifiers changed from: private */
    public static UserSetting codelessSetupEnabled = new UserSetting(false, "auto_event_setup_enabled", null);
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static SharedPreferences userSettingPref;
    private static Editor userSettingPrefEditor;

    private static class UserSetting {
        boolean defaultVal;
        String keyInCache;
        String keyInManifest;
        long lastTS;
        Boolean value;

        UserSetting(boolean z, String str, String str2) {
            this.defaultVal = z;
            this.keyInCache = str;
            this.keyInManifest = str2;
        }

        /* access modifiers changed from: 0000 */
        public boolean getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }

    static {
        String str = FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY;
        autoLogAppEventsEnabled = new UserSetting(true, str, str);
        String str2 = FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY;
        advertiserIDCollectionEnabled = new UserSetting(true, str2, str2);
    }

    public static void initializeIfNotInitialized() {
        if (FacebookSdk.isInitialized() && isInitialized.compareAndSet(false, true)) {
            userSettingPref = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
            userSettingPrefEditor = userSettingPref.edit();
            initializeUserSetting(autoLogAppEventsEnabled);
            initializeUserSetting(advertiserIDCollectionEnabled);
            initializeCodelessSepupEnabledAsync();
        }
    }

    private static void initializeUserSetting(UserSetting userSetting) {
        if (userSetting == codelessSetupEnabled) {
            initializeCodelessSepupEnabledAsync();
        } else if (userSetting.value == null) {
            readSettingFromCache(userSetting);
            if (userSetting.value == null && userSetting.keyInManifest != null) {
                loadSettingFromManifest(userSetting);
            }
        } else {
            writeSettingToCache(userSetting);
        }
    }

    private static void initializeCodelessSepupEnabledAsync() {
        readSettingFromCache(codelessSetupEnabled);
        final long currentTimeMillis = System.currentTimeMillis();
        UserSetting userSetting = codelessSetupEnabled;
        if (userSetting.value == null || currentTimeMillis - userSetting.lastTS >= 604800000) {
            UserSetting userSetting2 = codelessSetupEnabled;
            userSetting2.value = null;
            userSetting2.lastTS = 0;
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    if (UserSettingsManager.advertiserIDCollectionEnabled.getValue()) {
                        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                        if (queryAppSettings != null && queryAppSettings.getCodelessEventsEnabled()) {
                            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                            if (((attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId()) != null) {
                                Bundle bundle = new Bundle();
                                bundle.putString("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                                String str = "auto_event_setup_enabled";
                                bundle.putString(GraphRequest.FIELDS_PARAM, str);
                                GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, FacebookSdk.getApplicationId(), null);
                                newGraphPathRequest.setSkipClientToken(true);
                                newGraphPathRequest.setParameters(bundle);
                                JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                                if (jSONObject != null) {
                                    UserSettingsManager.codelessSetupEnabled.value = Boolean.valueOf(jSONObject.optBoolean(str, false));
                                    UserSettingsManager.codelessSetupEnabled.lastTS = currentTimeMillis;
                                    UserSettingsManager.writeSettingToCache(UserSettingsManager.codelessSetupEnabled);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void writeSettingToCache(UserSetting userSetting) {
        validateInitialized();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", userSetting.value);
            jSONObject.put("last_timestamp", userSetting.lastTS);
            userSettingPrefEditor.putString(userSetting.keyInCache, jSONObject.toString()).commit();
        } catch (JSONException e) {
            Utility.logd(TAG, (Exception) e);
        }
    }

    private static void readSettingFromCache(UserSetting userSetting) {
        validateInitialized();
        try {
            String string = userSettingPref.getString(userSetting.keyInCache, "");
            if (!string.isEmpty()) {
                JSONObject jSONObject = new JSONObject(string);
                userSetting.value = Boolean.valueOf(jSONObject.getBoolean("value"));
                userSetting.lastTS = jSONObject.getLong("last_timestamp");
            }
        } catch (JSONException e) {
            Utility.logd(TAG, (Exception) e);
        }
    }

    private static void loadSettingFromManifest(UserSetting userSetting) {
        validateInitialized();
        try {
            ApplicationInfo applicationInfo = FacebookSdk.getApplicationContext().getPackageManager().getApplicationInfo(FacebookSdk.getApplicationContext().getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(userSetting.keyInManifest)) {
                userSetting.value = Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.keyInManifest, userSetting.defaultVal));
            }
        } catch (NameNotFoundException e) {
            Utility.logd(TAG, (Exception) e);
        }
    }

    private static void validateInitialized() {
        if (!isInitialized.get()) {
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        }
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        autoLogAppEventsEnabled.value = Boolean.valueOf(z);
        autoLogAppEventsEnabled.lastTS = System.currentTimeMillis();
        if (isInitialized.get()) {
            writeSettingToCache(autoLogAppEventsEnabled);
        } else {
            initializeIfNotInitialized();
        }
    }

    public static boolean getAutoLogAppEventsEnabled() {
        initializeIfNotInitialized();
        return autoLogAppEventsEnabled.getValue();
    }

    public static void setAdvertiserIDCollectionEnabled(boolean z) {
        advertiserIDCollectionEnabled.value = Boolean.valueOf(z);
        advertiserIDCollectionEnabled.lastTS = System.currentTimeMillis();
        if (isInitialized.get()) {
            writeSettingToCache(advertiserIDCollectionEnabled);
        } else {
            initializeIfNotInitialized();
        }
    }

    public static boolean getAdvertiserIDCollectionEnabled() {
        initializeIfNotInitialized();
        return advertiserIDCollectionEnabled.getValue();
    }

    public static boolean getCodelessSetupEnabled() {
        initializeIfNotInitialized();
        return codelessSetupEnabled.getValue();
    }
}
