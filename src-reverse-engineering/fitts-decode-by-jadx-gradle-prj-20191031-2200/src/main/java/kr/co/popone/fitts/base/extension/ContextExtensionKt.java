package kr.co.popone.fitts.base.extension;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;

public final class ContextExtensionKt {
    public static final void activityStart(@NotNull Context context, @NotNull Intent intent, @NotNull ActivityAnimationType activityAnimationType) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Intrinsics.checkParameterIsNotNull(activityAnimationType, "animation");
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(context, activityAnimationType.getEnter(), activityAnimationType.getExit());
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…on.enter, animation.exit)");
        context.startActivity(intent, makeCustomAnimation.toBundle());
    }

    public static final void textCopy(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text/plain", str));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public static final int getScreenWidth(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "this.resources");
        return resources.getDisplayMetrics().widthPixels;
    }

    public static final int getHeightByRatio(@NotNull Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "this.resources");
        return (int) (((float) resources.getDisplayMetrics().widthPixels) / f);
    }
}
