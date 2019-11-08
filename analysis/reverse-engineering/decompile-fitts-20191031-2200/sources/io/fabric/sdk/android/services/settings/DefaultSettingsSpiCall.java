package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    /* access modifiers changed from: 0000 */
    public boolean requestWasSuccessful(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    public DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        this(kit, str, str2, httpRequestFactory, HttpMethod.GET);
    }

    DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject invoke(io.fabric.sdk.android.services.settings.SettingsRequest r9) {
        /*
            r8 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            java.lang.String r1 = "Settings request ID: "
            java.lang.String r2 = "Fabric"
            r3 = 0
            java.util.Map r4 = r8.getQueryParamsFor(r9)     // Catch:{ HttpRequestException -> 0x006c, all -> 0x0069 }
            io.fabric.sdk.android.services.network.HttpRequest r5 = r8.getHttpRequest(r4)     // Catch:{ HttpRequestException -> 0x006c, all -> 0x0069 }
            r8.applyHeadersTo(r5, r9)     // Catch:{ HttpRequestException -> 0x0067 }
            io.fabric.sdk.android.Logger r9 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ HttpRequestException -> 0x0067 }
            r6.<init>()     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r7 = "Requesting settings from "
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r7 = r8.getUrl()     // Catch:{ HttpRequestException -> 0x0067 }
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r6 = r6.toString()     // Catch:{ HttpRequestException -> 0x0067 }
            r9.d(r2, r6)     // Catch:{ HttpRequestException -> 0x0067 }
            io.fabric.sdk.android.Logger r9 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ HttpRequestException -> 0x0067 }
            r6.<init>()     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r7 = "Settings query params were: "
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0067 }
            r6.append(r4)     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r4 = r6.toString()     // Catch:{ HttpRequestException -> 0x0067 }
            r9.d(r2, r4)     // Catch:{ HttpRequestException -> 0x0067 }
            org.json.JSONObject r3 = r8.handleResponse(r5)     // Catch:{ HttpRequestException -> 0x0067 }
            if (r5 == 0) goto L_0x0083
            io.fabric.sdk.android.Logger r9 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x0055:
            r4.append(r1)
            java.lang.String r0 = r5.header(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r9.d(r2, r0)
            goto L_0x0083
        L_0x0067:
            r9 = move-exception
            goto L_0x006e
        L_0x0069:
            r9 = move-exception
            r5 = r3
            goto L_0x0085
        L_0x006c:
            r9 = move-exception
            r5 = r3
        L_0x006e:
            io.fabric.sdk.android.Logger r4 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = "Settings request failed."
            r4.e(r2, r6, r9)     // Catch:{ all -> 0x0084 }
            if (r5 == 0) goto L_0x0083
            io.fabric.sdk.android.Logger r9 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x0055
        L_0x0083:
            return r3
        L_0x0084:
            r9 = move-exception
        L_0x0085:
            if (r5 == 0) goto L_0x00a1
            io.fabric.sdk.android.Logger r3 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r0 = r5.header(r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.d(r2, r0)
        L_0x00a1:
            goto L_0x00a3
        L_0x00a2:
            throw r9
        L_0x00a3:
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.DefaultSettingsSpiCall.invoke(io.fabric.sdk.android.services.settings.SettingsRequest):org.json.JSONObject");
    }

    /* access modifiers changed from: 0000 */
    public JSONObject handleResponse(HttpRequest httpRequest) {
        int code = httpRequest.code();
        Logger logger = Fabric.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("Settings result was: ");
        sb.append(code);
        String sb2 = sb.toString();
        String str = Fabric.TAG;
        logger.d(str, sb2);
        if (requestWasSuccessful(code)) {
            return getJsonObjectFrom(httpRequest.body());
        }
        Logger logger2 = Fabric.getLogger();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Failed to retrieve settings from ");
        sb3.append(getUrl());
        logger2.e(str, sb3.toString());
        return null;
    }

    private JSONObject getJsonObjectFrom(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Logger logger = Fabric.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse settings JSON from ");
            sb.append(getUrl());
            String sb2 = sb.toString();
            String str2 = Fabric.TAG;
            logger.d(str2, sb2, e);
            Logger logger2 = Fabric.getLogger();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Settings response ");
            sb3.append(str);
            logger2.d(str2, sb3.toString());
            return null;
        }
    }

    private Map<String, String> getQueryParamsFor(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.buildVersion);
        hashMap.put("display_version", settingsRequest.displayVersion);
        hashMap.put("source", Integer.toString(settingsRequest.source));
        String str = settingsRequest.iconHash;
        if (str != null) {
            hashMap.put("icon_hash", str);
        }
        String str2 = settingsRequest.instanceId;
        if (!CommonUtils.isNullOrEmpty(str2)) {
            hashMap.put("instance", str2);
        }
        return hashMap;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_API_KEY, settingsRequest.apiKey);
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_CLIENT_TYPE, "android");
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_CLIENT_VERSION, this.kit.getVersion());
        applyNonNullHeader(httpRequest, "Accept", "application/json");
        applyNonNullHeader(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.deviceModel);
        applyNonNullHeader(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.osBuildVersion);
        applyNonNullHeader(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.osDisplayVersion);
        applyNonNullHeader(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.installationId);
        return httpRequest;
    }

    private void applyNonNullHeader(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.header(str, str2);
        }
    }
}
