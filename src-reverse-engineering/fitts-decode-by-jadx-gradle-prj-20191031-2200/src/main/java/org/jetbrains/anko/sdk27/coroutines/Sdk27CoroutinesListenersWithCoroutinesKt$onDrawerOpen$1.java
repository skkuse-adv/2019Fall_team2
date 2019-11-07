package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SlidingDrawer.OnDrawerOpenListener;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;

final class Sdk27CoroutinesListenersWithCoroutinesKt$onDrawerOpen$1 implements OnDrawerOpenListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function2 $handler;

    Sdk27CoroutinesListenersWithCoroutinesKt$onDrawerOpen$1(CoroutineContext coroutineContext, Function2 function2) {
        this.$context = coroutineContext;
        this.$handler = function2;
    }

    public final void onDrawerOpened() {
        BuildersKt.launch(GlobalScope.INSTANCE, this.$context, CoroutineStart.DEFAULT, this.$handler);
    }
}
