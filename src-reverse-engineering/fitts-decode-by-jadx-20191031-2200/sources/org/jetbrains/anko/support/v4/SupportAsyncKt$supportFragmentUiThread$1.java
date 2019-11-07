package org.jetbrains.anko.support.v4;

import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function1;

final class SupportAsyncKt$supportFragmentUiThread$1 implements Runnable {
    final /* synthetic */ Function1 $f;
    final /* synthetic */ Fragment $fragment;

    SupportAsyncKt$supportFragmentUiThread$1(Function1 function1, Fragment fragment) {
        this.$f = function1;
        this.$fragment = fragment;
    }

    public final void run() {
        this.$f.invoke(this.$fragment);
    }
}
