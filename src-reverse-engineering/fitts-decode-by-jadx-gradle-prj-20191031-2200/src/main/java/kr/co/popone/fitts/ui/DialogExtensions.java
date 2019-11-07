package kr.co.popone.fitts.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DialogExtensions {
    public static final DialogExtensions INSTANCE = new DialogExtensions();

    private DialogExtensions() {
    }

    public static /* synthetic */ void showMessageDialog$default(DialogExtensions dialogExtensions, Context context, String str, String str2, Function0 function0, String str3, int i, Object obj) {
        String str4 = "";
        String str5 = (i & 2) != 0 ? str4 : str;
        String str6 = (i & 4) != 0 ? str4 : str2;
        if ((i & 8) != 0) {
            function0 = null;
        }
        Function0 function02 = function0;
        if ((i & 16) != 0) {
            str3 = "닫기";
        }
        dialogExtensions.showMessageDialog(context, str5, str6, function02, str3);
    }

    public final void showMessageDialog(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable Function0<Unit> function0, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(str3, "confirmButtonTitle");
        Dialog dialog = new Dialog(context);
        boolean z = true;
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        dialog.setContentView(C0013R$layout.dialog_confirm);
        TextView textView = (TextView) dialog.findViewById(C0010R$id.titleTextView);
        TextView textView2 = (TextView) dialog.findViewById(C0010R$id.messageTextView);
        Button button = (Button) dialog.findViewById(C0010R$id.confirmButton);
        View findViewById = dialog.findViewById(C0010R$id.cancelButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "confirmButton");
        button.setText(str3);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "cancelButton");
        findViewById.setVisibility(4);
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleTextView");
        textView.setText(str);
        if (str.length() <= 0) {
            z = false;
        }
        textView.setVisibility(z ? 0 : 8);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "messageTextView");
        textView2.setText(str2);
        button.setOnClickListener(new DialogExtensions$showMessageDialog$1(dialog, function0));
        dialog.setOnCancelListener(new DialogExtensions$showMessageDialog$2(function0));
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @NotNull
    public static /* synthetic */ Dialog createMessageDialog$default(DialogExtensions dialogExtensions, Context context, String str, String str2, Function0 function0, String str3, int i, Object obj) {
        String str4 = "";
        String str5 = (i & 2) != 0 ? str4 : str;
        String str6 = (i & 4) != 0 ? str4 : str2;
        if ((i & 8) != 0) {
            function0 = null;
        }
        Function0 function02 = function0;
        if ((i & 16) != 0) {
            str3 = "닫기";
        }
        return dialogExtensions.createMessageDialog(context, str5, str6, function02, str3);
    }

    @NotNull
    public final Dialog createMessageDialog(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable Function0<Unit> function0, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(str3, "confirmButtonTitle");
        Dialog dialog = new Dialog(context);
        boolean z = true;
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        dialog.setContentView(C0013R$layout.dialog_confirm);
        TextView textView = (TextView) dialog.findViewById(C0010R$id.titleTextView);
        TextView textView2 = (TextView) dialog.findViewById(C0010R$id.messageTextView);
        Button button = (Button) dialog.findViewById(C0010R$id.confirmButton);
        View findViewById = dialog.findViewById(C0010R$id.cancelButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "confirmButton");
        button.setText(str3);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "cancelButton");
        findViewById.setVisibility(4);
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleTextView");
        textView.setText(str);
        if (str.length() <= 0) {
            z = false;
        }
        textView.setVisibility(z ? 0 : 8);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "messageTextView");
        textView2.setText(str2);
        button.setOnClickListener(new DialogExtensions$createMessageDialog$1(dialog, function0));
        dialog.setOnCancelListener(new DialogExtensions$createMessageDialog$2(function0));
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public static /* synthetic */ void showConfirmDialog$default(DialogExtensions dialogExtensions, Context context, String str, String str2, Function0 function0, Function0 function02, String str3, String str4, int i, int i2, Object obj) {
        int i3;
        int i4 = i2;
        String str5 = "";
        String str6 = (i4 & 2) != 0 ? str5 : str;
        if ((i4 & 4) == 0) {
            str5 = str2;
        }
        Function0 function03 = null;
        Function0 function04 = (i4 & 8) != 0 ? null : function0;
        if ((i4 & 16) == 0) {
            function03 = function02;
        }
        String str7 = (i4 & 32) != 0 ? "확인" : str3;
        String str8 = (i4 & 64) != 0 ? "취소" : str4;
        if ((i4 & 128) != 0) {
            Context context2 = context;
            i3 = ContextCompat.getColor(context, C0006R$color.gray8);
        } else {
            Context context3 = context;
            i3 = i;
        }
        dialogExtensions.showConfirmDialog(context, str6, str5, function04, function03, str7, str8, i3);
    }

    public final void showConfirmDialog(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02, @NotNull String str3, @NotNull String str4, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(str3, "confirmButtonTitle");
        Intrinsics.checkParameterIsNotNull(str4, "cancelButtonTitle");
        Dialog dialog = new Dialog(context);
        boolean z = true;
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        dialog.setContentView(C0013R$layout.dialog_confirm);
        TextView textView = (TextView) dialog.findViewById(C0010R$id.titleTextView);
        TextView textView2 = (TextView) dialog.findViewById(C0010R$id.messageTextView);
        Button button = (Button) dialog.findViewById(C0010R$id.confirmButton);
        Button button2 = (Button) dialog.findViewById(C0010R$id.cancelButton);
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleTextView");
        textView.setText(str);
        if (str.length() <= 0) {
            z = false;
        }
        textView.setVisibility(z ? 0 : 8);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "messageTextView");
        textView2.setText(str2);
        Intrinsics.checkExpressionValueIsNotNull(button, "confirmButton");
        button.setText(str3);
        Intrinsics.checkExpressionValueIsNotNull(button2, "cancelButton");
        button2.setText(str4);
        button2.setTextColor(i);
        button.setOnClickListener(new DialogExtensions$showConfirmDialog$1(dialog, function0));
        button2.setOnClickListener(new DialogExtensions$showConfirmDialog$2(dialog, function02));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnCancelListener(new DialogExtensions$showConfirmDialog$3(function02));
        dialog.show();
    }

    public static /* synthetic */ void showUpdateDialog$default(DialogExtensions dialogExtensions, Context context, Function0 function0, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "최신버전으로 업데이트해주세요👼";
        }
        if ((i & 8) != 0) {
            z = true;
        }
        dialogExtensions.showUpdateDialog(context, function0, str, z);
    }

    public final void showUpdateDialog(@NotNull Context context, @NotNull Function0<Unit> function0, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(function0, "confirmListener");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        dialog.setContentView(C0013R$layout.dialog_update);
        TextView textView = (TextView) dialog.findViewById(C0010R$id.titleTextView);
        TextView textView2 = (TextView) dialog.findViewById(C0010R$id.messageTextView);
        Button button = (Button) dialog.findViewById(C0010R$id.confirmButton);
        View findViewById = dialog.findViewById(C0010R$id.cancelButton);
        Intrinsics.checkExpressionValueIsNotNull(textView, "titleTextView");
        textView.setText("업데이트 안내");
        Intrinsics.checkExpressionValueIsNotNull(textView2, "messageTextView");
        textView2.setText(str);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "cancelButton");
        findViewById.setVisibility(z ? 0 : 8);
        button.setOnClickListener(new DialogExtensions$showUpdateDialog$1(function0));
        findViewById.setOnClickListener(new DialogExtensions$showUpdateDialog$2(dialog));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(z);
        dialog.show();
    }

    @NotNull
    public final Dialog buildDialog(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        dialog.setContentView(i);
        return dialog;
    }
}
