package org.jetbrains.anko;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AsyncKt$crashLogger$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final AsyncKt$crashLogger$1 INSTANCE = new AsyncKt$crashLogger$1();

    AsyncKt$crashLogger$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        th.printStackTrace();
    }
}
