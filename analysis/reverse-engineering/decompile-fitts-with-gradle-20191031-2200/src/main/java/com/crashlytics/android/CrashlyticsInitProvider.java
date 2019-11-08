package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.FirebaseInfo;

public class CrashlyticsInitProvider extends ContentProvider {
    private static final String TAG = "CrashlyticsInitProvider";

    interface EnabledCheckStrategy {
        boolean isCrashlyticsEnabled(Context context);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        Context context = getContext();
        boolean shouldInitializeFabric = shouldInitializeFabric(context, new FirebaseInfo(), new ManifestEnabledCheckStrategy());
        String str = TAG;
        if (shouldInitializeFabric) {
            try {
                Fabric.with(context, new Crashlytics());
                Fabric.getLogger().i(str, "CrashlyticsInitProvider initialization successful");
            } catch (IllegalStateException unused) {
                Fabric.getLogger().i(str, "CrashlyticsInitProvider initialization unsuccessful");
                return false;
            }
        } else {
            Fabric.getLogger().i(str, "CrashlyticsInitProvider skipping initialization");
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldInitializeFabric(Context context, FirebaseInfo firebaseInfo, EnabledCheckStrategy enabledCheckStrategy) {
        if (firebaseInfo.isFirebaseCrashlyticsEnabled(context)) {
            return enabledCheckStrategy.isCrashlyticsEnabled(context);
        }
        return firebaseInfo.isAutoInitializeFlagEnabled(context);
    }
}
