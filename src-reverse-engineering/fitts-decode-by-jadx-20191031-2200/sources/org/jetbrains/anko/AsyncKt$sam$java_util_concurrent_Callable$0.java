package org.jetbrains.anko;

import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;

final class AsyncKt$sam$java_util_concurrent_Callable$0 implements Callable {
    private final /* synthetic */ Function0 function;

    AsyncKt$sam$java_util_concurrent_Callable$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ Object call() {
        return this.function.invoke();
    }
}
