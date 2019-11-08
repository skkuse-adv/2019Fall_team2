package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient.Request;

class FacebookLiteLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<FacebookLiteLoginMethodHandler> CREATOR = new Creator<FacebookLiteLoginMethodHandler>() {
        public FacebookLiteLoginMethodHandler createFromParcel(Parcel parcel) {
            return new FacebookLiteLoginMethodHandler(parcel);
        }

        public FacebookLiteLoginMethodHandler[] newArray(int i) {
            return new FacebookLiteLoginMethodHandler[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public String getNameForLogging() {
        return "fb_lite_login";
    }

    FacebookLiteLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: 0000 */
    public boolean tryAuthorize(Request request) {
        String e2e = LoginClient.getE2E();
        Intent createFacebookLiteIntent = NativeProtocol.createFacebookLiteIntent(this.loginClient.getActivity(), request.getApplicationId(), request.getPermissions(), e2e, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType());
        addLoggingExtra("e2e", e2e);
        return tryIntent(createFacebookLiteIntent, LoginClient.getLoginRequestCode());
    }

    FacebookLiteLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
