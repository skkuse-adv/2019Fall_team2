package com.google.android.gms.internal.firebase_remote_config;

import java.util.Map;

public final class zzdg extends zzax {
    @zzcc
    private Map<String, String> analyticsUserProperties;
    @zzcc
    private String appId;
    @zzcc
    private String appInstanceId;
    @zzcc
    private String appInstanceIdToken;
    @zzcc
    private String appVersion;
    @zzcc
    private String countryCode;
    @zzcc
    private String languageCode;
    @zzcc
    private String packageName;
    @zzcc
    private String platformVersion;
    @zzcc
    private String sdkVersion;
    @zzcc
    private String timeZone;

    public final zzdg zza(Map<String, String> map) {
        this.analyticsUserProperties = map;
        return this;
    }

    public final zzdg zzar(String str) {
        this.appId = str;
        return this;
    }

    public final zzdg zzas(String str) {
        this.appInstanceId = str;
        return this;
    }

    public final zzdg zzat(String str) {
        this.appInstanceIdToken = str;
        return this;
    }

    public final zzdg zzau(String str) {
        this.appVersion = str;
        return this;
    }

    public final zzdg zzav(String str) {
        this.countryCode = str;
        return this;
    }

    public final zzdg zzaw(String str) {
        this.languageCode = str;
        return this;
    }

    public final zzdg zzax(String str) {
        this.packageName = str;
        return this;
    }

    public final zzdg zzay(String str) {
        this.platformVersion = str;
        return this;
    }

    public final zzdg zzaz(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final zzdg zzba(String str) {
        this.timeZone = str;
        return this;
    }

    public final /* synthetic */ zzax zza(String str, Object obj) {
        return (zzdg) zzb(str, obj);
    }

    public final /* synthetic */ zzax zza() {
        return (zzdg) clone();
    }

    public final /* synthetic */ zzby zzb() {
        return (zzdg) clone();
    }

    public final /* synthetic */ zzby zzb(String str, Object obj) {
        return (zzdg) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzdg) super.clone();
    }
}
