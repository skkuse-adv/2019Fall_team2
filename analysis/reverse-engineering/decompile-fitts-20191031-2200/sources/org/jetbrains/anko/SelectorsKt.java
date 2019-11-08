package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SelectorsKt {
    public static /* synthetic */ void selector$default(AnkoContext ankoContext, Function1 function1, CharSequence charSequence, List list, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        selector(ankoContext.getCtx(), function1, charSequence, list, function3);
    }

    public static final <D extends DialogInterface> void selector(@NotNull AnkoContext<?> ankoContext, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @Nullable CharSequence charSequence, @NotNull List<? extends CharSequence> list, @NotNull Function3<? super DialogInterface, ? super CharSequence, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        selector(ankoContext.getCtx(), function1, charSequence, list, function3);
    }

    public static /* synthetic */ void selector$default(Fragment fragment, Function1 function1, CharSequence charSequence, List list, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        selector((Context) activity, function1, charSequence, list, function3);
    }

    public static final <D extends DialogInterface> void selector(@NotNull Fragment fragment, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @Nullable CharSequence charSequence, @NotNull List<? extends CharSequence> list, @NotNull Function3<? super DialogInterface, ? super CharSequence, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        selector((Context) activity, function1, charSequence, list, function3);
    }

    public static /* synthetic */ void selector$default(Context context, Function1 function1, CharSequence charSequence, List list, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        selector(context, function1, charSequence, list, function3);
    }

    public static final <D extends DialogInterface> void selector(@NotNull Context context, @NotNull Function1<? super Context, ? extends AlertBuilder<? extends D>> function1, @Nullable CharSequence charSequence, @NotNull List<? extends CharSequence> list, @NotNull Function3<? super DialogInterface, ? super CharSequence, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "factory");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function3, "onClick");
        AlertBuilder alertBuilder = (AlertBuilder) function1.invoke(context);
        if (charSequence != null) {
            alertBuilder.setTitle(charSequence);
        }
        alertBuilder.items(list, function3);
        alertBuilder.show();
    }
}
