package org.jetbrains.anko.sdk27.coroutines;

import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.media.MediaPlayer;
import android.media.tv.TvView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.DragEvent;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.widget.AbsListView;
import android.widget.ActionMenuView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toolbar;
import android.widget.VideoView;
import android.widget.ZoomControls;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

public final class Sdk27CoroutinesListenersWithCoroutinesKt {
    public static /* synthetic */ void onLayoutChange$default(View view, CoroutineContext coroutineContext, Function11 function11, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onLayoutChange(view, coroutineContext, function11);
    }

    public static final void onLayoutChange(@NotNull View view, @NotNull CoroutineContext coroutineContext, @NotNull Function11<? super CoroutineScope, ? super View, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function11) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function11, "handler");
        view.addOnLayoutChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onLayoutChange$1(coroutineContext, function11));
    }

    public static /* synthetic */ void onAttachStateChangeListener$default(View view, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onAttachStateChangeListener(view, coroutineContext, function1);
    }

    public static final void onAttachStateChangeListener(@NotNull View view, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __View_OnAttachStateChangeListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __View_OnAttachStateChangeListener __view_onattachstatechangelistener = new __View_OnAttachStateChangeListener(coroutineContext);
        function1.invoke(__view_onattachstatechangelistener);
        view.addOnAttachStateChangeListener(__view_onattachstatechangelistener);
    }

    public static /* synthetic */ void textChangedListener$default(TextView textView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        textChangedListener(textView, coroutineContext, function1);
    }

    public static final void textChangedListener(@NotNull TextView textView, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __TextWatcher, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __TextWatcher __textwatcher = new __TextWatcher(coroutineContext);
        function1.invoke(__textwatcher);
        textView.addTextChangedListener(__textwatcher);
    }

    public static /* synthetic */ void onGestureListener$default(GestureOverlayView gestureOverlayView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onGestureListener(gestureOverlayView, coroutineContext, function1);
    }

    public static final void onGestureListener(@NotNull GestureOverlayView gestureOverlayView, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __GestureOverlayView_OnGestureListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gestureOverlayView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __GestureOverlayView_OnGestureListener __gestureoverlayview_ongesturelistener = new __GestureOverlayView_OnGestureListener(coroutineContext);
        function1.invoke(__gestureoverlayview_ongesturelistener);
        gestureOverlayView.addOnGestureListener(__gestureoverlayview_ongesturelistener);
    }

    public static /* synthetic */ void onGesturePerformed$default(GestureOverlayView gestureOverlayView, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onGesturePerformed(gestureOverlayView, coroutineContext, function4);
    }

    public static final void onGesturePerformed(@NotNull GestureOverlayView gestureOverlayView, @NotNull CoroutineContext coroutineContext, @NotNull Function4<? super CoroutineScope, ? super GestureOverlayView, ? super Gesture, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(gestureOverlayView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        gestureOverlayView.addOnGesturePerformedListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onGesturePerformed$1(coroutineContext, function4));
    }

    public static /* synthetic */ void onGesturingListener$default(GestureOverlayView gestureOverlayView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onGesturingListener(gestureOverlayView, coroutineContext, function1);
    }

    public static final void onGesturingListener(@NotNull GestureOverlayView gestureOverlayView, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __GestureOverlayView_OnGesturingListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gestureOverlayView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __GestureOverlayView_OnGesturingListener __gestureoverlayview_ongesturinglistener = new __GestureOverlayView_OnGesturingListener(coroutineContext);
        function1.invoke(__gestureoverlayview_ongesturinglistener);
        gestureOverlayView.addOnGesturingListener(__gestureoverlayview_ongesturinglistener);
    }

    public static /* synthetic */ void onUnhandledInputEvent$default(TvView tvView, CoroutineContext coroutineContext, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onUnhandledInputEvent(tvView, coroutineContext, z, function3);
    }

    public static final void onUnhandledInputEvent(@NotNull TvView tvView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function3<? super CoroutineScope, ? super InputEvent, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(tvView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        tvView.setOnUnhandledInputEventListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onUnhandledInputEvent$1(coroutineContext, function3, z));
    }

    public static /* synthetic */ void onApplyWindowInsets$default(View view, CoroutineContext coroutineContext, WindowInsets windowInsets, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onApplyWindowInsets(view, coroutineContext, windowInsets, function4);
    }

    public static final void onApplyWindowInsets(@NotNull View view, @NotNull CoroutineContext coroutineContext, @NotNull WindowInsets windowInsets, @NotNull Function4<? super CoroutineScope, ? super View, ? super WindowInsets, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(windowInsets, "returnValue");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        view.setOnApplyWindowInsetsListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onApplyWindowInsets$1(coroutineContext, function4, windowInsets));
    }

    public static /* synthetic */ void onCapturedPointer$default(View view, CoroutineContext coroutineContext, boolean z, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onCapturedPointer(view, coroutineContext, z, function4);
    }

    public static final void onCapturedPointer(@NotNull View view, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function4<? super CoroutineScope, ? super View, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        view.setOnCapturedPointerListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onCapturedPointer$1(coroutineContext, function4, z));
    }

    public static /* synthetic */ void onClick$default(View view, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onClick(view, coroutineContext, function3);
    }

    public static final void onClick(@NotNull View view, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        view.setOnClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onClick$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onContextClick$default(View view, CoroutineContext coroutineContext, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onContextClick(view, coroutineContext, z, function3);
    }

    public static final void onContextClick(@NotNull View view, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        view.setOnContextClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onContextClick$1(coroutineContext, function3, z));
    }

    public static /* synthetic */ void onCreateContextMenu$default(View view, CoroutineContext coroutineContext, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onCreateContextMenu(view, coroutineContext, function5);
    }

    public static final void onCreateContextMenu(@NotNull View view, @NotNull CoroutineContext coroutineContext, @NotNull Function5<? super CoroutineScope, ? super ContextMenu, ? super View, ? super ContextMenuInfo, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function5, "handler");
        view.setOnCreateContextMenuListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onCreateContextMenu$1(coroutineContext, function5));
    }

    public static /* synthetic */ void onDrag$default(View view, CoroutineContext coroutineContext, boolean z, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onDrag(view, coroutineContext, z, function4);
    }

    public static final void onDrag(@NotNull View view, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function4<? super CoroutineScope, ? super View, ? super DragEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        view.setOnDragListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onDrag$1(coroutineContext, function4, z));
    }

    public static /* synthetic */ void onFocusChange$default(View view, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onFocusChange(view, coroutineContext, function4);
    }

    public static final void onFocusChange(@NotNull View view, @NotNull CoroutineContext coroutineContext, @NotNull Function4<? super CoroutineScope, ? super View, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        view.setOnFocusChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onFocusChange$1(coroutineContext, function4));
    }

    public static /* synthetic */ void onGenericMotion$default(View view, CoroutineContext coroutineContext, boolean z, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onGenericMotion(view, coroutineContext, z, function4);
    }

    public static final void onGenericMotion(@NotNull View view, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function4<? super CoroutineScope, ? super View, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        view.setOnGenericMotionListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onGenericMotion$1(coroutineContext, function4, z));
    }

    public static /* synthetic */ void onHover$default(View view, CoroutineContext coroutineContext, boolean z, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onHover(view, coroutineContext, z, function4);
    }

    public static final void onHover(@NotNull View view, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function4<? super CoroutineScope, ? super View, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        view.setOnHoverListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onHover$1(coroutineContext, function4, z));
    }

    public static /* synthetic */ void onKey$default(View view, CoroutineContext coroutineContext, boolean z, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onKey(view, coroutineContext, z, function5);
    }

    public static final void onKey(@NotNull View view, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function5<? super CoroutineScope, ? super View, ? super Integer, ? super KeyEvent, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function5, "handler");
        view.setOnKeyListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onKey$1(coroutineContext, function5, z));
    }

    public static /* synthetic */ void onLongClick$default(View view, CoroutineContext coroutineContext, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onLongClick(view, coroutineContext, z, function3);
    }

    public static final void onLongClick(@NotNull View view, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        view.setOnLongClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onLongClick$1(coroutineContext, function3, z));
    }

    public static /* synthetic */ void onScrollChange$default(View view, CoroutineContext coroutineContext, Function7 function7, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onScrollChange(view, coroutineContext, function7);
    }

    public static final void onScrollChange(@NotNull View view, @NotNull CoroutineContext coroutineContext, @NotNull Function7<? super CoroutineScope, ? super View, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function7) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function7, "handler");
        view.setOnScrollChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onScrollChange$1(coroutineContext, function7));
    }

    public static /* synthetic */ void onSystemUiVisibilityChange$default(View view, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onSystemUiVisibilityChange(view, coroutineContext, function3);
    }

    public static final void onSystemUiVisibilityChange(@NotNull View view, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        view.setOnSystemUiVisibilityChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onSystemUiVisibilityChange$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onTouch$default(View view, CoroutineContext coroutineContext, boolean z, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onTouch(view, coroutineContext, z, function4);
    }

    public static final void onTouch(@NotNull View view, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function4<? super CoroutineScope, ? super View, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        view.setOnTouchListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onTouch$1(coroutineContext, function4, z));
    }

    public static /* synthetic */ void onHierarchyChangeListener$default(ViewGroup viewGroup, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onHierarchyChangeListener(viewGroup, coroutineContext, function1);
    }

    public static final void onHierarchyChangeListener(@NotNull ViewGroup viewGroup, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __ViewGroup_OnHierarchyChangeListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __ViewGroup_OnHierarchyChangeListener __viewgroup_onhierarchychangelistener = new __ViewGroup_OnHierarchyChangeListener(coroutineContext);
        function1.invoke(__viewgroup_onhierarchychangelistener);
        viewGroup.setOnHierarchyChangeListener(__viewgroup_onhierarchychangelistener);
    }

    public static /* synthetic */ void onInflate$default(ViewStub viewStub, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onInflate(viewStub, coroutineContext, function4);
    }

    public static final void onInflate(@NotNull ViewStub viewStub, @NotNull CoroutineContext coroutineContext, @NotNull Function4<? super CoroutineScope, ? super ViewStub, ? super View, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(viewStub, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        viewStub.setOnInflateListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onInflate$1(coroutineContext, function4));
    }

    public static /* synthetic */ void onScrollListener$default(AbsListView absListView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onScrollListener(absListView, coroutineContext, function1);
    }

    public static final void onScrollListener(@NotNull AbsListView absListView, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __AbsListView_OnScrollListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(absListView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __AbsListView_OnScrollListener __abslistview_onscrolllistener = new __AbsListView_OnScrollListener(coroutineContext);
        function1.invoke(__abslistview_onscrolllistener);
        absListView.setOnScrollListener(__abslistview_onscrolllistener);
    }

    public static /* synthetic */ void onMenuItemClick$default(ActionMenuView actionMenuView, CoroutineContext coroutineContext, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onMenuItemClick(actionMenuView, coroutineContext, z, function3);
    }

    public static final void onMenuItemClick(@NotNull ActionMenuView actionMenuView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function3<? super CoroutineScope, ? super MenuItem, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(actionMenuView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        actionMenuView.setOnMenuItemClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onMenuItemClick$1(coroutineContext, function3, z));
    }

    public static /* synthetic */ void onItemClick$default(AdapterView adapterView, CoroutineContext coroutineContext, Function6 function6, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onItemClick(adapterView, coroutineContext, function6);
    }

    public static final void onItemClick(@NotNull AdapterView<? extends Adapter> adapterView, @NotNull CoroutineContext coroutineContext, @NotNull Function6<? super CoroutineScope, ? super AdapterView<?>, ? super View, ? super Integer, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(adapterView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function6, "handler");
        adapterView.setOnItemClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onItemClick$1(coroutineContext, function6));
    }

    public static /* synthetic */ void onItemLongClick$default(AdapterView adapterView, CoroutineContext coroutineContext, boolean z, Function6 function6, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onItemLongClick(adapterView, coroutineContext, z, function6);
    }

    public static final void onItemLongClick(@NotNull AdapterView<? extends Adapter> adapterView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function6<? super CoroutineScope, ? super AdapterView<?>, ? super View, ? super Integer, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(adapterView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function6, "handler");
        adapterView.setOnItemLongClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onItemLongClick$1(coroutineContext, function6, z));
    }

    public static /* synthetic */ void onItemSelectedListener$default(AdapterView adapterView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onItemSelectedListener(adapterView, coroutineContext, function1);
    }

    public static final void onItemSelectedListener(@NotNull AdapterView<? extends Adapter> adapterView, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __AdapterView_OnItemSelectedListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(adapterView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __AdapterView_OnItemSelectedListener __adapterview_onitemselectedlistener = new __AdapterView_OnItemSelectedListener(coroutineContext);
        function1.invoke(__adapterview_onitemselectedlistener);
        adapterView.setOnItemSelectedListener(__adapterview_onitemselectedlistener);
    }

    public static /* synthetic */ void onDismiss$default(AutoCompleteTextView autoCompleteTextView, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onDismiss(autoCompleteTextView, coroutineContext, function2);
    }

    public static final void onDismiss(@NotNull AutoCompleteTextView autoCompleteTextView, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(autoCompleteTextView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        autoCompleteTextView.setOnDismissListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onDismiss$1(coroutineContext, function2));
    }

    public static /* synthetic */ void onDateChange$default(CalendarView calendarView, CoroutineContext coroutineContext, Function6 function6, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onDateChange(calendarView, coroutineContext, function6);
    }

    public static final void onDateChange(@NotNull CalendarView calendarView, @NotNull CoroutineContext coroutineContext, @NotNull Function6<? super CoroutineScope, ? super CalendarView, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(calendarView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function6, "handler");
        calendarView.setOnDateChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onDateChange$1(coroutineContext, function6));
    }

    public static /* synthetic */ void onChronometerTick$default(Chronometer chronometer, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onChronometerTick(chronometer, coroutineContext, function3);
    }

    public static final void onChronometerTick(@NotNull Chronometer chronometer, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super Chronometer, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(chronometer, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        chronometer.setOnChronometerTickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onChronometerTick$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onCheckedChange$default(CompoundButton compoundButton, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onCheckedChange(compoundButton, coroutineContext, function4);
    }

    public static final void onCheckedChange(@NotNull CompoundButton compoundButton, @NotNull CoroutineContext coroutineContext, @NotNull Function4<? super CoroutineScope, ? super CompoundButton, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(compoundButton, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        compoundButton.setOnCheckedChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onCheckedChange$1(coroutineContext, function4));
    }

    public static /* synthetic */ void onDateChanged$default(DatePicker datePicker, CoroutineContext coroutineContext, Function6 function6, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onDateChanged(datePicker, coroutineContext, function6);
    }

    public static final void onDateChanged(@NotNull DatePicker datePicker, @NotNull CoroutineContext coroutineContext, @NotNull Function6<? super CoroutineScope, ? super DatePicker, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(datePicker, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function6, "handler");
        datePicker.setOnDateChangedListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onDateChanged$1(coroutineContext, function6));
    }

    public static /* synthetic */ void onChildClick$default(ExpandableListView expandableListView, CoroutineContext coroutineContext, boolean z, Function7 function7, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onChildClick(expandableListView, coroutineContext, z, function7);
    }

    public static final void onChildClick(@NotNull ExpandableListView expandableListView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function7<? super CoroutineScope, ? super ExpandableListView, ? super View, ? super Integer, ? super Integer, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function7) {
        Intrinsics.checkParameterIsNotNull(expandableListView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function7, "handler");
        expandableListView.setOnChildClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onChildClick$1(coroutineContext, function7, z));
    }

    public static /* synthetic */ void onGroupClick$default(ExpandableListView expandableListView, CoroutineContext coroutineContext, boolean z, Function6 function6, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onGroupClick(expandableListView, coroutineContext, z, function6);
    }

    public static final void onGroupClick(@NotNull ExpandableListView expandableListView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function6<? super CoroutineScope, ? super ExpandableListView, ? super View, ? super Integer, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(expandableListView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function6, "handler");
        expandableListView.setOnGroupClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onGroupClick$1(coroutineContext, function6, z));
    }

    public static /* synthetic */ void onGroupCollapse$default(ExpandableListView expandableListView, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onGroupCollapse(expandableListView, coroutineContext, function3);
    }

    public static final void onGroupCollapse(@NotNull ExpandableListView expandableListView, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(expandableListView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        expandableListView.setOnGroupCollapseListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onGroupCollapse$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onGroupExpand$default(ExpandableListView expandableListView, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onGroupExpand(expandableListView, coroutineContext, function3);
    }

    public static final void onGroupExpand(@NotNull ExpandableListView expandableListView, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(expandableListView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        expandableListView.setOnGroupExpandListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onGroupExpand$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onScroll$default(NumberPicker numberPicker, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onScroll(numberPicker, coroutineContext, function4);
    }

    public static final void onScroll(@NotNull NumberPicker numberPicker, @NotNull CoroutineContext coroutineContext, @NotNull Function4<? super CoroutineScope, ? super NumberPicker, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(numberPicker, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        numberPicker.setOnScrollListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onScroll$1(coroutineContext, function4));
    }

    public static /* synthetic */ void onValueChanged$default(NumberPicker numberPicker, CoroutineContext coroutineContext, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onValueChanged(numberPicker, coroutineContext, function5);
    }

    public static final void onValueChanged(@NotNull NumberPicker numberPicker, @NotNull CoroutineContext coroutineContext, @NotNull Function5<? super CoroutineScope, ? super NumberPicker, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(numberPicker, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function5, "handler");
        numberPicker.setOnValueChangedListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onValueChanged$1(coroutineContext, function5));
    }

    public static /* synthetic */ void onCheckedChange$default(RadioGroup radioGroup, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onCheckedChange(radioGroup, coroutineContext, function4);
    }

    public static final void onCheckedChange(@NotNull RadioGroup radioGroup, @NotNull CoroutineContext coroutineContext, @NotNull Function4<? super CoroutineScope, ? super RadioGroup, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(radioGroup, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        radioGroup.setOnCheckedChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onCheckedChange$2(coroutineContext, function4));
    }

    public static /* synthetic */ void onRatingBarChange$default(RatingBar ratingBar, CoroutineContext coroutineContext, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onRatingBarChange(ratingBar, coroutineContext, function5);
    }

    public static final void onRatingBarChange(@NotNull RatingBar ratingBar, @NotNull CoroutineContext coroutineContext, @NotNull Function5<? super CoroutineScope, ? super RatingBar, ? super Float, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function5, "handler");
        ratingBar.setOnRatingBarChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onRatingBarChange$1(coroutineContext, function5));
    }

    public static /* synthetic */ void onClose$default(SearchView searchView, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onClose(searchView, coroutineContext, z, function2);
    }

    public static final void onClose(@NotNull SearchView searchView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(searchView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        searchView.setOnCloseListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onClose$1(coroutineContext, function2, z));
    }

    public static /* synthetic */ void onQueryTextFocusChange$default(SearchView searchView, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onQueryTextFocusChange(searchView, coroutineContext, function4);
    }

    public static final void onQueryTextFocusChange(@NotNull SearchView searchView, @NotNull CoroutineContext coroutineContext, @NotNull Function4<? super CoroutineScope, ? super View, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(searchView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        searchView.setOnQueryTextFocusChangeListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onQueryTextFocusChange$1(coroutineContext, function4));
    }

    public static /* synthetic */ void onQueryTextListener$default(SearchView searchView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onQueryTextListener(searchView, coroutineContext, function1);
    }

    public static final void onQueryTextListener(@NotNull SearchView searchView, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __SearchView_OnQueryTextListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(searchView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __SearchView_OnQueryTextListener __searchview_onquerytextlistener = new __SearchView_OnQueryTextListener(coroutineContext);
        function1.invoke(__searchview_onquerytextlistener);
        searchView.setOnQueryTextListener(__searchview_onquerytextlistener);
    }

    public static /* synthetic */ void onSearchClick$default(SearchView searchView, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onSearchClick(searchView, coroutineContext, function3);
    }

    public static final void onSearchClick(@NotNull SearchView searchView, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(searchView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        searchView.setOnSearchClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onSearchClick$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onSuggestionListener$default(SearchView searchView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onSuggestionListener(searchView, coroutineContext, function1);
    }

    public static final void onSuggestionListener(@NotNull SearchView searchView, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __SearchView_OnSuggestionListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(searchView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __SearchView_OnSuggestionListener __searchview_onsuggestionlistener = new __SearchView_OnSuggestionListener(coroutineContext);
        function1.invoke(__searchview_onsuggestionlistener);
        searchView.setOnSuggestionListener(__searchview_onsuggestionlistener);
    }

    public static /* synthetic */ void onSeekBarChangeListener$default(SeekBar seekBar, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onSeekBarChangeListener(seekBar, coroutineContext, function1);
    }

    public static final void onSeekBarChangeListener(@NotNull SeekBar seekBar, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __SeekBar_OnSeekBarChangeListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(seekBar, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __SeekBar_OnSeekBarChangeListener __seekbar_onseekbarchangelistener = new __SeekBar_OnSeekBarChangeListener(coroutineContext);
        function1.invoke(__seekbar_onseekbarchangelistener);
        seekBar.setOnSeekBarChangeListener(__seekbar_onseekbarchangelistener);
    }

    public static /* synthetic */ void onDrawerClose$default(SlidingDrawer slidingDrawer, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onDrawerClose(slidingDrawer, coroutineContext, function2);
    }

    public static final void onDrawerClose(@NotNull SlidingDrawer slidingDrawer, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(slidingDrawer, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        slidingDrawer.setOnDrawerCloseListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onDrawerClose$1(coroutineContext, function2));
    }

    public static /* synthetic */ void onDrawerOpen$default(SlidingDrawer slidingDrawer, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onDrawerOpen(slidingDrawer, coroutineContext, function2);
    }

    public static final void onDrawerOpen(@NotNull SlidingDrawer slidingDrawer, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(slidingDrawer, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        slidingDrawer.setOnDrawerOpenListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onDrawerOpen$1(coroutineContext, function2));
    }

    public static /* synthetic */ void onDrawerScrollListener$default(SlidingDrawer slidingDrawer, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onDrawerScrollListener(slidingDrawer, coroutineContext, function1);
    }

    public static final void onDrawerScrollListener(@NotNull SlidingDrawer slidingDrawer, @NotNull CoroutineContext coroutineContext, @NotNull Function1<? super __SlidingDrawer_OnDrawerScrollListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(slidingDrawer, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __SlidingDrawer_OnDrawerScrollListener __slidingdrawer_ondrawerscrolllistener = new __SlidingDrawer_OnDrawerScrollListener(coroutineContext);
        function1.invoke(__slidingdrawer_ondrawerscrolllistener);
        slidingDrawer.setOnDrawerScrollListener(__slidingdrawer_ondrawerscrolllistener);
    }

    public static /* synthetic */ void onTabChanged$default(TabHost tabHost, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onTabChanged(tabHost, coroutineContext, function3);
    }

    public static final void onTabChanged(@NotNull TabHost tabHost, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(tabHost, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        tabHost.setOnTabChangedListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onTabChanged$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onEditorAction$default(TextView textView, CoroutineContext coroutineContext, boolean z, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onEditorAction(textView, coroutineContext, z, function5);
    }

    public static final void onEditorAction(@NotNull TextView textView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function5<? super CoroutineScope, ? super TextView, ? super Integer, ? super KeyEvent, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function5, "handler");
        textView.setOnEditorActionListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onEditorAction$1(coroutineContext, function5, z));
    }

    public static /* synthetic */ void onTimeChanged$default(TimePicker timePicker, CoroutineContext coroutineContext, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onTimeChanged(timePicker, coroutineContext, function5);
    }

    public static final void onTimeChanged(@NotNull TimePicker timePicker, @NotNull CoroutineContext coroutineContext, @NotNull Function5<? super CoroutineScope, ? super TimePicker, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(timePicker, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function5, "handler");
        timePicker.setOnTimeChangedListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onTimeChanged$1(coroutineContext, function5));
    }

    public static /* synthetic */ void onMenuItemClick$default(Toolbar toolbar, CoroutineContext coroutineContext, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onMenuItemClick(toolbar, coroutineContext, z, function3);
    }

    public static final void onMenuItemClick(@NotNull Toolbar toolbar, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function3<? super CoroutineScope, ? super MenuItem, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(toolbar, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        toolbar.setOnMenuItemClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onMenuItemClick$2(coroutineContext, function3, z));
    }

    public static /* synthetic */ void onCompletion$default(VideoView videoView, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onCompletion(videoView, coroutineContext, function3);
    }

    public static final void onCompletion(@NotNull VideoView videoView, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super MediaPlayer, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(videoView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        videoView.setOnCompletionListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onCompletion$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onError$default(VideoView videoView, CoroutineContext coroutineContext, boolean z, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onError(videoView, coroutineContext, z, function5);
    }

    public static final void onError(@NotNull VideoView videoView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function5<? super CoroutineScope, ? super MediaPlayer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(videoView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function5, "handler");
        videoView.setOnErrorListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onError$1(coroutineContext, function5, z));
    }

    public static /* synthetic */ void onInfo$default(VideoView videoView, CoroutineContext coroutineContext, boolean z, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onInfo(videoView, coroutineContext, z, function5);
    }

    public static final void onInfo(@NotNull VideoView videoView, @NotNull CoroutineContext coroutineContext, boolean z, @NotNull Function5<? super CoroutineScope, ? super MediaPlayer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(videoView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function5, "handler");
        videoView.setOnInfoListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onInfo$1(coroutineContext, function5, z));
    }

    public static /* synthetic */ void onPrepared$default(VideoView videoView, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onPrepared(videoView, coroutineContext, function3);
    }

    public static final void onPrepared(@NotNull VideoView videoView, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super MediaPlayer, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(videoView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        videoView.setOnPreparedListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onPrepared$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onZoomInClick$default(ZoomControls zoomControls, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onZoomInClick(zoomControls, coroutineContext, function3);
    }

    public static final void onZoomInClick(@NotNull ZoomControls zoomControls, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(zoomControls, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        zoomControls.setOnZoomInClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onZoomInClick$1(coroutineContext, function3));
    }

    public static /* synthetic */ void onZoomOutClick$default(ZoomControls zoomControls, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onZoomOutClick(zoomControls, coroutineContext, function3);
    }

    public static final void onZoomOutClick(@NotNull ZoomControls zoomControls, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(zoomControls, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        zoomControls.setOnZoomOutClickListener(new Sdk27CoroutinesListenersWithCoroutinesKt$onZoomOutClick$1(coroutineContext, function3));
    }
}
