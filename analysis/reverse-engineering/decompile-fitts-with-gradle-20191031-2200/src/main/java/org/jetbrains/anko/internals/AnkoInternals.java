package org.jetbrains.anko.internals;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import java.io.Serializable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoContext;
import org.jetbrains.anko.AnkoContextImpl;
import org.jetbrains.anko.AnkoException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnkoInternals {
    public static final AnkoInternals INSTANCE = new AnkoInternals();
    @NotNull
    public static final String NO_GETTER = "Property does not have a getter";

    private static final class AnkoContextThemeWrapper extends ContextThemeWrapper {
        private final int theme;

        public AnkoContextThemeWrapper(@Nullable Context context, int i) {
            super(context, i);
            this.theme = i;
        }

        public final int getTheme() {
            return this.theme;
        }
    }

    private static final class InternalConfiguration {
        public static final InternalConfiguration INSTANCE = new InternalConfiguration();
        private static final int SCREENLAYOUT_LAYOUTDIR_MASK = SCREENLAYOUT_LAYOUTDIR_MASK;
        private static final int SCREENLAYOUT_LAYOUTDIR_RTL = (2 << SCREENLAYOUT_LAYOUTDIR_SHIFT);
        private static final int SCREENLAYOUT_LAYOUTDIR_SHIFT = 6;
        private static final int UI_MODE_TYPE_APPLIANCE = 5;
        private static final int UI_MODE_TYPE_WATCH = 6;

        private InternalConfiguration() {
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_MASK() {
            return SCREENLAYOUT_LAYOUTDIR_MASK;
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_SHIFT() {
            return SCREENLAYOUT_LAYOUTDIR_SHIFT;
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_RTL() {
            return SCREENLAYOUT_LAYOUTDIR_RTL;
        }

        public final int getUI_MODE_TYPE_APPLIANCE() {
            return UI_MODE_TYPE_APPLIANCE;
        }

        public final int getUI_MODE_TYPE_WATCH() {
            return UI_MODE_TYPE_WATCH;
        }
    }

    private AnkoInternals() {
    }

    @NotNull
    public final Void noGetter() {
        throw new AnkoException(NO_GETTER);
    }

    public final <T extends View> void addView(@NotNull ViewManager viewManager, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(viewManager, "manager");
        Intrinsics.checkParameterIsNotNull(t, "view");
        if (viewManager instanceof ViewGroup) {
            ((ViewGroup) viewManager).addView(t);
        } else if (viewManager instanceof AnkoContext) {
            viewManager.addView(t, null);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(viewManager);
            sb.append(" is the wrong parent");
            throw new AnkoException(sb.toString());
        }
    }

    @NotNull
    public final Context wrapContextIfNeeded(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        if (i != 0) {
            return (!(context instanceof AnkoContextThemeWrapper) || ((AnkoContextThemeWrapper) context).getTheme() != i) ? new AnkoContextThemeWrapper(context, i) : context;
        }
        return context;
    }

    public final void applyRecursively(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(function1, "style");
        function1.invoke(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount() - 1;
            int i = 0;
            if (childCount >= 0) {
                while (true) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        INSTANCE.applyRecursively(childAt, function1);
                    }
                    if (i != childCount) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @NotNull
    public final Context getContext(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "manager");
        if (viewManager instanceof ViewGroup) {
            Context context = ((ViewGroup) viewManager).getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "manager.context");
            return context;
        } else if (viewManager instanceof AnkoContext) {
            return ((AnkoContext) viewManager).getCtx();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(viewManager);
            sb.append(" is the wrong parent");
            throw new AnkoException(sb.toString());
        }
    }

    @NotNull
    public static /* synthetic */ AnkoContext createAnkoContext$default(AnkoInternals ankoInternals, Object obj, Context context, Function1 function1, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, obj, z);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @NotNull
    public final <T> AnkoContext<T> createAnkoContext(T t, @NotNull Context context, @NotNull Function1<? super AnkoContext<? extends T>, Unit> function1, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, t, z);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @NotNull
    public static final <T> Intent createIntent(@NotNull Context context, @NotNull Class<? extends T> cls, @NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        Intent intent = new Intent(context, cls);
        if (!(pairArr.length == 0)) {
            fillIntentArguments(intent, pairArr);
        }
        return intent;
    }

    public static final void internalStartActivity(@NotNull Context context, @NotNull Class<? extends Activity> cls, @NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, "activity");
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        context.startActivity(createIntent(context, cls, pairArr));
    }

    public static final void internalStartActivityForResult(@NotNull Activity activity, @NotNull Class<? extends Activity> cls, int i, @NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(activity, "act");
        Intrinsics.checkParameterIsNotNull(cls, "activity");
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        activity.startActivityForResult(createIntent(activity, cls, pairArr), i);
    }

    @Nullable
    public static final ComponentName internalStartService(@NotNull Context context, @NotNull Class<? extends Service> cls, @NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        return context.startService(createIntent(context, cls, pairArr));
    }

    public static final boolean internalStopService(@NotNull Context context, @NotNull Class<? extends Service> cls, @NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        return context.stopService(createIntent(context, cls, pairArr));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r3, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T useCursor(@org.jetbrains.annotations.NotNull android.database.Cursor r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends T> r4) {
        /*
            java.lang.String r0 = "cursor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "f"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 16
            if (r0 < r2) goto L_0x002d
            r0 = 0
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x0020 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            goto L_0x003a
        L_0x0020:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x002d:
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x003b }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            r3.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
        L_0x003a:
            return r4
        L_0x003b:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            r3.close()     // Catch:{ Exception -> 0x0042 }
        L_0x0042:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.internals.AnkoInternals.useCursor(android.database.Cursor, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r5 = r1.invoke().newInstance(new java.lang.Object[]{r5, null});
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, "getConstructor2().newInstance(ctx, null)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0041, code lost:
        return (android.view.View) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0042, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("Can't initiate View of class ");
        r0.append(r6.getName());
        r0.append(": can't find proper constructor");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0061, code lost:
        throw new org.jetbrains.anko.AnkoException(r0.toString());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x002a */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> T initiateView(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.NotNull java.lang.Class<T> r6) {
        /*
            java.lang.String r0 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "viewClass"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            org.jetbrains.anko.internals.AnkoInternals$initiateView$1 r0 = new org.jetbrains.anko.internals.AnkoInternals$initiateView$1
            r0.<init>(r6)
            org.jetbrains.anko.internals.AnkoInternals$initiateView$2 r1 = new org.jetbrains.anko.internals.AnkoInternals$initiateView$2
            r1.<init>(r6)
            r2 = 0
            r3 = 1
            java.lang.reflect.Constructor r0 = r0.invoke()     // Catch:{ NoSuchMethodException -> 0x002a }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x002a }
            r4[r2] = r5     // Catch:{ NoSuchMethodException -> 0x002a }
            java.lang.Object r0 = r0.newInstance(r4)     // Catch:{ NoSuchMethodException -> 0x002a }
            java.lang.String r4 = "getConstructor1().newInstance(ctx)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)     // Catch:{ NoSuchMethodException -> 0x002a }
            android.view.View r0 = (android.view.View) r0     // Catch:{ NoSuchMethodException -> 0x002a }
            return r0
        L_0x002a:
            java.lang.reflect.Constructor r0 = r1.invoke()     // Catch:{ NoSuchMethodException -> 0x0042 }
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x0042 }
            r1[r2] = r5     // Catch:{ NoSuchMethodException -> 0x0042 }
            r5 = 0
            r1[r3] = r5     // Catch:{ NoSuchMethodException -> 0x0042 }
            java.lang.Object r5 = r0.newInstance(r1)     // Catch:{ NoSuchMethodException -> 0x0042 }
            java.lang.String r0 = "getConstructor2().newInstance(ctx, null)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)     // Catch:{ NoSuchMethodException -> 0x0042 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ NoSuchMethodException -> 0x0042 }
            return r5
        L_0x0042:
            org.jetbrains.anko.AnkoException r5 = new org.jetbrains.anko.AnkoException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Can't initiate View of class "
            r0.append(r1)
            java.lang.String r6 = r6.getName()
            r0.append(r6)
            java.lang.String r6 = ": can't find proper constructor"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.internals.AnkoInternals.initiateView(android.content.Context, java.lang.Class):android.view.View");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0164, code lost:
        if (r28.booleanValue() != false) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        if (r1 != ((java.lang.Number) r21.getEndInclusive()).intValue()) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean testConfiguration(@org.jetbrains.annotations.NotNull android.content.Context r19, @org.jetbrains.annotations.Nullable org.jetbrains.anko.ScreenSize r20, @org.jetbrains.annotations.Nullable kotlin.ranges.ClosedRange<java.lang.Integer> r21, @org.jetbrains.annotations.Nullable java.lang.String r22, @org.jetbrains.annotations.Nullable org.jetbrains.anko.Orientation r23, @org.jetbrains.annotations.Nullable java.lang.Boolean r24, @org.jetbrains.annotations.Nullable java.lang.Integer r25, @org.jetbrains.annotations.Nullable java.lang.Integer r26, @org.jetbrains.annotations.Nullable org.jetbrains.anko.UiMode r27, @org.jetbrains.annotations.Nullable java.lang.Boolean r28, @org.jetbrains.annotations.Nullable java.lang.Boolean r29, @org.jetbrains.annotations.Nullable java.lang.Integer r30) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            r7 = r22
            r8 = r23
            r9 = r27
            r10 = r29
            java.lang.String r3 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r3)
            android.content.res.Resources r3 = r19.getResources()
            if (r3 == 0) goto L_0x001f
            android.content.res.Configuration r3 = r3.getConfiguration()
            r12 = r3
            goto L_0x0020
        L_0x001f:
            r12 = 0
        L_0x0020:
            r13 = 4
            r14 = 3
            r15 = 2
            r6 = 1
            r16 = 0
            if (r1 == 0) goto L_0x004e
            if (r12 != 0) goto L_0x002b
            return r16
        L_0x002b:
            int r3 = r12.screenLayout
            r3 = r3 & 15
            if (r3 == 0) goto L_0x004e
            if (r3 == r6) goto L_0x0049
            if (r3 == r15) goto L_0x0044
            if (r3 == r14) goto L_0x003f
            if (r3 == r13) goto L_0x003a
            goto L_0x004e
        L_0x003a:
            org.jetbrains.anko.ScreenSize r3 = org.jetbrains.anko.ScreenSize.XLARGE
            if (r1 == r3) goto L_0x004e
            return r16
        L_0x003f:
            org.jetbrains.anko.ScreenSize r3 = org.jetbrains.anko.ScreenSize.LARGE
            if (r1 == r3) goto L_0x004e
            return r16
        L_0x0044:
            org.jetbrains.anko.ScreenSize r3 = org.jetbrains.anko.ScreenSize.NORMAL
            if (r1 == r3) goto L_0x004e
            return r16
        L_0x0049:
            org.jetbrains.anko.ScreenSize r3 = org.jetbrains.anko.ScreenSize.SMALL
            if (r1 == r3) goto L_0x004e
            return r16
        L_0x004e:
            if (r2 == 0) goto L_0x0075
            android.content.res.Resources r1 = r19.getResources()
            if (r1 == 0) goto L_0x0074
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            if (r1 == 0) goto L_0x0074
            int r1 = r1.densityDpi
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            boolean r3 = r2.contains(r3)
            if (r3 == 0) goto L_0x0074
            java.lang.Comparable r2 = r21.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r1 != r2) goto L_0x0075
        L_0x0074:
            return r16
        L_0x0075:
            if (r7 == 0) goto L_0x00aa
            java.util.Locale r5 = java.util.Locale.getDefault()
            r2 = 95
            r3 = 0
            r4 = 0
            r17 = 6
            r18 = 0
            r1 = r22
            r20 = r5
            r5 = r17
            r11 = 1
            r6 = r18
            int r1 = kotlin.text.StringsKt__StringsKt.indexOf$default(r1, r2, r3, r4, r5, r6)
            if (r1 < 0) goto L_0x0097
            java.lang.String r1 = r20.toString()
            goto L_0x00a2
        L_0x0097:
            java.lang.String r1 = "locale"
            r2 = r20
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r1)
            java.lang.String r1 = r2.getLanguage()
        L_0x00a2:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r7)
            r1 = r1 ^ r11
            if (r1 == 0) goto L_0x00ab
            return r16
        L_0x00aa:
            r11 = 1
        L_0x00ab:
            if (r8 == 0) goto L_0x00c8
            if (r12 != 0) goto L_0x00b0
            return r16
        L_0x00b0:
            int r1 = r12.orientation
            if (r1 == r11) goto L_0x00c3
            if (r1 == r15) goto L_0x00be
            if (r1 == r14) goto L_0x00b9
            goto L_0x00c8
        L_0x00b9:
            org.jetbrains.anko.Orientation r1 = org.jetbrains.anko.Orientation.SQUARE
            if (r8 == r1) goto L_0x00c8
            return r16
        L_0x00be:
            org.jetbrains.anko.Orientation r1 = org.jetbrains.anko.Orientation.LANDSCAPE
            if (r8 == r1) goto L_0x00c8
            return r16
        L_0x00c3:
            org.jetbrains.anko.Orientation r1 = org.jetbrains.anko.Orientation.PORTRAIT
            if (r8 == r1) goto L_0x00c8
            return r16
        L_0x00c8:
            if (r24 == 0) goto L_0x00e7
            if (r12 != 0) goto L_0x00cd
            return r16
        L_0x00cd:
            int r1 = r12.screenLayout
            r1 = r1 & 48
            r2 = 32
            if (r1 != r2) goto L_0x00dc
            boolean r2 = r24.booleanValue()
            if (r2 != 0) goto L_0x00dc
            return r16
        L_0x00dc:
            r2 = 16
            if (r1 != r2) goto L_0x00e7
            boolean r1 = r24.booleanValue()
            if (r1 == 0) goto L_0x00e7
            return r16
        L_0x00e7:
            if (r25 == 0) goto L_0x00f6
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = r25.intValue()
            int r1 = kotlin.jvm.internal.Intrinsics.compare(r1, r2)
            if (r1 >= 0) goto L_0x00f6
            return r16
        L_0x00f6:
            if (r26 == 0) goto L_0x0101
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = r26.intValue()
            if (r1 == r2) goto L_0x0101
            return r16
        L_0x0101:
            if (r9 == 0) goto L_0x0140
            if (r12 != 0) goto L_0x0106
            return r16
        L_0x0106:
            int r1 = r12.uiMode
            r1 = r1 & 15
            if (r1 != r11) goto L_0x0111
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.NORMAL
            if (r9 == r1) goto L_0x0140
            return r16
        L_0x0111:
            if (r1 != r15) goto L_0x0118
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.DESK
            if (r9 == r1) goto L_0x0140
            return r16
        L_0x0118:
            if (r1 != r14) goto L_0x011f
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.CAR
            if (r9 == r1) goto L_0x0140
            return r16
        L_0x011f:
            if (r1 != r13) goto L_0x0126
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.TELEVISION
            if (r9 == r1) goto L_0x0140
            return r16
        L_0x0126:
            org.jetbrains.anko.internals.AnkoInternals$InternalConfiguration r2 = org.jetbrains.anko.internals.AnkoInternals.InternalConfiguration.INSTANCE
            int r2 = r2.getUI_MODE_TYPE_APPLIANCE()
            if (r1 != r2) goto L_0x0133
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.APPLIANCE
            if (r9 == r1) goto L_0x0140
            return r16
        L_0x0133:
            org.jetbrains.anko.internals.AnkoInternals$InternalConfiguration r2 = org.jetbrains.anko.internals.AnkoInternals.InternalConfiguration.INSTANCE
            int r2 = r2.getUI_MODE_TYPE_WATCH()
            if (r1 != r2) goto L_0x0140
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.WATCH
            if (r9 == r1) goto L_0x0140
            return r16
        L_0x0140:
            if (r28 == 0) goto L_0x0167
            java.lang.String r1 = "uimode"
            java.lang.Object r0 = r0.getSystemService(r1)
            boolean r1 = r0 instanceof android.app.UiModeManager
            if (r1 != 0) goto L_0x014d
            r0 = 0
        L_0x014d:
            android.app.UiModeManager r0 = (android.app.UiModeManager) r0
            if (r0 == 0) goto L_0x0166
            int r0 = r0.getNightMode()
            if (r0 != r15) goto L_0x015e
            boolean r1 = r28.booleanValue()
            if (r1 != 0) goto L_0x015e
            return r16
        L_0x015e:
            if (r0 != r11) goto L_0x0167
            boolean r0 = r28.booleanValue()
            if (r0 == 0) goto L_0x0167
        L_0x0166:
            return r16
        L_0x0167:
            if (r10 == 0) goto L_0x018c
            if (r12 != 0) goto L_0x016c
            return r16
        L_0x016c:
            int r0 = r12.screenLayout
            org.jetbrains.anko.internals.AnkoInternals$InternalConfiguration r1 = org.jetbrains.anko.internals.AnkoInternals.InternalConfiguration.INSTANCE
            int r1 = r1.getSCREENLAYOUT_LAYOUTDIR_MASK()
            r0 = r0 & r1
            org.jetbrains.anko.internals.AnkoInternals$InternalConfiguration r1 = org.jetbrains.anko.internals.AnkoInternals.InternalConfiguration.INSTANCE
            int r1 = r1.getSCREENLAYOUT_LAYOUTDIR_RTL()
            if (r0 != r1) goto L_0x017f
            r0 = 1
            goto L_0x0180
        L_0x017f:
            r0 = 0
        L_0x0180:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r10)
            r0 = r0 ^ r11
            if (r0 == 0) goto L_0x018c
            return r16
        L_0x018c:
            if (r30 == 0) goto L_0x01a7
            if (r12 != 0) goto L_0x0191
            return r16
        L_0x0191:
            int r0 = r12.smallestScreenWidthDp
            if (r0 != 0) goto L_0x019c
            int r0 = r30.intValue()
            if (r0 == 0) goto L_0x01a7
            return r16
        L_0x019c:
            int r1 = r30.intValue()
            int r0 = kotlin.jvm.internal.Intrinsics.compare(r0, r1)
            if (r0 >= 0) goto L_0x01a7
            return r16
        L_0x01a7:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.internals.AnkoInternals.testConfiguration(android.content.Context, org.jetbrains.anko.ScreenSize, kotlin.ranges.ClosedRange, java.lang.String, org.jetbrains.anko.Orientation, java.lang.Boolean, java.lang.Integer, java.lang.Integer, org.jetbrains.anko.UiMode, java.lang.Boolean, java.lang.Boolean, java.lang.Integer):boolean");
    }

    public final <T extends View> void addView(@NotNull Context context, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(t, "view");
        INSTANCE.addView((ViewManager) new AnkoContextImpl(context, context, false), t);
    }

    public final <T extends View> void addView(@NotNull Activity activity, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(t, "view");
        INSTANCE.addView((ViewManager) new AnkoContextImpl(activity, this, true), t);
    }

    private static final void fillIntentArguments(Intent intent, Pair<String, ? extends Object>[] pairArr) {
        for (Pair<String, ? extends Object> pair : pairArr) {
            Object second = pair.getSecond();
            if (second == null) {
                intent.putExtra((String) pair.getFirst(), null);
            } else if (second instanceof Integer) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).intValue());
            } else if (second instanceof Long) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).longValue());
            } else if (second instanceof CharSequence) {
                intent.putExtra((String) pair.getFirst(), (CharSequence) second);
            } else if (second instanceof String) {
                intent.putExtra((String) pair.getFirst(), (String) second);
            } else if (second instanceof Float) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).floatValue());
            } else if (second instanceof Double) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).doubleValue());
            } else if (second instanceof Character) {
                intent.putExtra((String) pair.getFirst(), ((Character) second).charValue());
            } else if (second instanceof Short) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).shortValue());
            } else if (second instanceof Boolean) {
                intent.putExtra((String) pair.getFirst(), ((Boolean) second).booleanValue());
            } else if (second instanceof Serializable) {
                intent.putExtra((String) pair.getFirst(), (Serializable) second);
            } else if (second instanceof Bundle) {
                intent.putExtra((String) pair.getFirst(), (Bundle) second);
            } else if (second instanceof Parcelable) {
                intent.putExtra((String) pair.getFirst(), (Parcelable) second);
            } else {
                String str = " has wrong type ";
                String str2 = "Intent extra ";
                if (second instanceof Object[]) {
                    Object[] objArr = (Object[]) second;
                    if (objArr instanceof CharSequence[]) {
                        intent.putExtra((String) pair.getFirst(), (Serializable) second);
                    } else if (objArr instanceof String[]) {
                        intent.putExtra((String) pair.getFirst(), (Serializable) second);
                    } else if (objArr instanceof Parcelable[]) {
                        intent.putExtra((String) pair.getFirst(), (Serializable) second);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append((String) pair.getFirst());
                        sb.append(str);
                        sb.append(objArr.getClass().getName());
                        throw new AnkoException(sb.toString());
                    }
                } else if (second instanceof int[]) {
                    intent.putExtra((String) pair.getFirst(), (int[]) second);
                } else if (second instanceof long[]) {
                    intent.putExtra((String) pair.getFirst(), (long[]) second);
                } else if (second instanceof float[]) {
                    intent.putExtra((String) pair.getFirst(), (float[]) second);
                } else if (second instanceof double[]) {
                    intent.putExtra((String) pair.getFirst(), (double[]) second);
                } else if (second instanceof char[]) {
                    intent.putExtra((String) pair.getFirst(), (char[]) second);
                } else if (second instanceof short[]) {
                    intent.putExtra((String) pair.getFirst(), (short[]) second);
                } else if (second instanceof boolean[]) {
                    intent.putExtra((String) pair.getFirst(), (boolean[]) second);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append((String) pair.getFirst());
                    sb2.append(str);
                    sb2.append(second.getClass().getName());
                    throw new AnkoException(sb2.toString());
                }
            }
        }
    }
}
