package org.jetbrains.anko;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final class AsyncKt$doAsyncResult$2<V> implements Callable<R> {
    final /* synthetic */ AnkoAsyncContext $context;
    final /* synthetic */ Function1 $exceptionHandler;
    final /* synthetic */ Function1 $task;

    AsyncKt$doAsyncResult$2(Function1 function1, AnkoAsyncContext ankoAsyncContext, Function1 function12) {
        this.$task = function1;
        this.$context = ankoAsyncContext;
        this.$exceptionHandler = function12;
    }

    public final R call() {
        try {
            return this.$task.invoke(this.$context);
        } catch (Throwable th) {
            Function1 function1 = this.$exceptionHandler;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(th);
            }
            throw th;
        }
    }
}
