package org.jetbrains.anko.appcompat.v7.coroutines;

import androidx.appcompat.widget.SearchView.OnCloseListener;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;

final class AppcompatV7CoroutinesListenersWithCoroutinesKt$onClose$1 implements OnCloseListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function2 $handler;
    final /* synthetic */ boolean $returnValue;

    AppcompatV7CoroutinesListenersWithCoroutinesKt$onClose$1(CoroutineContext coroutineContext, Function2 function2, boolean z) {
        this.$context = coroutineContext;
        this.$handler = function2;
        this.$returnValue = z;
    }

    public final boolean onClose() {
        BuildersKt.launch(GlobalScope.INSTANCE, this.$context, CoroutineStart.DEFAULT, this.$handler);
        return this.$returnValue;
    }
}
