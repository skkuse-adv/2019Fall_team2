package org.jetbrains.anko.appcompat.v7.coroutines;

import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.FitWindowsFrameLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

public final class AppcompatV7CoroutinesListenersWithCoroutinesKt {
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
        actionMenuView.setOnMenuItemClickListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onMenuItemClick$1(coroutineContext, function3, z));
    }

    public static /* synthetic */ void onDismiss$default(ActivityChooserView activityChooserView, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onDismiss(activityChooserView, coroutineContext, function2);
    }

    public static final void onDismiss(@NotNull ActivityChooserView activityChooserView, @NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(activityChooserView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        activityChooserView.setOnDismissListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onDismiss$1(coroutineContext, function2));
    }

    public static /* synthetic */ void onFitSystemWindows$default(FitWindowsFrameLayout fitWindowsFrameLayout, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onFitSystemWindows(fitWindowsFrameLayout, coroutineContext, function3);
    }

    public static final void onFitSystemWindows(@NotNull FitWindowsFrameLayout fitWindowsFrameLayout, @NotNull CoroutineContext coroutineContext, @NotNull Function3<? super CoroutineScope, ? super Rect, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(fitWindowsFrameLayout, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        fitWindowsFrameLayout.setOnFitSystemWindowsListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onFitSystemWindows$1(coroutineContext, function3));
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
        searchView.setOnCloseListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onClose$1(coroutineContext, function2, z));
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
        searchView.setOnQueryTextFocusChangeListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onQueryTextFocusChange$1(coroutineContext, function4));
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
        searchView.setOnSearchClickListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onSearchClick$1(coroutineContext, function3));
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
        toolbar.setOnMenuItemClickListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onMenuItemClick$2(coroutineContext, function3, z));
    }

    public static /* synthetic */ void onInflate$default(ViewStubCompat viewStubCompat, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getMain();
        }
        onInflate(viewStubCompat, coroutineContext, function4);
    }

    public static final void onInflate(@NotNull ViewStubCompat viewStubCompat, @NotNull CoroutineContext coroutineContext, @NotNull Function4<? super CoroutineScope, ? super ViewStubCompat, ? super View, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(viewStubCompat, "receiver$0");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        viewStubCompat.setOnInflateListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onInflate$1(coroutineContext, function4));
    }
}
