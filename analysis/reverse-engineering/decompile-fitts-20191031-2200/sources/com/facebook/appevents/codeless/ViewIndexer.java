package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewIndexer {
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.appevents.codeless.ViewIndexer";
    private static ViewIndexer instance;
    private WeakReference<Activity> activityReference;
    /* access modifiers changed from: private */
    public Timer indexingTimer;
    /* access modifiers changed from: private */
    public String previousDigest = null;
    /* access modifiers changed from: private */
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    private static class ScreenshotTaker implements Callable<String> {
        private WeakReference<View> rootView;

        ScreenshotTaker(View view) {
            this.rootView = new WeakReference<>(view);
        }

        public String call() {
            View view = (View) this.rootView.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }

    public ViewIndexer(Activity activity) {
        this.activityReference = new WeakReference<>(activity);
        instance = this;
    }

    public void schedule() {
        final Activity activity = (Activity) this.activityReference.get();
        if (activity != null) {
            final String simpleName = activity.getClass().getSimpleName();
            final AnonymousClass1 r2 = new TimerTask() {
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003f */
                /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0066 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r6 = this;
                        android.app.Activity r0 = r0     // Catch:{ Exception -> 0x0073 }
                        android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x0073 }
                        android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x0073 }
                        android.view.View r0 = r0.getRootView()     // Catch:{ Exception -> 0x0073 }
                        boolean r1 = com.facebook.appevents.internal.ActivityLifecycleTracker.getIsAppIndexingEnabled()     // Catch:{ Exception -> 0x0073 }
                        if (r1 != 0) goto L_0x0015
                        return
                    L_0x0015:
                        boolean r1 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x0073 }
                        if (r1 == 0) goto L_0x001f
                        com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy()     // Catch:{ Exception -> 0x0073 }
                        return
                    L_0x001f:
                        java.util.concurrent.FutureTask r1 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x0073 }
                        com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r2 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x0073 }
                        r2.<init>(r0)     // Catch:{ Exception -> 0x0073 }
                        r1.<init>(r2)     // Catch:{ Exception -> 0x0073 }
                        com.facebook.appevents.codeless.ViewIndexer r2 = com.facebook.appevents.codeless.ViewIndexer.this     // Catch:{ Exception -> 0x0073 }
                        android.os.Handler r2 = r2.uiThreadHandler     // Catch:{ Exception -> 0x0073 }
                        r2.post(r1)     // Catch:{ Exception -> 0x0073 }
                        java.lang.String r2 = ""
                        r3 = 1
                        java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x003f }
                        java.lang.Object r1 = r1.get(r3, r5)     // Catch:{ Exception -> 0x003f }
                        java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x003f }
                        goto L_0x0043
                    L_0x003f:
                        com.facebook.appevents.codeless.ViewIndexer.TAG     // Catch:{ Exception -> 0x0073 }
                        r1 = r2
                    L_0x0043:
                        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0073 }
                        r2.<init>()     // Catch:{ Exception -> 0x0073 }
                        java.lang.String r3 = "screenname"
                        java.lang.String r4 = r1     // Catch:{ JSONException -> 0x0066 }
                        r2.put(r3, r4)     // Catch:{ JSONException -> 0x0066 }
                        java.lang.String r3 = "screenshot"
                        r2.put(r3, r1)     // Catch:{ JSONException -> 0x0066 }
                        org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0066 }
                        r1.<init>()     // Catch:{ JSONException -> 0x0066 }
                        org.json.JSONObject r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r0)     // Catch:{ JSONException -> 0x0066 }
                        r1.put(r0)     // Catch:{ JSONException -> 0x0066 }
                        java.lang.String r0 = "view"
                        r2.put(r0, r1)     // Catch:{ JSONException -> 0x0066 }
                        goto L_0x0069
                    L_0x0066:
                        com.facebook.appevents.codeless.ViewIndexer.TAG     // Catch:{ Exception -> 0x0073 }
                    L_0x0069:
                        java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0073 }
                        com.facebook.appevents.codeless.ViewIndexer r1 = com.facebook.appevents.codeless.ViewIndexer.this     // Catch:{ Exception -> 0x0073 }
                        r1.sendToServer(r0)     // Catch:{ Exception -> 0x0073 }
                        goto L_0x0076
                    L_0x0073:
                        com.facebook.appevents.codeless.ViewIndexer.TAG
                    L_0x0076:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer.AnonymousClass1.run():void");
                }
            };
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    try {
                        if (ViewIndexer.this.indexingTimer != null) {
                            ViewIndexer.this.indexingTimer.cancel();
                        }
                        ViewIndexer.this.previousDigest = null;
                        ViewIndexer.this.indexingTimer = new Timer();
                        ViewIndexer.this.indexingTimer.scheduleAtFixedRate(r2, 0, 1000);
                    } catch (Exception unused) {
                        ViewIndexer.TAG;
                    }
                }
            });
        }
    }

    public void unschedule() {
        if (((Activity) this.activityReference.get()) != null) {
            Timer timer = this.indexingTimer;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.indexingTimer = null;
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void sendToServerUnityInstance(String str) {
        ViewIndexer viewIndexer = instance;
        if (viewIndexer != null) {
            viewIndexer.sendToServerUnity(str);
        }
    }

    @Deprecated
    public void sendToServerUnity(String str) {
        instance.sendToServer(str);
    }

    /* access modifiers changed from: private */
    public void sendToServer(final String str) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                String str = "is_app_indexing_enabled";
                String md5hash = Utility.md5hash(str);
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                if (md5hash == null || !md5hash.equals(ViewIndexer.this.previousDigest)) {
                    GraphRequest buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(str, currentAccessToken, FacebookSdk.getApplicationId(), "app_indexing");
                    if (buildAppIndexingRequest != null) {
                        GraphResponse executeAndWait = buildAppIndexingRequest.executeAndWait();
                        try {
                            JSONObject jSONObject = executeAndWait.getJSONObject();
                            if (jSONObject != null) {
                                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(jSONObject.optString(GraphResponse.SUCCESS_KEY))) {
                                    Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "Successfully send UI component tree to server");
                                    ViewIndexer.this.previousDigest = md5hash;
                                }
                                if (jSONObject.has(str)) {
                                    ActivityLifecycleTracker.updateAppIndexing(Boolean.valueOf(jSONObject.getBoolean(str)));
                                }
                            } else {
                                ViewIndexer.TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Error sending UI component tree to Facebook: ");
                                sb.append(executeAndWait.getError());
                                sb.toString();
                            }
                        } catch (JSONException unused) {
                            ViewIndexer.TAG;
                        }
                    }
                }
            }
        });
    }

    @Nullable
    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        if (str == null) {
            return null;
        }
        GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", new Object[]{str2}), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("tree", str);
        parameters.putString("app_version", AppEventUtility.getAppVersion());
        parameters.putString("platform", "android");
        parameters.putString("request_type", str3);
        if (str3.equals("app_indexing")) {
            parameters.putString("device_session_id", ActivityLifecycleTracker.getCurrentDeviceSessionID());
        }
        newPostRequest.setParameters(parameters);
        newPostRequest.setCallback(new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                Logger.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "App index sent to FB!");
            }
        });
        return newPostRequest;
    }
}
