package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsIntent.Builder;
import com.facebook.FacebookSdk;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        String dialogAuthority = ServerProtocol.getDialogAuthority();
        StringBuilder sb = new StringBuilder();
        sb.append(FacebookSdk.getGraphApiVersion());
        sb.append("/");
        sb.append(ServerProtocol.DIALOG_PATH);
        sb.append(str);
        this.uri = Utility.buildUri(dialogAuthority, sb.toString(), bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        CustomTabsIntent build = new Builder().build();
        build.intent.setPackage(str);
        build.intent.addFlags(1073741824);
        build.launchUrl(activity, this.uri);
    }
}
