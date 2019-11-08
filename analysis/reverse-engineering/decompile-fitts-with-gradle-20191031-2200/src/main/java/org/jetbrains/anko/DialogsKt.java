package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DialogsKt {
    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(AnkoContext ankoContext, Function1 function1, String str, String str2, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        return alert(ankoContext.getCtx(), function1, str, str2, function12);
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull AnkoContext<?> ankoContext, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @NotNull String str, @Nullable String str2, @Nullable Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        return alert(ankoContext.getCtx(), function1, str, str2, function12);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Fragment fragment, Function1 function1, String str, String str2, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, function1, str, str2, function12);
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull Fragment fragment, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @NotNull String str, @Nullable String str2, @Nullable Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, function1, str, str2, function12);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Context context, Function1 function1, String str, String str2, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        return alert(context, function1, str, str2, function12);
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull Context context, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @NotNull String str, @Nullable String str2, @Nullable Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        AlertBuilder<D> alertBuilder = (AlertBuilder) function1.invoke(context);
        if (str2 != null) {
            alertBuilder.setTitle(str2);
        }
        alertBuilder.setMessage(str);
        if (function12 != null) {
            function12.invoke(alertBuilder);
        }
        return alertBuilder;
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(AnkoContext ankoContext, Function1 function1, int i, Integer num, Function1 function12, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        return alert(ankoContext.getCtx(), function1, i, num, function12);
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull AnkoContext<?> ankoContext, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, int i, @Nullable Integer num, @Nullable Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        return alert(ankoContext.getCtx(), function1, i, num, function12);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Fragment fragment, Function1 function1, int i, Integer num, Function1 function12, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, function1, i, num, function12);
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull Fragment fragment, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, int i, @Nullable Integer num, @Nullable Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, function1, i, num, function12);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Context context, Function1 function1, int i, Integer num, Function1 function12, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        return alert(context, function1, i, num, function12);
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull Context context, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, int i, @Nullable Integer num, @Nullable Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        AlertBuilder<D> alertBuilder = (AlertBuilder) function1.invoke(context);
        if (num != null) {
            alertBuilder.setTitleResource(num.intValue());
        }
        alertBuilder.setMessageResource(i);
        if (function12 != null) {
            function12.invoke(alertBuilder);
        }
        return alertBuilder;
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull AnkoContext<?> ankoContext, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @NotNull Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        return alert(ankoContext.getCtx(), function1, function12);
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull Fragment fragment, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @NotNull Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, function1, function12);
    }

    @NotNull
    public static final <D extends DialogInterface> AlertBuilder<D> alert(@NotNull Context context, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @NotNull Function1<? super AlertBuilder<? extends D>, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(function12, "init");
        AlertBuilder<D> alertBuilder = (AlertBuilder) function1.invoke(context);
        function12.invoke(alertBuilder);
        return alertBuilder;
    }
}
