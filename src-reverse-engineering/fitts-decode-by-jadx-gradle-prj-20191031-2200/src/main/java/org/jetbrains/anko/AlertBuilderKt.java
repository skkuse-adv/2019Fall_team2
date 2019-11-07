package org.jetbrains.anko;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class AlertBuilderKt {
    public static final void customTitle(@NotNull AlertBuilder<?> alertBuilder, @NotNull Function1<? super ViewManager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(alertBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "dsl");
        Context ctx = alertBuilder.getCtx();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(ctx, ctx, false);
        function1.invoke(ankoContextImpl);
        alertBuilder.setCustomTitle(ankoContextImpl.getView());
    }

    public static final void customView(@NotNull AlertBuilder<?> alertBuilder, @NotNull Function1<? super ViewManager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(alertBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "dsl");
        Context ctx = alertBuilder.getCtx();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(ctx, ctx, false);
        function1.invoke(ankoContextImpl);
        alertBuilder.setCustomView(ankoContextImpl.getView());
    }

    public static final void okButton(@NotNull AlertBuilder<?> alertBuilder, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(alertBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        alertBuilder.positiveButton(17039370, function1);
    }

    public static final void cancelButton(@NotNull AlertBuilder<?> alertBuilder, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(alertBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        alertBuilder.negativeButton(17039360, function1);
    }

    public static final void yesButton(@NotNull AlertBuilder<?> alertBuilder, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(alertBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        alertBuilder.positiveButton(17039379, function1);
    }

    public static final void noButton(@NotNull AlertBuilder<?> alertBuilder, @NotNull Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(alertBuilder, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        alertBuilder.negativeButton(17039369, function1);
    }
}
