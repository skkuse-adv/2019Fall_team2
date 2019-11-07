package org.jetbrains.anko.support.v4;

import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTabHost;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SupportV4ListenersKt {
    public static final void drawerListener(@NotNull DrawerLayout drawerLayout, @NotNull Function1<? super __DrawerLayout_DrawerListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(drawerLayout, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __DrawerLayout_DrawerListener __drawerlayout_drawerlistener = new __DrawerLayout_DrawerListener();
        function1.invoke(__drawerlayout_drawerlistener);
        drawerLayout.addDrawerListener(__drawerlayout_drawerlistener);
    }

    public static final void onAdapterChange(@NotNull ViewPager viewPager, @NotNull Function3<? super ViewPager, ? super PagerAdapter, ? super PagerAdapter, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(viewPager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "l");
        viewPager.addOnAdapterChangeListener(new SupportV4ListenersKt$sam$i$android_support_v4_view_ViewPager_OnAdapterChangeListener$0(function3));
    }

    public static final void onPageChangeListener(@NotNull ViewPager viewPager, @NotNull Function1<? super __ViewPager_OnPageChangeListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewPager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __ViewPager_OnPageChangeListener __viewpager_onpagechangelistener = new __ViewPager_OnPageChangeListener();
        function1.invoke(__viewpager_onpagechangelistener);
        viewPager.addOnPageChangeListener(__viewpager_onpagechangelistener);
    }

    public static final void onTabChanged(@NotNull FragmentTabHost fragmentTabHost, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragmentTabHost, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "l");
        fragmentTabHost.setOnTabChangedListener(new SupportV4ListenersKt$sam$i$android_widget_TabHost_OnTabChangeListener$0(function1));
    }

    public static final void onScrollChange(@NotNull NestedScrollView nestedScrollView, @NotNull Function5<? super NestedScrollView, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function5) {
        Intrinsics.checkParameterIsNotNull(nestedScrollView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function5, "l");
        nestedScrollView.setOnScrollChangeListener(new SupportV4ListenersKt$sam$i$android_support_v4_widget_NestedScrollView_OnScrollChangeListener$0(function5));
    }

    public static final void onRefresh(@NotNull SwipeRefreshLayout swipeRefreshLayout, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "l");
        swipeRefreshLayout.setOnRefreshListener(new SupportV4ListenersKt$sam$i$android_support_v4_widget_SwipeRefreshLayout_OnRefreshListener$0(function0));
    }
}
