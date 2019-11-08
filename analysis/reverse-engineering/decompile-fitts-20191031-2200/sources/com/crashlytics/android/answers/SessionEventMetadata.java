package com.crashlytics.android.answers;

final class SessionEventMetadata {
    public final String appBundleId;
    public final String appVersionCode;
    public final String appVersionName;
    public final String betaDeviceToken;
    public final String buildId;
    public final String deviceModel;
    public final String executionId;
    public final String installationId;
    public final Boolean limitAdTrackingEnabled;
    public final String osVersion;
    private String stringRepresentation;

    public SessionEventMetadata(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.appBundleId = str;
        this.executionId = str2;
        this.installationId = str3;
        this.limitAdTrackingEnabled = bool;
        this.betaDeviceToken = str4;
        this.buildId = str5;
        this.osVersion = str6;
        this.deviceModel = str7;
        this.appVersionCode = str8;
        this.appVersionName = str9;
    }

    public String toString() {
        if (this.stringRepresentation == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("appBundleId=");
            sb.append(this.appBundleId);
            sb.append(", executionId=");
            sb.append(this.executionId);
            sb.append(", installationId=");
            sb.append(this.installationId);
            sb.append(", limitAdTrackingEnabled=");
            sb.append(this.limitAdTrackingEnabled);
            sb.append(", betaDeviceToken=");
            sb.append(this.betaDeviceToken);
            sb.append(", buildId=");
            sb.append(this.buildId);
            sb.append(", osVersion=");
            sb.append(this.osVersion);
            sb.append(", deviceModel=");
            sb.append(this.deviceModel);
            sb.append(", appVersionCode=");
            sb.append(this.appVersionCode);
            sb.append(", appVersionName=");
            sb.append(this.appVersionName);
            this.stringRepresentation = sb.toString();
        }
        return this.stringRepresentation;
    }
}
