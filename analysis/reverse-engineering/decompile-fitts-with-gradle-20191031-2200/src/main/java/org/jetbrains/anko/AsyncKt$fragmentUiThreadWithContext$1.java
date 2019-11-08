package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import kotlin.jvm.functions.Function2;

final class AsyncKt$fragmentUiThreadWithContext$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function2 $f;
    final /* synthetic */ Fragment $fragment;

    AsyncKt$fragmentUiThreadWithContext$1(Function2 function2, Activity activity, Fragment fragment) {
        this.$f = function2;
        this.$activity = activity;
        this.$fragment = fragment;
    }

    public final void run() {
        this.$f.invoke(this.$activity, this.$fragment);
    }
}
