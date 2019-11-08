package org.jetbrains.anko.support.v4;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewManager;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTabHost;
import androidx.legacy.widget.Space;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class SupportV4ViewsKt {
    @NotNull
    public static final PagerTabStrip pagerTabStrip(@NotNull ViewManager viewManager, @NotNull Function1<? super PagerTabStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 pager_tab_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_tab_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTabStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTabStrip themedPagerTabStrip$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 pager_tab_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_tab_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTabStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTabStrip themedPagerTabStrip$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 pager_tab_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_tab_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip themedPagerTabStrip(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super PagerTabStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 pager_tab_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_tab_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip pagerTabStrip(@NotNull Context context, @NotNull Function1<? super PagerTabStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTabStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTabStrip themedPagerTabStrip$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTabStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTabStrip themedPagerTabStrip$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip themedPagerTabStrip(@NotNull Context context, int i, @NotNull Function1<? super PagerTabStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip pagerTabStrip(@NotNull Activity activity, @NotNull Function1<? super PagerTabStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTabStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTabStrip themedPagerTabStrip$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTabStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTabStrip themedPagerTabStrip$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip themedPagerTabStrip(@NotNull Activity activity, int i, @NotNull Function1<? super PagerTabStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        function1.invoke(pagerTabStrip);
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTitleStrip pagerTitleStrip(@NotNull ViewManager viewManager, @NotNull Function1<? super PagerTitleStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 pager_title_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_title_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTitleStrip themedPagerTitleStrip$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 pager_title_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_title_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTitleStrip themedPagerTitleStrip$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 pager_title_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_title_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip themedPagerTitleStrip(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super PagerTitleStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 pager_title_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_title_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip pagerTitleStrip(@NotNull Context context, @NotNull Function1<? super PagerTitleStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTitleStrip themedPagerTitleStrip$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTitleStrip themedPagerTitleStrip$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip themedPagerTitleStrip(@NotNull Context context, int i, @NotNull Function1<? super PagerTitleStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip pagerTitleStrip(@NotNull Activity activity, @NotNull Function1<? super PagerTitleStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTitleStrip themedPagerTitleStrip$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static /* synthetic */ PagerTitleStrip themedPagerTitleStrip$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip themedPagerTitleStrip(@NotNull Activity activity, int i, @NotNull Function1<? super PagerTitleStrip, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        function1.invoke(pagerTitleStrip);
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final ContentLoadingProgressBar contentLoadingProgressBar(@NotNull ViewManager viewManager, @NotNull Function1<? super ContentLoadingProgressBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 content_loading_progress_bar = C$$Anko$Factories$SupportV4View.INSTANCE.getCONTENT_LOADING_PROGRESS_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_loading_progress_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) view;
        function1.invoke(contentLoadingProgressBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentLoadingProgressBar;
    }

    @NotNull
    public static /* synthetic */ ContentLoadingProgressBar themedContentLoadingProgressBar$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 content_loading_progress_bar = C$$Anko$Factories$SupportV4View.INSTANCE.getCONTENT_LOADING_PROGRESS_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_loading_progress_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentLoadingProgressBar;
    }

    @NotNull
    public static /* synthetic */ ContentLoadingProgressBar themedContentLoadingProgressBar$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 content_loading_progress_bar = C$$Anko$Factories$SupportV4View.INSTANCE.getCONTENT_LOADING_PROGRESS_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_loading_progress_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) view;
        function1.invoke(contentLoadingProgressBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentLoadingProgressBar;
    }

    @NotNull
    public static final ContentLoadingProgressBar themedContentLoadingProgressBar(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ContentLoadingProgressBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 content_loading_progress_bar = C$$Anko$Factories$SupportV4View.INSTANCE.getCONTENT_LOADING_PROGRESS_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_loading_progress_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) view;
        function1.invoke(contentLoadingProgressBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentLoadingProgressBar;
    }

    @NotNull
    public static final Space space(@NotNull ViewManager viewManager, @NotNull Function1<? super Space, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 space = C$$Anko$Factories$SupportV4View.INSTANCE.getSPACE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) space.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Space space2 = (Space) view;
        function1.invoke(space2);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return space2;
    }

    @NotNull
    public static /* synthetic */ Space themedSpace$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 space = C$$Anko$Factories$SupportV4View.INSTANCE.getSPACE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) space.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Space space2 = (Space) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return space2;
    }

    @NotNull
    public static /* synthetic */ Space themedSpace$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 space = C$$Anko$Factories$SupportV4View.INSTANCE.getSPACE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) space.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Space space2 = (Space) view;
        function1.invoke(space2);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return space2;
    }

    @NotNull
    public static final Space themedSpace(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super Space, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 space = C$$Anko$Factories$SupportV4View.INSTANCE.getSPACE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) space.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Space space2 = (Space) view;
        function1.invoke(space2);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return space2;
    }

    @NotNull
    public static final SwipeRefreshLayout swipeRefreshLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super SwipeRefreshLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 swipe_refresh_layout = C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) swipe_refresh_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static /* synthetic */ SwipeRefreshLayout themedSwipeRefreshLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 swipe_refresh_layout = C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) swipe_refresh_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static /* synthetic */ SwipeRefreshLayout themedSwipeRefreshLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 swipe_refresh_layout = C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) swipe_refresh_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout themedSwipeRefreshLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super SwipeRefreshLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 swipe_refresh_layout = C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) swipe_refresh_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout swipeRefreshLayout(@NotNull Context context, @NotNull Function1<? super SwipeRefreshLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static /* synthetic */ SwipeRefreshLayout themedSwipeRefreshLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static /* synthetic */ SwipeRefreshLayout themedSwipeRefreshLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout themedSwipeRefreshLayout(@NotNull Context context, int i, @NotNull Function1<? super SwipeRefreshLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout swipeRefreshLayout(@NotNull Activity activity, @NotNull Function1<? super SwipeRefreshLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static /* synthetic */ SwipeRefreshLayout themedSwipeRefreshLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static /* synthetic */ SwipeRefreshLayout themedSwipeRefreshLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout themedSwipeRefreshLayout(@NotNull Activity activity, int i, @NotNull Function1<? super SwipeRefreshLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        function1.invoke(swipeRefreshLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final FragmentTabHost fragmentTabHost(@NotNull ViewManager viewManager, @NotNull Function1<? super _FragmentTabHost, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fragment_tab_host = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fragment_tab_host.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static /* synthetic */ FragmentTabHost themedFragmentTabHost$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fragment_tab_host = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fragment_tab_host.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static /* synthetic */ FragmentTabHost themedFragmentTabHost$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fragment_tab_host = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fragment_tab_host.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost themedFragmentTabHost(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _FragmentTabHost, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fragment_tab_host = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fragment_tab_host.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost fragmentTabHost(@NotNull Context context, @NotNull Function1<? super _FragmentTabHost, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static /* synthetic */ FragmentTabHost themedFragmentTabHost$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static /* synthetic */ FragmentTabHost themedFragmentTabHost$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost themedFragmentTabHost(@NotNull Context context, int i, @NotNull Function1<? super _FragmentTabHost, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost fragmentTabHost(@NotNull Activity activity, @NotNull Function1<? super _FragmentTabHost, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static /* synthetic */ FragmentTabHost themedFragmentTabHost$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static /* synthetic */ FragmentTabHost themedFragmentTabHost$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost themedFragmentTabHost(@NotNull Activity activity, int i, @NotNull Function1<? super _FragmentTabHost, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_FragmentTabHost) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final ViewPager viewPager(@NotNull ViewManager viewManager, @NotNull Function1<? super _ViewPager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 view_pager = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_pager.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ViewPager) view;
    }

    @NotNull
    public static /* synthetic */ ViewPager themedViewPager$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 view_pager = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_pager.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ViewPager) view;
    }

    @NotNull
    public static /* synthetic */ ViewPager themedViewPager$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 view_pager = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_pager.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager themedViewPager(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _ViewPager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 view_pager = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_pager.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager viewPager(@NotNull Context context, @NotNull Function1<? super _ViewPager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ViewPager) view;
    }

    @NotNull
    public static /* synthetic */ ViewPager themedViewPager$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ViewPager) view;
    }

    @NotNull
    public static /* synthetic */ ViewPager themedViewPager$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager themedViewPager(@NotNull Context context, int i, @NotNull Function1<? super _ViewPager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager viewPager(@NotNull Activity activity, @NotNull Function1<? super _ViewPager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ViewPager) view;
    }

    @NotNull
    public static /* synthetic */ ViewPager themedViewPager$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ViewPager) view;
    }

    @NotNull
    public static /* synthetic */ ViewPager themedViewPager$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager themedViewPager(@NotNull Activity activity, int i, @NotNull Function1<? super _ViewPager, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ViewPager) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final DrawerLayout drawerLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super _DrawerLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 drawer_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) drawer_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static /* synthetic */ DrawerLayout themedDrawerLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 drawer_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) drawer_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static /* synthetic */ DrawerLayout themedDrawerLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 drawer_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) drawer_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout themedDrawerLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _DrawerLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 drawer_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) drawer_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout drawerLayout(@NotNull Context context, @NotNull Function1<? super _DrawerLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static /* synthetic */ DrawerLayout themedDrawerLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static /* synthetic */ DrawerLayout themedDrawerLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout themedDrawerLayout(@NotNull Context context, int i, @NotNull Function1<? super _DrawerLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout drawerLayout(@NotNull Activity activity, @NotNull Function1<? super _DrawerLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static /* synthetic */ DrawerLayout themedDrawerLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static /* synthetic */ DrawerLayout themedDrawerLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout themedDrawerLayout(@NotNull Activity activity, int i, @NotNull Function1<? super _DrawerLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_DrawerLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final NestedScrollView nestedScrollView(@NotNull ViewManager viewManager, @NotNull Function1<? super _NestedScrollView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 nested_scroll_view = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) nested_scroll_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static /* synthetic */ NestedScrollView themedNestedScrollView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 nested_scroll_view = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) nested_scroll_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static /* synthetic */ NestedScrollView themedNestedScrollView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 nested_scroll_view = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) nested_scroll_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView themedNestedScrollView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _NestedScrollView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 nested_scroll_view = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) nested_scroll_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView nestedScrollView(@NotNull Context context, @NotNull Function1<? super _NestedScrollView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static /* synthetic */ NestedScrollView themedNestedScrollView$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static /* synthetic */ NestedScrollView themedNestedScrollView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView themedNestedScrollView(@NotNull Context context, int i, @NotNull Function1<? super _NestedScrollView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView nestedScrollView(@NotNull Activity activity, @NotNull Function1<? super _NestedScrollView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static /* synthetic */ NestedScrollView themedNestedScrollView$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static /* synthetic */ NestedScrollView themedNestedScrollView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView themedNestedScrollView(@NotNull Activity activity, int i, @NotNull Function1<? super _NestedScrollView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_NestedScrollView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final SlidingPaneLayout slidingPaneLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super _SlidingPaneLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 sliding_pane_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) sliding_pane_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static /* synthetic */ SlidingPaneLayout themedSlidingPaneLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 sliding_pane_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) sliding_pane_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static /* synthetic */ SlidingPaneLayout themedSlidingPaneLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 sliding_pane_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) sliding_pane_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout themedSlidingPaneLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _SlidingPaneLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 sliding_pane_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) sliding_pane_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout slidingPaneLayout(@NotNull Context context, @NotNull Function1<? super _SlidingPaneLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static /* synthetic */ SlidingPaneLayout themedSlidingPaneLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static /* synthetic */ SlidingPaneLayout themedSlidingPaneLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout themedSlidingPaneLayout(@NotNull Context context, int i, @NotNull Function1<? super _SlidingPaneLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout slidingPaneLayout(@NotNull Activity activity, @NotNull Function1<? super _SlidingPaneLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static /* synthetic */ SlidingPaneLayout themedSlidingPaneLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static /* synthetic */ SlidingPaneLayout themedSlidingPaneLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout themedSlidingPaneLayout(@NotNull Activity activity, int i, @NotNull Function1<? super _SlidingPaneLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_SlidingPaneLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final PagerTabStrip pagerTabStrip(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 pager_tab_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_tab_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip themedPagerTabStrip(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 pager_tab_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_tab_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip pagerTabStrip(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip themedPagerTabStrip(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip pagerTabStrip(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTabStrip themedPagerTabStrip(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TAB_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        PagerTabStrip pagerTabStrip = (PagerTabStrip) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTabStrip;
    }

    @NotNull
    public static final PagerTitleStrip pagerTitleStrip(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 pager_title_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_title_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip themedPagerTitleStrip(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 pager_title_strip = C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) pager_title_strip.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip pagerTitleStrip(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip themedPagerTitleStrip(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip pagerTitleStrip(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final PagerTitleStrip themedPagerTitleStrip(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getPAGER_TITLE_STRIP().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return pagerTitleStrip;
    }

    @NotNull
    public static final ContentLoadingProgressBar contentLoadingProgressBar(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 content_loading_progress_bar = C$$Anko$Factories$SupportV4View.INSTANCE.getCONTENT_LOADING_PROGRESS_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_loading_progress_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentLoadingProgressBar;
    }

    @NotNull
    public static final ContentLoadingProgressBar themedContentLoadingProgressBar(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 content_loading_progress_bar = C$$Anko$Factories$SupportV4View.INSTANCE.getCONTENT_LOADING_PROGRESS_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_loading_progress_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentLoadingProgressBar;
    }

    @NotNull
    public static final Space space(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 space = C$$Anko$Factories$SupportV4View.INSTANCE.getSPACE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) space.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Space space2 = (Space) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return space2;
    }

    @NotNull
    public static final Space themedSpace(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 space = C$$Anko$Factories$SupportV4View.INSTANCE.getSPACE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) space.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Space space2 = (Space) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return space2;
    }

    @NotNull
    public static final SwipeRefreshLayout swipeRefreshLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 swipe_refresh_layout = C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) swipe_refresh_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout themedSwipeRefreshLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 swipe_refresh_layout = C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) swipe_refresh_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout swipeRefreshLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout themedSwipeRefreshLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout swipeRefreshLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final SwipeRefreshLayout themedSwipeRefreshLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4View.INSTANCE.getSWIPE_REFRESH_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return swipeRefreshLayout;
    }

    @NotNull
    public static final FragmentTabHost fragmentTabHost(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fragment_tab_host = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fragment_tab_host.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost themedFragmentTabHost(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fragment_tab_host = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fragment_tab_host.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost fragmentTabHost(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost themedFragmentTabHost(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost fragmentTabHost(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final FragmentTabHost themedFragmentTabHost(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getFRAGMENT_TAB_HOST().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _FragmentTabHost _fragmenttabhost = (_FragmentTabHost) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (FragmentTabHost) view;
    }

    @NotNull
    public static final ViewPager viewPager(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 view_pager = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_pager.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager themedViewPager(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 view_pager = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_pager.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager viewPager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager themedViewPager(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager viewPager(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final ViewPager themedViewPager(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getVIEW_PAGER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ViewPager _viewpager = (_ViewPager) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ViewPager) view;
    }

    @NotNull
    public static final DrawerLayout drawerLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 drawer_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) drawer_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout themedDrawerLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 drawer_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) drawer_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout drawerLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout themedDrawerLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout drawerLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final DrawerLayout themedDrawerLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getDRAWER_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _DrawerLayout _drawerlayout = (_DrawerLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (DrawerLayout) view;
    }

    @NotNull
    public static final NestedScrollView nestedScrollView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 nested_scroll_view = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) nested_scroll_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView themedNestedScrollView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 nested_scroll_view = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) nested_scroll_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView nestedScrollView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView themedNestedScrollView(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView nestedScrollView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final NestedScrollView themedNestedScrollView(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getNESTED_SCROLL_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _NestedScrollView _nestedscrollview = (_NestedScrollView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (NestedScrollView) view;
    }

    @NotNull
    public static final SlidingPaneLayout slidingPaneLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 sliding_pane_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) sliding_pane_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout themedSlidingPaneLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 sliding_pane_layout = C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) sliding_pane_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout slidingPaneLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout themedSlidingPaneLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout slidingPaneLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (SlidingPaneLayout) view;
    }

    @NotNull
    public static final SlidingPaneLayout themedSlidingPaneLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$SupportV4ViewGroup.INSTANCE.getSLIDING_PANE_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _SlidingPaneLayout _slidingpanelayout = (_SlidingPaneLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (SlidingPaneLayout) view;
    }
}
