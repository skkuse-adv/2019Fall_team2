package com.facebook.marketing.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ButtonIndexer {
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.marketing.internal.ButtonIndexer";
    private Set<Activity> activitiesSet = new HashSet();
    private HashSet<String> delegateSet = new HashSet<>();
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<ViewProcessor> viewProcessors = new HashSet();

    protected static class ViewProcessor implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        private static volatile float displayDensity = -1.0f;
        public static volatile Set<String> loadedKeySet = new HashSet();
        private final String activityName;
        private HashSet<String> delegateSet;
        private final Handler handler;
        private WeakReference<View> rootView;
        private HashMap<String, WeakReference<View>> viewMap = new HashMap<>();

        public ViewProcessor(View view, String str, HashSet<String> hashSet, Handler handler2) {
            this.rootView = new WeakReference<>(view);
            this.handler = handler2;
            this.activityName = str;
            this.delegateSet = hashSet;
            if (displayDensity < 0.0f) {
                displayDensity = view.getContext().getResources().getDisplayMetrics().density;
            }
            this.handler.postDelayed(this, 200);
        }

        public void run() {
            RemoteConfig remoteConfigWithoutQuery = RemoteConfigManager.getRemoteConfigWithoutQuery(FacebookSdk.getApplicationId());
            if (remoteConfigWithoutQuery != null && remoteConfigWithoutQuery.getEnableButtonIndexing()) {
                process();
            }
        }

        public void onGlobalLayout() {
            process();
        }

        public void onScrollChanged() {
            process();
        }

        private void process() {
            View view = (View) this.rootView.get();
            if (view != null) {
                attachListeners(view);
            }
        }

        public void attachListeners(View view) {
            JSONObject clickableElementsOfView = getClickableElementsOfView(view, -1, this.activityName, false);
            if (clickableElementsOfView != null) {
                ButtonIndexingLogger.logAllIndexing(clickableElementsOfView, this.activityName);
            }
            for (Entry entry : this.viewMap.entrySet()) {
                attachListener((View) ((WeakReference) entry.getValue()).get(), (String) entry.getKey());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0039 A[Catch:{ JSONException -> 0x00bc }] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A[Catch:{ JSONException -> 0x00bc }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x007e A[Catch:{ JSONException -> 0x00bc }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0082 A[Catch:{ JSONException -> 0x00bc }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00ab A[Catch:{ JSONException -> 0x00bc }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00ac A[Catch:{ JSONException -> 0x00bc }] */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.json.JSONObject getClickableElementsOfView(android.view.View r17, int r18, java.lang.String r19, boolean r20) {
            /*
                r16 = this;
                r1 = r16
                r0 = r17
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r3 = r19
                r2.append(r3)
                java.lang.String r3 = "."
                r2.append(r3)
                java.lang.String r3 = java.lang.String.valueOf(r18)
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r3 = 0
                if (r0 != 0) goto L_0x0022
                return r3
            L_0x0022:
                org.json.JSONObject r4 = new org.json.JSONObject
                r4.<init>()
                boolean r5 = com.facebook.appevents.codeless.internal.ViewHierarchy.isClickableView(r17)     // Catch:{ JSONException -> 0x00bc }
                r6 = 0
                r7 = 1
                if (r5 != 0) goto L_0x0036
                boolean r5 = r0 instanceof android.widget.Button     // Catch:{ JSONException -> 0x00bc }
                if (r5 == 0) goto L_0x0034
                goto L_0x0036
            L_0x0034:
                r5 = 0
                goto L_0x0037
            L_0x0036:
                r5 = 1
            L_0x0037:
                if (r5 == 0) goto L_0x0043
                java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r8 = r1.viewMap     // Catch:{ JSONException -> 0x00bc }
                java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference     // Catch:{ JSONException -> 0x00bc }
                r9.<init>(r0)     // Catch:{ JSONException -> 0x00bc }
                r8.put(r2, r9)     // Catch:{ JSONException -> 0x00bc }
            L_0x0043:
                boolean r8 = r0 instanceof android.widget.TextView     // Catch:{ JSONException -> 0x00bc }
                if (r8 != 0) goto L_0x004b
                boolean r8 = r0 instanceof android.widget.ImageView     // Catch:{ JSONException -> 0x00bc }
                if (r8 == 0) goto L_0x0050
            L_0x004b:
                if (r20 != 0) goto L_0x00a3
                if (r5 == 0) goto L_0x0050
                goto L_0x00a3
            L_0x0050:
                org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00bc }
                r8.<init>()     // Catch:{ JSONException -> 0x00bc }
                boolean r9 = r0 instanceof android.view.ViewGroup     // Catch:{ JSONException -> 0x00bc }
                if (r9 == 0) goto L_0x0093
                r9 = r0
                android.view.ViewGroup r9 = (android.view.ViewGroup) r9     // Catch:{ JSONException -> 0x00bc }
                int r10 = r9.getChildCount()     // Catch:{ JSONException -> 0x00bc }
                r11 = 0
                r12 = 0
            L_0x0062:
                if (r11 >= r10) goto L_0x0093
                android.view.View r13 = r9.getChildAt(r11)     // Catch:{ JSONException -> 0x00bc }
                int r14 = r13.getVisibility()     // Catch:{ JSONException -> 0x00bc }
                if (r14 != 0) goto L_0x0090
                int r14 = r12 + 1
                if (r20 != 0) goto L_0x0077
                if (r5 == 0) goto L_0x0075
                goto L_0x0077
            L_0x0075:
                r15 = 0
                goto L_0x0078
            L_0x0077:
                r15 = 1
            L_0x0078:
                org.json.JSONObject r12 = r1.getClickableElementsOfView(r13, r12, r2, r15)     // Catch:{ JSONException -> 0x00bc }
                if (r12 == 0) goto L_0x0082
                r8.put(r12)     // Catch:{ JSONException -> 0x00bc }
                goto L_0x008f
            L_0x0082:
                org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00bc }
                r16.getClass()     // Catch:{ JSONException -> 0x00bc }
                java.lang.String r13 = "{\"classname\": \"placeholder\", \"id\": 1}"
                r12.<init>(r13)     // Catch:{ JSONException -> 0x00bc }
                r8.put(r12)     // Catch:{ JSONException -> 0x00bc }
            L_0x008f:
                r12 = r14
            L_0x0090:
                int r11 = r11 + 1
                goto L_0x0062
            L_0x0093:
                int r2 = r8.length()     // Catch:{ JSONException -> 0x00bc }
                if (r2 <= 0) goto L_0x00c4
                org.json.JSONObject r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.setBasicInfoOfView(r0, r4)     // Catch:{ JSONException -> 0x00bc }
                java.lang.String r2 = "childviews"
                r0.put(r2, r8)     // Catch:{ JSONException -> 0x00bc }
                return r0
            L_0x00a3:
                java.util.Set<java.lang.String> r5 = loadedKeySet     // Catch:{ JSONException -> 0x00bc }
                boolean r5 = r5.contains(r2)     // Catch:{ JSONException -> 0x00bc }
                if (r5 == 0) goto L_0x00ac
                return r3
            L_0x00ac:
                java.util.Set<java.lang.String> r5 = loadedKeySet     // Catch:{ JSONException -> 0x00bc }
                r5.add(r2)     // Catch:{ JSONException -> 0x00bc }
                org.json.JSONObject r2 = com.facebook.appevents.codeless.internal.ViewHierarchy.setBasicInfoOfView(r0, r4)     // Catch:{ JSONException -> 0x00bc }
                float r4 = displayDensity     // Catch:{ JSONException -> 0x00bc }
                org.json.JSONObject r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.setAppearanceOfView(r0, r2, r4)     // Catch:{ JSONException -> 0x00bc }
                return r0
            L_0x00bc:
                r0 = move-exception
                java.lang.String r2 = com.facebook.marketing.internal.ButtonIndexer.TAG
                com.facebook.internal.Utility.logd(r2, r0)
            L_0x00c4:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.marketing.internal.ButtonIndexer.ViewProcessor.getClickableElementsOfView(android.view.View, int, java.lang.String, boolean):org.json.JSONObject");
        }

        private void attachListener(View view, String str) {
            if (view != null) {
                try {
                    AccessibilityDelegate existingDelegate = ViewHierarchy.getExistingDelegate(view);
                    boolean z = true;
                    boolean z2 = existingDelegate != null;
                    boolean z3 = z2 && (existingDelegate instanceof AutoLoggingAccessibilityDelegate);
                    if (!z3 || !((AutoLoggingAccessibilityDelegate) existingDelegate).getSupportButtonIndexing()) {
                        z = false;
                    }
                    if (!this.delegateSet.contains(str) && (!z2 || !z3 || !z)) {
                        view.setAccessibilityDelegate(ButtonIndexingEventListener.getAccessibilityDelegate(view, str));
                        this.delegateSet.add(str);
                    }
                } catch (FacebookException unused) {
                    ButtonIndexer.TAG;
                }
            }
        }
    }

    public void add(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.activitiesSet.add(activity);
            this.delegateSet.clear();
            startTracking();
            return;
        }
        throw new FacebookException("Can't add activity to ButtonIndexer on non-UI thread");
    }

    public void remove(Activity activity) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.activitiesSet.remove(activity);
            this.viewProcessors.clear();
            this.delegateSet.clear();
            return;
        }
        throw new FacebookException("Can't remove activity from ButtonIndexer on non-UI thread");
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            processViews();
        } else {
            this.uiThreadHandler.post(new Runnable() {
                public void run() {
                    ButtonIndexer.this.processViews();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void processViews() {
        for (Activity activity : this.activitiesSet) {
            this.viewProcessors.add(new ViewProcessor(activity.getWindow().getDecorView().getRootView(), activity.getClass().getSimpleName(), this.delegateSet, this.uiThreadHandler));
        }
    }
}
