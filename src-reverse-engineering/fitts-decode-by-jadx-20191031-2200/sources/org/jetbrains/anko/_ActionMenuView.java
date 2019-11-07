package org.jetbrains.anko;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ActionMenuView.LayoutParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class _ActionMenuView extends ActionMenuView {
    public _ActionMenuView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        super(context);
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
    public static /* synthetic */ View lparams$default(_ActionMenuView _actionmenuview, View view, int i, int i2, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = -2;
            }
            if ((i3 & 2) != 0) {
                i2 = -2;
            }
            Intrinsics.checkParameterIsNotNull(view, "receiver$0");
            Intrinsics.checkParameterIsNotNull(function1, "init");
            LayoutParams layoutParams = new LayoutParams(i, i2);
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return view;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lparams");
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, int i, int i2, @NotNull Function1<? super LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        LayoutParams layoutParams = new LayoutParams(i, i2);
        function1.invoke(layoutParams);
        t.setLayoutParams(layoutParams);
        return t;
    }

    @NotNull
    public static /* synthetic */ View lparams$default(_ActionMenuView _actionmenuview, View view, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = -2;
            }
            if ((i3 & 2) != 0) {
                i2 = -2;
            }
            Intrinsics.checkParameterIsNotNull(view, "receiver$0");
            view.setLayoutParams(new LayoutParams(i, i2));
            return view;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lparams");
    }

    @NotNull
    public final <T extends View> T lparams(@NotNull T t, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        t.setLayoutParams(new LayoutParams(i, i2));
        return t;
    }
}
