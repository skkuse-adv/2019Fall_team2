package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient.Request;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

abstract class LoginMethodHandler implements Parcelable {
    protected LoginClient loginClient;
    Map<String, String> methodLoggingExtras;

    /* access modifiers changed from: 0000 */
    public void cancel() {
    }

    /* access modifiers changed from: 0000 */
    public abstract String getNameForLogging();

    /* access modifiers changed from: 0000 */
    public boolean needsInternetPermission() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
    }

    /* access modifiers changed from: 0000 */
    public abstract boolean tryAuthorize(Request request);

    LoginMethodHandler(LoginClient loginClient2) {
        this.loginClient = loginClient2;
    }

    LoginMethodHandler(Parcel parcel) {
        this.methodLoggingExtras = Utility.readStringMapFromParcel(parcel);
    }

    /* access modifiers changed from: 0000 */
    public void setLoginClient(LoginClient loginClient2) {
        if (this.loginClient == null) {
            this.loginClient = loginClient2;
            return;
        }
        throw new FacebookException("Can't set LoginClient if it is already set.");
    }

    /* access modifiers changed from: protected */
    public String getClientState(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating client state json: ");
            sb.append(e.getMessage());
            sb.toString();
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: protected */
    public void addLoggingExtra(String str, Object obj) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        this.methodLoggingExtras.put(str, obj == null ? null : obj.toString());
    }

    /* access modifiers changed from: protected */
    public void logWebLoginCompleted(String str) {
        String applicationId = this.loginClient.getPendingRequest().getApplicationId();
        AppEventsLogger newLogger = AppEventsLogger.newLogger((Context) this.loginClient.getActivity(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        newLogger.logSdkEvent("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    static AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Bundle bundle2 = bundle;
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
        ArrayList stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
        String string = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        AccessToken accessToken = new AccessToken(string, str, bundle.getString(NativeProtocol.EXTRA_USER_ID), stringArrayList, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
        return accessToken;
    }

    public static AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        String string2 = bundle.getString("granted_scopes");
        String str2 = ",";
        if (!Utility.isNullOrEmpty(string2)) {
            collection = new ArrayList<>(Arrays.asList(string2.split(str2)));
        }
        Collection<String> collection2 = collection;
        String string3 = bundle.getString("denied_scopes");
        Collection arrayList = !Utility.isNullOrEmpty(string3) ? new ArrayList(Arrays.asList(string3.split(str2))) : null;
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        AccessToken accessToken = new AccessToken(string, str, getUserIDFromSignedRequest(bundle.getString("signed_request")), collection2, arrayList, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
        return accessToken;
    }

    static String getUserIDFromSignedRequest(String str) throws FacebookException {
        if (str == null || str.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] split = str.split("\\.");
            if (split.length == 2) {
                return new JSONObject(new String(Base64.decode(split[1], 0), "UTF-8")).getString("user_id");
            }
        } catch (UnsupportedEncodingException | JSONException unused) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Utility.writeStringMapToParcel(parcel, this.methodLoggingExtras);
    }
}
