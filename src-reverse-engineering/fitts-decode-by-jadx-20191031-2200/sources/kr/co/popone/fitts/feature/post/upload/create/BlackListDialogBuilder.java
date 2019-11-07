package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0017R$style;
import org.jetbrains.annotations.NotNull;

public final class BlackListDialogBuilder {
    public static final BlackListDialogBuilder INSTANCE = new BlackListDialogBuilder();

    public interface Listener {
        void onCancel();

        void onConfirm();
    }

    private BlackListDialogBuilder() {
    }

    public final void showDialog(@NotNull Context context, @NotNull Listener listener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        Dialog dialog = new Dialog(context, C0017R$style.AppTheme_NoActionBar);
        dialog.setContentView(C0013R$layout.dialog_post_black_listed_notice);
        dialog.setOnCancelListener(new BlackListDialogBuilder$showDialog$1(listener));
        ((Button) dialog.findViewById(C0010R$id.confirmButton)).setOnClickListener(new BlackListDialogBuilder$showDialog$2(dialog, listener));
        ((ImageButton) dialog.findViewById(C0010R$id.cancelButton)).setOnClickListener(new BlackListDialogBuilder$showDialog$3(dialog, listener));
        dialog.show();
    }
}
