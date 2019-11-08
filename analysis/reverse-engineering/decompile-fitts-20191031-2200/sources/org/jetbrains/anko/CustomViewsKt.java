package org.jetbrains.anko;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class CustomViewsKt {
    @NotNull
    public static /* synthetic */ LinearLayout verticalLayout$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 vertical_layout_factory = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) vertical_layout_factory.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _LinearLayout _linearlayout = (_LinearLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayout verticalLayout$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 vertical_layout_factory = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) vertical_layout_factory.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static final LinearLayout verticalLayout(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super _LinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 vertical_layout_factory = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) vertical_layout_factory.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayout verticalLayout$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _LinearLayout _linearlayout = (_LinearLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayout verticalLayout$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static final LinearLayout verticalLayout(@NotNull Context context, int i, @NotNull Function1<? super _LinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayout verticalLayout$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _LinearLayout _linearlayout = (_LinearLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static /* synthetic */ LinearLayout verticalLayout$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static final LinearLayout verticalLayout(@NotNull Activity activity, int i, @NotNull Function1<? super _LinearLayout, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static /* synthetic */ EditText editText$default(ViewManager viewManager, InputConstraints inputConstraints, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Function1 edit_text = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static /* synthetic */ EditText editText$default(ViewManager viewManager, InputConstraints inputConstraints, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 edit_text = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        EditText editText = (EditText) view;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static final EditText editText(@NotNull ViewManager viewManager, @NotNull InputConstraints inputConstraints, int i, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 edit_text = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        EditText editText = (EditText) view;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static /* synthetic */ EditText editText$default(Context context, InputConstraints inputConstraints, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(context, view);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static /* synthetic */ EditText editText$default(Context context, InputConstraints inputConstraints, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(context, view);
        EditText editText = (EditText) view;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static final EditText editText(@NotNull Context context, @NotNull InputConstraints inputConstraints, int i, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(context, view);
        EditText editText = (EditText) view;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static /* synthetic */ EditText editText$default(Activity activity, InputConstraints inputConstraints, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static /* synthetic */ EditText editText$default(Activity activity, InputConstraints inputConstraints, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(activity, view);
        EditText editText = (EditText) view;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static final EditText editText(@NotNull Activity activity, @NotNull InputConstraints inputConstraints, int i, @NotNull Function1<? super EditText, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(activity, view);
        EditText editText = (EditText) view;
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static /* synthetic */ ProgressBar horizontalProgressBar$default(ViewManager viewManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 horizontal_progress_bar_factory = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) horizontal_progress_bar_factory.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ProgressBar progressBar = (ProgressBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return progressBar;
    }

    @NotNull
    public static /* synthetic */ ProgressBar horizontalProgressBar$default(ViewManager viewManager, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 horizontal_progress_bar_factory = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) horizontal_progress_bar_factory.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ProgressBar) view;
    }

    @NotNull
    public static final ProgressBar horizontalProgressBar(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super ProgressBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Function1 horizontal_progress_bar_factory = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) horizontal_progress_bar_factory.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (ProgressBar) view;
    }

    @NotNull
    public static /* synthetic */ ProgressBar horizontalProgressBar$default(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ProgressBar progressBar = (ProgressBar) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return progressBar;
    }

    @NotNull
    public static /* synthetic */ ProgressBar horizontalProgressBar$default(Context context, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ProgressBar) view;
    }

    @NotNull
    public static final ProgressBar horizontalProgressBar(@NotNull Context context, int i, @NotNull Function1<? super ProgressBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(context, view);
        return (ProgressBar) view;
    }

    @NotNull
    public static /* synthetic */ ProgressBar horizontalProgressBar$default(Activity activity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ProgressBar progressBar = (ProgressBar) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return progressBar;
    }

    @NotNull
    public static /* synthetic */ ProgressBar horizontalProgressBar$default(Activity activity, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ProgressBar) view;
    }

    @NotNull
    public static final ProgressBar horizontalProgressBar(@NotNull Activity activity, int i, @NotNull Function1<? super ProgressBar, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        function1.invoke(view);
        AnkoInternals.INSTANCE.addView(activity, view);
        return (ProgressBar) view;
    }

    @NotNull
    public static final LinearLayout verticalLayout(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 vertical_layout_factory = C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) vertical_layout_factory.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        _LinearLayout _linearlayout = (_LinearLayout) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static final LinearLayout verticalLayout(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        _LinearLayout _linearlayout = (_LinearLayout) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static final LinearLayout verticalLayout(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getVERTICAL_LAYOUT_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        _LinearLayout _linearlayout = (_LinearLayout) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return (LinearLayout) view;
    }

    @NotNull
    public static final EditText editText(@NotNull ViewManager viewManager, @NotNull InputConstraints inputConstraints, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        Function1 edit_text = C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) edit_text.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static final EditText editText(@NotNull Context context, @NotNull InputConstraints inputConstraints, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(context, view);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static final EditText editText(@NotNull Activity activity, @NotNull InputConstraints inputConstraints, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(inputConstraints, "constraints");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getEDIT_TEXT().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        EditText editText = (EditText) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        editText.setInputType(inputConstraints.getValue());
        return editText;
    }

    @NotNull
    public static final ProgressBar horizontalProgressBar(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Function1 horizontal_progress_bar_factory = C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY();
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        View view = (View) horizontal_progress_bar_factory.invoke(ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), i));
        ProgressBar progressBar = (ProgressBar) view;
        AnkoInternals.INSTANCE.addView(viewManager, view);
        return progressBar;
    }

    @NotNull
    public static final ProgressBar horizontalProgressBar(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(context, i));
        ProgressBar progressBar = (ProgressBar) view;
        AnkoInternals.INSTANCE.addView(context, view);
        return progressBar;
    }

    @NotNull
    public static final ProgressBar horizontalProgressBar(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        View view = (View) C$$Anko$Factories$CustomViews.INSTANCE.getHORIZONTAL_PROGRESS_BAR_FACTORY().invoke(AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, i));
        ProgressBar progressBar = (ProgressBar) view;
        AnkoInternals.INSTANCE.addView(activity, view);
        return progressBar;
    }

    @NotNull
    public static final <T extends View> T include(@NotNull ViewManager viewManager, int i) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        Object systemService = ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T inflate = ((LayoutInflater) systemService).inflate(i, null);
            if (inflate != null) {
                AnkoInternals.INSTANCE.addView(viewManager, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public static final <T extends View> T include(@NotNull ViewManager viewManager, int i, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewManager, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        Object systemService = ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewManager), 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T inflate = ((LayoutInflater) systemService).inflate(i, null);
            if (inflate != null) {
                function1.invoke(inflate);
                AnkoInternals.INSTANCE.addView(viewManager, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public static final <T extends View> T include(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "receiver$0");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        Object systemService = ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewGroup), 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T inflate = ((LayoutInflater) systemService).inflate(i, viewGroup, false);
            if (inflate != null) {
                AnkoInternals.INSTANCE.addView((ViewManager) viewGroup, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public static final <T extends View> T include(@NotNull ViewGroup viewGroup, int i, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoInternals ankoInternals = AnkoInternals.INSTANCE;
        Object systemService = ankoInternals.wrapContextIfNeeded(ankoInternals.getContext(viewGroup), 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T inflate = ((LayoutInflater) systemService).inflate(i, viewGroup, false);
            if (inflate != null) {
                function1.invoke(inflate);
                AnkoInternals.INSTANCE.addView((ViewManager) viewGroup, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public static final <T extends View> T include(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T inflate = ((LayoutInflater) systemService).inflate(i, null);
            if (inflate != null) {
                AnkoInternals.INSTANCE.addView(context, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public static final <T extends View> T include(@NotNull Context context, int i, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(context, 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T inflate = ((LayoutInflater) systemService).inflate(i, null);
            if (inflate != null) {
                function1.invoke(inflate);
                AnkoInternals.INSTANCE.addView(context, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public static final <T extends View> T include(@NotNull Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T inflate = ((LayoutInflater) systemService).inflate(i, null);
            if (inflate != null) {
                AnkoInternals.INSTANCE.addView(activity, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public static final <T extends View> T include(@NotNull Activity activity, int i, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        Object systemService = AnkoInternals.INSTANCE.wrapContextIfNeeded(activity, 0).getSystemService("layout_inflater");
        if (systemService != null) {
            T inflate = ((LayoutInflater) systemService).inflate(i, null);
            if (inflate != null) {
                function1.invoke(inflate);
                AnkoInternals.INSTANCE.addView(activity, inflate);
                return inflate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
