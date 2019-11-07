package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
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
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DialogTitle;
import androidx.appcompat.widget.FitWindowsFrameLayout;
import androidx.appcompat.widget.FitWindowsLinearLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.ViewStubCompat;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.appcompat.v7.$$Anko$Factories$AppcompatV7View reason: invalid class name */
public final class C$$Anko$Factories$AppcompatV7View {
    @NotNull
    private static final Function1<Context, ActionBarContextView> ACTION_BAR_CONTEXT_VIEW = C$$Anko$Factories$AppcompatV7View$ACTION_BAR_CONTEXT_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, ActionMenuItemView> ACTION_MENU_ITEM_VIEW = C$$Anko$Factories$AppcompatV7View$ACTION_MENU_ITEM_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, ActivityChooserView> ACTIVITY_CHOOSER_VIEW = C$$Anko$Factories$AppcompatV7View$ACTIVITY_CHOOSER_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, ContentFrameLayout> CONTENT_FRAME_LAYOUT = C$$Anko$Factories$AppcompatV7View$CONTENT_FRAME_LAYOUT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, DialogTitle> DIALOG_TITLE = C$$Anko$Factories$AppcompatV7View$DIALOG_TITLE$1.INSTANCE;
    @NotNull
    private static final Function1<Context, ExpandedMenuView> EXPANDED_MENU_VIEW = C$$Anko$Factories$AppcompatV7View$EXPANDED_MENU_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, FitWindowsFrameLayout> FIT_WINDOWS_FRAME_LAYOUT = C$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_FRAME_LAYOUT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, FitWindowsLinearLayout> FIT_WINDOWS_LINEAR_LAYOUT = C$$Anko$Factories$AppcompatV7View$FIT_WINDOWS_LINEAR_LAYOUT$1.INSTANCE;
    public static final C$$Anko$Factories$AppcompatV7View INSTANCE = new C$$Anko$Factories$AppcompatV7View();
    @NotNull
    private static final Function1<Context, SearchView> SEARCH_VIEW = C$$Anko$Factories$AppcompatV7View$SEARCH_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, SwitchCompat> SWITCH_COMPAT = C$$Anko$Factories$AppcompatV7View$SWITCH_COMPAT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, AutoCompleteTextView> TINTED_AUTO_COMPLETE_TEXT_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_AUTO_COMPLETE_TEXT_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, Button> TINTED_BUTTON = C$$Anko$Factories$AppcompatV7View$TINTED_BUTTON$1.INSTANCE;
    @NotNull
    private static final Function1<Context, CheckedTextView> TINTED_CHECKED_TEXT_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_CHECKED_TEXT_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, CheckBox> TINTED_CHECK_BOX = C$$Anko$Factories$AppcompatV7View$TINTED_CHECK_BOX$1.INSTANCE;
    @NotNull
    private static final Function1<Context, EditText> TINTED_EDIT_TEXT = C$$Anko$Factories$AppcompatV7View$TINTED_EDIT_TEXT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, ImageButton> TINTED_IMAGE_BUTTON = C$$Anko$Factories$AppcompatV7View$TINTED_IMAGE_BUTTON$1.INSTANCE;
    @NotNull
    private static final Function1<Context, ImageView> TINTED_IMAGE_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_IMAGE_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, MultiAutoCompleteTextView> TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, RadioButton> TINTED_RADIO_BUTTON = C$$Anko$Factories$AppcompatV7View$TINTED_RADIO_BUTTON$1.INSTANCE;
    @NotNull
    private static final Function1<Context, RatingBar> TINTED_RATING_BAR = C$$Anko$Factories$AppcompatV7View$TINTED_RATING_BAR$1.INSTANCE;
    @NotNull
    private static final Function1<Context, SeekBar> TINTED_SEEK_BAR = C$$Anko$Factories$AppcompatV7View$TINTED_SEEK_BAR$1.INSTANCE;
    @NotNull
    private static final Function1<Context, Spinner> TINTED_SPINNER = C$$Anko$Factories$AppcompatV7View$TINTED_SPINNER$1.INSTANCE;
    @NotNull
    private static final Function1<Context, TextView> TINTED_TEXT_VIEW = C$$Anko$Factories$AppcompatV7View$TINTED_TEXT_VIEW$1.INSTANCE;
    @NotNull
    private static final Function1<Context, ViewStubCompat> VIEW_STUB_COMPAT = C$$Anko$Factories$AppcompatV7View$VIEW_STUB_COMPAT$1.INSTANCE;

    private C$$Anko$Factories$AppcompatV7View() {
    }

    @NotNull
    public final Function1<Context, ActionMenuItemView> getACTION_MENU_ITEM_VIEW() {
        return ACTION_MENU_ITEM_VIEW;
    }

    @NotNull
    public final Function1<Context, ExpandedMenuView> getEXPANDED_MENU_VIEW() {
        return EXPANDED_MENU_VIEW;
    }

    @NotNull
    public final Function1<Context, ActionBarContextView> getACTION_BAR_CONTEXT_VIEW() {
        return ACTION_BAR_CONTEXT_VIEW;
    }

    @NotNull
    public final Function1<Context, ActivityChooserView> getACTIVITY_CHOOSER_VIEW() {
        return ACTIVITY_CHOOSER_VIEW;
    }

    @NotNull
    public final Function1<Context, AutoCompleteTextView> getTINTED_AUTO_COMPLETE_TEXT_VIEW() {
        return TINTED_AUTO_COMPLETE_TEXT_VIEW;
    }

    @NotNull
    public final Function1<Context, Button> getTINTED_BUTTON() {
        return TINTED_BUTTON;
    }

    @NotNull
    public final Function1<Context, CheckBox> getTINTED_CHECK_BOX() {
        return TINTED_CHECK_BOX;
    }

    @NotNull
    public final Function1<Context, CheckedTextView> getTINTED_CHECKED_TEXT_VIEW() {
        return TINTED_CHECKED_TEXT_VIEW;
    }

    @NotNull
    public final Function1<Context, EditText> getTINTED_EDIT_TEXT() {
        return TINTED_EDIT_TEXT;
    }

    @NotNull
    public final Function1<Context, ImageButton> getTINTED_IMAGE_BUTTON() {
        return TINTED_IMAGE_BUTTON;
    }

    @NotNull
    public final Function1<Context, ImageView> getTINTED_IMAGE_VIEW() {
        return TINTED_IMAGE_VIEW;
    }

    @NotNull
    public final Function1<Context, MultiAutoCompleteTextView> getTINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW() {
        return TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW;
    }

    @NotNull
    public final Function1<Context, RadioButton> getTINTED_RADIO_BUTTON() {
        return TINTED_RADIO_BUTTON;
    }

    @NotNull
    public final Function1<Context, RatingBar> getTINTED_RATING_BAR() {
        return TINTED_RATING_BAR;
    }

    @NotNull
    public final Function1<Context, SeekBar> getTINTED_SEEK_BAR() {
        return TINTED_SEEK_BAR;
    }

    @NotNull
    public final Function1<Context, Spinner> getTINTED_SPINNER() {
        return TINTED_SPINNER;
    }

    @NotNull
    public final Function1<Context, TextView> getTINTED_TEXT_VIEW() {
        return TINTED_TEXT_VIEW;
    }

    @NotNull
    public final Function1<Context, ContentFrameLayout> getCONTENT_FRAME_LAYOUT() {
        return CONTENT_FRAME_LAYOUT;
    }

    @NotNull
    public final Function1<Context, DialogTitle> getDIALOG_TITLE() {
        return DIALOG_TITLE;
    }

    @NotNull
    public final Function1<Context, FitWindowsFrameLayout> getFIT_WINDOWS_FRAME_LAYOUT() {
        return FIT_WINDOWS_FRAME_LAYOUT;
    }

    @NotNull
    public final Function1<Context, FitWindowsLinearLayout> getFIT_WINDOWS_LINEAR_LAYOUT() {
        return FIT_WINDOWS_LINEAR_LAYOUT;
    }

    @NotNull
    public final Function1<Context, SearchView> getSEARCH_VIEW() {
        return SEARCH_VIEW;
    }

    @NotNull
    public final Function1<Context, SwitchCompat> getSWITCH_COMPAT() {
        return SWITCH_COMPAT;
    }

    @NotNull
    public final Function1<Context, ViewStubCompat> getVIEW_STUB_COMPAT() {
        return VIEW_STUB_COMPAT;
    }
}
