package kr.co.popone.fitts.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ToastExtensionKt {
    public static final void showToast(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        toast(context, str);
    }

    public static final void showToast(@NotNull Fragment fragment, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Context context = fragment.getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "it");
            toast(context, str);
        }
    }

    public static final void showToast(@NotNull View view, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        toast(context, str);
    }

    private static final void toast(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        Intrinsics.checkExpressionValueIsNotNull(makeText, "toast");
        TextView textView = (TextView) makeText.getView().findViewById(16908299);
        Intrinsics.checkExpressionValueIsNotNull(textView, "view");
        textView.setGravity(17);
        makeText.show();
    }
}
