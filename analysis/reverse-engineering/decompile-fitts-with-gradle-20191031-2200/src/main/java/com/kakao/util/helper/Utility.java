package com.kakao.util.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import com.kakao.util.exception.KakaoException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;

public final class Utility {
    private static final String TAG = "com.kakao.util.helper.Utility";

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static Uri buildUri(String str, String str2) {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        return builder.build();
    }

    public static Uri buildUri(String str, String str2, Bundle bundle) {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        return builder.build();
    }

    public static String buildQueryString(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    public static void putObjectInBundle(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else {
            throw new KakaoException("attempted to add unsupported type to Bundle");
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Argument '");
            sb.append(str);
            sb.append("' cannot be null");
            throw new NullPointerException(sb.toString());
        }
    }

    public static String getMetadata(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return null;
            }
            return applicationInfo.metaData.getString(str);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean getBooleanMetadata(Context context, String str, boolean z) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return z;
            }
            return applicationInfo.metaData.getBoolean(str, z);
        } catch (NameNotFoundException unused) {
            return z;
        }
    }

    public static ResolveInfo resolveIntent(Context context, Intent intent) {
        return context.getPackageManager().resolveActivity(intent, 0);
    }

    public static PackageInfo getPackageInfo(Context context) {
        return getPackageInfo(context, 0);
    }

    public static PackageInfo getPackageInfo(Context context, int i) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isPackageInstalled(Context context, String str) {
        return context.getPackageManager().getLaunchIntentForPackage(str) != null;
    }

    public static int getAppVersion(Context context) {
        return getPackageInfo(context).versionCode;
    }

    public static String getAppPackageName(Context context) {
        return getPackageInfo(context).packageName;
    }

    public static String getKeyHash(Context context) {
        PackageInfo packageInfo = getPackageInfo(context, 64);
        if (packageInfo == null) {
            return null;
        }
        Signature[] signatureArr = packageInfo.signatures;
        int length = signatureArr.length;
        int i = 0;
        while (i < length) {
            Signature signature = signatureArr[i];
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(signature.toByteArray());
                return Base64.encodeToString(instance.digest(), 2);
            } catch (NoSuchAlgorithmException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to get MessageDigest. signature=");
                sb.append(signature);
                sb.toString();
                i++;
            }
        }
        return null;
    }

    public static boolean isUsablePermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
