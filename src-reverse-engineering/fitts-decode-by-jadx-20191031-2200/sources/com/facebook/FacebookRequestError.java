package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    public static final Creator<FacebookRequestError> CREATOR = new Creator<FacebookRequestError>() {
        public FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel);
        }

        public FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    };
    static final Range HTTP_RANGE_SUCCESS = new Range(Callback.DEFAULT_DRAG_ANIMATION_DURATION, 299);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    private static class Range {
        private final int end;
        private final int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* access modifiers changed from: 0000 */
        public boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    public int describeContents() {
        return 0;
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean z2;
        Category category2;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        if (facebookException != null) {
            this.exception = facebookException;
            z2 = true;
        } else {
            this.exception = new FacebookServiceException(this, str2);
            z2 = false;
        }
        FacebookRequestErrorClassification errorClassification = getErrorClassification();
        if (z2) {
            category2 = Category.OTHER;
        } else {
            category2 = errorClassification.classify(i2, i3, z);
        }
        this.category = category2;
        this.errorRecoveryMessage = errorClassification.getRecoveryMessage(this.category);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        Exception exc2 = exc;
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, exc2 instanceof FacebookException ? (FacebookException) exc2 : new FacebookException((Throwable) exc2));
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    public Category getCategory() {
        return this.category;
    }

    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        return this.exception.getLocalizedMessage();
    }

    public String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public JSONObject getRequestResult() {
        return this.requestResult;
    }

    public Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    public FacebookException getException() {
        return this.exception;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{HttpStatus: ");
        sb.append(this.requestStatusCode);
        sb.append(", errorCode: ");
        sb.append(this.errorCode);
        sb.append(", subErrorCode: ");
        sb.append(this.subErrorCode);
        sb.append(", errorType: ");
        sb.append(this.errorType);
        sb.append(", errorMessage: ");
        sb.append(getErrorMessage());
        sb.append("}");
        return sb.toString();
    }

    static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        JSONObject jSONObject2 = jSONObject;
        String str5 = NativeProtocol.BRIDGE_ARG_ERROR_CODE;
        String str6 = "error";
        String str7 = GraphResponse.NON_JSON_RESPONSE_PROPERTY;
        String str8 = "body";
        String str9 = "code";
        try {
            if (jSONObject2.has(str9)) {
                int i3 = jSONObject2.getInt(str9);
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject2, str8, str7);
                if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                    JSONObject jSONObject3 = (JSONObject) stringPropertyAsJSON;
                    boolean has = jSONObject3.has(str6);
                    boolean z2 = true;
                    String str10 = NativeProtocol.BRIDGE_ARG_ERROR_SUBCODE;
                    if (has) {
                        JSONObject jSONObject4 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject3, str6, null);
                        String optString = jSONObject4.optString("type", null);
                        String optString2 = jSONObject4.optString(SettingsJsonConstants.PROMPT_MESSAGE_KEY, null);
                        i2 = jSONObject4.optInt(str9, -1);
                        int optInt = jSONObject4.optInt(str10, -1);
                        str2 = jSONObject4.optString("error_user_msg", null);
                        str = jSONObject4.optString("error_user_title", null);
                        z = jSONObject4.optBoolean("is_transient", false);
                        str3 = optString2;
                        i = optInt;
                        str4 = optString;
                    } else {
                        String str11 = "error_msg";
                        String str12 = "error_reason";
                        if (!jSONObject3.has(str5)) {
                            if (!jSONObject3.has(str11)) {
                                if (!jSONObject3.has(str12)) {
                                    str4 = null;
                                    str3 = null;
                                    str2 = null;
                                    str = null;
                                    i2 = -1;
                                    i = -1;
                                    z2 = false;
                                    z = false;
                                }
                            }
                        }
                        String optString3 = jSONObject3.optString(str12, null);
                        String optString4 = jSONObject3.optString(str11, null);
                        int optInt2 = jSONObject3.optInt(str5, -1);
                        i = jSONObject3.optInt(str10, -1);
                        str4 = optString3;
                        str3 = optString4;
                        str2 = null;
                        str = null;
                        z = false;
                        i2 = optInt2;
                    }
                    if (z2) {
                        FacebookRequestError facebookRequestError = new FacebookRequestError(i3, i2, i, str4, str3, str, str2, z, jSONObject3, jSONObject, obj, httpURLConnection, null);
                        return facebookRequestError;
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i3)) {
                    FacebookRequestError facebookRequestError2 = new FacebookRequestError(i3, -1, -1, null, null, null, null, false, jSONObject2.has(str8) ? (JSONObject) Utility.getStringPropertyAsJSON(jSONObject2, str8, str7) : null, jSONObject, obj, httpURLConnection, null);
                    return facebookRequestError2;
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    static synchronized FacebookRequestErrorClassification getErrorClassification() {
        synchronized (FacebookRequestError.class) {
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                FacebookRequestErrorClassification defaultErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
                return defaultErrorClassification;
            }
            FacebookRequestErrorClassification errorClassification = appSettingsWithoutQuery.getErrorClassification();
            return errorClassification;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }
}
