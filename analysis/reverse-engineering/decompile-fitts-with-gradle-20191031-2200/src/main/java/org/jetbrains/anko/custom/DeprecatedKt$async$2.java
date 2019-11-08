package org.jetbrains.anko.custom;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.anko.AnkoAsyncContext;

final class DeprecatedKt$async$2<V> implements Callable<Unit> {
    final /* synthetic */ AnkoAsyncContext $context;
    final /* synthetic */ Function1 $task;

    DeprecatedKt$async$2(Function1 function1, AnkoAsyncContext ankoAsyncContext) {
        this.$task = function1;
        this.$context = ankoAsyncContext;
    }

    public final void call() {
        this.$task.invoke(this.$context);
    }
}
