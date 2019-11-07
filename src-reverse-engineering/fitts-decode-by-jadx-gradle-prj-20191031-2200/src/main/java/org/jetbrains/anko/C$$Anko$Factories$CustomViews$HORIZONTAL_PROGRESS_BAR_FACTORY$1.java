package org.jetbrains.anko;

import android.content.Context;
import android.widget.ProgressBar;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1 reason: invalid class name */
final class C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1 extends Lambda implements Function1<Context, ProgressBar> {
    public static final C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1 INSTANCE = new C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1();

    C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1() {
        super(1);
    }

    @NotNull
    public final ProgressBar invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new ProgressBar(context, null, 16842872);
    }
}
