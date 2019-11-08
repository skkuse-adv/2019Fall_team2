package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class AdvertisingInfoProvider {
    private final Context context;
    private final PreferenceStore preferenceStore;

    public AdvertisingInfoProvider(Context context2) {
        this.context = context2.getApplicationContext();
        this.preferenceStore = new PreferenceStoreImpl(context2, "TwitterAdvertisingInfoPreferences");
    }

    public AdvertisingInfo getAdvertisingInfo() {
        AdvertisingInfo infoFromPreferences = getInfoFromPreferences();
        if (isInfoValid(infoFromPreferences)) {
            Fabric.getLogger().d(Fabric.TAG, "Using AdvertisingInfo from Preference Store");
            refreshInfoIfNeededAsync(infoFromPreferences);
            return infoFromPreferences;
        }
        AdvertisingInfo advertisingInfoFromStrategies = getAdvertisingInfoFromStrategies();
        storeInfoToPreferences(advertisingInfoFromStrategies);
        return advertisingInfoFromStrategies;
    }

    private void refreshInfoIfNeededAsync(final AdvertisingInfo advertisingInfo) {
        new Thread(new BackgroundPriorityRunnable() {
            public void onRun() {
                AdvertisingInfo access$000 = AdvertisingInfoProvider.this.getAdvertisingInfoFromStrategies();
                if (!advertisingInfo.equals(access$000)) {
                    Fabric.getLogger().d(Fabric.TAG, "Asychronously getting Advertising Info and storing it to preferences");
                    AdvertisingInfoProvider.this.storeInfoToPreferences(access$000);
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public void storeInfoToPreferences(AdvertisingInfo advertisingInfo) {
        String str = "limit_ad_tracking_enabled";
        String str2 = "advertising_id";
        if (isInfoValid(advertisingInfo)) {
            PreferenceStore preferenceStore2 = this.preferenceStore;
            preferenceStore2.save(preferenceStore2.edit().putString(str2, advertisingInfo.advertisingId).putBoolean(str, advertisingInfo.limitAdTrackingEnabled));
            return;
        }
        PreferenceStore preferenceStore3 = this.preferenceStore;
        preferenceStore3.save(preferenceStore3.edit().remove(str2).remove(str));
    }

    /* access modifiers changed from: protected */
    public AdvertisingInfo getInfoFromPreferences() {
        return new AdvertisingInfo(this.preferenceStore.get().getString("advertising_id", ""), this.preferenceStore.get().getBoolean("limit_ad_tracking_enabled", false));
    }

    public AdvertisingInfoStrategy getReflectionStrategy() {
        return new AdvertisingInfoReflectionStrategy(this.context);
    }

    public AdvertisingInfoStrategy getServiceStrategy() {
        return new AdvertisingInfoServiceStrategy(this.context);
    }

    private boolean isInfoValid(AdvertisingInfo advertisingInfo) {
        return advertisingInfo != null && !TextUtils.isEmpty(advertisingInfo.advertisingId);
    }

    /* access modifiers changed from: private */
    public AdvertisingInfo getAdvertisingInfoFromStrategies() {
        AdvertisingInfo advertisingInfo = getReflectionStrategy().getAdvertisingInfo();
        boolean isInfoValid = isInfoValid(advertisingInfo);
        String str = Fabric.TAG;
        if (!isInfoValid) {
            advertisingInfo = getServiceStrategy().getAdvertisingInfo();
            if (!isInfoValid(advertisingInfo)) {
                Fabric.getLogger().d(str, "AdvertisingInfo not present");
            } else {
                Fabric.getLogger().d(str, "Using AdvertisingInfo from Service Provider");
            }
        } else {
            Fabric.getLogger().d(str, "Using AdvertisingInfo from Reflection Provider");
        }
        return advertisingInfo;
    }
}
