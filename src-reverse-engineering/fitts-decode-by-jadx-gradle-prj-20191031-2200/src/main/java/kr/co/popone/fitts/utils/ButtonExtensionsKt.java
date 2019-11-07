package kr.co.popone.fitts.utils;

import android.graphics.Typeface;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import org.jetbrains.annotations.NotNull;

public final class ButtonExtensionsKt {
    public static final void updateStyleButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "receiver$0");
        if (button.isSelected()) {
            button.setTextColor(ContextCompat.getColor(button.getContext(), C0006R$color.point));
            button.setTypeface(button.getTypeface(), 1);
            return;
        }
        button.setTextColor(ContextCompat.getColor(button.getContext(), C0006R$color.gray6));
        button.setTypeface(Typeface.create(button.getTypeface(), 0));
    }
}
