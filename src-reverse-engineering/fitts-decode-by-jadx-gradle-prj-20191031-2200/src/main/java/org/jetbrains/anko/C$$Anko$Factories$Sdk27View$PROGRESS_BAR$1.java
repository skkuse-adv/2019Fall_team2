package org.jetbrains.anko;

import android.content.Context;
import android.widget.ProgressBar;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.$$Anko$Factories$Sdk27View$PROGRESS_BAR$1 reason: invalid class name */
final class C$$Anko$Factories$Sdk27View$PROGRESS_BAR$1 extends Lambda implements Function1<Context, ProgressBar> {
    public static final C$$Anko$Factories$Sdk27View$PROGRESS_BAR$1 INSTANCE = new C$$Anko$Factories$Sdk27View$PROGRESS_BAR$1();

    C$$Anko$Factories$Sdk27View$PROGRESS_BAR$1() {
        super(1);
    }

    @NotNull
    public final ProgressBar invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new ProgressBar(context);
    }
}
