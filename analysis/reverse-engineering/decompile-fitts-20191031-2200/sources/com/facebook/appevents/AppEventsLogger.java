package com.facebook.appevents;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import bolts.AppLinks;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.appevents.AppEventsLogger";
    private static String anonymousAppDeviceGUID;
    /* access modifiers changed from: private */
    public static ScheduledThreadPoolExecutor backgroundExecutor;
    private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
    private static boolean isActivateAppEventRequested;
    private static boolean isOpenedByAppLink;
    private static String pushNotificationsRegistrationId;
    private static String sourceApplication;
    private static Object staticLock = new Object();
    private final AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    static class PersistedAppSessionInfo {
        private static final Runnable appSessionInfoFlushRunnable = new Runnable() {
            public void run() {
                PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
            }
        };
        private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap = null;
        private static boolean hasChanges = false;
        private static boolean isLoaded = false;
        private static final Object staticLock = new Object();

        /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[Catch:{ all -> 0x0077 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A[Catch:{ all -> 0x0077 }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x009d A[Catch:{ all -> 0x0077 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void restoreAppSessionInformation(android.content.Context r8) {
            /*
                java.lang.Object r0 = staticLock
                monitor-enter(r0)
                boolean r1 = isLoaded     // Catch:{ all -> 0x00a9 }
                if (r1 != 0) goto L_0x00a7
                r1 = 0
                r2 = 1
                r3 = 0
                java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x0090, Exception -> 0x0046, all -> 0x0041 }
                java.lang.String r5 = "AppEventsLogger.persistedsessioninfo"
                java.io.FileInputStream r5 = r8.openFileInput(r5)     // Catch:{ FileNotFoundException -> 0x0090, Exception -> 0x0046, all -> 0x0041 }
                r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0090, Exception -> 0x0046, all -> 0x0041 }
                java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x0091, Exception -> 0x003f }
                java.util.HashMap r3 = (java.util.HashMap) r3     // Catch:{ FileNotFoundException -> 0x0091, Exception -> 0x003f }
                appSessionInfoMap = r3     // Catch:{ FileNotFoundException -> 0x0091, Exception -> 0x003f }
                com.facebook.LoggingBehavior r3 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ FileNotFoundException -> 0x0091, Exception -> 0x003f }
                java.lang.String r5 = "AppEvents"
                java.lang.String r6 = "App session info loaded"
                com.facebook.internal.Logger.log(r3, r5, r6)     // Catch:{ FileNotFoundException -> 0x0091, Exception -> 0x003f }
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00a9 }
                java.lang.String r3 = "AppEventsLogger.persistedsessioninfo"
                r8.deleteFile(r3)     // Catch:{ all -> 0x00a9 }
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r8 = appSessionInfoMap     // Catch:{ all -> 0x00a9 }
                if (r8 != 0) goto L_0x0039
                java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x00a9 }
                r8.<init>()     // Catch:{ all -> 0x00a9 }
                appSessionInfoMap = r8     // Catch:{ all -> 0x00a9 }
            L_0x0039:
                isLoaded = r2     // Catch:{ all -> 0x00a9 }
            L_0x003b:
                hasChanges = r1     // Catch:{ all -> 0x00a9 }
                goto L_0x00a7
            L_0x003f:
                r3 = move-exception
                goto L_0x004a
            L_0x0041:
                r4 = move-exception
                r7 = r4
                r4 = r3
                r3 = r7
                goto L_0x0078
            L_0x0046:
                r4 = move-exception
                r7 = r4
                r4 = r3
                r3 = r7
            L_0x004a:
                com.facebook.appevents.AppEventsLogger.TAG     // Catch:{ all -> 0x0077 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
                r5.<init>()     // Catch:{ all -> 0x0077 }
                java.lang.String r6 = "Got unexpected exception restoring app session info: "
                r5.append(r6)     // Catch:{ all -> 0x0077 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0077 }
                r5.append(r3)     // Catch:{ all -> 0x0077 }
                r5.toString()     // Catch:{ all -> 0x0077 }
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00a9 }
                java.lang.String r3 = "AppEventsLogger.persistedsessioninfo"
                r8.deleteFile(r3)     // Catch:{ all -> 0x00a9 }
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r8 = appSessionInfoMap     // Catch:{ all -> 0x00a9 }
                if (r8 != 0) goto L_0x0074
                java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x00a9 }
                r8.<init>()     // Catch:{ all -> 0x00a9 }
                appSessionInfoMap = r8     // Catch:{ all -> 0x00a9 }
            L_0x0074:
                isLoaded = r2     // Catch:{ all -> 0x00a9 }
                goto L_0x003b
            L_0x0077:
                r3 = move-exception
            L_0x0078:
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00a9 }
                java.lang.String r4 = "AppEventsLogger.persistedsessioninfo"
                r8.deleteFile(r4)     // Catch:{ all -> 0x00a9 }
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r8 = appSessionInfoMap     // Catch:{ all -> 0x00a9 }
                if (r8 != 0) goto L_0x008b
                java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x00a9 }
                r8.<init>()     // Catch:{ all -> 0x00a9 }
                appSessionInfoMap = r8     // Catch:{ all -> 0x00a9 }
            L_0x008b:
                isLoaded = r2     // Catch:{ all -> 0x00a9 }
                hasChanges = r1     // Catch:{ all -> 0x00a9 }
                throw r3     // Catch:{ all -> 0x00a9 }
            L_0x0090:
                r4 = r3
            L_0x0091:
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00a9 }
                java.lang.String r3 = "AppEventsLogger.persistedsessioninfo"
                r8.deleteFile(r3)     // Catch:{ all -> 0x00a9 }
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r8 = appSessionInfoMap     // Catch:{ all -> 0x00a9 }
                if (r8 != 0) goto L_0x00a4
                java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x00a9 }
                r8.<init>()     // Catch:{ all -> 0x00a9 }
                appSessionInfoMap = r8     // Catch:{ all -> 0x00a9 }
            L_0x00a4:
                isLoaded = r2     // Catch:{ all -> 0x00a9 }
                goto L_0x003b
            L_0x00a7:
                monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
                return
            L_0x00a9:
                r8 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
                goto L_0x00ad
            L_0x00ac:
                throw r8
            L_0x00ad:
                goto L_0x00ac
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLogger.PersistedAppSessionInfo.restoreAppSessionInformation(android.content.Context):void");
        }

        static void saveAppSessionInformation(Context context) {
            synchronized (staticLock) {
                if (hasChanges) {
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedsessioninfo", 0)));
                        try {
                            objectOutputStream2.writeObject(appSessionInfoMap);
                            hasChanges = false;
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
                            Utility.closeQuietly(objectOutputStream2);
                        } catch (Exception e) {
                            e = e;
                            objectOutputStream = objectOutputStream2;
                            try {
                                AppEventsLogger.TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Got unexpected exception while writing app session info: ");
                                sb.append(e.toString());
                                sb.toString();
                                Utility.closeQuietly(objectOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                Utility.closeQuietly(objectOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream = objectOutputStream2;
                            Utility.closeQuietly(objectOutputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        AppEventsLogger.TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Got unexpected exception while writing app session info: ");
                        sb2.append(e.toString());
                        sb2.toString();
                        Utility.closeQuietly(objectOutputStream);
                    }
                }
            }
        }

        static void onResume(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j, String str) {
            synchronized (staticLock) {
                getTimeSpentData(context, accessTokenAppIdPair).onResume(appEventsLogger, j, str);
                onTimeSpentDataUpdate();
            }
        }

        static void onSuspend(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j) {
            synchronized (staticLock) {
                getTimeSpentData(context, accessTokenAppIdPair).onSuspend(appEventsLogger, j);
                onTimeSpentDataUpdate();
            }
        }

        private static FacebookTimeSpentData getTimeSpentData(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
            restoreAppSessionInformation(context);
            FacebookTimeSpentData facebookTimeSpentData = (FacebookTimeSpentData) appSessionInfoMap.get(accessTokenAppIdPair);
            if (facebookTimeSpentData != null) {
                return facebookTimeSpentData;
            }
            FacebookTimeSpentData facebookTimeSpentData2 = new FacebookTimeSpentData();
            appSessionInfoMap.put(accessTokenAppIdPair, facebookTimeSpentData2);
            return facebookTimeSpentData2;
        }

        private static void onTimeSpentDataUpdate() {
            if (!hasChanges) {
                hasChanges = true;
                AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30, TimeUnit.SECONDS);
            }
        }
    }

    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED
    }

    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED
    }

    public static void activateApp(Application application) {
        activateApp(application, (String) null);
    }

    public static void activateApp(Application application, String str) {
        if (FacebookSdk.isInitialized()) {
            AnalyticsUserIDStore.initStore();
            UserDataStore.initStore();
            if (str == null) {
                str = FacebookSdk.getApplicationId();
            }
            FacebookSdk.publishInstallAsync(application, str);
            ActivityLifecycleTracker.startTracking(application, str);
            return;
        }
        throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
    }

    @Deprecated
    public static void activateApp(Context context) {
        if (!ActivityLifecycleTracker.isTracking()) {
            FacebookSdk.sdkInitialize(context);
            activateApp(context, Utility.getMetadataApplicationId(context));
        }
    }

    @Deprecated
    public static void activateApp(Context context, String str) {
        if (!ActivityLifecycleTracker.isTracking()) {
            if (context == null || str == null) {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            AnalyticsUserIDStore.initStore();
            UserDataStore.initStore();
            if (context instanceof Activity) {
                setSourceApplication((Activity) context);
            } else {
                resetSourceApplication();
                Utility.logd(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
            }
            FacebookSdk.publishInstallAsync(context, str);
            AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, (AccessToken) null);
            final long currentTimeMillis = System.currentTimeMillis();
            final String sourceApplication2 = getSourceApplication();
            backgroundExecutor.execute(new Runnable(appEventsLogger) {
                final /* synthetic */ AppEventsLogger val$logger;

                {
                    this.val$logger = r1;
                }

                public void run() {
                    this.val$logger.logAppSessionResumeEvent(currentTimeMillis, sourceApplication2);
                }
            });
        }
    }

    @Deprecated
    public static void deactivateApp(Context context) {
        if (!ActivityLifecycleTracker.isTracking()) {
            deactivateApp(context, Utility.getMetadataApplicationId(context));
        }
    }

    @Deprecated
    public static void deactivateApp(Context context, String str) {
        if (!ActivityLifecycleTracker.isTracking()) {
            if (context == null || str == null) {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            resetSourceApplication();
            AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, (AccessToken) null);
            final long currentTimeMillis = System.currentTimeMillis();
            backgroundExecutor.execute(new Runnable(appEventsLogger) {
                final /* synthetic */ AppEventsLogger val$logger;

                {
                    this.val$logger = r1;
                }

                public void run() {
                    this.val$logger.logAppSessionSuspendEvent(currentTimeMillis);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void logAppSessionResumeEvent(long j, String str) {
        PersistedAppSessionInfo.onResume(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j, str);
    }

    /* access modifiers changed from: private */
    public void logAppSessionSuspendEvent(long j) {
        PersistedAppSessionInfo.onSuspend(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j);
    }

    public static void initializeLib(Context context, String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            backgroundExecutor.execute(new Runnable(new AppEventsLogger(context, str, (AccessToken) null)) {
                final /* synthetic */ AppEventsLogger val$logger;

                {
                    this.val$logger = r1;
                }

                public void run() {
                    Bundle bundle = new Bundle();
                    try {
                        Class.forName("com.facebook.core.Core");
                        bundle.putInt("core_lib_included", 1);
                    } catch (ClassNotFoundException unused) {
                    }
                    try {
                        Class.forName("com.facebook.login.Login");
                        bundle.putInt("login_lib_included", 1);
                    } catch (ClassNotFoundException unused2) {
                    }
                    try {
                        Class.forName("com.facebook.share.Share");
                        bundle.putInt("share_lib_included", 1);
                    } catch (ClassNotFoundException unused3) {
                    }
                    try {
                        Class.forName("com.facebook.places.Places");
                        bundle.putInt("places_lib_included", 1);
                    } catch (ClassNotFoundException unused4) {
                    }
                    try {
                        Class.forName("com.facebook.messenger.Messenger");
                        bundle.putInt("messenger_lib_included", 1);
                    } catch (ClassNotFoundException unused5) {
                    }
                    try {
                        Class.forName("com.facebook.applinks.AppLinks");
                        bundle.putInt("applinks_lib_included", 1);
                    } catch (ClassNotFoundException unused6) {
                    }
                    try {
                        Class.forName("com.facebook.marketing.Marketing");
                        bundle.putInt("marketing_lib_included", 1);
                    } catch (ClassNotFoundException unused7) {
                    }
                    try {
                        Class.forName("com.facebook.all.All");
                        bundle.putInt("all_lib_included", 1);
                    } catch (ClassNotFoundException unused8) {
                    }
                    try {
                        Class.forName("com.android.billingclient.api.BillingClient");
                        bundle.putInt("billing_client_lib_included", 1);
                    } catch (ClassNotFoundException unused9) {
                    }
                    try {
                        Class.forName("com.android.vending.billing.IInAppBillingService");
                        bundle.putInt("billing_service_lib_included", 1);
                    } catch (ClassNotFoundException unused10) {
                    }
                    this.val$logger.logSdkEvent("fb_sdk_initialize", null, bundle);
                }
            });
        }
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, (String) null, (AccessToken) null);
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        return new AppEventsLogger(context, (String) null, accessToken);
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        return new AppEventsLogger(context, str, accessToken);
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, (AccessToken) null);
    }

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior2;
        synchronized (staticLock) {
            flushBehavior2 = flushBehavior;
        }
        return flushBehavior2;
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior2) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior2;
        }
    }

    public void logEvent(String str) {
        logEvent(str, (Bundle) null);
    }

    public void logEvent(String str, double d) {
        logEvent(str, d, null);
    }

    public void logEvent(String str, Bundle bundle) {
        logEvent(str, null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public void logEvent(String str, double d, Bundle bundle) {
        logEvent(str, Double.valueOf(d), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        boolean isImplicitPurchaseLoggingEnabled = AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
        logPurchase(bigDecimal, currency, null, false);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        boolean isImplicitPurchaseLoggingEnabled = AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
        logPurchase(bigDecimal, currency, bundle, false);
    }

    @Deprecated
    public void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        String str = "Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. ";
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("Auto-logging of in-app purchase has been enabled in the SDK, so you don't have to manually log purchases");
            sb.toString();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("Please use logPurchase() function instead.");
        sb2.toString();
    }

    /* access modifiers changed from: protected */
    public void logPurchaseImplicitlyInternal(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        logPurchase(bigDecimal, currency, bundle, true);
    }

    private void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putString("fb_currency", currency.getCurrencyCode());
            logEvent("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle2, z, ActivityLifecycleTracker.getCurrentSessionGuid());
            eagerFlush();
        }
    }

    public void logPushNotificationOpen(Bundle bundle) {
        logPushNotificationOpen(bundle, null);
    }

    public void logPushNotificationOpen(Bundle bundle, String str) {
        String str2;
        try {
            String string = bundle.getString("fb_push_payload");
            if (!Utility.isNullOrEmpty(string)) {
                str2 = new JSONObject(string).getString("campaign");
                if (str2 == null) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("fb_push_campaign", str2);
                if (str != null) {
                    bundle2.putString("fb_push_action", str);
                }
                logEvent("fb_mobile_push_opened", bundle2);
            }
        } catch (JSONException unused) {
            str2 = null;
        }
    }

    public void logProductItem(String str, ProductAvailability productAvailability, ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        if (str == null) {
            notifyDeveloperError("itemID cannot be null");
        } else if (productAvailability == null) {
            notifyDeveloperError("availability cannot be null");
        } else if (productCondition == null) {
            notifyDeveloperError("condition cannot be null");
        } else if (str2 == null) {
            notifyDeveloperError("description cannot be null");
        } else if (str3 == null) {
            notifyDeveloperError("imageLink cannot be null");
        } else if (str4 == null) {
            notifyDeveloperError("link cannot be null");
        } else if (str5 == null) {
            notifyDeveloperError("title cannot be null");
        } else if (bigDecimal == null) {
            notifyDeveloperError("priceAmount cannot be null");
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
        } else if (str6 == null && str7 == null && str8 == null) {
            notifyDeveloperError("Either gtin, mpn or brand is required");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_ITEM_ID, str);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_AVAILABILITY, productAvailability.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_CONDITION, productCondition.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_DESCRIPTION, str2);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_IMAGE_LINK, str3);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_LINK, str4);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_TITLE, str5);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_AMOUNT, bigDecimal.setScale(3, 4).toString());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_CURRENCY, currency.getCurrencyCode());
            if (str6 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_GTIN, str6);
            }
            if (str7 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_MPN, str7);
            }
            if (str8 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_BRAND, str8);
            }
            logEvent("fb_mobile_catalog_update", bundle);
            eagerFlush();
        }
    }

    public void flush() {
        AppEventQueue.flush(FlushReason.EXPLICIT);
    }

    public static void onContextStop() {
        AppEventQueue.persistToDisk();
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        return this.accessTokenAppId.equals(new AccessTokenAppIdPair(accessToken));
    }

    public static void setPushNotificationsRegistrationId(String str) {
        synchronized (staticLock) {
            if (!Utility.stringsEqualOrEmpty(pushNotificationsRegistrationId, str)) {
                pushNotificationsRegistrationId = str;
                AppEventsLogger newLogger = newLogger(FacebookSdk.getApplicationContext());
                newLogger.logEvent("fb_mobile_obtain_push_token");
                if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                    newLogger.flush();
                }
            }
        }
    }

    static String getPushNotificationsRegistrationId() {
        String str;
        synchronized (staticLock) {
            str = pushNotificationsRegistrationId;
        }
        return str;
    }

    public static void augmentWebView(WebView webView, Context context) {
        String[] split = VERSION.RELEASE.split("\\.");
        int i = 0;
        int parseInt = split.length > 0 ? Integer.parseInt(split[0]) : 0;
        if (split.length > 1) {
            i = Integer.parseInt(split[1]);
        }
        if (VERSION.SDK_INT < 17 || parseInt < 4 || (parseInt == 4 && i <= 1)) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
            return;
        }
        FacebookSDKJSInterface facebookSDKJSInterface = new FacebookSDKJSInterface(context);
        StringBuilder sb = new StringBuilder();
        sb.append("fbmq_");
        sb.append(FacebookSdk.getApplicationId());
        webView.addJavascriptInterface(facebookSDKJSInterface, sb.toString());
    }

    public static void setUserID(String str) {
        AnalyticsUserIDStore.setUserID(str);
    }

    public static String getUserID() {
        return AnalyticsUserIDStore.getUserID();
    }

    public static void clearUserID() {
        AnalyticsUserIDStore.setUserID(null);
    }

    @Deprecated
    public static void setUserData(Bundle bundle) {
        UserDataStore.setUserDataAndHash(bundle);
    }

    public static void setUserData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        UserDataStore.setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public static String getUserData() {
        return UserDataStore.getHashedUserData();
    }

    public static void clearUserData() {
        UserDataStore.clear();
    }

    public static void updateUserProperties(Bundle bundle, Callback callback) {
        updateUserProperties(bundle, FacebookSdk.getApplicationId(), callback);
    }

    public static void updateUserProperties(final Bundle bundle, final String str, final Callback callback) {
        getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                String userID = AppEventsLogger.getUserID();
                if (userID == null || userID.isEmpty()) {
                    Logger.log(LoggingBehavior.APP_EVENTS, AppEventsLogger.TAG, "AppEventsLogger userID cannot be null or empty");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("user_unique_id", userID);
                bundle.putBundle("custom_data", bundle);
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
                    bundle.putString("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                }
                Bundle bundle2 = new Bundle();
                try {
                    JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(convertToJSON);
                    bundle2.putString("data", jSONArray.toString());
                    GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.US, "%s/user_properties", new Object[]{str}), bundle2, HttpMethod.POST, callback);
                    graphRequest.setSkipClientToken(true);
                    graphRequest.executeAsync();
                } catch (JSONException e) {
                    throw new FacebookException("Failed to construct request", (Throwable) e);
                }
            }
        });
    }

    public void logSdkEvent(String str, Double d, Bundle bundle) {
        logEvent(str, d, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
    }

    protected AppEventsLogger(String str, String str2, AccessToken accessToken) {
        Validate.sdkInitialized();
        this.contextName = str;
        if (accessToken == null) {
            accessToken = AccessToken.getCurrentAccessToken();
        }
        if (!AccessToken.isCurrentAccessTokenActive() || (str2 != null && !str2.equals(accessToken.getApplicationId()))) {
            if (str2 == null) {
                str2 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str2);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        }
        initializeTimersIfNeeded();
    }

    private static void initializeTimersIfNeeded() {
        synchronized (staticLock) {
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                backgroundExecutor.scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        HashSet<String> hashSet = new HashSet<>();
                        for (AccessTokenAppIdPair applicationId : AppEventQueue.getKeySet()) {
                            hashSet.add(applicationId.getApplicationId());
                        }
                        for (String queryAppSettings : hashSet) {
                            FetchedAppSettingsManager.queryAppSettings(queryAppSettings, true);
                        }
                    }
                }, 0, 86400, TimeUnit.SECONDS);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        logEvent(str, Double.valueOf(bigDecimal.doubleValue()), bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    private void logEvent(String str, Double d, Bundle bundle, boolean z, @Nullable UUID uuid) {
        String str2 = "AppEvents";
        try {
            AppEvent appEvent = new AppEvent(this.contextName, str, d, bundle, z, uuid);
            logEvent(appEvent, this.accessTokenAppId);
        } catch (JSONException e) {
            Logger.log(LoggingBehavior.APP_EVENTS, str2, "JSON encoding for app event failed: '%s'", e.toString());
        } catch (FacebookException e2) {
            Logger.log(LoggingBehavior.APP_EVENTS, str2, "Invalid app event: %s", e2.toString());
        }
    }

    private static void logEvent(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        AppEventQueue.add(accessTokenAppIdPair, appEvent);
        if (!appEvent.getIsImplicit() && !isActivateAppEventRequested) {
            if (appEvent.getName().equals("fb_mobile_activate_app")) {
                isActivateAppEventRequested = true;
            } else {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    static void eagerFlush() {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    private static void notifyDeveloperError(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    private static void setSourceApplication(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            String packageName = callingActivity.getPackageName();
            if (packageName.equals(activity.getPackageName())) {
                resetSourceApplication();
                return;
            }
            sourceApplication = packageName;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            String str = "_fbSourceApplicationHasBeenSet";
            if (!intent.getBooleanExtra(str, false)) {
                Bundle appLinkData = AppLinks.getAppLinkData(intent);
                if (appLinkData == null) {
                    resetSourceApplication();
                    return;
                }
                isOpenedByAppLink = true;
                Bundle bundle = appLinkData.getBundle("referer_app_link");
                if (bundle == null) {
                    sourceApplication = null;
                    return;
                }
                sourceApplication = bundle.getString("package");
                intent.putExtra(str, true);
                return;
            }
        }
        resetSourceApplication();
    }

    static String getSourceApplication() {
        String str = isOpenedByAppLink ? "Applink" : "Unclassified";
        if (sourceApplication == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("(");
        sb.append(sourceApplication);
        sb.append(")");
        return sb.toString();
    }

    static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByAppLink = false;
    }

    static Executor getAnalyticsExecutor() {
        if (backgroundExecutor == null) {
            initializeTimersIfNeeded();
        }
        return backgroundExecutor;
    }

    public static String getAnonymousAppDeviceGUID(Context context) {
        if (anonymousAppDeviceGUID == null) {
            synchronized (staticLock) {
                if (anonymousAppDeviceGUID == null) {
                    anonymousAppDeviceGUID = context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getString("anonymousAppDeviceGUID", null);
                    if (anonymousAppDeviceGUID == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("XZ");
                        sb.append(UUID.randomUUID().toString());
                        anonymousAppDeviceGUID = sb.toString();
                        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
                    }
                }
            }
        }
        return anonymousAppDeviceGUID;
    }
}
