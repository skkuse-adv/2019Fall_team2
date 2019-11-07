package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.widget.Toast;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ToastsKt {
    @NotNull
    public static final Toast toast(@NotNull AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Toast makeText = Toast.makeText(ankoContext.getCtx(), i, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast toast(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Toast makeText = Toast.makeText(activity, i, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast toast(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Toast makeText = Toast.makeText(context, i, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast toast(@NotNull AnkoContext<?> ankoContext, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Toast makeText = Toast.makeText(ankoContext.getCtx(), charSequence, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast toast(@NotNull Fragment fragment, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Toast makeText = Toast.makeText(activity, charSequence, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast toast(@NotNull Context context, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Toast makeText = Toast.makeText(context, charSequence, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast longToast(@NotNull AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Toast makeText = Toast.makeText(ankoContext.getCtx(), i, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast longToast(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Toast makeText = Toast.makeText(activity, i, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast longToast(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Toast makeText = Toast.makeText(context, i, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast longToast(@NotNull AnkoContext<?> ankoContext, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Toast makeText = Toast.makeText(ankoContext.getCtx(), charSequence, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast longToast(@NotNull Fragment fragment, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Toast makeText = Toast.makeText(activity, charSequence, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast longToast(@NotNull Context context, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Toast makeText = Toast.makeText(context, charSequence, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }
}
