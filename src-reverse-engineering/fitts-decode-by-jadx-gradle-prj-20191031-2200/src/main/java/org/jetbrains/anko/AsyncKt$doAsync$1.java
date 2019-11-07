package org.jetbrains.anko;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class AsyncKt$doAsync$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnkoAsyncContext $context;
    final /* synthetic */ Function1 $exceptionHandler;
    final /* synthetic */ Function1 $task;

    AsyncKt$doAsync$1(Function1 function1, AnkoAsyncContext ankoAsyncContext, Function1 function12) {
        this.$task = function1;
        this.$context = ankoAsyncContext;
        this.$exceptionHandler = function12;
        super(0);
    }

    public final void invoke() {
        try {
            Unit unit = (Unit) this.$task.invoke(this.$context);
        } catch (Throwable th) {
            Function1 function1 = this.$exceptionHandler;
            if ((function1 != null ? (Unit) function1.invoke(th) : null) == null) {
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }
}
