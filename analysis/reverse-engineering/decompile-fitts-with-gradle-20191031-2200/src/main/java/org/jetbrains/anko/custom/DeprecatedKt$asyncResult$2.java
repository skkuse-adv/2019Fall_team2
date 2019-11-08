package org.jetbrains.anko.custom;

import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;
import org.jetbrains.anko.AnkoAsyncContext;

final class DeprecatedKt$asyncResult$2<V> implements Callable<R> {
    final /* synthetic */ AnkoAsyncContext $context;
    final /* synthetic */ Function1 $task;

    DeprecatedKt$asyncResult$2(Function1 function1, AnkoAsyncContext ankoAsyncContext) {
        this.$task = function1;
        this.$context = ankoAsyncContext;
    }

    public final R call() {
        return this.$task.invoke(this.$context);
    }
}
