package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.kakao.auth.StringSet;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

public final class ServerProtocol {
    public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
    public static final String DIALOG_PARAM_DISPLAY = "display";
    public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
    public static final String DIALOG_PARAM_E2E = "e2e";
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    public static final String DIALOG_PARAM_SCOPE = "scope";
    public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
    public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
    public static final String DIALOG_PARAM_STATE = "state";
    public static final String DIALOG_PATH = "dialog/";
    public static final String DIALOG_REDIRECT_CHROME_OS_URI = "fbconnect://chrome_os_success";
    public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request";
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
    private static final String TAG = "com.facebook.internal.ServerProtocol";
    public static final String errorConnectionFailure = "CONNECTION_FAILURE";
    public static final Collection<String> errorsProxyAuthDisabled = Utility.unmodifiableCollection("service_disabled", "AndroidAuthKillSwitchException");
    public static final Collection<String> errorsUserCanceled = Utility.unmodifiableCollection(StringSet.access_denied, "OAuthAccessDeniedException");

    public static final String getDefaultAPIVersion() {
        return "v3.2";
    }

    public static final String getDialogAuthority() {
        return String.format("m.%s", new Object[]{FacebookSdk.getFacebookDomain()});
    }

    public static final String getGraphUrlBase() {
        return String.format("https://graph.%s", new Object[]{FacebookSdk.getFacebookDomain()});
    }

    public static final String getGraphVideoUrlBase() {
        return String.format("https://graph-video.%s", new Object[]{FacebookSdk.getFacebookDomain()});
    }

    public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(String str, int i, Bundle bundle) {
        String applicationSignature = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
        if (Utility.isNullOrEmpty(applicationSignature)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("android_key_hash", applicationSignature);
        bundle2.putString("app_id", FacebookSdk.getApplicationId());
        bundle2.putInt(FALLBACK_DIALOG_PARAM_VERSION, i);
        bundle2.putString(DIALOG_PARAM_DISPLAY, "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString(NativeProtocol.BRIDGE_ARG_ACTION_ID_STRING, str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle3);
            JSONObject convertToJSON2 = BundleJSONConverter.convertToJSON(bundle);
            if (convertToJSON != null) {
                if (convertToJSON2 != null) {
                    bundle2.putString(FALLBACK_DIALOG_PARAM_BRIDGE_ARGS, convertToJSON.toString());
                    bundle2.putString(FALLBACK_DIALOG_PARAM_METHOD_ARGS, convertToJSON2.toString());
                    return bundle2;
                }
            }
            return null;
        } catch (JSONException e) {
            LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating Url -- ");
            sb.append(e);
            Logger.log(loggingBehavior, 6, str2, sb.toString());
            bundle2 = null;
        }
    }
}
