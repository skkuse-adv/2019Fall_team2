package org.jetbrains.anko;

import kotlin.jvm.functions.Function0;

public final class AsyncKt$runOnUiThread$2 implements Runnable {
    final /* synthetic */ Function0 $f;

    public AsyncKt$runOnUiThread$2(Function0 function0) {
        this.$f = function0;
    }

    public final void run() {
        this.$f.invoke();
    }
}
