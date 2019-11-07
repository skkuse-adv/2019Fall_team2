package kr.co.popone.fitts.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import org.jetbrains.annotations.NotNull;

public final class TextViewExtensionKt {
    public static /* synthetic */ void setTextColorPartially$default(TextView textView, Context context, String str, int i, int i2, int i3, int i4, Object obj) {
        setTextColorPartially(textView, context, str, i, i2, (i4 & 16) != 0 ? C0006R$color.point : i3);
    }

    public static final void setTextColorPartially(@NotNull TextView textView, @NotNull Context context, @NotNull String str, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "text");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i3)), i, i2, 33);
        textView.append(spannableStringBuilder);
    }
}
