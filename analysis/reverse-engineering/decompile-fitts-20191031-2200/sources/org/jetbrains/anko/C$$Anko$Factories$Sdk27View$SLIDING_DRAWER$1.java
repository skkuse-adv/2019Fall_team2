package org.jetbrains.anko;

import android.content.Context;
import android.widget.SlidingDrawer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.$$Anko$Factories$Sdk27View$SLIDING_DRAWER$1 reason: invalid class name */
final class C$$Anko$Factories$Sdk27View$SLIDING_DRAWER$1 extends Lambda implements Function1<Context, SlidingDrawer> {
    public static final C$$Anko$Factories$Sdk27View$SLIDING_DRAWER$1 INSTANCE = new C$$Anko$Factories$Sdk27View$SLIDING_DRAWER$1();

    C$$Anko$Factories$Sdk27View$SLIDING_DRAWER$1() {
        super(1);
    }

    @NotNull
    public final SlidingDrawer invoke(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        return new SlidingDrawer(context, null);
    }
}
