package org.jetbrains.anko.support.v4;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AlertBuilder;
import org.jetbrains.anko.AndroidDialogsKt;
import org.jetbrains.anko.AndroidSelectorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SupportDialogsKt {
    @NotNull
    public static final Toast toast(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Toast makeText = Toast.makeText(requireActivity, i, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast toast(@NotNull Fragment fragment, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Toast makeText = Toast.makeText(requireActivity, charSequence, 0);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast longToast(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Toast makeText = Toast.makeText(requireActivity, i, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    @NotNull
    public static final Toast longToast(@NotNull Fragment fragment, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Toast makeText = Toast.makeText(requireActivity, charSequence, 1);
        makeText.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return makeText;
    }

    public static /* synthetic */ void selector$default(Fragment fragment, CharSequence charSequence, List list, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function2, "onClick");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        AndroidSelectorsKt.selector((Context) requireActivity, charSequence, list, function2);
    }

    public static final void selector(@NotNull Fragment fragment, @Nullable CharSequence charSequence, @NotNull List<? extends CharSequence> list, @NotNull Function2<? super DialogInterface, ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(function2, "onClick");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        AndroidSelectorsKt.selector((Context) requireActivity, charSequence, list, function2);
    }

    @NotNull
    public static /* synthetic */ AlertBuilder alert$default(Fragment fragment, String str, String str2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert((Context) requireActivity, (CharSequence) str, (CharSequence) str2, function1);
    }

    @NotNull
    public static final AlertBuilder<AlertDialog> alert(@NotNull Fragment fragment, @NotNull String str, @Nullable String str2, @Nullable Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert((Context) requireActivity, (CharSequence) str, (CharSequence) str2, function1);
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
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert((Context) requireActivity, i, num, function1);
    }

    @NotNull
    public static final AlertBuilder<DialogInterface> alert(@NotNull Fragment fragment, int i, @Nullable Integer num, @Nullable Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert((Context) requireActivity, i, num, function1);
    }

    @NotNull
    public static final AlertBuilder<DialogInterface> alert(@NotNull Fragment fragment, @NotNull Function1<? super AlertBuilder<? extends DialogInterface>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.alert((Context) requireActivity, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog progressDialog$default(Fragment fragment, String str, String str2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.progressDialog((Context) requireActivity, (CharSequence) str, (CharSequence) str2, function1);
    }

    @NotNull
    public static final ProgressDialog progressDialog(@NotNull Fragment fragment, @Nullable String str, @Nullable String str2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.progressDialog((Context) requireActivity, (CharSequence) str, (CharSequence) str2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Fragment fragment, String str, String str2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.indeterminateProgressDialog((Context) requireActivity, (CharSequence) str, (CharSequence) str2, function1);
    }

    @NotNull
    public static final ProgressDialog indeterminateProgressDialog(@NotNull Fragment fragment, @Nullable String str, @Nullable String str2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        return AndroidDialogsKt.indeterminateProgressDialog((Context) requireActivity, (CharSequence) str, (CharSequence) str2, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog progressDialog$default(Fragment fragment, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        CharSequence charSequence;
        String str = null;
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
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        if (num != null) {
            charSequence = fragment.requireActivity().getString(num.intValue());
        } else {
            charSequence = null;
        }
        if (num2 != null) {
            str = fragment.requireActivity().getString(num2.intValue());
        }
        return AndroidDialogsKt.progressDialog((Context) requireActivity, charSequence, (CharSequence) str, function1);
    }

    @NotNull
    public static final ProgressDialog progressDialog(@NotNull Fragment fragment, @Nullable Integer num, @Nullable Integer num2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        String str = null;
        if (num != null) {
            charSequence = fragment.requireActivity().getString(num.intValue());
        } else {
            charSequence = null;
        }
        if (num2 != null) {
            str = fragment.requireActivity().getString(num2.intValue());
        }
        return AndroidDialogsKt.progressDialog((Context) requireActivity, charSequence, (CharSequence) str, function1);
    }

    @NotNull
    public static /* synthetic */ ProgressDialog indeterminateProgressDialog$default(Fragment fragment, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        CharSequence charSequence;
        String str = null;
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
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        if (num != null) {
            charSequence = fragment.requireActivity().getString(num.intValue());
        } else {
            charSequence = null;
        }
        if (num2 != null) {
            str = fragment.requireActivity().getString(num2.intValue());
        }
        return AndroidDialogsKt.indeterminateProgressDialog((Context) requireActivity, charSequence, (CharSequence) str, function1);
    }

    @NotNull
    public static final ProgressDialog indeterminateProgressDialog(@NotNull Fragment fragment, @Nullable Integer num, @Nullable Integer num2, @Nullable Function1<? super ProgressDialog, Unit> function1) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        String str = null;
        if (num != null) {
            charSequence = fragment.requireActivity().getString(num.intValue());
        } else {
            charSequence = null;
        }
        if (num2 != null) {
            str = fragment.requireActivity().getString(num2.intValue());
        }
        return AndroidDialogsKt.indeterminateProgressDialog((Context) requireActivity, charSequence, (CharSequence) str, function1);
    }
}
