package kr.co.popone.fitts.utils;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class Snackbar {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showMessage(@NotNull Activity activity, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            com.google.android.material.snackbar.Snackbar make = com.google.android.material.snackbar.Snackbar.make(activity.findViewById(16908290), (CharSequence) str, -1);
            Intrinsics.checkExpressionValueIsNotNull(make, "Snackbar.make(activity.f…e, Snackbar.LENGTH_SHORT)");
            View view = make.getView();
            Intrinsics.checkExpressionValueIsNotNull(view, "snackBar.view");
            TextView textView = (TextView) view.findViewById(2131362945);
            Intrinsics.checkExpressionValueIsNotNull(textView, "snackTextView");
            textView.setMaxLines(3);
            make.show();
        }
    }

    public static final void showMessage(@NotNull Activity activity, @NotNull String str) {
        Companion.showMessage(activity, str);
    }
}
