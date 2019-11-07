package org.jetbrains.anko;

import kotlin.jvm.functions.Function1;

final class AsyncKt$onComplete$1 implements Runnable {
    final /* synthetic */ Function1 $f;
    final /* synthetic */ Object $ref;

    AsyncKt$onComplete$1(Function1 function1, Object obj) {
        this.$f = function1;
        this.$ref = obj;
    }

    public final void run() {
        this.$f.invoke(this.$ref);
    }
}
