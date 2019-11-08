package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Creator<DeviceAuthMethodHandler> CREATOR = new Creator() {
        public DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
            return new DeviceAuthMethodHandler(parcel);
        }

        public DeviceAuthMethodHandler[] newArray(int i) {
            return new DeviceAuthMethodHandler[i];
        }
    };
    private static ScheduledThreadPoolExecutor backgroundExecutor;

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public String getNameForLogging() {
        return "device_auth";
    }

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: 0000 */
    public boolean tryAuthorize(Request request) {
        showDialog(request);
        return true;
    }

    private void showDialog(Request request) {
        FragmentActivity activity = this.loginClient.getActivity();
        if (activity != null && !activity.isFinishing()) {
            DeviceAuthDialog createDeviceAuthDialog = createDeviceAuthDialog();
            createDeviceAuthDialog.show(activity.getSupportFragmentManager(), "login_with_facebook");
            createDeviceAuthDialog.startLogin(request);
        }
    }

    /* access modifiers changed from: protected */
    public DeviceAuthDialog createDeviceAuthDialog() {
        return new DeviceAuthDialog();
    }

    public void onCancel() {
        this.loginClient.completeAndValidate(Result.createCancelResult(this.loginClient.getPendingRequest(), "User canceled log in."));
    }

    public void onError(Exception exc) {
        this.loginClient.completeAndValidate(Result.createErrorResult(this.loginClient.getPendingRequest(), null, exc.getMessage()));
    }

    public void onSuccess(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        AccessToken accessToken = new AccessToken(str, str2, str3, collection, collection2, accessTokenSource, date, date2, date3);
        this.loginClient.completeAndValidate(Result.createTokenResult(this.loginClient.getPendingRequest(), accessToken));
    }

    public static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = backgroundExecutor;
        }
        return scheduledThreadPoolExecutor;
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
