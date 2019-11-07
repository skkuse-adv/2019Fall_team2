package org.jetbrains.anko;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AndroidDialogsKt {
    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(AnkoContext ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        return alert(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @NotNull
    public static final AlertBuilder<AlertDialog> alert(@NotNull AnkoContext<?> ankoContext, @NotNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        return alert(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, charSequence, charSequence2, function1);
    }

    @NotNull
    public static final AlertBuilder<AlertDialog> alert(@NotNull Fragment fragment, @NotNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, charSequence, charSequence2, function1);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Context context, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return alert(context, charSequence, charSequence2, function1);
    }

    @NotNull
    public static final AlertBuilder<AlertDialog> alert(@NotNull Context context, @NotNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        AndroidAlertBuilder androidAlertBuilder = new AndroidAlertBuilder(context);
        if (charSequence2 != null) {
            androidAlertBuilder.setTitle(charSequence2);
        }
        androidAlertBuilder.setMessage(charSequence);
        if (function1 != null) {
            function1.invoke(androidAlertBuilder);
        }
        return androidAlertBuilder;
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(AnkoContext ankoContext, int i, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return alert(ankoContext.getCtx(), i, num, function1);
    }

    @NotNull
    public static final AlertBuilder<DialogInterface> alert(@NotNull AnkoContext<?> ankoContext, int i, @Nullable Integer num, @Nullable Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return alert(ankoContext.getCtx(), i, num, function1);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Fragment fragment, int i, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, i, num, function1);
    }

    @NotNull
    public static final AlertBuilder<DialogInterface> alert(@NotNull Fragment fragment, int i, @Nullable Integer num, @Nullable Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, i, num, function1);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Context context, int i, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return alert(context, i, num, function1);
    }

    @NotNull
    public static final AlertBuilder<DialogInterface> alert(@NotNull Context context, int i, @Nullable Integer num, @Nullable Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        AndroidAlertBuilder androidAlertBuilder = new AndroidAlertBuilder(context);
        if (num != null) {
            androidAlertBuilder.setTitleResource(num.intValue());
        }
        androidAlertBuilder.setMessageResource(i);
        if (function1 != null) {
            function1.invoke(androidAlertBuilder);
        }
        return androidAlertBuilder;
    }

    @NotNull
    public static final AlertBuilder<DialogInterface> alert(@NotNull AnkoContext<?> ankoContext, @NotNull Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        return alert(ankoContext.getCtx(), function1);
    }

    @NotNull
    public static final AlertBuilder<DialogInterface> alert(@NotNull Fragment fragment, @NotNull Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return alert((Context) activity, function1);
    }

    @NotNull
    public static final AlertBuilder<DialogInterface> alert(@NotNull Context context, @NotNull Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AndroidAlertBuilder androidAlertBuilder = new AndroidAlertBuilder(context);
        function1.invoke(androidAlertBuilder);
        return androidAlertBuilder;
    }

    @NotNull
    public static /* synthetic */ ProgressDialog progressDialog$default(AnkoContext ankoContext, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return progressDialog(ankoContext.getCtx(), num, num2, function1);
    }

    @NotNull
    public static final ProgressDialog progressDialog(@NotNull AnkoContext<?> ankoContext, @Nullable Integer num, @Nullable Integer num2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return progressDialog(ankoContext.getCtx(), num, num2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog progressDialog$default(Fragment fragment, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return progressDialog((Context) activity, num, num2, function1);
    }

    @NotNull
    public static final ProgressDialog progressDialog(@NotNull Fragment fragment, @Nullable Integer num, @Nullable Integer num2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return progressDialog((Context) activity, num, num2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog progressDialog$default(Context context, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return progressDialog(context, num, num2, function1);
    }

    @NotNull
    public static final ProgressDialog progressDialog(@NotNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        String str = null;
        CharSequence string = num != null ? context.getString(num.intValue()) : null;
        if (num2 != null) {
            str = context.getString(num2.intValue());
        }
        return progressDialog(context, false, string, str, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog indeterminateProgressDialog$default(AnkoContext ankoContext, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return indeterminateProgressDialog(ankoContext.getCtx(), num, num2, function1);
    }

    @NotNull
    public static final ProgressDialog indeterminateProgressDialog(@NotNull AnkoContext<?> ankoContext, @Nullable Integer num, @Nullable Integer num2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return indeterminateProgressDialog(ankoContext.getCtx(), num, num2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Fragment fragment, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return indeterminateProgressDialog((Context) activity, num, num2, function1);
    }

    @NotNull
    public static final ProgressDialog indeterminateProgressDialog(@NotNull Fragment fragment, @Nullable Integer num, @Nullable Integer num2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return indeterminateProgressDialog((Context) activity, num, num2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Context context, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return indeterminateProgressDialog(context, num, num2, function1);
    }

    @NotNull
    public static final ProgressDialog indeterminateProgressDialog(@NotNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        String str = null;
        CharSequence string = num != null ? context.getString(num.intValue()) : null;
        if (num2 != null) {
            str = context.getString(num2.intValue());
        }
        return progressDialog(context, true, string, str, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog progressDialog$default(AnkoContext ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return progressDialog(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @NotNull
    public static final ProgressDialog progressDialog(@NotNull AnkoContext<?> ankoContext, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return progressDialog(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog progressDialog$default(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return progressDialog((Context) activity, charSequence, charSequence2, function1);
    }

    @NotNull
    public static final ProgressDialog progressDialog(@NotNull Fragment fragment, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return progressDialog((Context) activity, charSequence, charSequence2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog progressDialog$default(Context context, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return progressDialog(context, charSequence, charSequence2, function1);
    }

    @NotNull
    public static final ProgressDialog progressDialog(@NotNull Context context, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        return progressDialog(context, false, charSequence, charSequence2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog indeterminateProgressDialog$default(AnkoContext ankoContext, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return indeterminateProgressDialog(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @NotNull
    public static final ProgressDialog indeterminateProgressDialog(@NotNull AnkoContext<?> ankoContext, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return indeterminateProgressDialog(ankoContext.getCtx(), charSequence, charSequence2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Fragment fragment, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return indeterminateProgressDialog((Context) activity, charSequence, charSequence2, function1);
    }

    @NotNull
    public static final ProgressDialog indeterminateProgressDialog(@NotNull Fragment fragment, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return indeterminateProgressDialog((Context) activity, charSequence, charSequence2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Context context, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return indeterminateProgressDialog(context, charSequence, charSequence2, function1);
    }

    @NotNull
    public static final ProgressDialog indeterminateProgressDialog(@NotNull Context context, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        return progressDialog(context, true, charSequence, charSequence2, function1);
    }

    static /* synthetic */ ProgressDialog progressDialog$default(Context context, boolean z, CharSequence charSequence, CharSequence charSequence2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        return progressDialog(context, z, charSequence, charSequence2, function1);
    }

    private static final ProgressDialog progressDialog(@NotNull Context context, boolean z, CharSequence charSequence, CharSequence charSequence2, Function1<? super ProgressDialog, Unit> function1) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(z);
        if (!z) {
            progressDialog.setProgressStyle(1);
        }
        if (charSequence != null) {
            progressDialog.setMessage(charSequence);
        }
        if (charSequence2 != null) {
            progressDialog.setTitle(charSequence2);
        }
        if (function1 != null) {
            function1.invoke(progressDialog);
        }
        progressDialog.show();
        return progressDialog;
    }
}
