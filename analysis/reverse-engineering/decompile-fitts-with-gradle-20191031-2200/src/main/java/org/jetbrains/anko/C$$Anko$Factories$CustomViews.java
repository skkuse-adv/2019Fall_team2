package org.jetbrains.anko;

import android.content.Context;
import android.widget.EditText;
import android.widget.ProgressBar;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* renamed from: org.jetbrains.anko.$$Anko$Factories$CustomViews reason: invalid class name */
public final class C$$Anko$Factories$CustomViews {
    @NotNull
    private static final Function1<Context, EditText> EDIT_TEXT = C$$Anko$Factories$CustomViews$EDIT_TEXT$1.INSTANCE;
    @NotNull
    private static final Function1<Context, ProgressBar> HORIZONTAL_PROGRESS_BAR_FACTORY = C$$Anko$Factories$CustomViews$HORIZONTAL_PROGRESS_BAR_FACTORY$1.INSTANCE;
    public static final C$$Anko$Factories$CustomViews INSTANCE = new C$$Anko$Factories$CustomViews();
    @NotNull
    private static final Function1<Context, _LinearLayout> VERTICAL_LAYOUT_FACTORY = C$$Anko$Factories$CustomViews$VERTICAL_LAYOUT_FACTORY$1.INSTANCE;

    private C$$Anko$Factories$CustomViews() {
    }

    @NotNull
    public final Function1<Context, _LinearLayout> getVERTICAL_LAYOUT_FACTORY() {
        return VERTICAL_LAYOUT_FACTORY;
    }

    @NotNull
    public final Function1<Context, EditText> getEDIT_TEXT() {
        return EDIT_TEXT;
    }

    @NotNull
    public final Function1<Context, ProgressBar> getHORIZONTAL_PROGRESS_BAR_FACTORY() {
        return HORIZONTAL_PROGRESS_BAR_FACTORY;
    }
}
