package io.fabric.sdk.android.services.settings;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DataCollectionArbiter;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Settings {
    public static final String SETTINGS_CACHE_FILENAME = "com.crashlytics.settings.json";
    private boolean initialized;
    private SettingsController settingsController;
    private final AtomicReference<SettingsData> settingsData;
    private final CountDownLatch settingsDataLatch;

    static class LazyHolder {
        /* access modifiers changed from: private */
        public static final Settings INSTANCE = new Settings();
    }

    public interface SettingsAccess<T> {
        T usingSettings(SettingsData settingsData);
    }

    public static Settings getInstance() {
        return LazyHolder.INSTANCE;
    }

    private Settings() {
        this.settingsData = new AtomicReference<>();
        this.settingsDataLatch = new CountDownLatch(1);
        this.initialized = false;
    }

    public synchronized Settings initialize(Kit kit, IdManager idManager, HttpRequestFactory httpRequestFactory, String str, String str2, String str3, DataCollectionArbiter dataCollectionArbiter) {
        Kit kit2 = kit;
        synchronized (this) {
            if (this.initialized) {
                return this;
            }
            if (this.settingsController == null) {
                Context context = kit.getContext();
                String appIdentifier = idManager.getAppIdentifier();
                String value = new ApiKey().getValue(context);
                String installerPackageName = idManager.getInstallerPackageName();
                SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
                DefaultSettingsJsonTransform defaultSettingsJsonTransform = new DefaultSettingsJsonTransform();
                DefaultCachedSettingsIo defaultCachedSettingsIo = new DefaultCachedSettingsIo(kit2);
                String appIconHashOrNull = CommonUtils.getAppIconHashOrNull(context);
                String str4 = str3;
                DefaultSettingsSpiCall defaultSettingsSpiCall = new DefaultSettingsSpiCall(kit2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{appIdentifier}), httpRequestFactory);
                String modelName = idManager.getModelName();
                String str5 = modelName;
                String str6 = str2;
                String str7 = str;
                SettingsRequest settingsRequest = new SettingsRequest(value, str5, idManager.getOsBuildVersionString(), idManager.getOsDisplayVersionString(), idManager.getAppInstallIdentifier(), CommonUtils.createInstanceIdFrom(CommonUtils.resolveBuildId(context)), str6, str7, DeliveryMechanism.determineFrom(installerPackageName).getId(), appIconHashOrNull);
                DefaultSettingsController defaultSettingsController = new DefaultSettingsController(kit, settingsRequest, systemCurrentTimeProvider, defaultSettingsJsonTransform, defaultCachedSettingsIo, defaultSettingsSpiCall, dataCollectionArbiter);
                this.settingsController = defaultSettingsController;
            }
            this.initialized = true;
            return this;
        }
    }

    public void clearSettings() {
        this.settingsData.set(null);
    }

    public void setSettingsController(SettingsController settingsController2) {
        this.settingsController = settingsController2;
    }

    public <T> T withSettings(SettingsAccess<T> settingsAccess, T t) {
        SettingsData settingsData2 = (SettingsData) this.settingsData.get();
        return settingsData2 == null ? t : settingsAccess.usingSettings(settingsData2);
    }

    public SettingsData awaitSettingsData() {
        try {
            this.settingsDataLatch.await();
            return (SettingsData) this.settingsData.get();
        } catch (InterruptedException unused) {
            Fabric.getLogger().e(Fabric.TAG, "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean loadSettingsData() {
        SettingsData loadSettingsData;
        loadSettingsData = this.settingsController.loadSettingsData();
        setSettingsData(loadSettingsData);
        return loadSettingsData != null;
    }

    public synchronized boolean loadSettingsSkippingCache() {
        SettingsData loadSettingsData;
        loadSettingsData = this.settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        setSettingsData(loadSettingsData);
        if (loadSettingsData == null) {
            Fabric.getLogger().e(Fabric.TAG, "Failed to force reload of settings from Crashlytics.", null);
        }
        return loadSettingsData != null;
    }

    private void setSettingsData(SettingsData settingsData2) {
        this.settingsData.set(settingsData2);
        this.settingsDataLatch.countDown();
    }
}
