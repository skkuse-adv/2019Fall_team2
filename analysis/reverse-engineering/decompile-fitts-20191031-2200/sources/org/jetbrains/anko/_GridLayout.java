package org.jetbrains.anko;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.GridLayout.Spec;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class _GridLayout extends GridLayout {
    public _GridLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        super(context);
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable Spec spec, @Nullable Spec spec2, @NotNull Function1<? super LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (spec == null) {
            Intrinsics.throwNpe();
        }
        if (spec2 == null) {
            Intrinsics.throwNpe();
        }
        LayoutParams layoutParams = new LayoutParams(spec, spec2);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable Spec spec, @Nullable Spec spec2) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        if (spec == null) {
            Intrinsics.throwNpe();
        }
        if (spec2 == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new LayoutParams(spec, spec2));
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @NotNull Function1<? super LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        LayoutParams layoutParams = new LayoutParams();
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        t.setLayoutParams(new LayoutParams());
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable ViewGroup.LayoutParams layoutParams, @NotNull Function1<? super LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        function1.invoke(layoutParams2);
        t.setLayoutParams(layoutParams2);
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new LayoutParams(layoutParams));
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable MarginLayoutParams marginLayoutParams, @NotNull Function1<? super LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (marginLayoutParams == null) {
            Intrinsics.throwNpe();
        }
        LayoutParams layoutParams = new LayoutParams(marginLayoutParams);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        if (marginLayoutParams == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new LayoutParams(marginLayoutParams));
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable LayoutParams layoutParams, @NotNull Function1<? super LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        function1.invoke(layoutParams2);
        t.setLayoutParams(layoutParams2);
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        if (layoutParams == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new LayoutParams(layoutParams));
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable Context context, @Nullable AttributeSet attributeSet, @NotNull Function1<? super LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        if (context == null) {
            Intrinsics.throwNpe();
        }
        if (attributeSet == null) {
            Intrinsics.throwNpe();
        }
        LayoutParams layoutParams = new LayoutParams(context, attributeSet);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, @Nullable Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        if (context == null) {
            Intrinsics.throwNpe();
        }
        if (attributeSet == null) {
            Intrinsics.throwNpe();
        }
        t.setLayoutParams(new LayoutParams(context, attributeSet));
        return t;
    }
}
