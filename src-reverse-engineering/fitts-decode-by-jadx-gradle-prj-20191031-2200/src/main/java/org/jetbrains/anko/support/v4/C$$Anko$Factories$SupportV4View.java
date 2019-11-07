package org.jetbrains.anko.support.v4;

import android.content.Context;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.legacy.widget.Space;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.PagerTitleStrip;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.support.v4.$$Anko$Factories$SupportV4View reason: invalid class name */
public final class C$$Anko$Factories$SupportV4View {
    @NotNull
    private static final Function1<Context, ContentLoadingProgressBar> CONTENT_LOADING_PROGRESS_BAR = C$$Anko$Factories$SupportV4View$CONTENT_LOADING_PROGRESS_BAR$1.INSTANCE;
    public static final C$$Anko$Factories$SupportV4View INSTANCE = new C$$Anko$Factories$SupportV4View();
    @NotNull
    private static final Function1<Context, PagerTabStrip> PAGER_TAB_STRIP = C$$Anko$Factories$SupportV4View$PAGER_TAB_STRIP$1.INSTANCE;
    @NotNull
    private static final Function1<Context, PagerTitleStrip> PAGER_TITLE_STRIP = C$$Anko$Factories$SupportV4View$PAGER_TITLE_STRIP$1.INSTANCE;
    @NotNull
    private static final Function1<Context, Space> SPACE = C$$Anko$Factories$SupportV4View$SPACE$1.INSTANCE;
    @NotNull
    private static final Function1<Context, SwipeRefreshLayout> SWIPE_REFRESH_LAYOUT = C$$Anko$Factories$SupportV4View$SWIPE_REFRESH_LAYOUT$1.INSTANCE;

    private C$$Anko$Factories$SupportV4View() {
    }

    @NotNull
    public final Function1<Context, PagerTabStrip> getPAGER_TAB_STRIP() {
        return PAGER_TAB_STRIP;
    }

    @NotNull
    public final Function1<Context, PagerTitleStrip> getPAGER_TITLE_STRIP() {
        return PAGER_TITLE_STRIP;
    }

    @NotNull
    public final Function1<Context, ContentLoadingProgressBar> getCONTENT_LOADING_PROGRESS_BAR() {
        return CONTENT_LOADING_PROGRESS_BAR;
    }

    @NotNull
    public final Function1<Context, Space> getSPACE() {
        return SPACE;
    }

    @NotNull
    public final Function1<Context, SwipeRefreshLayout> getSWIPE_REFRESH_LAYOUT() {
        return SWIPE_REFRESH_LAYOUT;
    }
}
