package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final String LAST_NAME = "ln";
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    /* access modifiers changed from: private */
    public static final String TAG = "UserDataStore";
    public static final String ZIP = "zp";
    /* access modifiers changed from: private */
    public static ConcurrentHashMap<String, String> hashedUserData;
    /* access modifiers changed from: private */
    public static AtomicBoolean initialized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static SharedPreferences sharedPreferences;

    static void initStore() {
        if (!initialized.get()) {
            initAndWait();
        }
    }

    static void setUserDataAndHash(final Bundle bundle) {
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                if (!UserDataStore.initialized.get()) {
                    UserDataStore.TAG;
                    UserDataStore.initAndWait();
                }
                UserDataStore.updateHashUserData(bundle);
                UserDataStore.sharedPreferences.edit().putString("com.facebook.appevents.UserDataStore.userData", UserDataStore.mapToJsonStr(UserDataStore.hashedUserData)).apply();
            }
        });
    }

    static void setUserDataAndHash(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(EMAIL, str);
        }
        if (str2 != null) {
            bundle.putString(FIRST_NAME, str2);
        }
        if (str3 != null) {
            bundle.putString(LAST_NAME, str3);
        }
        if (str4 != null) {
            bundle.putString(PHONE, str4);
        }
        if (str5 != null) {
            bundle.putString(DATE_OF_BIRTH, str5);
        }
        if (str6 != null) {
            bundle.putString(GENDER, str6);
        }
        if (str7 != null) {
            bundle.putString(CITY, str7);
        }
        if (str8 != null) {
            bundle.putString(STATE, str8);
        }
        if (str9 != null) {
            bundle.putString(ZIP, str9);
        }
        if (str10 != null) {
            bundle.putString(COUNTRY, str10);
        }
        setUserDataAndHash(bundle);
    }

    static void clear() {
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                if (!UserDataStore.initialized.get()) {
                    UserDataStore.TAG;
                    UserDataStore.initAndWait();
                }
                UserDataStore.hashedUserData.clear();
                UserDataStore.sharedPreferences.edit().putString("com.facebook.appevents.UserDataStore.userData", null).apply();
            }
        });
    }

    static String getHashedUserData() {
        if (!initialized.get()) {
            initAndWait();
        }
        return mapToJsonStr(hashedUserData);
    }

    /* access modifiers changed from: private */
    public static synchronized void initAndWait() {
        synchronized (UserDataStore.class) {
            if (!initialized.get()) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                hashedUserData = new ConcurrentHashMap<>(JsonStrToMap(sharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", "")));
                initialized.set(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void updateHashUserData(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (maybeSHA256Hashed(obj2)) {
                        hashedUserData.put(str, obj2.toLowerCase());
                    } else {
                        String encryptData = encryptData(normalizeData(str, obj2));
                        if (encryptData != null) {
                            hashedUserData.put(str, encryptData);
                        }
                    }
                }
            }
        }
    }

    @Nullable
    private static String encryptData(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                MessageDigest instance = MessageDigest.getInstance(CommonUtils.SHA256_INSTANCE);
                instance.update(str.getBytes());
                return AppEventUtility.bytesToHex(instance.digest());
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    private static String normalizeData(String str, String str2) {
        String lowerCase = str2.trim().toLowerCase();
        String str3 = "";
        if (EMAIL.equals(str)) {
            return Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches() ? lowerCase : str3;
        }
        if (PHONE.equals(str)) {
            return lowerCase.replaceAll("[^0-9]", str3);
        }
        if (!GENDER.equals(str)) {
            return lowerCase;
        }
        String substring = lowerCase.length() > 0 ? lowerCase.substring(0, 1) : str3;
        return ("f".equals(substring) || "m".equals(substring)) ? substring : str3;
    }

    private static boolean maybeSHA256Hashed(String str) {
        return str.matches("[A-Fa-f0-9]{64}");
    }

    /* access modifiers changed from: private */
    public static String mapToJsonStr(Map<String, String> map) {
        String str = "";
        if (map.isEmpty()) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    private static Map<String, String> JsonStrToMap(String str) {
        if (str.isEmpty()) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.getString(str2));
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }
}
