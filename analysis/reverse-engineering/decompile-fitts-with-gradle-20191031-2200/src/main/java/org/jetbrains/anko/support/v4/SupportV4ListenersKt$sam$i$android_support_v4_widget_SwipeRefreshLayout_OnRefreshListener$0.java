package org.jetbrains.anko.support.v4;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class SupportV4ListenersKt$sam$i$android_support_v4_widget_SwipeRefreshLayout_OnRefreshListener$0 implements OnRefreshListener {
    private final /* synthetic */ Function0 function;

    public SupportV4ListenersKt$sam$i$android_support_v4_widget_SwipeRefreshLayout_OnRefreshListener$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void onRefresh() {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(), "invoke(...)");
    }
}
