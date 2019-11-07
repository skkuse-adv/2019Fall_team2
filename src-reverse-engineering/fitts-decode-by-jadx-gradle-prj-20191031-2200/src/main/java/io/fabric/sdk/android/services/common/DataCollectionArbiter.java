package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class DataCollectionArbiter {
    private static DataCollectionArbiter instance;
    private static Object instanceLock = new Object();
    private volatile boolean crashlyticsDataCollectionEnabled;
    private volatile boolean crashlyticsDataCollectionExplicitlySet;
    private final FirebaseApp firebaseApp;
    private boolean isUnity = false;
    private final SharedPreferences sharedPreferences;

    public static DataCollectionArbiter getInstance(Context context) {
        DataCollectionArbiter dataCollectionArbiter;
        synchronized (instanceLock) {
            if (instance == null) {
                instance = new DataCollectionArbiter(context);
            }
            dataCollectionArbiter = instance;
        }
        return dataCollectionArbiter;
    }

    public static void resetForTesting(Context context) {
        synchronized (instanceLock) {
            instance = new DataCollectionArbiter(context);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DataCollectionArbiter(android.content.Context r7) {
        /*
            r6 = this;
            r6.<init>()
            r0 = 0
            r6.isUnity = r0
            if (r7 == 0) goto L_0x006a
            java.lang.String r1 = "com.google.firebase.crashlytics.prefs"
            android.content.SharedPreferences r1 = r7.getSharedPreferences(r1, r0)
            r6.sharedPreferences = r1
            io.fabric.sdk.android.services.common.FirebaseApp r1 = io.fabric.sdk.android.services.common.FirebaseAppImpl.getInstance(r7)
            r6.firebaseApp = r1
            android.content.SharedPreferences r1 = r6.sharedPreferences
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r1 = r1.contains(r2)
            r3 = 1
            if (r1 == 0) goto L_0x0029
            android.content.SharedPreferences r1 = r6.sharedPreferences
            boolean r1 = r1.getBoolean(r2, r3)
        L_0x0027:
            r2 = 1
            goto L_0x005c
        L_0x0029:
            android.content.pm.PackageManager r1 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x004e }
            if (r1 == 0) goto L_0x005a
            java.lang.String r4 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x004e }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r1 == 0) goto L_0x005a
            android.os.Bundle r4 = r1.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            if (r4 == 0) goto L_0x005a
            android.os.Bundle r4 = r1.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            boolean r4 = r4.containsKey(r2)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r4 == 0) goto L_0x005a
            android.os.Bundle r1 = r1.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            boolean r1 = r1.getBoolean(r2)     // Catch:{ NameNotFoundException -> 0x004e }
            goto L_0x0027
        L_0x004e:
            r1 = move-exception
            io.fabric.sdk.android.Logger r2 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.String r4 = "Fabric"
            java.lang.String r5 = "Unable to get PackageManager. Falling through"
            r2.d(r4, r5, r1)
        L_0x005a:
            r1 = 1
            r2 = 0
        L_0x005c:
            r6.crashlyticsDataCollectionEnabled = r1
            r6.crashlyticsDataCollectionExplicitlySet = r2
            java.lang.String r7 = io.fabric.sdk.android.services.common.CommonUtils.resolveUnityEditorVersion(r7)
            if (r7 == 0) goto L_0x0067
            r0 = 1
        L_0x0067:
            r6.isUnity = r0
            return
        L_0x006a:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r0 = "null context"
            r7.<init>(r0)
            goto L_0x0073
        L_0x0072:
            throw r7
        L_0x0073:
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.DataCollectionArbiter.<init>(android.content.Context):void");
    }

    public boolean isDataCollectionEnabled() {
        if (this.isUnity && this.crashlyticsDataCollectionExplicitlySet) {
            return this.crashlyticsDataCollectionEnabled;
        }
        FirebaseApp firebaseApp2 = this.firebaseApp;
        if (firebaseApp2 != null) {
            return firebaseApp2.isDataCollectionDefaultEnabled();
        }
        return true;
    }

    public boolean shouldAutoInitialize() {
        return this.crashlyticsDataCollectionEnabled;
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void setCrashlyticsDataCollectionEnabled(boolean z) {
        this.crashlyticsDataCollectionEnabled = z;
        this.crashlyticsDataCollectionExplicitlySet = true;
        this.sharedPreferences.edit().putBoolean("firebase_crashlytics_collection_enabled", z).commit();
    }
}
