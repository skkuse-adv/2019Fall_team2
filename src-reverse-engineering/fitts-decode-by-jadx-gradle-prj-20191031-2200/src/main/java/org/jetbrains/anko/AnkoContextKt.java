package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class AnkoContextKt {
    @NotNull
    public static final AnkoContext<Context> UI(@NotNull Context context, boolean z, @NotNull Function1<? super AnkoContext<? extends Context>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, context, z);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @NotNull
    public static final AnkoContext<Context> UI(@NotNull Context context, @NotNull Function1<? super AnkoContext<? extends Context>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, context, false);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @NotNull
    public static final AnkoContext<Fragment> UI(@NotNull Fragment fragment, @NotNull Function1<? super AnkoContext<? extends Fragment>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(activity, fragment, false);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @NotNull
    public static final <T extends Activity> View setContentView(@NotNull AnkoComponent<? super T> ankoComponent, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(ankoComponent, "receiver$0");
        Intrinsics.checkParameterIsNotNull(t, "activity");
        return ankoComponent.createView(new AnkoContextImpl(t, t, true));
    }
}
