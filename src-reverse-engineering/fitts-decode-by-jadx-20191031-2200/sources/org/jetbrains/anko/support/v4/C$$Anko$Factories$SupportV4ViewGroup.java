package org.jetbrains.anko.support.v4;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.support.v4.$$Anko$Factories$SupportV4ViewGroup reason: invalid class name */
public final class C$$Anko$Factories$SupportV4ViewGroup {
    @NotNull
    private static final Function1<Context, _DrawerLayout> DRAWER_LAYOUT = C$$Anko$Factories$SupportV4ViewGroup$DRAWER_LAYOUT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _FragmentTabHost> FRAGMENT_TAB_HOST = C$$Anko$Factories$SupportV4ViewGroup$FRAGMENT_TAB_HOST$1.INSTANCE;
    public static final C$$Anko$Factories$SupportV4ViewGroup INSTANCE = new C$$Anko$Factories$SupportV4ViewGroup();
    @NotNull
    private static final Function1<Context, _NestedScrollView> NESTED_SCROLL_VIEW = C$$Anko$Factories$SupportV4ViewGroup$NESTED_SCROLL_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _SlidingPaneLayout> SLIDING_PANE_LAYOUT = C$$Anko$Factories$SupportV4ViewGroup$SLIDING_PANE_LAYOUT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _ViewPager> VIEW_PAGER = C$$Anko$Factories$SupportV4ViewGroup$VIEW_PAGER$1.INSTANCE;

    private C$$Anko$Factories$SupportV4ViewGroup() {
    }

    @NotNull
    public final Function1<Context, _FragmentTabHost> getFRAGMENT_TAB_HOST() {
        return FRAGMENT_TAB_HOST;
    }

    @NotNull
    public final Function1<Context, _ViewPager> getVIEW_PAGER() {
        return VIEW_PAGER;
    }

    @NotNull
    public final Function1<Context, _DrawerLayout> getDRAWER_LAYOUT() {
        return DRAWER_LAYOUT;
    }

    @NotNull
    public final Function1<Context, _NestedScrollView> getNESTED_SCROLL_VIEW() {
        return NESTED_SCROLL_VIEW;
    }

    @NotNull
    public final Function1<Context, _SlidingPaneLayout> getSLIDING_PANE_LAYOUT() {
        return SLIDING_PANE_LAYOUT;
    }
}
