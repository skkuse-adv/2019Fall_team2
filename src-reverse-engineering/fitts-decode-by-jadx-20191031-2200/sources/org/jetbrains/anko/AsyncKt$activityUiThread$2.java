package org.jetbrains.anko;

import android.app.Activity;
import kotlin.jvm.functions.Function1;

final class AsyncKt$activityUiThread$2 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1 $f;

    AsyncKt$activityUiThread$2(Function1 function1, Activity activity) {
        this.$f = function1;
        this.$activity = activity;
    }

    public final void run() {
        this.$f.invoke(this.$activity);
    }
}
