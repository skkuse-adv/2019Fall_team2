package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

@SuppressLint({"CommitPrefEdits"})
class PreferenceManager {
    static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final String PREF_MIGRATION_COMPLETE = "preferences_migration_complete";
    private static final boolean SHOULD_ALWAYS_SEND_REPORTS_DEFAULT = false;
    private final CrashlyticsCore kit;
    private final PreferenceStore preferenceStore;

    public static PreferenceManager create(PreferenceStore preferenceStore2, CrashlyticsCore crashlyticsCore) {
        return new PreferenceManager(preferenceStore2, crashlyticsCore);
    }

    public PreferenceManager(PreferenceStore preferenceStore2, CrashlyticsCore crashlyticsCore) {
        this.preferenceStore = preferenceStore2;
        this.kit = crashlyticsCore;
    }

    /* access modifiers changed from: 0000 */
    public void setShouldAlwaysSendReports(boolean z) {
        PreferenceStore preferenceStore2 = this.preferenceStore;
        preferenceStore2.save(preferenceStore2.edit().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldAlwaysSendReports() {
        SharedPreferences sharedPreferences = this.preferenceStore.get();
        String str = PREF_MIGRATION_COMPLETE;
        boolean contains = sharedPreferences.contains(str);
        String str2 = PREF_ALWAYS_SEND_REPORTS_KEY;
        if (!contains) {
            PreferenceStoreImpl preferenceStoreImpl = new PreferenceStoreImpl(this.kit);
            if (!this.preferenceStore.get().contains(str2) && preferenceStoreImpl.get().contains(str2)) {
                boolean z = preferenceStoreImpl.get().getBoolean(str2, false);
                PreferenceStore preferenceStore2 = this.preferenceStore;
                preferenceStore2.save(preferenceStore2.edit().putBoolean(str2, z));
            }
            PreferenceStore preferenceStore3 = this.preferenceStore;
            preferenceStore3.save(preferenceStore3.edit().putBoolean(str, true));
        }
        return this.preferenceStore.get().getBoolean(str2, false);
    }
}
