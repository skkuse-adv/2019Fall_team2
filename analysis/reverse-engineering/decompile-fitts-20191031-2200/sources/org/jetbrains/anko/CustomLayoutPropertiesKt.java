package org.jetbrains.anko;

import android.view.ViewGroup.MarginLayoutParams;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class CustomLayoutPropertiesKt {
    private static final int matchParent = -1;
    private static final int wrapContent = -2;

    public static final int getMatchParent() {
        return matchParent;
    }

    public static final int getWrapContent() {
        return wrapContent;
    }

    public static final int getVerticalMargin(@NotNull MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setVerticalMargin(@NotNull MarginLayoutParams marginLayoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "receiver$0");
        marginLayoutParams.topMargin = i;
        marginLayoutParams.bottomMargin = i;
    }

    public static final int getHorizontalMargin(@NotNull MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setHorizontalMargin(@NotNull MarginLayoutParams marginLayoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "receiver$0");
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i;
    }

    public static final int getMargin(@NotNull MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setMargin(@NotNull MarginLayoutParams marginLayoutParams, int i) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "receiver$0");
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i;
        marginLayoutParams.topMargin = i;
        marginLayoutParams.bottomMargin = i;
    }
}
