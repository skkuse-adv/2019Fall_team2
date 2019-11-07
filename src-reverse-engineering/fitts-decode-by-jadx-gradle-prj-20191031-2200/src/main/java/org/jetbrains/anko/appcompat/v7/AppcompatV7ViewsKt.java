package org.jetbrains.anko.appcompat.v7;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DialogTitle;
import androidx.appcompat.widget.FitWindowsFrameLayout;
import androidx.appcompat.widget.FitWindowsLinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppcompatV7ViewsKt {
    @NotNull
    public static final ActionMenuItemView actionMenuItemView(@NotNull ViewManager viewManager, @NotNull Function1<? super ActionMenuItemView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_menu_item_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
        function1.invoke(actionMenuItemView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionMenuItemView;
    }

    @NotNull
    public static /* synthetic */ ActionMenuItemView themedActionMenuItemView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_menu_item_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionMenuItemView;
    }

    @NotNull
    public static /* synthetic */ ActionMenuItemView themedActionMenuItemView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_menu_item_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
        function1.invoke(actionMenuItemView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionMenuItemView;
    }

    @NotNull
    public static final ActionMenuItemView themedActionMenuItemView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ActionMenuItemView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_menu_item_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
        function1.invoke(actionMenuItemView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionMenuItemView;
    }

    @NotNull
    public static final ExpandedMenuView expandedMenuView(@NotNull ViewManager viewManager, @NotNull Function1<? super ExpandedMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 expanded_menu_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) expanded_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return expandedMenuView;
    }

    @NotNull
    public static /* synthetic */ ExpandedMenuView themedExpandedMenuView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 expanded_menu_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) expanded_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return expandedMenuView;
    }

    @NotNull
    public static /* synthetic */ ExpandedMenuView themedExpandedMenuView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 expanded_menu_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) expanded_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView themedExpandedMenuView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ExpandedMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 expanded_menu_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) expanded_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView expandedMenuView(@NotNull Context context, @NotNull Function1<? super ExpandedMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(context, view);
        return expandedMenuView;
    }

    @NotNull
    public static /* synthetic */ ExpandedMenuView themedExpandedMenuView$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return expandedMenuView;
    }

    @NotNull
    public static /* synthetic */ ExpandedMenuView themedExpandedMenuView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(context, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView themedExpandedMenuView(@NotNull Context context, int i, @NotNull Function1<? super ExpandedMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(context, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView expandedMenuView(@NotNull Activity activity, @NotNull Function1<? super ExpandedMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return expandedMenuView;
    }

    @NotNull
    public static /* synthetic */ ExpandedMenuView themedExpandedMenuView$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return expandedMenuView;
    }

    @NotNull
    public static /* synthetic */ ExpandedMenuView themedExpandedMenuView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView themedExpandedMenuView(@NotNull Activity activity, int i, @NotNull Function1<? super ExpandedMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        function1.invoke(expandedMenuView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ActionBarContextView actionBarContextView(@NotNull ViewManager viewManager, @NotNull Function1<? super ActionBarContextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_context_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_context_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionBarContextView;
    }

    @NotNull
    public static /* synthetic */ ActionBarContextView themedActionBarContextView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_context_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_context_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionBarContextView;
    }

    @NotNull
    public static /* synthetic */ ActionBarContextView themedActionBarContextView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_context_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_context_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView themedActionBarContextView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ActionBarContextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_context_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_context_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView actionBarContextView(@NotNull Context context, @NotNull Function1<? super ActionBarContextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(context, view);
        return actionBarContextView;
    }

    @NotNull
    public static /* synthetic */ ActionBarContextView themedActionBarContextView$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return actionBarContextView;
    }

    @NotNull
    public static /* synthetic */ ActionBarContextView themedActionBarContextView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(context, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView themedActionBarContextView(@NotNull Context context, int i, @NotNull Function1<? super ActionBarContextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(context, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView actionBarContextView(@NotNull Activity activity, @NotNull Function1<? super ActionBarContextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return actionBarContextView;
    }

    @NotNull
    public static /* synthetic */ ActionBarContextView themedActionBarContextView$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return actionBarContextView;
    }

    @NotNull
    public static /* synthetic */ ActionBarContextView themedActionBarContextView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView themedActionBarContextView(@NotNull Activity activity, int i, @NotNull Function1<? super ActionBarContextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        function1.invoke(actionBarContextView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActivityChooserView activityChooserView(@NotNull ViewManager viewManager, @NotNull Function1<? super ActivityChooserView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 activity_chooser_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) activity_chooser_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return activityChooserView;
    }

    @NotNull
    public static /* synthetic */ ActivityChooserView themedActivityChooserView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 activity_chooser_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) activity_chooser_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return activityChooserView;
    }

    @NotNull
    public static /* synthetic */ ActivityChooserView themedActivityChooserView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 activity_chooser_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) activity_chooser_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView themedActivityChooserView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ActivityChooserView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 activity_chooser_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) activity_chooser_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView activityChooserView(@NotNull Context context, @NotNull Function1<? super ActivityChooserView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(context, view);
        return activityChooserView;
    }

    @NotNull
    public static /* synthetic */ ActivityChooserView themedActivityChooserView$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return activityChooserView;
    }

    @NotNull
    public static /* synthetic */ ActivityChooserView themedActivityChooserView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(context, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView themedActivityChooserView(@NotNull Context context, int i, @NotNull Function1<? super ActivityChooserView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(context, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView activityChooserView(@NotNull Activity activity, @NotNull Function1<? super ActivityChooserView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return activityChooserView;
    }

    @NotNull
    public static /* synthetic */ ActivityChooserView themedActivityChooserView$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return activityChooserView;
    }

    @NotNull
    public static /* synthetic */ ActivityChooserView themedActivityChooserView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView themedActivityChooserView(@NotNull Activity activity, int i, @NotNull Function1<? super ActivityChooserView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        function1.invoke(activityChooserView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return activityChooserView;
    }

    @NotNull
    public static final AutoCompleteTextView tintedAutoCompleteTextView(@NotNull ViewManager viewManager, @NotNull Function1<? super AutoCompleteTextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
        function1.invoke(autoCompleteTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return autoCompleteTextView;
    }

    @NotNull
    public static /* synthetic */ AutoCompleteTextView themedTintedAutoCompleteTextView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return autoCompleteTextView;
    }

    @NotNull
    public static /* synthetic */ AutoCompleteTextView themedTintedAutoCompleteTextView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
        function1.invoke(autoCompleteTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return autoCompleteTextView;
    }

    @NotNull
    public static final AutoCompleteTextView themedTintedAutoCompleteTextView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super AutoCompleteTextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
        function1.invoke(autoCompleteTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return autoCompleteTextView;
    }

    @NotNull
    public static final Button tintedButton(@NotNull ViewManager viewManager, @NotNull Function1<? super Button, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Button button = (Button) view;
        function1.invoke(button);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static /* synthetic */ Button themedTintedButton$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Button button = (Button) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static /* synthetic */ Button themedTintedButton$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Button button = (Button) view;
        function1.invoke(button);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button themedTintedButton(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super Button, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Button button = (Button) view;
        function1.invoke(button);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button tintedButton(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Button button = (Button) view;
        button.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button tintedButton(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, @NotNull Function1<? super Button, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Button button = (Button) view;
        function1.invoke(button);
        button.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button themedTintedButton(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Button button = (Button) view;
        button.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button themedTintedButton(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, int i, @NotNull Function1<? super Button, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Button button = (Button) view;
        function1.invoke(button);
        button.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button tintedButton(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Button button = (Button) view;
        button.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button tintedButton(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super Button, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Button button = (Button) view;
        function1.invoke(button);
        button.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button themedTintedButton(@NotNull ViewManager viewManager, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        Button button = (Button) view;
        button.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button themedTintedButton(@NotNull ViewManager viewManager, int i, int i2, @NotNull Function1<? super Button, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        Button button = (Button) view;
        function1.invoke(button);
        button.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static /* synthetic */ CheckBox themedTintedCheckBox$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckBox checkBox = (CheckBox) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static /* synthetic */ CheckBox themedTintedCheckBox$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        checkBox.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        checkBox.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckBox checkBox = (CheckBox) view;
        checkBox.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, int i, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        checkBox.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        checkBox.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        checkBox.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        CheckBox checkBox = (CheckBox) view;
        checkBox.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, int i, int i2, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        checkBox.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, boolean z) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        checkBox.setText(charSequence);
        checkBox.setChecked(z);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, boolean z, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        checkBox.setText(charSequence);
        checkBox.setChecked(z);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckBox checkBox = (CheckBox) view;
        checkBox.setText(charSequence);
        checkBox.setChecked(z);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, boolean z, int i, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        checkBox.setText(charSequence);
        checkBox.setChecked(z);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        checkBox.setText(i);
        checkBox.setChecked(z);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager, int i, boolean z, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        checkBox.setText(i);
        checkBox.setChecked(z);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, int i, boolean z, int i2) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        CheckBox checkBox = (CheckBox) view;
        checkBox.setText(i);
        checkBox.setChecked(z);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, int i, boolean z, int i2, @NotNull Function1<? super CheckBox, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        CheckBox checkBox = (CheckBox) view;
        function1.invoke(checkBox);
        checkBox.setText(i);
        checkBox.setChecked(z);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckedTextView tintedCheckedTextView(@NotNull ViewManager viewManager, @NotNull Function1<? super CheckedTextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_checked_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECKED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_checked_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckedTextView checkedTextView = (CheckedTextView) view;
        function1.invoke(checkedTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkedTextView;
    }

    @NotNull
    public static /* synthetic */ CheckedTextView themedTintedCheckedTextView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_checked_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECKED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_checked_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckedTextView checkedTextView = (CheckedTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkedTextView;
    }

    @NotNull
    public static /* synthetic */ CheckedTextView themedTintedCheckedTextView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_checked_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECKED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_checked_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckedTextView checkedTextView = (CheckedTextView) view;
        function1.invoke(checkedTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkedTextView;
    }

    @NotNull
    public static final CheckedTextView themedTintedCheckedTextView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super CheckedTextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_checked_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECKED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_checked_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckedTextView checkedTextView = (CheckedTextView) view;
        function1.invoke(checkedTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkedTextView;
    }

    @NotNull
    public static final EditText tintedEditText(@NotNull ViewManager viewManager, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        EditText editText = (EditText) view;
        function1.invoke(editText);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static /* synthetic */ EditText themedTintedEditText$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static /* synthetic */ EditText themedTintedEditText$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        EditText editText = (EditText) view;
        function1.invoke(editText);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText themedTintedEditText(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        EditText editText = (EditText) view;
        function1.invoke(editText);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText tintedEditText(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        EditText editText = (EditText) view;
        editText.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText tintedEditText(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        EditText editText = (EditText) view;
        function1.invoke(editText);
        editText.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText themedTintedEditText(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        EditText editText = (EditText) view;
        editText.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText themedTintedEditText(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, int i, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        EditText editText = (EditText) view;
        function1.invoke(editText);
        editText.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText tintedEditText(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        EditText editText = (EditText) view;
        editText.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText tintedEditText(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        EditText editText = (EditText) view;
        function1.invoke(editText);
        editText.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText themedTintedEditText(@NotNull ViewManager viewManager, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        EditText editText = (EditText) view;
        editText.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText themedTintedEditText(@NotNull ViewManager viewManager, int i, int i2, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        EditText editText = (EditText) view;
        function1.invoke(editText);
        editText.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final ImageButton tintedImageButton(@NotNull ViewManager viewManager, @NotNull Function1<? super ImageButton, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageButton imageButton = (ImageButton) view;
        function1.invoke(imageButton);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static /* synthetic */ ImageButton themedTintedImageButton$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageButton imageButton = (ImageButton) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static /* synthetic */ ImageButton themedTintedImageButton$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageButton imageButton = (ImageButton) view;
        function1.invoke(imageButton);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton themedTintedImageButton(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ImageButton, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageButton imageButton = (ImageButton) view;
        function1.invoke(imageButton);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton tintedImageButton(@NotNull ViewManager viewManager, @Nullable Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageButton imageButton = (ImageButton) view;
        imageButton.setImageDrawable(drawable);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton tintedImageButton(@NotNull ViewManager viewManager, @Nullable Drawable drawable, @NotNull Function1<? super ImageButton, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageButton imageButton = (ImageButton) view;
        function1.invoke(imageButton);
        imageButton.setImageDrawable(drawable);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton themedTintedImageButton(@NotNull ViewManager viewManager, @Nullable Drawable drawable, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageButton imageButton = (ImageButton) view;
        imageButton.setImageDrawable(drawable);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton themedTintedImageButton(@NotNull ViewManager viewManager, @Nullable Drawable drawable, int i, @NotNull Function1<? super ImageButton, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageButton imageButton = (ImageButton) view;
        function1.invoke(imageButton);
        imageButton.setImageDrawable(drawable);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton tintedImageButton(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageButton imageButton = (ImageButton) view;
        imageButton.setImageResource(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton tintedImageButton(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ImageButton, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageButton imageButton = (ImageButton) view;
        function1.invoke(imageButton);
        imageButton.setImageResource(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton themedTintedImageButton(@NotNull ViewManager viewManager, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        ImageButton imageButton = (ImageButton) view;
        imageButton.setImageResource(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton themedTintedImageButton(@NotNull ViewManager viewManager, int i, int i2, @NotNull Function1<? super ImageButton, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        ImageButton imageButton = (ImageButton) view;
        function1.invoke(imageButton);
        imageButton.setImageResource(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageView tintedImageView(@NotNull ViewManager viewManager, @NotNull Function1<? super ImageView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageView imageView = (ImageView) view;
        function1.invoke(imageView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static /* synthetic */ ImageView themedTintedImageView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageView imageView = (ImageView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static /* synthetic */ ImageView themedTintedImageView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageView imageView = (ImageView) view;
        function1.invoke(imageView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView themedTintedImageView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ImageView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageView imageView = (ImageView) view;
        function1.invoke(imageView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView tintedImageView(@NotNull ViewManager viewManager, @Nullable Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageView imageView = (ImageView) view;
        imageView.setImageDrawable(drawable);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView tintedImageView(@NotNull ViewManager viewManager, @Nullable Drawable drawable, @NotNull Function1<? super ImageView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageView imageView = (ImageView) view;
        function1.invoke(imageView);
        imageView.setImageDrawable(drawable);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView themedTintedImageView(@NotNull ViewManager viewManager, @Nullable Drawable drawable, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageView imageView = (ImageView) view;
        imageView.setImageDrawable(drawable);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView themedTintedImageView(@NotNull ViewManager viewManager, @Nullable Drawable drawable, int i, @NotNull Function1<? super ImageView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageView imageView = (ImageView) view;
        function1.invoke(imageView);
        imageView.setImageDrawable(drawable);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView tintedImageView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageView imageView = (ImageView) view;
        imageView.setImageResource(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView tintedImageView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ImageView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageView imageView = (ImageView) view;
        function1.invoke(imageView);
        imageView.setImageResource(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView themedTintedImageView(@NotNull ViewManager viewManager, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        ImageView imageView = (ImageView) view;
        imageView.setImageResource(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView themedTintedImageView(@NotNull ViewManager viewManager, int i, int i2, @NotNull Function1<? super ImageView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        ImageView imageView = (ImageView) view;
        function1.invoke(imageView);
        imageView.setImageResource(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final MultiAutoCompleteTextView tintedMultiAutoCompleteTextView(@NotNull ViewManager viewManager, @NotNull Function1<? super MultiAutoCompleteTextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_multi_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_multi_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) view;
        function1.invoke(multiAutoCompleteTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return multiAutoCompleteTextView;
    }

    @NotNull
    public static /* synthetic */ MultiAutoCompleteTextView themedTintedMultiAutoCompleteTextView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_multi_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_multi_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return multiAutoCompleteTextView;
    }

    @NotNull
    public static /* synthetic */ MultiAutoCompleteTextView themedTintedMultiAutoCompleteTextView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_multi_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_multi_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) view;
        function1.invoke(multiAutoCompleteTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return multiAutoCompleteTextView;
    }

    @NotNull
    public static final MultiAutoCompleteTextView themedTintedMultiAutoCompleteTextView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super MultiAutoCompleteTextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_multi_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_multi_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) view;
        function1.invoke(multiAutoCompleteTextView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return multiAutoCompleteTextView;
    }

    @NotNull
    public static final RadioButton tintedRadioButton(@NotNull ViewManager viewManager, @NotNull Function1<? super RadioButton, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_radio_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RADIO_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_radio_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        RadioButton radioButton = (RadioButton) view;
        function1.invoke(radioButton);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return radioButton;
    }

    @NotNull
    public static /* synthetic */ RadioButton themedTintedRadioButton$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_radio_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RADIO_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_radio_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        RadioButton radioButton = (RadioButton) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return radioButton;
    }

    @NotNull
    public static /* synthetic */ RadioButton themedTintedRadioButton$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_radio_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RADIO_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_radio_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        RadioButton radioButton = (RadioButton) view;
        function1.invoke(radioButton);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return radioButton;
    }

    @NotNull
    public static final RadioButton themedTintedRadioButton(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super RadioButton, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_radio_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RADIO_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_radio_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        RadioButton radioButton = (RadioButton) view;
        function1.invoke(radioButton);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return radioButton;
    }

    @NotNull
    public static final RatingBar tintedRatingBar(@NotNull ViewManager viewManager, @NotNull Function1<? super RatingBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_rating_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RATING_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_rating_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        RatingBar ratingBar = (RatingBar) view;
        function1.invoke(ratingBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return ratingBar;
    }

    @NotNull
    public static /* synthetic */ RatingBar themedTintedRatingBar$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_rating_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RATING_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_rating_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        RatingBar ratingBar = (RatingBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return ratingBar;
    }

    @NotNull
    public static /* synthetic */ RatingBar themedTintedRatingBar$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_rating_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RATING_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_rating_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        RatingBar ratingBar = (RatingBar) view;
        function1.invoke(ratingBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return ratingBar;
    }

    @NotNull
    public static final RatingBar themedTintedRatingBar(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super RatingBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_rating_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RATING_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_rating_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        RatingBar ratingBar = (RatingBar) view;
        function1.invoke(ratingBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return ratingBar;
    }

    @NotNull
    public static final SeekBar tintedSeekBar(@NotNull ViewManager viewManager, @NotNull Function1<? super SeekBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_seek_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SEEK_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_seek_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        SeekBar seekBar = (SeekBar) view;
        function1.invoke(seekBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return seekBar;
    }

    @NotNull
    public static /* synthetic */ SeekBar themedTintedSeekBar$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_seek_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SEEK_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_seek_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SeekBar seekBar = (SeekBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return seekBar;
    }

    @NotNull
    public static /* synthetic */ SeekBar themedTintedSeekBar$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_seek_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SEEK_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_seek_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SeekBar seekBar = (SeekBar) view;
        function1.invoke(seekBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return seekBar;
    }

    @NotNull
    public static final SeekBar themedTintedSeekBar(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super SeekBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_seek_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SEEK_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_seek_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SeekBar seekBar = (SeekBar) view;
        function1.invoke(seekBar);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return seekBar;
    }

    @NotNull
    public static final Spinner tintedSpinner(@NotNull ViewManager viewManager, @NotNull Function1<? super Spinner, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_spinner = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_spinner.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return spinner;
    }

    @NotNull
    public static /* synthetic */ Spinner themedTintedSpinner$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_spinner = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_spinner.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return spinner;
    }

    @NotNull
    public static /* synthetic */ Spinner themedTintedSpinner$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_spinner = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_spinner.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return spinner;
    }

    @NotNull
    public static final Spinner themedTintedSpinner(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super Spinner, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_spinner = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_spinner.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return spinner;
    }

    @NotNull
    public static final Spinner tintedSpinner(@NotNull Context context, @NotNull Function1<? super Spinner, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(context, view);
        return spinner;
    }

    @NotNull
    public static /* synthetic */ Spinner themedTintedSpinner$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return spinner;
    }

    @NotNull
    public static /* synthetic */ Spinner themedTintedSpinner$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(context, view);
        return spinner;
    }

    @NotNull
    public static final Spinner themedTintedSpinner(@NotNull Context context, int i, @NotNull Function1<? super Spinner, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(context, view);
        return spinner;
    }

    @NotNull
    public static final Spinner tintedSpinner(@NotNull Activity activity, @NotNull Function1<? super Spinner, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(activity, view);
        return spinner;
    }

    @NotNull
    public static /* synthetic */ Spinner themedTintedSpinner$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return spinner;
    }

    @NotNull
    public static /* synthetic */ Spinner themedTintedSpinner$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(activity, view);
        return spinner;
    }

    @NotNull
    public static final Spinner themedTintedSpinner(@NotNull Activity activity, int i, @NotNull Function1<? super Spinner, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        Spinner spinner = (Spinner) view;
        function1.invoke(spinner);
        AnkoInternals.INSTANCE.addView(activity, view);
        return spinner;
    }

    @NotNull
    public static final TextView tintedTextView(@NotNull ViewManager viewManager, @NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        TextView textView = (TextView) view;
        function1.invoke(textView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static /* synthetic */ TextView themedTintedTextView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        TextView textView = (TextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static /* synthetic */ TextView themedTintedTextView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        TextView textView = (TextView) view;
        function1.invoke(textView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView themedTintedTextView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        TextView textView = (TextView) view;
        function1.invoke(textView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView tintedTextView(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        TextView textView = (TextView) view;
        textView.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView tintedTextView(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, @NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        TextView textView = (TextView) view;
        function1.invoke(textView);
        textView.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView themedTintedTextView(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        TextView textView = (TextView) view;
        textView.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView themedTintedTextView(@NotNull ViewManager viewManager, @Nullable CharSequence charSequence, int i, @NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        TextView textView = (TextView) view;
        function1.invoke(textView);
        textView.setText(charSequence);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView tintedTextView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        TextView textView = (TextView) view;
        textView.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView tintedTextView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        TextView textView = (TextView) view;
        function1.invoke(textView);
        textView.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView themedTintedTextView(@NotNull ViewManager viewManager, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        TextView textView = (TextView) view;
        textView.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView themedTintedTextView(@NotNull ViewManager viewManager, int i, int i2, @NotNull Function1<? super TextView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i2));
        TextView textView = (TextView) view;
        function1.invoke(textView);
        textView.setText(i);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final ContentFrameLayout contentFrameLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super ContentFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 content_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentFrameLayout;
    }

    @NotNull
    public static /* synthetic */ ContentFrameLayout themedContentFrameLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 content_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentFrameLayout;
    }

    @NotNull
    public static /* synthetic */ ContentFrameLayout themedContentFrameLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 content_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout themedContentFrameLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ContentFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 content_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout contentFrameLayout(@NotNull Context context, @NotNull Function1<? super ContentFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return contentFrameLayout;
    }

    @NotNull
    public static /* synthetic */ ContentFrameLayout themedContentFrameLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return contentFrameLayout;
    }

    @NotNull
    public static /* synthetic */ ContentFrameLayout themedContentFrameLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout themedContentFrameLayout(@NotNull Context context, int i, @NotNull Function1<? super ContentFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout contentFrameLayout(@NotNull Activity activity, @NotNull Function1<? super ContentFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return contentFrameLayout;
    }

    @NotNull
    public static /* synthetic */ ContentFrameLayout themedContentFrameLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return contentFrameLayout;
    }

    @NotNull
    public static /* synthetic */ ContentFrameLayout themedContentFrameLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout themedContentFrameLayout(@NotNull Activity activity, int i, @NotNull Function1<? super ContentFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        function1.invoke(contentFrameLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final DialogTitle dialogTitle(@NotNull ViewManager viewManager, @NotNull Function1<? super DialogTitle, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 dialog_title = C$$Anko$Factories$AppcompatV7View.INSTANCE.getDIALOG_TITLE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) dialog_title.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        DialogTitle dialogTitle = (DialogTitle) view;
        function1.invoke(dialogTitle);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return dialogTitle;
    }

    @NotNull
    public static /* synthetic */ DialogTitle themedDialogTitle$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 dialog_title = C$$Anko$Factories$AppcompatV7View.INSTANCE.getDIALOG_TITLE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) dialog_title.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        DialogTitle dialogTitle = (DialogTitle) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return dialogTitle;
    }

    @NotNull
    public static /* synthetic */ DialogTitle themedDialogTitle$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 dialog_title = C$$Anko$Factories$AppcompatV7View.INSTANCE.getDIALOG_TITLE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) dialog_title.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        DialogTitle dialogTitle = (DialogTitle) view;
        function1.invoke(dialogTitle);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return dialogTitle;
    }

    @NotNull
    public static final DialogTitle themedDialogTitle(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super DialogTitle, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 dialog_title = C$$Anko$Factories$AppcompatV7View.INSTANCE.getDIALOG_TITLE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) dialog_title.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        DialogTitle dialogTitle = (DialogTitle) view;
        function1.invoke(dialogTitle);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return dialogTitle;
    }

    @NotNull
    public static final FitWindowsFrameLayout fitWindowsFrameLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super FitWindowsFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fit_windows_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsFrameLayout themedFitWindowsFrameLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fit_windows_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsFrameLayout themedFitWindowsFrameLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fit_windows_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout themedFitWindowsFrameLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super FitWindowsFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fit_windows_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout fitWindowsFrameLayout(@NotNull Context context, @NotNull Function1<? super FitWindowsFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsFrameLayout themedFitWindowsFrameLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsFrameLayout themedFitWindowsFrameLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout themedFitWindowsFrameLayout(@NotNull Context context, int i, @NotNull Function1<? super FitWindowsFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout fitWindowsFrameLayout(@NotNull Activity activity, @NotNull Function1<? super FitWindowsFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsFrameLayout themedFitWindowsFrameLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsFrameLayout themedFitWindowsFrameLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout themedFitWindowsFrameLayout(@NotNull Activity activity, int i, @NotNull Function1<? super FitWindowsFrameLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        function1.invoke(fitWindowsFrameLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout fitWindowsLinearLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super FitWindowsLinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fit_windows_linear_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_linear_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsLinearLayout themedFitWindowsLinearLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fit_windows_linear_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_linear_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsLinearLayout themedFitWindowsLinearLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fit_windows_linear_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_linear_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout themedFitWindowsLinearLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super FitWindowsLinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 fit_windows_linear_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_linear_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout fitWindowsLinearLayout(@NotNull Context context, @NotNull Function1<? super FitWindowsLinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsLinearLayout themedFitWindowsLinearLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsLinearLayout themedFitWindowsLinearLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout themedFitWindowsLinearLayout(@NotNull Context context, int i, @NotNull Function1<? super FitWindowsLinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout fitWindowsLinearLayout(@NotNull Activity activity, @NotNull Function1<? super FitWindowsLinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsLinearLayout themedFitWindowsLinearLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static /* synthetic */ FitWindowsLinearLayout themedFitWindowsLinearLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout themedFitWindowsLinearLayout(@NotNull Activity activity, int i, @NotNull Function1<? super FitWindowsLinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        function1.invoke(fitWindowsLinearLayout);
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final SearchView searchView(@NotNull ViewManager viewManager, @NotNull Function1<? super SearchView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 search_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) search_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return searchView;
    }

    @NotNull
    public static /* synthetic */ SearchView themedSearchView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 search_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) search_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return searchView;
    }

    @NotNull
    public static /* synthetic */ SearchView themedSearchView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 search_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) search_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return searchView;
    }

    @NotNull
    public static final SearchView themedSearchView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super SearchView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 search_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) search_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return searchView;
    }

    @NotNull
    public static final SearchView searchView(@NotNull Context context, @NotNull Function1<? super SearchView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(context, view);
        return searchView;
    }

    @NotNull
    public static /* synthetic */ SearchView themedSearchView$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return searchView;
    }

    @NotNull
    public static /* synthetic */ SearchView themedSearchView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(context, view);
        return searchView;
    }

    @NotNull
    public static final SearchView themedSearchView(@NotNull Context context, int i, @NotNull Function1<? super SearchView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(context, view);
        return searchView;
    }

    @NotNull
    public static final SearchView searchView(@NotNull Activity activity, @NotNull Function1<? super SearchView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return searchView;
    }

    @NotNull
    public static /* synthetic */ SearchView themedSearchView$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return searchView;
    }

    @NotNull
    public static /* synthetic */ SearchView themedSearchView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return searchView;
    }

    @NotNull
    public static final SearchView themedSearchView(@NotNull Activity activity, int i, @NotNull Function1<? super SearchView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        SearchView searchView = (SearchView) view;
        function1.invoke(searchView);
        AnkoInternals.INSTANCE.addView(activity, view);
        return searchView;
    }

    @NotNull
    public static final SwitchCompat switchCompat(@NotNull ViewManager viewManager, @NotNull Function1<? super SwitchCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 switch_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSWITCH_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) switch_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        SwitchCompat switchCompat = (SwitchCompat) view;
        function1.invoke(switchCompat);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return switchCompat;
    }

    @NotNull
    public static /* synthetic */ SwitchCompat themedSwitchCompat$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 switch_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSWITCH_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) switch_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SwitchCompat switchCompat = (SwitchCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return switchCompat;
    }

    @NotNull
    public static /* synthetic */ SwitchCompat themedSwitchCompat$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 switch_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSWITCH_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) switch_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SwitchCompat switchCompat = (SwitchCompat) view;
        function1.invoke(switchCompat);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return switchCompat;
    }

    @NotNull
    public static final SwitchCompat themedSwitchCompat(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super SwitchCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 switch_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSWITCH_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) switch_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SwitchCompat switchCompat = (SwitchCompat) view;
        function1.invoke(switchCompat);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return switchCompat;
    }

    @NotNull
    public static final ViewStubCompat viewStubCompat(@NotNull ViewManager viewManager, @NotNull Function1<? super ViewStubCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 view_stub_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getVIEW_STUB_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_stub_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ViewStubCompat viewStubCompat = (ViewStubCompat) view;
        function1.invoke(viewStubCompat);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return viewStubCompat;
    }

    @NotNull
    public static /* synthetic */ ViewStubCompat themedViewStubCompat$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 view_stub_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getVIEW_STUB_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_stub_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ViewStubCompat viewStubCompat = (ViewStubCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return viewStubCompat;
    }

    @NotNull
    public static /* synthetic */ ViewStubCompat themedViewStubCompat$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 view_stub_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getVIEW_STUB_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_stub_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ViewStubCompat viewStubCompat = (ViewStubCompat) view;
        function1.invoke(viewStubCompat);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return viewStubCompat;
    }

    @NotNull
    public static final ViewStubCompat themedViewStubCompat(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ViewStubCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 view_stub_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getVIEW_STUB_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_stub_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ViewStubCompat viewStubCompat = (ViewStubCompat) view;
        function1.invoke(viewStubCompat);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return viewStubCompat;
    }

    @NotNull
    public static final ListMenuItemView listMenuItemView(@NotNull ViewManager viewManager, @NotNull Function1<? super _ListMenuItemView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 list_menu_item_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) list_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static /* synthetic */ ListMenuItemView themedListMenuItemView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 list_menu_item_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) list_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static /* synthetic */ ListMenuItemView themedListMenuItemView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 list_menu_item_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) list_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView themedListMenuItemView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _ListMenuItemView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 list_menu_item_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) list_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView listMenuItemView(@NotNull Context context, @NotNull Function1<? super _ListMenuItemView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static /* synthetic */ ListMenuItemView themedListMenuItemView$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static /* synthetic */ ListMenuItemView themedListMenuItemView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView themedListMenuItemView(@NotNull Context context, int i, @NotNull Function1<? super _ListMenuItemView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView listMenuItemView(@NotNull Activity activity, @NotNull Function1<? super _ListMenuItemView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static /* synthetic */ ListMenuItemView themedListMenuItemView$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static /* synthetic */ ListMenuItemView themedListMenuItemView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView themedListMenuItemView(@NotNull Activity activity, int i, @NotNull Function1<? super _ListMenuItemView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ListMenuItemView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ActionBarContainer actionBarContainer(@NotNull ViewManager viewManager, @NotNull Function1<? super _ActionBarContainer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_container = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_container.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarContainer themedActionBarContainer$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_container = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_container.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarContainer themedActionBarContainer$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_container = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_container.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer themedActionBarContainer(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _ActionBarContainer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_container = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_container.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer actionBarContainer(@NotNull Context context, @NotNull Function1<? super _ActionBarContainer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarContainer themedActionBarContainer$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarContainer themedActionBarContainer$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer themedActionBarContainer(@NotNull Context context, int i, @NotNull Function1<? super _ActionBarContainer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer actionBarContainer(@NotNull Activity activity, @NotNull Function1<? super _ActionBarContainer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarContainer themedActionBarContainer$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarContainer themedActionBarContainer$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer themedActionBarContainer(@NotNull Activity activity, int i, @NotNull Function1<? super _ActionBarContainer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ActionBarContainer) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout actionBarOverlayLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super _ActionBarOverlayLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_overlay_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_overlay_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarOverlayLayout themedActionBarOverlayLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_overlay_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_overlay_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarOverlayLayout themedActionBarOverlayLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_overlay_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_overlay_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout themedActionBarOverlayLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _ActionBarOverlayLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_bar_overlay_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_overlay_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout actionBarOverlayLayout(@NotNull Context context, @NotNull Function1<? super _ActionBarOverlayLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarOverlayLayout themedActionBarOverlayLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarOverlayLayout themedActionBarOverlayLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout themedActionBarOverlayLayout(@NotNull Context context, int i, @NotNull Function1<? super _ActionBarOverlayLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout actionBarOverlayLayout(@NotNull Activity activity, @NotNull Function1<? super _ActionBarOverlayLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarOverlayLayout themedActionBarOverlayLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static /* synthetic */ ActionBarOverlayLayout themedActionBarOverlayLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout themedActionBarOverlayLayout(@NotNull Activity activity, int i, @NotNull Function1<? super _ActionBarOverlayLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ActionBarOverlayLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionMenuView actionMenuView(@NotNull ViewManager viewManager, @NotNull Function1<? super _ActionMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_menu_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static /* synthetic */ ActionMenuView themedActionMenuView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_menu_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static /* synthetic */ ActionMenuView themedActionMenuView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_menu_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView themedActionMenuView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _ActionMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 action_menu_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView actionMenuView(@NotNull Context context, @NotNull Function1<? super _ActionMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static /* synthetic */ ActionMenuView themedActionMenuView$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static /* synthetic */ ActionMenuView themedActionMenuView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView themedActionMenuView(@NotNull Context context, int i, @NotNull Function1<? super _ActionMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView actionMenuView(@NotNull Activity activity, @NotNull Function1<? super _ActionMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static /* synthetic */ ActionMenuView themedActionMenuView$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static /* synthetic */ ActionMenuView themedActionMenuView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView themedActionMenuView(@NotNull Activity activity, int i, @NotNull Function1<? super _ActionMenuView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ActionMenuView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final AlertDialogLayout alertDialogLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super _AlertDialogLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 alert_dialog_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) alert_dialog_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static /* synthetic */ AlertDialogLayout themedAlertDialogLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 alert_dialog_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) alert_dialog_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static /* synthetic */ AlertDialogLayout themedAlertDialogLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 alert_dialog_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) alert_dialog_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout themedAlertDialogLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _AlertDialogLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 alert_dialog_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) alert_dialog_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout alertDialogLayout(@NotNull Context context, @NotNull Function1<? super _AlertDialogLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static /* synthetic */ AlertDialogLayout themedAlertDialogLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static /* synthetic */ AlertDialogLayout themedAlertDialogLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout themedAlertDialogLayout(@NotNull Context context, int i, @NotNull Function1<? super _AlertDialogLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout alertDialogLayout(@NotNull Activity activity, @NotNull Function1<? super _AlertDialogLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static /* synthetic */ AlertDialogLayout themedAlertDialogLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static /* synthetic */ AlertDialogLayout themedAlertDialogLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout themedAlertDialogLayout(@NotNull Activity activity, int i, @NotNull Function1<? super _AlertDialogLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_AlertDialogLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout buttonBarLayout(@NotNull ViewManager viewManager, @NotNull Function1<? super _ButtonBarLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 button_bar_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) button_bar_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static /* synthetic */ ButtonBarLayout themedButtonBarLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 button_bar_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) button_bar_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static /* synthetic */ ButtonBarLayout themedButtonBarLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 button_bar_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) button_bar_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout themedButtonBarLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _ButtonBarLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 button_bar_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) button_bar_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout buttonBarLayout(@NotNull Context context, @NotNull Function1<? super _ButtonBarLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static /* synthetic */ ButtonBarLayout themedButtonBarLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static /* synthetic */ ButtonBarLayout themedButtonBarLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout themedButtonBarLayout(@NotNull Context context, int i, @NotNull Function1<? super _ButtonBarLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout buttonBarLayout(@NotNull Activity activity, @NotNull Function1<? super _ButtonBarLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static /* synthetic */ ButtonBarLayout themedButtonBarLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static /* synthetic */ ButtonBarLayout themedButtonBarLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout themedButtonBarLayout(@NotNull Activity activity, int i, @NotNull Function1<? super _ButtonBarLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ButtonBarLayout) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final LinearLayoutCompat linearLayoutCompat(@NotNull ViewManager viewManager, @NotNull Function1<? super _LinearLayoutCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 linear_layout_compat = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) linear_layout_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayoutCompat themedLinearLayoutCompat$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 linear_layout_compat = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) linear_layout_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayoutCompat themedLinearLayoutCompat$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 linear_layout_compat = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) linear_layout_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat themedLinearLayoutCompat(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _LinearLayoutCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 linear_layout_compat = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) linear_layout_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat linearLayoutCompat(@NotNull Context context, @NotNull Function1<? super _LinearLayoutCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayoutCompat themedLinearLayoutCompat$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayoutCompat themedLinearLayoutCompat$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat themedLinearLayoutCompat(@NotNull Context context, int i, @NotNull Function1<? super _LinearLayoutCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat linearLayoutCompat(@NotNull Activity activity, @NotNull Function1<? super _LinearLayoutCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayoutCompat themedLinearLayoutCompat$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayoutCompat themedLinearLayoutCompat$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat themedLinearLayoutCompat(@NotNull Activity activity, int i, @NotNull Function1<? super _LinearLayoutCompat, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_LinearLayoutCompat) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final ScrollingTabContainerView scrollingTabContainerView(@NotNull ViewManager viewManager, @NotNull Function1<? super _ScrollingTabContainerView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 scrolling_tab_container_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) scrolling_tab_container_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static /* synthetic */ ScrollingTabContainerView themedScrollingTabContainerView$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 scrolling_tab_container_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) scrolling_tab_container_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static /* synthetic */ ScrollingTabContainerView themedScrollingTabContainerView$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 scrolling_tab_container_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) scrolling_tab_container_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView themedScrollingTabContainerView(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _ScrollingTabContainerView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 scrolling_tab_container_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) scrolling_tab_container_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView scrollingTabContainerView(@NotNull Context context, @NotNull Function1<? super _ScrollingTabContainerView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static /* synthetic */ ScrollingTabContainerView themedScrollingTabContainerView$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static /* synthetic */ ScrollingTabContainerView themedScrollingTabContainerView$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView themedScrollingTabContainerView(@NotNull Context context, int i, @NotNull Function1<? super _ScrollingTabContainerView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView scrollingTabContainerView(@NotNull Activity activity, @NotNull Function1<? super _ScrollingTabContainerView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static /* synthetic */ ScrollingTabContainerView themedScrollingTabContainerView$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static /* synthetic */ ScrollingTabContainerView themedScrollingTabContainerView$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView themedScrollingTabContainerView(@NotNull Activity activity, int i, @NotNull Function1<? super _ScrollingTabContainerView, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_ScrollingTabContainerView) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final Toolbar toolbar(@NotNull ViewManager viewManager, @NotNull Function1<? super _Toolbar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 toolbar = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) toolbar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (Toolbar) view;
    }

    @NotNull
    public static /* synthetic */ Toolbar themedToolbar$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 toolbar = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) toolbar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (Toolbar) view;
    }

    @NotNull
    public static /* synthetic */ Toolbar themedToolbar$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 toolbar = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) toolbar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar themedToolbar(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _Toolbar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 toolbar = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) toolbar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar toolbar(@NotNull Context context, @NotNull Function1<? super _Toolbar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (Toolbar) view;
    }

    @NotNull
    public static /* synthetic */ Toolbar themedToolbar$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (Toolbar) view;
    }

    @NotNull
    public static /* synthetic */ Toolbar themedToolbar$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar themedToolbar(@NotNull Context context, int i, @NotNull Function1<? super _Toolbar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar toolbar(@NotNull Activity activity, @NotNull Function1<? super _Toolbar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (Toolbar) view;
    }

    @NotNull
    public static /* synthetic */ Toolbar themedToolbar$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (Toolbar) view;
    }

    @NotNull
    public static /* synthetic */ Toolbar themedToolbar$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar themedToolbar(@NotNull Activity activity, int i, @NotNull Function1<? super _Toolbar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke((_Toolbar) view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final ActionMenuItemView actionMenuItemView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_menu_item_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionMenuItemView;
    }

    @NotNull
    public static final ActionMenuItemView themedActionMenuItemView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_menu_item_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionMenuItemView;
    }

    @NotNull
    public static final ExpandedMenuView expandedMenuView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 expanded_menu_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) expanded_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView themedExpandedMenuView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 expanded_menu_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) expanded_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView expandedMenuView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView themedExpandedMenuView(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView expandedMenuView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ExpandedMenuView themedExpandedMenuView(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getEXPANDED_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ExpandedMenuView expandedMenuView = (ExpandedMenuView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return expandedMenuView;
    }

    @NotNull
    public static final ActionBarContextView actionBarContextView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_context_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_context_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView themedActionBarContextView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_context_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_context_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView actionBarContextView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView themedActionBarContextView(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView actionBarContextView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActionBarContextView themedActionBarContextView(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTION_BAR_CONTEXT_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ActionBarContextView actionBarContextView = (ActionBarContextView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return actionBarContextView;
    }

    @NotNull
    public static final ActivityChooserView activityChooserView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 activity_chooser_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) activity_chooser_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView themedActivityChooserView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 activity_chooser_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) activity_chooser_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView activityChooserView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView themedActivityChooserView(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView activityChooserView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return activityChooserView;
    }

    @NotNull
    public static final ActivityChooserView themedActivityChooserView(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getACTIVITY_CHOOSER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ActivityChooserView activityChooserView = (ActivityChooserView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return activityChooserView;
    }

    @NotNull
    public static final AutoCompleteTextView tintedAutoCompleteTextView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return autoCompleteTextView;
    }

    @NotNull
    public static final AutoCompleteTextView themedTintedAutoCompleteTextView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return autoCompleteTextView;
    }

    @NotNull
    public static final Button tintedButton(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Button button = (Button) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final Button themedTintedButton(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Button button = (Button) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return button;
    }

    @NotNull
    public static final CheckBox tintedCheckBox(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckBox checkBox = (CheckBox) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckBox themedTintedCheckBox(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_check_box = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECK_BOX();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_check_box.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckBox checkBox = (CheckBox) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkBox;
    }

    @NotNull
    public static final CheckedTextView tintedCheckedTextView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_checked_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECKED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_checked_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        CheckedTextView checkedTextView = (CheckedTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkedTextView;
    }

    @NotNull
    public static final CheckedTextView themedTintedCheckedTextView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_checked_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_CHECKED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_checked_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        CheckedTextView checkedTextView = (CheckedTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return checkedTextView;
    }

    @NotNull
    public static final EditText tintedEditText(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final EditText themedTintedEditText(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_edit_text = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_EDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return editText;
    }

    @NotNull
    public static final ImageButton tintedImageButton(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageButton imageButton = (ImageButton) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageButton themedTintedImageButton(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageButton imageButton = (ImageButton) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageButton;
    }

    @NotNull
    public static final ImageView tintedImageView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ImageView imageView = (ImageView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final ImageView themedTintedImageView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_image_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_IMAGE_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_image_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ImageView imageView = (ImageView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return imageView;
    }

    @NotNull
    public static final MultiAutoCompleteTextView tintedMultiAutoCompleteTextView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_multi_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_multi_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return multiAutoCompleteTextView;
    }

    @NotNull
    public static final MultiAutoCompleteTextView themedTintedMultiAutoCompleteTextView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_multi_auto_complete_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_multi_auto_complete_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return multiAutoCompleteTextView;
    }

    @NotNull
    public static final RadioButton tintedRadioButton(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_radio_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RADIO_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_radio_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        RadioButton radioButton = (RadioButton) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return radioButton;
    }

    @NotNull
    public static final RadioButton themedTintedRadioButton(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_radio_button = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RADIO_BUTTON();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_radio_button.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        RadioButton radioButton = (RadioButton) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return radioButton;
    }

    @NotNull
    public static final RatingBar tintedRatingBar(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_rating_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RATING_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_rating_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        RatingBar ratingBar = (RatingBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return ratingBar;
    }

    @NotNull
    public static final RatingBar themedTintedRatingBar(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_rating_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_RATING_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_rating_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        RatingBar ratingBar = (RatingBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return ratingBar;
    }

    @NotNull
    public static final SeekBar tintedSeekBar(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_seek_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SEEK_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_seek_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        SeekBar seekBar = (SeekBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return seekBar;
    }

    @NotNull
    public static final SeekBar themedTintedSeekBar(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_seek_bar = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SEEK_BAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_seek_bar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SeekBar seekBar = (SeekBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return seekBar;
    }

    @NotNull
    public static final Spinner tintedSpinner(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_spinner = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_spinner.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return spinner;
    }

    @NotNull
    public static final Spinner themedTintedSpinner(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_spinner = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_spinner.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return spinner;
    }

    @NotNull
    public static final Spinner tintedSpinner(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return spinner;
    }

    @NotNull
    public static final Spinner themedTintedSpinner(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return spinner;
    }

    @NotNull
    public static final Spinner tintedSpinner(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return spinner;
    }

    @NotNull
    public static final Spinner themedTintedSpinner(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_SPINNER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        Spinner spinner = (Spinner) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return spinner;
    }

    @NotNull
    public static final TextView tintedTextView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        TextView textView = (TextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final TextView themedTintedTextView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 tinted_text_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getTINTED_TEXT_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) tinted_text_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        TextView textView = (TextView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return textView;
    }

    @NotNull
    public static final ContentFrameLayout contentFrameLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 content_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout themedContentFrameLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 content_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) content_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout contentFrameLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout themedContentFrameLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout contentFrameLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final ContentFrameLayout themedContentFrameLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getCONTENT_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return contentFrameLayout;
    }

    @NotNull
    public static final DialogTitle dialogTitle(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 dialog_title = C$$Anko$Factories$AppcompatV7View.INSTANCE.getDIALOG_TITLE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) dialog_title.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        DialogTitle dialogTitle = (DialogTitle) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return dialogTitle;
    }

    @NotNull
    public static final DialogTitle themedDialogTitle(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 dialog_title = C$$Anko$Factories$AppcompatV7View.INSTANCE.getDIALOG_TITLE();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) dialog_title.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        DialogTitle dialogTitle = (DialogTitle) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return dialogTitle;
    }

    @NotNull
    public static final FitWindowsFrameLayout fitWindowsFrameLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fit_windows_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout themedFitWindowsFrameLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fit_windows_frame_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_frame_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout fitWindowsFrameLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout themedFitWindowsFrameLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout fitWindowsFrameLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsFrameLayout themedFitWindowsFrameLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_FRAME_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        FitWindowsFrameLayout fitWindowsFrameLayout = (FitWindowsFrameLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsFrameLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout fitWindowsLinearLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fit_windows_linear_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_linear_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout themedFitWindowsLinearLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 fit_windows_linear_layout = C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) fit_windows_linear_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout fitWindowsLinearLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout themedFitWindowsLinearLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout fitWindowsLinearLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final FitWindowsLinearLayout themedFitWindowsLinearLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getFIT_WINDOWS_LINEAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        FitWindowsLinearLayout fitWindowsLinearLayout = (FitWindowsLinearLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return fitWindowsLinearLayout;
    }

    @NotNull
    public static final SearchView searchView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 search_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) search_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return searchView;
    }

    @NotNull
    public static final SearchView themedSearchView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 search_view = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) search_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return searchView;
    }

    @NotNull
    public static final SearchView searchView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return searchView;
    }

    @NotNull
    public static final SearchView themedSearchView(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return searchView;
    }

    @NotNull
    public static final SearchView searchView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return searchView;
    }

    @NotNull
    public static final SearchView themedSearchView(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7View.INSTANCE.getSEARCH_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        SearchView searchView = (SearchView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return searchView;
    }

    @NotNull
    public static final SwitchCompat switchCompat(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 switch_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSWITCH_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) switch_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        SwitchCompat switchCompat = (SwitchCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return switchCompat;
    }

    @NotNull
    public static final SwitchCompat themedSwitchCompat(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 switch_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getSWITCH_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) switch_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        SwitchCompat switchCompat = (SwitchCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return switchCompat;
    }

    @NotNull
    public static final ViewStubCompat viewStubCompat(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 view_stub_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getVIEW_STUB_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_stub_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        ViewStubCompat viewStubCompat = (ViewStubCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return viewStubCompat;
    }

    @NotNull
    public static final ViewStubCompat themedViewStubCompat(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 view_stub_compat = C$$Anko$Factories$AppcompatV7View.INSTANCE.getVIEW_STUB_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) view_stub_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ViewStubCompat viewStubCompat = (ViewStubCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return viewStubCompat;
    }

    @NotNull
    public static final ListMenuItemView listMenuItemView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 list_menu_item_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) list_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView themedListMenuItemView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 list_menu_item_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) list_menu_item_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView listMenuItemView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView themedListMenuItemView(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView listMenuItemView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ListMenuItemView themedListMenuItemView(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLIST_MENU_ITEM_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ListMenuItemView _listmenuitemview = (_ListMenuItemView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ListMenuItemView) view;
    }

    @NotNull
    public static final ActionBarContainer actionBarContainer(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_container = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_container.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer themedActionBarContainer(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_container = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_container.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer actionBarContainer(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer themedActionBarContainer(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer actionBarContainer(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarContainer themedActionBarContainer(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_CONTAINER().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ActionBarContainer _actionbarcontainer = (_ActionBarContainer) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarContainer) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout actionBarOverlayLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_overlay_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_overlay_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout themedActionBarOverlayLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_bar_overlay_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_bar_overlay_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout actionBarOverlayLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout themedActionBarOverlayLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout actionBarOverlayLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionBarOverlayLayout themedActionBarOverlayLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_BAR_OVERLAY_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ActionBarOverlayLayout _actionbaroverlaylayout = (_ActionBarOverlayLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionBarOverlayLayout) view;
    }

    @NotNull
    public static final ActionMenuView actionMenuView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_menu_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView themedActionMenuView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 action_menu_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) action_menu_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView actionMenuView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView themedActionMenuView(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView actionMenuView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final ActionMenuView themedActionMenuView(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getACTION_MENU_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ActionMenuView _actionmenuview = (_ActionMenuView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ActionMenuView) view;
    }

    @NotNull
    public static final AlertDialogLayout alertDialogLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 alert_dialog_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) alert_dialog_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout themedAlertDialogLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 alert_dialog_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) alert_dialog_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout alertDialogLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout themedAlertDialogLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout alertDialogLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final AlertDialogLayout themedAlertDialogLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getALERT_DIALOG_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _AlertDialogLayout _alertdialoglayout = (_AlertDialogLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (AlertDialogLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout buttonBarLayout(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 button_bar_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) button_bar_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout themedButtonBarLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 button_bar_layout = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) button_bar_layout.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout buttonBarLayout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout themedButtonBarLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout buttonBarLayout(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final ButtonBarLayout themedButtonBarLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getBUTTON_BAR_LAYOUT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ButtonBarLayout _buttonbarlayout = (_ButtonBarLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ButtonBarLayout) view;
    }

    @NotNull
    public static final LinearLayoutCompat linearLayoutCompat(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 linear_layout_compat = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) linear_layout_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat themedLinearLayoutCompat(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 linear_layout_compat = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) linear_layout_compat.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat linearLayoutCompat(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat themedLinearLayoutCompat(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat linearLayoutCompat(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final LinearLayoutCompat themedLinearLayoutCompat(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getLINEAR_LAYOUT_COMPAT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _LinearLayoutCompat _linearlayoutcompat = (_LinearLayoutCompat) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayoutCompat) view;
    }

    @NotNull
    public static final ScrollingTabContainerView scrollingTabContainerView(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 scrolling_tab_container_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) scrolling_tab_container_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView themedScrollingTabContainerView(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 scrolling_tab_container_view = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) scrolling_tab_container_view.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView scrollingTabContainerView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView themedScrollingTabContainerView(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView scrollingTabContainerView(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final ScrollingTabContainerView themedScrollingTabContainerView(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getSCROLLING_TAB_CONTAINER_VIEW().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _ScrollingTabContainerView _scrollingtabcontainerview = (_ScrollingTabContainerView) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ScrollingTabContainerView) view;
    }

    @NotNull
    public static final Toolbar toolbar(@NotNull ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 toolbar = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) toolbar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar themedToolbar(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 toolbar = C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) toolbar.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar toolbar(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar themedToolbar(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar toolbar(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (Toolbar) view;
    }

    @NotNull
    public static final Toolbar themedToolbar(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$AppcompatV7ViewGroup.INSTANCE.getTOOLBAR().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _Toolbar _toolbar = (_Toolbar) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (Toolbar) view;
    }
}
