package com.facebook.marketing.internal;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdk.InitializeCallback;
import com.facebook.marketing.CodelessActivityLifecycleTracker;

public final class MarketingInitProvider extends ContentProvider {
    private static final String TAG = MarketingInitProvider.class.getSimpleName();

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
        try {
            if (!FacebookSdk.isInitialized()) {
                FacebookSdk.sdkInitialize(getContext(), (InitializeCallback) new InitializeCallback() {
                    public void onInitialized() {
                        MarketingInitProvider.this.setupCodeless();
                    }
                });
            } else {
                setupCodeless();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void setupCodeless() {
        CodelessActivityLifecycleTracker.startTracking((Application) FacebookSdk.getApplicationContext());
        RemoteConfigManager.loadRemoteConfigAsync();
        new MarketingLogger((Application) FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId()).logCodelessInitialized();
    }
}
