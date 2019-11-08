package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.core.view.ViewCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HelpersKt {
    public static final int getGray(int i) {
        return (i << 16) | (i << 8) | i;
    }

    public static final int getOpaque(int i) {
        return i | ((int) 4278190080L);
    }

    public static final int withAlpha(int i, int i2) {
        if (i2 >= 0 && 255 >= i2) {
            return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Nullable
    public static /* synthetic */ Object configuration$default(Context context, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            screenSize = null;
        }
        if ((i & 2) != 0) {
            closedRange = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            orientation = null;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            num2 = null;
        }
        if ((i & 128) != 0) {
            uiMode = null;
        }
        if ((i & 256) != 0) {
            bool2 = null;
        }
        if ((i & 512) != 0) {
            bool3 = null;
        }
        if ((i & 1024) != 0) {
            num3 = null;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(context, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return function0.invoke();
        }
        return null;
    }

    @Nullable
    public static final <T> T configuration(@NotNull Context context, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(context, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return function0.invoke();
        }
        return null;
    }

    @Nullable
    public static /* synthetic */ Object configuration$default(Activity activity, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            screenSize = null;
        }
        if ((i & 2) != 0) {
            closedRange = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            orientation = null;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            num2 = null;
        }
        if ((i & 128) != 0) {
            uiMode = null;
        }
        if ((i & 256) != 0) {
            bool2 = null;
        }
        if ((i & 512) != 0) {
            bool3 = null;
        }
        if ((i & 1024) != 0) {
            num3 = null;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return function0.invoke();
        }
        return null;
    }

    @Nullable
    public static final <T> T configuration(@NotNull Activity activity, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return function0.invoke();
        }
        return null;
    }

    @Nullable
    public static /* synthetic */ Object configuration$default(AnkoContext ankoContext, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            screenSize = null;
        }
        if ((i & 2) != 0) {
            closedRange = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            orientation = null;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            num2 = null;
        }
        if ((i & 128) != 0) {
            uiMode = null;
        }
        if ((i & 256) != 0) {
            bool2 = null;
        }
        if ((i & 512) != 0) {
            bool3 = null;
        }
        if ((i & 1024) != 0) {
            num3 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(ankoContext.getCtx(), screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return function0.invoke();
        }
        return null;
    }

    @Nullable
    public static final <T> T configuration(@NotNull AnkoContext<?> ankoContext, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        AnkoContext<?> ankoContext2 = ankoContext;
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (AnkoInternals.testConfiguration(ankoContext.getCtx(), screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return function0.invoke();
        }
        return null;
    }

    @Nullable
    public static /* synthetic */ Object configuration$default(Fragment fragment, ScreenSize screenSize, ClosedRange closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            screenSize = null;
        }
        if ((i & 2) != 0) {
            closedRange = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            orientation = null;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            num2 = null;
        }
        if ((i & 128) != 0) {
            uiMode = null;
        }
        if ((i & 256) != 0) {
            bool2 = null;
        }
        if ((i & 512) != 0) {
            bool3 = null;
        }
        if ((i & 1024) != 0) {
            num3 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return null;
        }
        return function0.invoke();
    }

    @Nullable
    public static final <T> T configuration(@NotNull Fragment fragment, @Nullable ScreenSize screenSize, @Nullable ClosedRange<Integer> closedRange, @Nullable String str, @Nullable Orientation orientation, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable UiMode uiMode, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num3, @NotNull Function0<? extends T> function0) {
        Fragment fragment2 = fragment;
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Activity activity = fragment.getActivity();
        if (activity == null || !AnkoInternals.testConfiguration(activity, screenSize, closedRange, str, orientation, bool, num, num2, uiMode, bool2, bool3, num3)) {
            return null;
        }
        return function0.invoke();
    }

    public static final void doBeforeSdk(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (VERSION.SDK_INT <= i) {
            function0.invoke();
        }
    }

    public static final void doFromSdk(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (VERSION.SDK_INT >= i) {
            function0.invoke();
        }
    }

    public static final void doIfSdk(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        if (VERSION.SDK_INT == i) {
            function0.invoke();
        }
    }

    @NotNull
    public static final <T> AttemptResult<T> attempt(@NotNull Function0<? extends T> function0) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(function0, "f");
        Throwable th = null;
        try {
            obj = function0.invoke();
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        return new AttemptResult<>(obj, th);
    }
}
