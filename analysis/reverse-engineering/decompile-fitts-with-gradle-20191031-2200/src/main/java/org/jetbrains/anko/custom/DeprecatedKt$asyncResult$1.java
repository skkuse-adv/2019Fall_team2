package org.jetbrains.anko.custom;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.anko.AnkoAsyncContext;

final class DeprecatedKt$asyncResult$1 extends Lambda implements Function0<R> {
    final /* synthetic */ AnkoAsyncContext $context;
    final /* synthetic */ Function1 $task;

    DeprecatedKt$asyncResult$1(Function1 function1, AnkoAsyncContext ankoAsyncContext) {
        this.$task = function1;
        this.$context = ankoAsyncContext;
        super(0);
    }

    public final R invoke() {
        return this.$task.invoke(this.$context);
    }
}
