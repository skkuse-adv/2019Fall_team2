package photopicker.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ScreenUtils {
    public static final ScreenUtils INSTANCE = new ScreenUtils();

    private ScreenUtils() {
    }

    public final int dip2px(@NotNull Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final int getScreenWidth(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "(context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public final int getScreenHeight(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = ((Activity) context).getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "(context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - getStatusBarHeight(context);
    }

    private final int getStatusBarHeight(Context context) {
        String str = "com.android.internal.R$dimen";
        try {
            Object newInstance = Class.forName(str).newInstance();
            return context.getResources().getDimensionPixelSize(Integer.parseInt(Class.forName(str).getField("status_bar_height").get(newInstance).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
