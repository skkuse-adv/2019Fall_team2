package org.jetbrains.anko;

import android.app.Activity;
import kotlin.jvm.functions.Function2;

final class AsyncKt$activityUiThreadWithContext$2 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function2 $f;

    AsyncKt$activityUiThreadWithContext$2(Function2 function2, Activity activity) {
        this.$f = function2;
        this.$activity = activity;
    }

    public final void run() {
        Function2 function2 = this.$f;
        Activity activity = this.$activity;
        function2.invoke(activity, activity);
    }
}
