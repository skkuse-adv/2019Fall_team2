package org.jetbrains.anko;

import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class BuildSpannedKt$clickable$1 extends ClickableSpan {
    final /* synthetic */ Function1 $onClick;

    public BuildSpannedKt$clickable$1(Function1 function1) {
        this.$onClick = function1;
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "widget");
        this.$onClick.invoke(view);
    }
}
