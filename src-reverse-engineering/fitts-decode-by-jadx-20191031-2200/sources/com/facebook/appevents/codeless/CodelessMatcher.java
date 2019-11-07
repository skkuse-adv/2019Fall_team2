package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import androidx.annotation.Nullable;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CodelessMatcher {
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.appevents.codeless.CodelessMatcher";
    private Set<Activity> activitiesSet = new HashSet();
    private HashMap<String, String> delegateMap = new HashMap<>();
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<ViewMatcher> viewMatchers = new HashSet();

    public static class MatchedView {
        private WeakReference<View> view;
        private String viewMapKey;

        public MatchedView(View view2, String str) {
            this.view = new WeakReference<>(view2);
            this.viewMapKey = str;
        }

        @Nullable
        public View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return (View) weakReference.get();
        }

        public String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    protected static class ViewMatcher implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        private final String activityName;
        private HashMap<String, String> delegateMap;
        @Nullable
        private List<EventBinding> eventBindings;
        private final Handler handler;
        private WeakReference<View> rootView;

        public ViewMatcher(View view, Handler handler2, HashMap<String, String> hashMap, String str) {
            this.rootView = new WeakReference<>(view);
            this.handler = handler2;
            this.delegateMap = hashMap;
            this.activityName = str;
            this.handler.postDelayed(this, 200);
        }

        public void run() {
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                this.eventBindings = EventBinding.parseArray(appSettingsWithoutQuery.getEventBindings());
                if (this.eventBindings != null) {
                    View view = (View) this.rootView.get();
                    if (view != null) {
                        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.addOnGlobalLayoutListener(this);
                            viewTreeObserver.addOnScrollChangedListener(this);
                        }
                        startMatch();
                    }
                }
            }
        }

        public void onGlobalLayout() {
            startMatch();
        }

        public void onScrollChanged() {
            startMatch();
        }

        private void startMatch() {
            if (this.eventBindings != null && this.rootView.get() != null) {
                for (int i = 0; i < this.eventBindings.size(); i++) {
                    findView((EventBinding) this.eventBindings.get(i), (View) this.rootView.get());
                }
            }
        }

        public void findView(EventBinding eventBinding, View view) {
            if (eventBinding != null && view != null && (TextUtils.isEmpty(eventBinding.getActivityName()) || eventBinding.getActivityName().equals(this.activityName))) {
                List viewPath = eventBinding.getViewPath();
                if (viewPath.size() <= 25) {
                    for (MatchedView attachListener : findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName)) {
                        attachListener(attachListener, view, eventBinding);
                    }
                }
            }
        }

        public static List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = ".";
            sb.append(str2);
            sb.append(String.valueOf(i2));
            String sb2 = sb.toString();
            ArrayList arrayList = new ArrayList();
            if (view == null) {
                return arrayList;
            }
            if (i >= list.size()) {
                arrayList.add(new MatchedView(view, sb2));
            } else {
                PathComponent pathComponent = (PathComponent) list.get(i);
                if (pathComponent.className.equals("..")) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        List findVisibleChildren = findVisibleChildren((ViewGroup) parent);
                        int size = findVisibleChildren.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList.addAll(findViewByPath(eventBinding, (View) findVisibleChildren.get(i3), list, i + 1, i3, sb2));
                        }
                    }
                    return arrayList;
                } else if (pathComponent.className.equals(str2)) {
                    arrayList.add(new MatchedView(view, sb2));
                    return arrayList;
                } else if (!isTheSameView(view, pathComponent, i2)) {
                    return arrayList;
                } else {
                    if (i == list.size() - 1) {
                        arrayList.add(new MatchedView(view, sb2));
                    }
                }
            }
            if (view instanceof ViewGroup) {
                List findVisibleChildren2 = findVisibleChildren((ViewGroup) view);
                int size2 = findVisibleChildren2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    arrayList.addAll(findViewByPath(eventBinding, (View) findVisibleChildren2.get(i4), list, i + 1, i4, sb2));
                }
            }
            return arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
            if (r4.getClass().getSimpleName().equals(r6[r6.length - 1]) == false) goto L_0x0041;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean isTheSameView(android.view.View r4, com.facebook.appevents.codeless.internal.PathComponent r5, int r6) {
            /*
                int r0 = r5.index
                r1 = 0
                r2 = -1
                if (r0 == r2) goto L_0x0009
                if (r6 == r0) goto L_0x0009
                return r1
            L_0x0009:
                java.lang.Class r6 = r4.getClass()
                java.lang.String r6 = r6.getCanonicalName()
                java.lang.String r0 = r5.className
                boolean r6 = r6.equals(r0)
                r0 = 1
                if (r6 != 0) goto L_0x0042
                java.lang.String r6 = r5.className
                java.lang.String r2 = ".*android\\..*"
                boolean r6 = r6.matches(r2)
                if (r6 == 0) goto L_0x0041
                java.lang.String r6 = r5.className
                java.lang.String r2 = "\\."
                java.lang.String[] r6 = r6.split(r2)
                int r2 = r6.length
                if (r2 <= 0) goto L_0x0041
                int r2 = r6.length
                int r2 = r2 - r0
                r6 = r6[r2]
                java.lang.Class r2 = r4.getClass()
                java.lang.String r2 = r2.getSimpleName()
                boolean r6 = r2.equals(r6)
                if (r6 != 0) goto L_0x0042
            L_0x0041:
                return r1
            L_0x0042:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.ID
                int r2 = r2.getValue()
                r6 = r6 & r2
                if (r6 <= 0) goto L_0x0056
                int r6 = r5.id
                int r2 = r4.getId()
                if (r6 == r2) goto L_0x0056
                return r1
            L_0x0056:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TEXT
                int r2 = r2.getValue()
                r6 = r6 & r2
                if (r6 <= 0) goto L_0x006e
                java.lang.String r6 = r5.text
                java.lang.String r2 = com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(r4)
                boolean r6 = r6.equals(r2)
                if (r6 != 0) goto L_0x006e
                return r1
            L_0x006e:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.DESCRIPTION
                int r2 = r2.getValue()
                r6 = r6 & r2
                java.lang.String r2 = ""
                if (r6 <= 0) goto L_0x0094
                java.lang.String r6 = r5.description
                java.lang.CharSequence r3 = r4.getContentDescription()
                if (r3 != 0) goto L_0x0085
                r3 = r2
                goto L_0x008d
            L_0x0085:
                java.lang.CharSequence r3 = r4.getContentDescription()
                java.lang.String r3 = java.lang.String.valueOf(r3)
            L_0x008d:
                boolean r6 = r6.equals(r3)
                if (r6 != 0) goto L_0x0094
                return r1
            L_0x0094:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.HINT
                int r3 = r3.getValue()
                r6 = r6 & r3
                if (r6 <= 0) goto L_0x00ac
                java.lang.String r6 = r5.hint
                java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(r4)
                boolean r6 = r6.equals(r3)
                if (r6 != 0) goto L_0x00ac
                return r1
            L_0x00ac:
                int r6 = r5.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TAG
                int r3 = r3.getValue()
                r6 = r6 & r3
                if (r6 <= 0) goto L_0x00cf
                java.lang.String r5 = r5.tag
                java.lang.Object r6 = r4.getTag()
                if (r6 != 0) goto L_0x00c0
                goto L_0x00c8
            L_0x00c0:
                java.lang.Object r4 = r4.getTag()
                java.lang.String r2 = java.lang.String.valueOf(r4)
            L_0x00c8:
                boolean r4 = r5.equals(r2)
                if (r4 != 0) goto L_0x00cf
                return r1
            L_0x00cf:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.isTheSameView(android.view.View, com.facebook.appevents.codeless.internal.PathComponent, int):boolean");
        }

        private static List<View> findVisibleChildren(ViewGroup viewGroup) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }

        private void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            if (eventBinding != null) {
                try {
                    View view2 = matchedView.getView();
                    if (view2 != null) {
                        View findRCTRootView = ViewHierarchy.findRCTRootView(view2);
                        if (findRCTRootView != null && ViewHierarchy.isRCTButton(view2, findRCTRootView)) {
                            attachRCTListener(matchedView, view, findRCTRootView, eventBinding);
                        } else if (!view2.getClass().getName().startsWith("com.facebook.react")) {
                            String viewMapKey = matchedView.getViewMapKey();
                            AccessibilityDelegate existingDelegate = ViewHierarchy.getExistingDelegate(view2);
                            boolean z = true;
                            boolean z2 = existingDelegate != null;
                            boolean z3 = z2 && (existingDelegate instanceof AutoLoggingAccessibilityDelegate);
                            if (!z3 || !((AutoLoggingAccessibilityDelegate) existingDelegate).getSupportCodelessLogging()) {
                                z = false;
                            }
                            if (!this.delegateMap.containsKey(viewMapKey) && (!z2 || !z3 || !z)) {
                                view2.setAccessibilityDelegate(CodelessLoggingEventListener.getAccessibilityDelegate(eventBinding, view, view2));
                                this.delegateMap.put(viewMapKey, eventBinding.getEventName());
                            }
                        }
                    }
                } catch (FacebookException unused) {
                    CodelessMatcher.TAG;
                }
            }
        }

        private void attachRCTListener(MatchedView matchedView, View view, View view2, EventBinding eventBinding) {
            if (eventBinding != null) {
                View view3 = matchedView.getView();
                if (view3 != null && ViewHierarchy.isRCTButton(view3, view2)) {
                    String viewMapKey = matchedView.getViewMapKey();
                    OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view3);
                    boolean z = true;
                    boolean z2 = existingOnTouchListener != null;
                    boolean z3 = z2 && (existingOnTouchListener instanceof AutoLoggingOnTouchListener);
                    if (!z3 || !((AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging()) {
                        z = false;
                    }
                    if (!this.delegateMap.containsKey(viewMapKey) && (!z2 || !z3 || !z)) {
                        view3.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view3));
                        this.delegateMap.put(viewMapKey, eventBinding.getEventName());
                    }
                }
            }
        }
    }

    public void add(Activity activity) {
        if (!InternalSettings.isUnityApp()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.activitiesSet.add(activity);
                this.delegateMap.clear();
                startTracking();
                return;
            }
            throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
        }
    }

    public void remove(Activity activity) {
        if (!InternalSettings.isUnityApp()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.activitiesSet.remove(activity);
                this.viewMatchers.clear();
                this.delegateMap.clear();
                return;
            }
            throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
        }
    }

    public static Bundle getParameters(EventBinding eventBinding, View view, View view2) {
        List list;
        Bundle bundle = new Bundle();
        if (eventBinding == null) {
            return bundle;
        }
        List<ParameterComponent> viewParameters = eventBinding.getViewParameters();
        if (viewParameters != null) {
            for (ParameterComponent parameterComponent : viewParameters) {
                String str = parameterComponent.value;
                if (str == null || str.length() <= 0) {
                    if (parameterComponent.path.size() > 0) {
                        if (parameterComponent.pathType.equals("relative")) {
                            list = ViewMatcher.findViewByPath(eventBinding, view2, parameterComponent.path, 0, -1, view2.getClass().getSimpleName());
                        } else {
                            list = ViewMatcher.findViewByPath(eventBinding, view, parameterComponent.path, 0, -1, view.getClass().getSimpleName());
                        }
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            MatchedView matchedView = (MatchedView) it.next();
                            if (matchedView.getView() != null) {
                                String textOfView = ViewHierarchy.getTextOfView(matchedView.getView());
                                if (textOfView.length() > 0) {
                                    bundle.putString(parameterComponent.name, textOfView);
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    bundle.putString(parameterComponent.name, parameterComponent.value);
                }
            }
        }
        return bundle;
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            matchViews();
        } else {
            this.uiThreadHandler.post(new Runnable() {
                public void run() {
                    CodelessMatcher.this.matchViews();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void matchViews() {
        for (Activity activity : this.activitiesSet) {
            this.viewMatchers.add(new ViewMatcher(activity.getWindow().getDecorView().getRootView(), this.uiThreadHandler, this.delegateMap, activity.getClass().getSimpleName()));
        }
    }
}
