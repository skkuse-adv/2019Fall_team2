package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;

class SourceApplicationInfo {
    private String callingApplicationPackage;
    private boolean openedByAppLink;

    private SourceApplicationInfo(String str, boolean z) {
        this.callingApplicationPackage = str;
        this.openedByAppLink = z;
    }

    public static SourceApplicationInfo getStoredSourceApplicatioInfo() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        String str = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
        if (!defaultSharedPreferences.contains(str)) {
            return null;
        }
        return new SourceApplicationInfo(defaultSharedPreferences.getString(str, null), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
    }

    public static void clearSavedSourceApplicationInfoFromDisk() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
        edit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
        edit.apply();
    }

    public String getCallingApplicationPackage() {
        return this.callingApplicationPackage;
    }

    public boolean isOpenedByAppLink() {
        return this.openedByAppLink;
    }

    public String toString() {
        String str = this.openedByAppLink ? "Applink" : "Unclassified";
        if (this.callingApplicationPackage == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("(");
        sb.append(this.callingApplicationPackage);
        sb.append(")");
        return sb.toString();
    }

    public void writeSourceApplicationInfoToDisk() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.callingApplicationPackage);
        edit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.openedByAppLink);
        edit.apply();
    }
}
