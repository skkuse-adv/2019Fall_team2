package io.fabric.sdk.android.services.settings;

public class SettingsData {
    public final AnalyticsSettingsData analyticsSettingsData;
    public final AppSettingsData appData;
    public final BetaSettingsData betaSettingsData;
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeaturesSettingsData featuresData;
    public final PromptSettingsData promptData;
    public final SessionSettingsData sessionData;
    public final int settingsVersion;

    public SettingsData(long j, AppSettingsData appSettingsData, SessionSettingsData sessionSettingsData, PromptSettingsData promptSettingsData, FeaturesSettingsData featuresSettingsData, AnalyticsSettingsData analyticsSettingsData2, BetaSettingsData betaSettingsData2, int i, int i2) {
        this.expiresAtMillis = j;
        this.appData = appSettingsData;
        this.sessionData = sessionSettingsData;
        this.promptData = promptSettingsData;
        this.featuresData = featuresSettingsData;
        this.settingsVersion = i;
        this.cacheDuration = i2;
        this.analyticsSettingsData = analyticsSettingsData2;
        this.betaSettingsData = betaSettingsData2;
    }

    public boolean isExpired(long j) {
        return this.expiresAtMillis < j;
    }
}
