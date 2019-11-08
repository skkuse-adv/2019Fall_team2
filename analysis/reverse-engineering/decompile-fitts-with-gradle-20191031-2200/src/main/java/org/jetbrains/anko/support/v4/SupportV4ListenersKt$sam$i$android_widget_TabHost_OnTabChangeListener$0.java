package org.jetbrains.anko.support.v4;

import android.widget.TabHost.OnTabChangeListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class SupportV4ListenersKt$sam$i$android_widget_TabHost_OnTabChangeListener$0 implements OnTabChangeListener {
    private final /* synthetic */ Function1 function;

    public SupportV4ListenersKt$sam$i$android_widget_TabHost_OnTabChangeListener$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onTabChanged(String str) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(str), "invoke(...)");
    }
}
