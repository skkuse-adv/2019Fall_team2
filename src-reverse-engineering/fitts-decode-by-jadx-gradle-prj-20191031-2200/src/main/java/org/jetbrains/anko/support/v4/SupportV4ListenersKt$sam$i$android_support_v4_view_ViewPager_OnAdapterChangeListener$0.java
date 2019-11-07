package org.jetbrains.anko.support.v4;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SupportV4ListenersKt$sam$i$android_support_v4_view_ViewPager_OnAdapterChangeListener$0 implements OnAdapterChangeListener {
    private final /* synthetic */ Function3 function;

    public SupportV4ListenersKt$sam$i$android_support_v4_view_ViewPager_OnAdapterChangeListener$0(Function3 function3) {
        this.function = function3;
    }

    public final /* synthetic */ void onAdapterChanged(@NotNull @NonNull ViewPager viewPager, @Nullable @androidx.annotation.Nullable PagerAdapter pagerAdapter, @Nullable @androidx.annotation.Nullable PagerAdapter pagerAdapter2) {
        Intrinsics.checkParameterIsNotNull(viewPager, "p0");
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(viewPager, pagerAdapter, pagerAdapter2), "invoke(...)");
    }
}
