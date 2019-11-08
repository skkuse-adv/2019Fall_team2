package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.common.R$string;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new Creator<LoginClient>() {
        public LoginClient createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        public LoginClient[] newArray(int i) {
            return new LoginClient[i];
        }
    };
    BackgroundProcessingListener backgroundProcessingListener;
    boolean checkedInternetPermission;
    int currentHandler = -1;
    Map<String, String> extraData;
    Fragment fragment;
    LoginMethodHandler[] handlersToTry;
    Map<String, String> loggingExtras;
    private LoginLogger loginLogger;
    OnCompletedListener onCompletedListener;
    Request pendingRequest;

    interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    public static class Request implements Parcelable {
        public static final Creator<Request> CREATOR = new Creator<Request>() {
            public Request createFromParcel(Parcel parcel) {
                return new Request(parcel);
            }

            public Request[] newArray(int i) {
                return new Request[i];
            }
        };
        private final String applicationId;
        private final String authId;
        private String authType;
        private final DefaultAudience defaultAudience;
        private String deviceAuthTargetUserId;
        private String deviceRedirectUriString;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private Set<String> permissions;

        public int describeContents() {
            return 0;
        }

        Request(LoginBehavior loginBehavior2, Set<String> set, DefaultAudience defaultAudience2, String str, String str2, String str3) {
            this.isRerequest = false;
            this.loginBehavior = loginBehavior2;
            if (set == null) {
                set = new HashSet<>();
            }
            this.permissions = set;
            this.defaultAudience = defaultAudience2;
            this.authType = str;
            this.applicationId = str2;
            this.authId = str3;
        }

        /* access modifiers changed from: 0000 */
        public Set<String> getPermissions() {
            return this.permissions;
        }

        /* access modifiers changed from: 0000 */
        public void setPermissions(Set<String> set) {
            Validate.notNull(set, "permissions");
            this.permissions = set;
        }

        /* access modifiers changed from: 0000 */
        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        /* access modifiers changed from: 0000 */
        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        /* access modifiers changed from: 0000 */
        public String getApplicationId() {
            return this.applicationId;
        }

        /* access modifiers changed from: 0000 */
        public String getAuthId() {
            return this.authId;
        }

        /* access modifiers changed from: 0000 */
        public boolean isRerequest() {
            return this.isRerequest;
        }

        /* access modifiers changed from: 0000 */
        public void setRerequest(boolean z) {
            this.isRerequest = z;
        }

        /* access modifiers changed from: 0000 */
        public String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        /* access modifiers changed from: 0000 */
        public String getDeviceAuthTargetUserId() {
            return this.deviceAuthTargetUserId;
        }

        /* access modifiers changed from: 0000 */
        public String getAuthType() {
            return this.authType;
        }

        /* access modifiers changed from: 0000 */
        public boolean hasPublishPermission() {
            for (String isPublishPermission : this.permissions) {
                if (LoginManager.isPublishPermission(isPublishPermission)) {
                    return true;
                }
            }
            return false;
        }

        private Request(Parcel parcel) {
            boolean z = false;
            this.isRerequest = false;
            String readString = parcel.readString();
            DefaultAudience defaultAudience2 = null;
            this.loginBehavior = readString != null ? LoginBehavior.valueOf(readString) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String readString2 = parcel.readString();
            if (readString2 != null) {
                defaultAudience2 = DefaultAudience.valueOf(readString2);
            }
            this.defaultAudience = defaultAudience2;
            this.applicationId = parcel.readString();
            this.authId = parcel.readString();
            if (parcel.readByte() != 0) {
                z = true;
            }
            this.isRerequest = z;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = parcel.readString();
            this.deviceAuthTargetUserId = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            LoginBehavior loginBehavior2 = this.loginBehavior;
            String str = null;
            parcel.writeString(loginBehavior2 != null ? loginBehavior2.name() : null);
            parcel.writeStringList(new ArrayList(this.permissions));
            DefaultAudience defaultAudience2 = this.defaultAudience;
            if (defaultAudience2 != null) {
                str = defaultAudience2.name();
            }
            parcel.writeString(str);
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte(this.isRerequest ? (byte) 1 : 0);
            parcel.writeString(this.deviceRedirectUriString);
            parcel.writeString(this.authType);
            parcel.writeString(this.deviceAuthTargetUserId);
        }
    }

    public static class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new Creator<Result>() {
            public Result createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public Result[] newArray(int i) {
                return new Result[i];
            }
        };
        final Code code;
        final String errorCode;
        final String errorMessage;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;
        final Request request;
        final AccessToken token;

        enum Code {
            SUCCESS(GraphResponse.SUCCESS_KEY),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String loggingValue;

            private Code(String str) {
                this.loggingValue = str;
            }

            /* access modifiers changed from: 0000 */
            public String getLoggingValue() {
                return this.loggingValue;
            }
        }

        public int describeContents() {
            return 0;
        }

        Result(Request request2, Code code2, AccessToken accessToken, String str, String str2) {
            Validate.notNull(code2, "code");
            this.request = request2;
            this.token = accessToken;
            this.errorMessage = str;
            this.code = code2;
            this.errorCode = str2;
        }

        static Result createTokenResult(Request request2, AccessToken accessToken) {
            Result result = new Result(request2, Code.SUCCESS, accessToken, null, null);
            return result;
        }

        static Result createCancelResult(Request request2, String str) {
            Result result = new Result(request2, Code.CANCEL, null, str, null);
            return result;
        }

        static Result createErrorResult(Request request2, String str, String str2) {
            return createErrorResult(request2, str, str2, null);
        }

        static Result createErrorResult(Request request2, String str, String str2, String str3) {
            String[] strArr = {str, str2};
            Request request3 = request2;
            Result result = new Result(request3, Code.ERROR, null, TextUtils.join(": ", Utility.asListNoNulls(strArr)), str3);
            return result;
        }

        private Result(Parcel parcel) {
            this.code = Code.valueOf(parcel.readString());
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readStringMapFromParcel(parcel);
            this.extraData = Utility.readStringMapFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.code.name());
            parcel.writeParcelable(this.token, i);
            parcel.writeString(this.errorMessage);
            parcel.writeString(this.errorCode);
            parcel.writeParcelable(this.request, i);
            Utility.writeStringMapToParcel(parcel, this.loggingExtras);
            Utility.writeStringMapToParcel(parcel, this.extraData);
        }
    }

    public int describeContents() {
        return 0;
    }

    public LoginClient(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    /* access modifiers changed from: 0000 */
    public void setFragment(Fragment fragment2) {
        if (this.fragment == null) {
            this.fragment = fragment2;
            return;
        }
        throw new FacebookException("Can't set fragment once it is already set.");
    }

    /* access modifiers changed from: 0000 */
    public FragmentActivity getActivity() {
        return this.fragment.getActivity();
    }

    public Request getPendingRequest() {
        return this.pendingRequest;
    }

    public static int getLoginRequestCode() {
        return RequestCodeOffset.Login.toRequestCode();
    }

    /* access modifiers changed from: 0000 */
    public void startOrContinueAuth(Request request) {
        if (!getInProgress()) {
            authorize(request);
        }
    }

    /* access modifiers changed from: 0000 */
    public void authorize(Request request) {
        if (request != null) {
            if (this.pendingRequest != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            } else if (!AccessToken.isCurrentAccessTokenActive() || checkInternetPermission()) {
                this.pendingRequest = request;
                this.handlersToTry = getHandlersToTry(request);
                tryNextHandler();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    /* access modifiers changed from: 0000 */
    public void cancelCurrentHandler() {
        if (this.currentHandler >= 0) {
            getCurrentHandler().cancel();
        }
    }

    /* access modifiers changed from: 0000 */
    public LoginMethodHandler getCurrentHandler() {
        int i = this.currentHandler;
        if (i >= 0) {
            return this.handlersToTry[i];
        }
        return null;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.pendingRequest != null) {
            return getCurrentHandler().onActivityResult(i, i2, intent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public LoginMethodHandler[] getHandlersToTry(Request request) {
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (loginBehavior.allowsGetTokenAuth()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
        }
        if (loginBehavior.allowsKatanaAuth()) {
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (loginBehavior.allowsFacebookLiteAuth()) {
            arrayList.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (loginBehavior.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (loginBehavior.allowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        return loginMethodHandlerArr;
    }

    /* access modifiers changed from: 0000 */
    public boolean checkInternetPermission() {
        if (this.checkedInternetPermission) {
            return true;
        }
        if (checkPermission("android.permission.INTERNET") != 0) {
            FragmentActivity activity = getActivity();
            complete(Result.createErrorResult(this.pendingRequest, activity.getString(R$string.com_facebook_internet_permission_error_title), activity.getString(R$string.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.checkedInternetPermission = true;
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void tryNextHandler() {
        if (this.currentHandler >= 0) {
            logAuthorizationMethodComplete(getCurrentHandler().getNameForLogging(), "skipped", null, null, getCurrentHandler().methodLoggingExtras);
        }
        do {
            LoginMethodHandler[] loginMethodHandlerArr = this.handlersToTry;
            if (loginMethodHandlerArr != null) {
                int i = this.currentHandler;
                if (i < loginMethodHandlerArr.length - 1) {
                    this.currentHandler = i + 1;
                }
            }
            if (this.pendingRequest != null) {
                completeWithFailure();
            }
            return;
        } while (!tryCurrentHandler());
    }

    private void completeWithFailure() {
        complete(Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
    }

    private void addLoggingExtra(String str, String str2, boolean z) {
        if (this.loggingExtras == null) {
            this.loggingExtras = new HashMap();
        }
        if (this.loggingExtras.containsKey(str) && z) {
            StringBuilder sb = new StringBuilder();
            sb.append((String) this.loggingExtras.get(str));
            sb.append(",");
            sb.append(str2);
            str2 = sb.toString();
        }
        this.loggingExtras.put(str, str2);
    }

    /* access modifiers changed from: 0000 */
    public boolean tryCurrentHandler() {
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (!currentHandler2.needsInternetPermission() || checkInternetPermission()) {
            boolean tryAuthorize = currentHandler2.tryAuthorize(this.pendingRequest);
            if (tryAuthorize) {
                getLogger().logAuthorizationMethodStart(this.pendingRequest.getAuthId(), currentHandler2.getNameForLogging());
            } else {
                getLogger().logAuthorizationMethodNotTried(this.pendingRequest.getAuthId(), currentHandler2.getNameForLogging());
                addLoggingExtra("not_tried", currentHandler2.getNameForLogging(), true);
            }
            return tryAuthorize;
        }
        addLoggingExtra("no_internet_permission", "1", false);
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void completeAndValidate(Result result) {
        if (result.token == null || !AccessToken.isCurrentAccessTokenActive()) {
            complete(result);
        } else {
            validateSameFbidAndFinish(result);
        }
    }

    /* access modifiers changed from: 0000 */
    public void complete(Result result) {
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (currentHandler2 != null) {
            logAuthorizationMethodComplete(currentHandler2.getNameForLogging(), result, currentHandler2.methodLoggingExtras);
        }
        Map<String, String> map = this.loggingExtras;
        if (map != null) {
            result.loggingExtras = map;
        }
        Map<String, String> map2 = this.extraData;
        if (map2 != null) {
            result.extraData = map2;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        notifyOnCompleteListener(result);
    }

    /* access modifiers changed from: 0000 */
    public void setOnCompletedListener(OnCompletedListener onCompletedListener2) {
        this.onCompletedListener = onCompletedListener2;
    }

    /* access modifiers changed from: 0000 */
    public void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener2) {
        this.backgroundProcessingListener = backgroundProcessingListener2;
    }

    /* access modifiers changed from: 0000 */
    public int checkPermission(String str) {
        return getActivity().checkCallingOrSelfPermission(str);
    }

    /* access modifiers changed from: 0000 */
    public void validateSameFbidAndFinish(Result result) {
        Result result2;
        if (result.token != null) {
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            AccessToken accessToken = result.token;
            if (!(currentAccessToken == null || accessToken == null)) {
                try {
                    if (currentAccessToken.getUserId().equals(accessToken.getUserId())) {
                        result2 = Result.createTokenResult(this.pendingRequest, result.token);
                        complete(result2);
                        return;
                    }
                } catch (Exception e) {
                    complete(Result.createErrorResult(this.pendingRequest, "Caught exception", e.getMessage()));
                    return;
                }
            }
            result2 = Result.createErrorResult(this.pendingRequest, "User logged in as different Facebook user.", null);
            complete(result2);
            return;
        }
        throw new FacebookException("Can't validate without a token");
    }

    private LoginLogger getLogger() {
        LoginLogger loginLogger2 = this.loginLogger;
        if (loginLogger2 == null || !loginLogger2.getApplicationId().equals(this.pendingRequest.getApplicationId())) {
            this.loginLogger = new LoginLogger(getActivity(), this.pendingRequest.getApplicationId());
        }
        return this.loginLogger;
    }

    private void notifyOnCompleteListener(Result result) {
        OnCompletedListener onCompletedListener2 = this.onCompletedListener;
        if (onCompletedListener2 != null) {
            onCompletedListener2.onCompleted(result);
        }
    }

    /* access modifiers changed from: 0000 */
    public void notifyBackgroundProcessingStart() {
        BackgroundProcessingListener backgroundProcessingListener2 = this.backgroundProcessingListener;
        if (backgroundProcessingListener2 != null) {
            backgroundProcessingListener2.onBackgroundProcessingStarted();
        }
    }

    /* access modifiers changed from: 0000 */
    public void notifyBackgroundProcessingStop() {
        BackgroundProcessingListener backgroundProcessingListener2 = this.backgroundProcessingListener;
        if (backgroundProcessingListener2 != null) {
            backgroundProcessingListener2.onBackgroundProcessingStopped();
        }
    }

    private void logAuthorizationMethodComplete(String str, Result result, Map<String, String> map) {
        logAuthorizationMethodComplete(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
    }

    private void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.pendingRequest == null) {
            getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            getLogger().logAuthorizationMethodComplete(this.pendingRequest.getAuthId(), str, str2, str3, str4, map);
        }
    }

    static String getE2E() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public LoginClient(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.handlersToTry = new LoginMethodHandler[readParcelableArray.length];
        for (int i = 0; i < readParcelableArray.length; i++) {
            LoginMethodHandler[] loginMethodHandlerArr = this.handlersToTry;
            loginMethodHandlerArr[i] = (LoginMethodHandler) readParcelableArray[i];
            loginMethodHandlerArr[i].setLoginClient(this);
        }
        this.currentHandler = parcel.readInt();
        this.pendingRequest = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.loggingExtras = Utility.readStringMapFromParcel(parcel);
        this.extraData = Utility.readStringMapFromParcel(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.handlersToTry, i);
        parcel.writeInt(this.currentHandler);
        parcel.writeParcelable(this.pendingRequest, i);
        Utility.writeStringMapToParcel(parcel, this.loggingExtras);
        Utility.writeStringMapToParcel(parcel, this.extraData);
    }
}
