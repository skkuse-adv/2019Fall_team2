package photopicker.utils;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ScreenUtilsKt {
    public static final int screenWidth(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        return ScreenUtils.INSTANCE.getScreenWidth(context);
    }
}
