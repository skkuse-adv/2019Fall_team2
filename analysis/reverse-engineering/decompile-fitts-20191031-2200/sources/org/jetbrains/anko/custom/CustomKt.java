package org.jetbrains.anko.custom;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewManager;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class CustomKt {
    @NotNull
    public static final <T extends View> T ankoView(@NotNull ViewManager viewManager, @NotNull Function1<? super Context, ? extends T> function1, int i, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        T t = (View) function1.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function12.invoke(t);
        AnkoInternals.INSTANCE.addView(viewManager, t);
        return t;
    }

    @NotNull
    public static final <T extends View> T ankoView(@NotNull Context context, @NotNull Function1<? super Context, ? extends T> function1, int i, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        T t = (View) function1.invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function12.invoke(t);
        AnkoInternals.INSTANCE.addView(context, t);
        return t;
    }

    @NotNull
    public static final <T extends View> T ankoView(@NotNull Activity activity, @NotNull Function1<? super Context, ? extends T> function1, int i, @NotNull Function1<? super T, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        T t = (View) function1.invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function12.invoke(t);
        AnkoInternals.INSTANCE.addView(activity, t);
        return t;
    }

    private static final <T extends View> T customView(@NotNull ViewManager viewManager, int i, Function1<? super T, Unit> function1) {
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        Context wrapContextIfNeeded = ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(viewManager, initiateView);
        return initiateView;
    }

    static /* synthetic */ View customView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        Context wrapContextIfNeeded = ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(viewManager, initiateView);
        return initiateView;
    }

    private static final <T extends View> T customView(@NotNull Context context, int i, Function1<? super T, Unit> function1) {
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(context, initiateView);
        return initiateView;
    }

    static /* synthetic */ View customView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(context, initiateView);
        return initiateView;
    }

    private static final <T extends View> T customView(@NotNull Activity activity, int i, Function1<? super T, Unit> function1) {
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(activity, initiateView);
        return initiateView;
    }

    static /* synthetic */ View customView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Context wrapContextIfNeeded = AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        View initiateView = AnkoInternals.initiateView(wrapContextIfNeeded, View.class);
        function1.invoke(initiateView);
        AnkoInternals.INSTANCE.addView(activity, initiateView);
        return initiateView;
    }
}
