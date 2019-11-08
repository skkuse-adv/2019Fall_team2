package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.FacebookSdk;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Locale;

public class ImageRequest {
    public static final int UNSPECIFIED_DIMENSION = 0;
    private boolean allowCachedRedirects;
    private Callback callback;
    private Object callerTag;
    private Context context;
    private Uri imageUri;

    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    public static Uri getProfilePictureUri(String str, int i, int i2) {
        Validate.notNullOrEmpty(str, "userId");
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (max == 0 && max2 == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        Builder path = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon().path(String.format(Locale.US, "%s/%s/picture", new Object[]{FacebookSdk.getGraphApiVersion(), str}));
        if (max2 != 0) {
            path.appendQueryParameter(SettingsJsonConstants.ICON_HEIGHT_KEY, String.valueOf(max2));
        }
        if (max != 0) {
            path.appendQueryParameter(SettingsJsonConstants.ICON_WIDTH_KEY, String.valueOf(max));
        }
        path.appendQueryParameter("migration_overrides", "{october_2012:true}");
        return path.build();
    }

    public Context getContext() {
        return this.context;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    public Object getCallerTag() {
        return this.callerTag;
    }
}
