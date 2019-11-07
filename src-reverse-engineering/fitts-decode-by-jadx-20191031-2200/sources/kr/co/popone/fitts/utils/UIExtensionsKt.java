package kr.co.popone.fitts.utils;

import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UIExtensionsKt {
    public static final int navigationBarHeight(@NotNull Resources resources) {
        Intrinsics.checkParameterIsNotNull(resources, "receiver$0");
        int identifier = resources.getIdentifier(resources.getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
