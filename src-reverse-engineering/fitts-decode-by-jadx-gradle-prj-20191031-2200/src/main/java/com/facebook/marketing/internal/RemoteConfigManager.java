package com.facebook.marketing.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.AttributionIdentifiers;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class RemoteConfigManager {
    private static final Map<String, RemoteConfig> remoteConfigs = new ConcurrentHashMap();

    public static void loadRemoteConfigAsync() {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                Context applicationContext = FacebookSdk.getApplicationContext();
                String applicationId = FacebookSdk.getApplicationId();
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(applicationContext);
                if ((attributionIdentifiers != null ? attributionIdentifiers.getAndroidAdvertiserId() : null) != null) {
                    JSONObject access$000 = RemoteConfigManager.getRemoteConfigQueryResponse(applicationId);
                    if (access$000 != null) {
                        RemoteConfigManager.parseRemoteConfigFromJSON(applicationId, access$000);
                    }
                }
            }
        });
    }

    @Nullable
    public static RemoteConfig getRemoteConfigWithoutQuery(String str) {
        if (str != null) {
            return (RemoteConfig) remoteConfigs.get(str);
        }
        return null;
    }

    /* access modifiers changed from: private */
    @Nullable
    public static JSONObject getRemoteConfigQueryResponse(String str) {
        try {
            String format = String.format(Locale.US, "%s/button_auto_detection_device_selection", new Object[]{str});
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "is_selected");
            GraphRequest graphRequest = new GraphRequest(null, format, bundle, HttpMethod.GET, null);
            graphRequest.setSkipClientToken(true);
            return graphRequest.executeAndWait().getJSONObject();
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    /* access modifiers changed from: private */
    public static void parseRemoteConfigFromJSON(String str, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                remoteConfigs.put(str, new RemoteConfig(optJSONObject.optBoolean("is_selected", false)));
            }
        }
    }
}
