package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.DataCollectionArbiter;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsController implements SettingsController {
    private final CachedSettingsIo cachedSettingsIo;
    private final CurrentTimeProvider currentTimeProvider;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final Kit kit;
    private final PreferenceStore preferenceStore = new PreferenceStoreImpl(this.kit);
    private final SettingsJsonTransform settingsJsonTransform;
    private final SettingsRequest settingsRequest;
    private final SettingsSpiCall settingsSpiCall;

    public DefaultSettingsController(Kit kit2, SettingsRequest settingsRequest2, CurrentTimeProvider currentTimeProvider2, SettingsJsonTransform settingsJsonTransform2, CachedSettingsIo cachedSettingsIo2, SettingsSpiCall settingsSpiCall2, DataCollectionArbiter dataCollectionArbiter2) {
        this.kit = kit2;
        this.settingsRequest = settingsRequest2;
        this.currentTimeProvider = currentTimeProvider2;
        this.settingsJsonTransform = settingsJsonTransform2;
        this.cachedSettingsIo = cachedSettingsIo2;
        this.settingsSpiCall = settingsSpiCall2;
        this.dataCollectionArbiter = dataCollectionArbiter2;
    }

    public SettingsData loadSettingsData() {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE);
    }

    public SettingsData loadSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        boolean isDataCollectionEnabled = this.dataCollectionArbiter.isDataCollectionEnabled();
        String str = Fabric.TAG;
        SettingsData settingsData = null;
        if (!isDataCollectionEnabled) {
            Fabric.getLogger().d(str, "Not fetching settings, because data collection is disabled by Firebase.");
            return null;
        }
        try {
            if (!Fabric.isDebuggable() && !buildInstanceIdentifierChanged()) {
                settingsData = getCachedSettingsData(settingsCacheBehavior);
            }
            if (settingsData == null) {
                JSONObject invoke = this.settingsSpiCall.invoke(this.settingsRequest);
                if (invoke != null) {
                    settingsData = this.settingsJsonTransform.buildFromJson(this.currentTimeProvider, invoke);
                    this.cachedSettingsIo.writeCachedSettings(settingsData.expiresAtMillis, invoke);
                    logSettings(invoke, "Loaded settings: ");
                    setStoredBuildInstanceIdentifier(getBuildInstanceIdentifierFromContext());
                }
            }
            if (settingsData == null) {
                settingsData = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
            }
        } catch (Exception e) {
            Fabric.getLogger().e(str, "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
        }
        return settingsData;
    }

    private SettingsData getCachedSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        String str = Fabric.TAG;
        SettingsData settingsData = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject readCachedSettings = this.cachedSettingsIo.readCachedSettings();
            if (readCachedSettings != null) {
                SettingsData buildFromJson = this.settingsJsonTransform.buildFromJson(this.currentTimeProvider, readCachedSettings);
                if (buildFromJson != null) {
                    logSettings(readCachedSettings, "Loaded cached settings: ");
                    long currentTimeMillis = this.currentTimeProvider.getCurrentTimeMillis();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                        if (buildFromJson.isExpired(currentTimeMillis)) {
                            Fabric.getLogger().d(str, "Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        Fabric.getLogger().d(str, "Returning cached settings.");
                        return buildFromJson;
                    } catch (Exception e) {
                        e = e;
                        settingsData = buildFromJson;
                        Fabric.getLogger().e(str, "Failed to get cached settings", e);
                        return settingsData;
                    }
                } else {
                    Fabric.getLogger().e(str, "Failed to transform cached settings data.", null);
                    return null;
                }
            } else {
                Fabric.getLogger().d(str, "No cached settings data found.");
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            Fabric.getLogger().e(str, "Failed to get cached settings", e);
            return settingsData;
        }
    }

    private void logSettings(JSONObject jSONObject, String str) throws JSONException {
        Logger logger = Fabric.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(jSONObject.toString());
        logger.d(Fabric.TAG, sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public String getBuildInstanceIdentifierFromContext() {
        return CommonUtils.createInstanceIdFrom(CommonUtils.resolveBuildId(this.kit.getContext()));
    }

    /* access modifiers changed from: 0000 */
    public String getStoredBuildInstanceIdentifier() {
        return this.preferenceStore.get().getString("existing_instance_identifier", "");
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"CommitPrefEdits"})
    public boolean setStoredBuildInstanceIdentifier(String str) {
        Editor edit = this.preferenceStore.edit();
        edit.putString("existing_instance_identifier", str);
        return this.preferenceStore.save(edit);
    }

    /* access modifiers changed from: 0000 */
    public boolean buildInstanceIdentifierChanged() {
        return !getStoredBuildInstanceIdentifier().equals(getBuildInstanceIdentifierFromContext());
    }
}
