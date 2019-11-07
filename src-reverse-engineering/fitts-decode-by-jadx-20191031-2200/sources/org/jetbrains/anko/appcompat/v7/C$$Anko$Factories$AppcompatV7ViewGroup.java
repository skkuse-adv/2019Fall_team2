package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7ViewGroup reason: invalid class name */
public final class C$$Anko$Factories$AppcompatV7ViewGroup {
    @NotNull
    private static final Function1<Context, _ActionBarContainer> ACTION_BAR_CONTAINER = C$$Anko$Factories$AppcompatV7ViewGroup$ACTION_BAR_CONTAINER$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _ActionBarOverlayLayout> ACTION_BAR_OVERLAY_LAYOUT = C$$Anko$Factories$AppcompatV7ViewGroup$ACTION_BAR_OVERLAY_LAYOUT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _ActionMenuView> ACTION_MENU_VIEW = C$$Anko$Factories$AppcompatV7ViewGroup$ACTION_MENU_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _AlertDialogLayout> ALERT_DIALOG_LAYOUT = C$$Anko$Factories$AppcompatV7ViewGroup$ALERT_DIALOG_LAYOUT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _ButtonBarLayout> BUTTON_BAR_LAYOUT = C$$Anko$Factories$AppcompatV7ViewGroup$BUTTON_BAR_LAYOUT$1.INSTANCE;
    public static final C$$Anko$Factories$AppcompatV7ViewGroup INSTANCE = new C$$Anko$Factories$AppcompatV7ViewGroup();
    @NotNull
    private static final Function1<Context, _LinearLayoutCompat> LINEAR_LAYOUT_COMPAT = C$$Anko$Factories$AppcompatV7ViewGroup$LINEAR_LAYOUT_COMPAT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _ListMenuItemView> LIST_MENU_ITEM_VIEW = C$$Anko$Factories$AppcompatV7ViewGroup$LIST_MENU_ITEM_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _ScrollingTabContainerView> SCROLLING_TAB_CONTAINER_VIEW = C$$Anko$Factories$AppcompatV7ViewGroup$SCROLLING_TAB_CONTAINER_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, _Toolbar> TOOLBAR = C$$Anko$Factories$AppcompatV7ViewGroup$TOOLBAR$1.INSTANCE;

    private C$$Anko$Factories$AppcompatV7ViewGroup() {
    }

    @NotNull
    public final Function1<Context, _ListMenuItemView> getLIST_MENU_ITEM_VIEW() {
        return LIST_MENU_ITEM_VIEW;
    }

    @NotNull
    public final Function1<Context, _ActionBarContainer> getACTION_BAR_CONTAINER() {
        return ACTION_BAR_CONTAINER;
    }

    @NotNull
    public final Function1<Context, _ActionBarOverlayLayout> getACTION_BAR_OVERLAY_LAYOUT() {
        return ACTION_BAR_OVERLAY_LAYOUT;
    }

    @NotNull
    public final Function1<Context, _ActionMenuView> getACTION_MENU_VIEW() {
        return ACTION_MENU_VIEW;
    }

    @NotNull
    public final Function1<Context, _AlertDialogLayout> getALERT_DIALOG_LAYOUT() {
        return ALERT_DIALOG_LAYOUT;
    }

    @NotNull
    public final Function1<Context, _ButtonBarLayout> getBUTTON_BAR_LAYOUT() {
        return BUTTON_BAR_LAYOUT;
    }

    @NotNull
    public final Function1<Context, _LinearLayoutCompat> getLINEAR_LAYOUT_COMPAT() {
        return LINEAR_LAYOUT_COMPAT;
    }

    @NotNull
    public final Function1<Context, _ScrollingTabContainerView> getSCROLLING_TAB_CONTAINER_VIEW() {
        return SCROLLING_TAB_CONTAINER_VIEW;
    }

    @NotNull
    public final Function1<Context, _Toolbar> getTOOLBAR() {
        return TOOLBAR;
    }
}
