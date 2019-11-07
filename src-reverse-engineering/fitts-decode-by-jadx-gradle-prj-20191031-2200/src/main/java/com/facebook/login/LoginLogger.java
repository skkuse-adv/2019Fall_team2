package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.ServerProtocol;
import com.facebook.login.LoginClient.Request;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class LoginLogger {
    private final AppEventsLogger appEventsLogger;
    private String applicationId;
    private String facebookVersion;

    LoginLogger(Context context, String str) {
        this.applicationId = str;
        this.appEventsLogger = AppEventsLogger.newLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0);
                if (packageInfo != null) {
                    this.facebookVersion = packageInfo.versionName;
                }
            }
        } catch (NameNotFoundException unused) {
        }
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    static Bundle newAuthorizationLoggingBundle(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", str);
        String str2 = "";
        bundle.putString("3_method", str2);
        bundle.putString("2_result", str2);
        bundle.putString("5_error_message", str2);
        bundle.putString("4_error_code", str2);
        bundle.putString("6_extras", str2);
        return bundle;
    }

    public void logStartLogin(Request request) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(request.getAuthId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("login_behavior", request.getLoginBehavior().toString());
            jSONObject.put("request_code", LoginClient.getLoginRequestCode());
            jSONObject.put("permissions", TextUtils.join(",", request.getPermissions()));
            jSONObject.put(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, request.getDefaultAudience().toString());
            jSONObject.put("isReauthorize", request.isRerequest());
            if (this.facebookVersion != null) {
                jSONObject.put("facebookVersion", this.facebookVersion);
            }
            newAuthorizationLoggingBundle.putString("6_extras", jSONObject.toString());
        } catch (JSONException unused) {
        }
        this.appEventsLogger.logSdkEvent("fb_mobile_login_start", null, newAuthorizationLoggingBundle);
    }

    public void logCompleteLogin(String str, Map<String, String> map, Code code, Map<String, String> map2, Exception exc) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        if (code != null) {
            newAuthorizationLoggingBundle.putString("2_result", code.getLoggingValue());
        }
        if (!(exc == null || exc.getMessage() == null)) {
            newAuthorizationLoggingBundle.putString("5_error_message", exc.getMessage());
        }
        JSONObject jSONObject = !map.isEmpty() ? new JSONObject(map) : null;
        if (map2 != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                for (Entry entry : map2.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
            }
        }
        if (jSONObject != null) {
            newAuthorizationLoggingBundle.putString("6_extras", jSONObject.toString());
        }
        this.appEventsLogger.logSdkEvent("fb_mobile_login_complete", null, newAuthorizationLoggingBundle);
    }

    public void logAuthorizationMethodStart(String str, String str2) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("3_method", str2);
        this.appEventsLogger.logSdkEvent("fb_mobile_login_method_start", null, newAuthorizationLoggingBundle);
    }

    public void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        if (str3 != null) {
            newAuthorizationLoggingBundle.putString("2_result", str3);
        }
        if (str4 != null) {
            newAuthorizationLoggingBundle.putString("5_error_message", str4);
        }
        if (str5 != null) {
            newAuthorizationLoggingBundle.putString("4_error_code", str5);
        }
        if (map != null && !map.isEmpty()) {
            newAuthorizationLoggingBundle.putString("6_extras", new JSONObject(map).toString());
        }
        newAuthorizationLoggingBundle.putString("3_method", str2);
        this.appEventsLogger.logSdkEvent("fb_mobile_login_method_complete", null, newAuthorizationLoggingBundle);
    }

    public void logAuthorizationMethodNotTried(String str, String str2) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("3_method", str2);
        this.appEventsLogger.logSdkEvent("fb_mobile_login_method_not_tried", null, newAuthorizationLoggingBundle);
    }

    public void logLoginStatusStart(String str) {
        this.appEventsLogger.logSdkEvent("fb_mobile_login_status_start", null, newAuthorizationLoggingBundle(str));
    }

    public void logLoginStatusSuccess(String str) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("2_result", Code.SUCCESS.getLoggingValue());
        this.appEventsLogger.logSdkEvent("fb_mobile_login_status_complete", null, newAuthorizationLoggingBundle);
    }

    public void logLoginStatusFailure(String str) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("2_result", "failure");
        this.appEventsLogger.logSdkEvent("fb_mobile_login_status_complete", null, newAuthorizationLoggingBundle);
    }

    public void logLoginStatusError(String str, Exception exc) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString("2_result", Code.ERROR.getLoggingValue());
        newAuthorizationLoggingBundle.putString("5_error_message", exc.toString());
        this.appEventsLogger.logSdkEvent("fb_mobile_login_status_complete", null, newAuthorizationLoggingBundle);
    }

    public void logUnexpectedError(String str, String str2) {
        logUnexpectedError(str, str2, "");
    }

    public void logUnexpectedError(String str, String str2, String str3) {
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle("");
        newAuthorizationLoggingBundle.putString("2_result", Code.ERROR.getLoggingValue());
        newAuthorizationLoggingBundle.putString("5_error_message", str2);
        newAuthorizationLoggingBundle.putString("3_method", str3);
        this.appEventsLogger.logSdkEvent(str, null, newAuthorizationLoggingBundle);
    }
}
