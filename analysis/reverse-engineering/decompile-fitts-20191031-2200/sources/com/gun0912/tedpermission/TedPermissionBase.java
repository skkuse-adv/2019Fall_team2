package com.gun0912.tedpermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public abstract class TedPermissionBase {
    public static final int REQ_CODE_REQUEST_SETTING = 2000;

    public static boolean isGranted(Context context, @NonNull String... strArr) {
        for (String isDenied : strArr) {
            if (isDenied(context, isDenied)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDenied(Context context, @NonNull String str) {
        return !isGranted(context, str);
    }

    private static boolean isGranted(Context context, @NonNull String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static ArrayList<String> getDeniedPermissions(Context context, @NonNull String... strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strArr) {
            if (isDenied(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean canRequestPermission(Activity activity, @NonNull String... strArr) {
        if (isFirstRequest((Context) activity, strArr)) {
            return true;
        }
        for (String str : strArr) {
            boolean shouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
            if (isDenied(activity, str) && !shouldShowRequestPermissionRationale) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFirstRequest(Context context, @NonNull String[] strArr) {
        for (String isFirstRequest : strArr) {
            if (!isFirstRequest(context, isFirstRequest)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFirstRequest(Context context, String str) {
        return getSharedPreferences(context).getBoolean(getPrefsNamePermission(str), true);
    }

    private static String getPrefsNamePermission(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("IS_FIRST_REQUEST_");
        sb.append(str);
        return sb.toString();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("PREFS_NAME_PERMISSION", 0);
    }

    public static void startSettingActivityForResult(Activity activity) {
        startSettingActivityForResult(activity, (int) REQ_CODE_REQUEST_SETTING);
    }

    public static void startSettingActivityForResult(Activity activity, int i) {
        activity.startActivityForResult(getSettingIntent(activity), i);
    }

    private static Intent getSettingIntent(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(context.getPackageName());
        return intent.setData(Uri.parse(sb.toString()));
    }

    public static void startSettingActivityForResult(Fragment fragment) {
        startSettingActivityForResult(fragment, (int) REQ_CODE_REQUEST_SETTING);
    }

    public static void startSettingActivityForResult(Fragment fragment, int i) {
        fragment.startActivityForResult(getSettingIntent(fragment.getActivity()), i);
    }

    static void setFirstRequest(Context context, @NonNull String[] strArr) {
        for (String firstRequest : strArr) {
            setFirstRequest(context, firstRequest);
        }
    }

    private static void setFirstRequest(Context context, String str) {
        getSharedPreferences(context).edit().putBoolean(getPrefsNamePermission(str), false).apply();
    }
}
