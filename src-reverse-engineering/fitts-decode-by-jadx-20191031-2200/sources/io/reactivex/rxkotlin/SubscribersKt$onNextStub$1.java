package io.reactivex.rxkotlin;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class SubscribersKt$onNextStub$1 extends Lambda implements Function1<Object, Unit> {
    public static final SubscribersKt$onNextStub$1 INSTANCE = new SubscribersKt$onNextStub$1();

    SubscribersKt$onNextStub$1() {
        super(1);
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
    }
}
