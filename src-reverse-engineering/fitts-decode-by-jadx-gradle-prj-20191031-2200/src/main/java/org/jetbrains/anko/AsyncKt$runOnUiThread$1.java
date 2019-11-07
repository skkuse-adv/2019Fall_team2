package org.jetbrains.anko;

import android.content.Context;
import kotlin.jvm.functions.Function1;

final class AsyncKt$runOnUiThread$1 implements Runnable {
    final /* synthetic */ Function1 $f;
    final /* synthetic */ Context $this_runOnUiThread;

    AsyncKt$runOnUiThread$1(Context context, Function1 function1) {
        this.$this_runOnUiThread = context;
        this.$f = function1;
    }

    public final void run() {
        this.$f.invoke(this.$this_runOnUiThread);
    }
}
