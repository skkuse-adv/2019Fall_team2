package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.os.EnvironmentCompat;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.kakao.message.template.MessageTemplateProtocol;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility {
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static long availableExternalStorageGB = -1;
    private static String carrierName = "NoCarrier";
    private static String deviceTimeZoneName = "";
    private static String deviceTimezoneAbbreviation = "";
    private static int numCPUCores = 0;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;

    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    public interface Mapper<T, K> {
        K apply(T t);
    }

    public static class PermissionsPair {
        List<String> declinedPermissions;
        List<String> grantedPermissions;

        public PermissionsPair(List<String> list, List<String> list2) {
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
        }

        public List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }
    }

    public interface Predicate<T> {
        boolean apply(T t);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x000e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] intersectRanges(int[] r10, int[] r11) {
        /*
            if (r10 != 0) goto L_0x0003
            return r11
        L_0x0003:
            if (r11 != 0) goto L_0x0006
            return r10
        L_0x0006:
            int r0 = r10.length
            int r1 = r11.length
            int r0 = r0 + r1
            int[] r0 = new int[r0]
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x000e:
            int r4 = r10.length
            if (r1 >= r4) goto L_0x0068
            int r4 = r11.length
            if (r2 >= r4) goto L_0x0068
            r4 = r10[r1]
            r5 = r11[r2]
            int r6 = r10.length
            int r6 = r6 + -1
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r6) goto L_0x0025
            int r6 = r1 + 1
            r6 = r10[r6]
            goto L_0x0028
        L_0x0025:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x0028:
            int r8 = r11.length
            int r8 = r8 + -1
            if (r2 >= r8) goto L_0x0032
            int r8 = r2 + 1
            r8 = r11[r8]
            goto L_0x0035
        L_0x0032:
            r8 = 2147483647(0x7fffffff, float:NaN)
        L_0x0035:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 >= r5) goto L_0x0048
            if (r6 <= r5) goto L_0x0045
            if (r6 <= r8) goto L_0x0041
            int r2 = r2 + 2
            r4 = r5
            goto L_0x0051
        L_0x0041:
            int r1 = r1 + 2
            r4 = r5
            goto L_0x005a
        L_0x0045:
            int r1 = r1 + 2
            goto L_0x0055
        L_0x0048:
            if (r8 <= r4) goto L_0x0053
            if (r8 <= r6) goto L_0x004f
            int r1 = r1 + 2
            goto L_0x005a
        L_0x004f:
            int r2 = r2 + 2
        L_0x0051:
            r6 = r8
            goto L_0x005a
        L_0x0053:
            int r2 = r2 + 2
        L_0x0055:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x005a:
            if (r4 == r9) goto L_0x000e
            int r5 = r3 + 1
            r0[r3] = r4
            if (r6 == r7) goto L_0x0067
            int r3 = r5 + 1
            r0[r5] = r6
            goto L_0x000e
        L_0x0067:
            r3 = r5
        L_0x0068:
            int[] r10 = java.util.Arrays.copyOf(r0, r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.intersectRanges(int[], int[]):int[]");
    }

    public static <T> boolean isSubset(Collection<T> collection, Collection<T> collection2) {
        boolean z = false;
        if (collection2 == null || collection2.size() == 0) {
            if (collection == null || collection.size() == 0) {
                z = true;
            }
            return z;
        }
        HashSet hashSet = new HashSet(collection2);
        for (T contains : collection) {
            if (!hashSet.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    public static <T> Collection<T> unmodifiableCollection(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    public static <T> ArrayList<T> arrayList(T... tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static <T> HashSet<T> hashSet(T... tArr) {
        HashSet<T> hashSet = new HashSet<>(tArr.length);
        for (T add : tArr) {
            hashSet.add(add);
        }
        return hashSet;
    }

    public static String md5hash(String str) {
        return hashWithAlgorithm("MD5", str);
    }

    public static String sha1hash(String str) {
        return hashWithAlgorithm(CommonUtils.SHA1_INSTANCE, str);
    }

    public static String sha1hash(byte[] bArr) {
        return hashWithAlgorithm(CommonUtils.SHA1_INSTANCE, bArr);
    }

    private static String hashWithAlgorithm(String str, String str2) {
        return hashWithAlgorithm(str, str2.getBytes());
    }

    private static String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            return hashBytes(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        return sb.toString();
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

    public static Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    String str2 = "UTF-8";
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], str2), URLDecoder.decode(split2[1], str2));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], str2), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    logd("FacebookSDK", (Exception) e);
                }
            }
        }
        return bundle;
    }

    public static void putNonEmptyString(Bundle bundle, String str, String str2) {
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    public static void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (String append : list) {
                sb.append(append);
                sb.append(",");
            }
            bundle.putString(str, sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
        }
    }

    public static void putUri(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    public static boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.remove(str);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
        } else if (!(obj instanceof JSONObject)) {
            return false;
        } else {
            bundle.putString(str, obj.toString());
        }
        return true;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        FacebookSdk.sdkInitialize(context);
        return FacebookSdk.getApplicationId();
    }

    public static Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb.append(cArr, 0, read);
                        } else {
                            String sb2 = sb.toString();
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int copyAndCloseInputStream(java.io.InputStream r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0023 }
            r1.<init>(r6)     // Catch:{ all -> 0x0023 }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0021 }
            r2 = 0
            r3 = 0
        L_0x000c:
            int r4 = r1.read(r0)     // Catch:{ all -> 0x0021 }
            r5 = -1
            if (r4 == r5) goto L_0x0018
            r7.write(r0, r2, r4)     // Catch:{ all -> 0x0021 }
            int r3 = r3 + r4
            goto L_0x000c
        L_0x0018:
            r1.close()
            if (r6 == 0) goto L_0x0020
            r6.close()
        L_0x0020:
            return r3
        L_0x0021:
            r7 = move-exception
            goto L_0x0025
        L_0x0023:
            r7 = move-exception
            r1 = r0
        L_0x0025:
            if (r1 == 0) goto L_0x002a
            r1.close()
        L_0x002a:
            if (r6 == 0) goto L_0x002f
            r6.close()
        L_0x002f:
            goto L_0x0031
        L_0x0030:
            throw r7
        L_0x0031:
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.copyAndCloseInputStream(java.io.InputStream, java.io.OutputStream):int");
    }

    public static boolean stringsEqualOrEmpty(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            return true;
        }
        if (isEmpty || isEmpty2) {
            return false;
        }
        return str.equals(str2);
    }

    private static void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            for (String split : cookie.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(split2[0].trim());
                    sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                    instance.setCookie(str, sb.toString());
                }
            }
            instance.removeExpiredCookie();
        }
    }

    public static void clearFacebookCookies(Context context) {
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
    }

    public static void logd(String str, Exception exc) {
        if (FacebookSdk.isDebugEnabled() && str != null && exc != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(exc.getClass().getSimpleName());
            sb.append(": ");
            sb.append(exc.getMessage());
            sb.toString();
        }
    }

    public static void logd(String str, String str2) {
        boolean isDebugEnabled = FacebookSdk.isDebugEnabled();
    }

    public static void logd(String str, String str2, Throwable th) {
        if (FacebookSdk.isDebugEnabled()) {
            boolean isNullOrEmpty = isNullOrEmpty(str);
        }
    }

    public static <T> boolean areObjectsEqual(T t, T t2) {
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }

    public static boolean hasSameId(JSONObject jSONObject, JSONObject jSONObject2) {
        if (!(jSONObject == null || jSONObject2 == null)) {
            String str = "id";
            if (jSONObject.has(str) && jSONObject2.has(str)) {
                if (jSONObject.equals(jSONObject2)) {
                    return true;
                }
                String optString = jSONObject.optString(str);
                String optString2 = jSONObject2.optString(str);
                if (!(optString == null || optString2 == null)) {
                    return optString.equals(optString2);
                }
            }
        }
        return false;
    }

    public static String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        String str2 = "";
        return jSONObject != null ? jSONObject.optString(str, str2) : str2;
    }

    public static JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public static JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    public static void clearCaches(Context context) {
        ImageDownloader.clearCache(context);
    }

    public static void deleteDirectory(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File deleteDirectory : listFiles) {
                        deleteDirectory(deleteDirectory);
                    }
                }
            }
            file.delete();
        }
    }

    public static <T> List<T> asListNoNulls(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static List<String> jsonArrayToStringList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static Set<String> jsonArrayToSet(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return hashSet;
    }

    public static void setAppEventAttributionParameters(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) throws JSONException {
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAttributionId() == null)) {
            jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
            jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
            jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidInstallerPackage() == null)) {
            jSONObject.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
        }
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", !z);
    }

    public static void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) throws JSONException {
        String str;
        Locale locale;
        int i;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i2 = 0;
        int i3 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i3 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (NameNotFoundException unused) {
            str = "";
        }
        jSONArray.put(packageName);
        jSONArray.put(i3);
        jSONArray.put(str);
        jSONArray.put(VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale = Locale.getDefault();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        sb.append("_");
        sb.append(locale.getCountry());
        jSONArray.put(sb.toString());
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
                try {
                    i2 = displayMetrics.heightPixels;
                    d = (double) displayMetrics.density;
                } catch (Exception unused3) {
                }
                jSONArray.put(i);
                jSONArray.put(i2);
                jSONArray.put(new DecimalFormat("#.##").format(d));
                jSONArray.put(refreshBestGuessNumberOfCPUCores());
                jSONArray.put(totalExternalStorageGB);
                jSONArray.put(availableExternalStorageGB);
                jSONArray.put(deviceTimeZoneName);
                jSONObject.put("extinfo", jSONArray.toString());
            }
        } catch (Exception unused4) {
        }
        i = 0;
        jSONArray.put(i);
        jSONArray.put(i2);
        jSONArray.put(new DecimalFormat("#.##").format(d));
        jSONArray.put(refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        try {
            return getMethodQuietly(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return context.getClass().getSimpleName();
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> list2 = null;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (predicate.apply(next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() != 0) {
            list2 = arrayList;
        }
        return list2;
    }

    public static <T, K> List<K> map(List<T> list, Mapper<T, K> mapper) {
        List<K> list2 = null;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T apply : list) {
            Object apply2 = mapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        if (arrayList.size() != 0) {
            list2 = arrayList;
        }
        return list2;
    }

    public static String getUriString(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        if ("fbstaging".equalsIgnoreCase(r2.getScheme()) != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isWebUri(android.net.Uri r2) {
        /*
            if (r2 == 0) goto L_0x0028
            java.lang.String r0 = r2.getScheme()
            java.lang.String r1 = "http"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r2.getScheme()
            java.lang.String r1 = "https"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0026
            java.lang.String r2 = r2.getScheme()
            java.lang.String r0 = "fbstaging"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0028
        L_0x0026:
            r2 = 1
            goto L_0x0029
        L_0x0028:
            r2 = 0
        L_0x0029:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.isWebUri(android.net.Uri):boolean");
    }

    public static boolean isContentUri(Uri uri) {
        if (uri != null) {
            if (MessageTemplateProtocol.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFileUri(Uri uri) {
        if (uri != null) {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return true;
            }
        }
        return false;
    }

    public static long getContentSize(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = FacebookSdk.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            return cursor.getLong(columnIndex);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long j;
        Date date2 = null;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            j = ((Long) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    j = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return date2;
        }
        if (j == 0) {
            return new Date(Long.MAX_VALUE);
        }
        date2 = new Date(date.getTime() + (j * 1000));
        return date2;
    }

    public static void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    public static Map<String, String> readStringMapFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    public static boolean isCurrentAccessToken(AccessToken accessToken) {
        return accessToken != null && accessToken.equals(AccessToken.getCurrentAccessToken());
    }

    public static void getGraphMeRequestWithCacheAsync(final String str, final GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            return;
        }
        AnonymousClass1 r0 = new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (graphResponse.getError() != null) {
                    graphMeRequestWithCacheCallback.onFailure(graphResponse.getError().getException());
                    return;
                }
                ProfileInformationCache.putProfileInformation(str, graphResponse.getJSONObject());
                graphMeRequestWithCacheCallback.onSuccess(graphResponse.getJSONObject());
            }
        };
        GraphRequest graphMeRequestWithCache = getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(r0);
        graphMeRequestWithCache.executeAsync();
    }

    public static JSONObject awaitGetGraphMeRequestWithCache(String str) {
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJSONObject();
    }

    private static GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        GraphRequest graphRequest = new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
        return graphRequest;
    }

    private static int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]+", str);
                }
            });
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    private static void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private static void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            deviceTimezoneAbbreviation = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            deviceTimeZoneName = timeZone.getID();
        } catch (AssertionError | Exception unused) {
        }
    }

    private static void refreshCarrierName(Context context) {
        if (carrierName.equals("NoCarrier")) {
            try {
                carrierName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception unused) {
            }
        }
    }

    private static boolean externalStorageExists() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            availableExternalStorageGB = convertBytesToGB((double) availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private static void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            totalExternalStorageGB = convertBytesToGB((double) totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private static long convertBytesToGB(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    public static PermissionsPair handlePermissionResponse(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("permission");
            if (optString != null && !optString.equals("installed")) {
                String optString2 = optJSONObject.optString("status");
                if (optString2 != null) {
                    if (optString2.equals("granted")) {
                        arrayList.add(optString);
                    } else if (optString2.equals("declined")) {
                        arrayList2.add(optString);
                    }
                }
            }
        }
        return new PermissionsPair(arrayList, arrayList2);
    }

    public static String generateRandomString(int i) {
        return new BigInteger(i * 5, new Random()).toString(32);
    }

    public static boolean mustFixWindowParamsForAutofill(Context context) {
        return isAutofillAvailable(context);
    }

    public static boolean isAutofillAvailable(Context context) {
        boolean z = false;
        if (VERSION.SDK_INT < 26) {
            return false;
        }
        AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        if (autofillManager != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            z = true;
        }
        return z;
    }

    public static boolean isChromeOS(Context context) {
        if (VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        return str != null && str.matches(".+_cheets|cheets_.+");
    }

    public static Locale getCurrentLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return Locale.getDefault();
        }
    }
}
