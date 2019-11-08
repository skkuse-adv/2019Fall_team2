package io.fabric.sdk.android.services.settings;

public class SettingsRequest {
    public final String apiKey;
    public final String buildVersion;
    public final String deviceModel;
    public final String displayVersion;
    public final String iconHash;
    public final String installationId;
    public final String instanceId;
    public final String osBuildVersion;
    public final String osDisplayVersion;
    public final int source;

    public SettingsRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9) {
        this.apiKey = str;
        this.deviceModel = str2;
        this.osBuildVersion = str3;
        this.osDisplayVersion = str4;
        this.installationId = str5;
        this.instanceId = str6;
        this.displayVersion = str7;
        this.buildVersion = str8;
        this.source = i;
        this.iconHash = str9;
    }
}
