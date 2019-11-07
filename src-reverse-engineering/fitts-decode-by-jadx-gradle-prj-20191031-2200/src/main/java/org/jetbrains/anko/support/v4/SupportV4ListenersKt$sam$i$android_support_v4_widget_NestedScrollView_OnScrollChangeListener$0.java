package org.jetbrains.anko.support.v4;

import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.OnScrollChangeListener;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

public final class SupportV4ListenersKt$sam$i$android_support_v4_widget_NestedScrollView_OnScrollChangeListener$0 implements OnScrollChangeListener {
    private final /* synthetic */ Function5 function;

    public SupportV4ListenersKt$sam$i$android_support_v4_widget_NestedScrollView_OnScrollChangeListener$0(Function5 function5) {
        this.function = function5;
    }

    public final /* synthetic */ void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(nestedScrollView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)), "invoke(...)");
    }
}
