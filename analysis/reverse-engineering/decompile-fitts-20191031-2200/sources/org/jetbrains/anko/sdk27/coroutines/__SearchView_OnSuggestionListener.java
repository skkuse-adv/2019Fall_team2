package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SearchView.OnSuggestionListener;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

public final class __SearchView_OnSuggestionListener implements OnSuggestionListener {
    private Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> _onSuggestionClick;
    private boolean _onSuggestionClick_returnValue;
    private Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> _onSuggestionSelect;
    private boolean _onSuggestionSelect_returnValue;
    private final CoroutineContext context;

    public __SearchView_OnSuggestionListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public boolean onSuggestionSelect(int i) {
        boolean z = this._onSuggestionSelect_returnValue;
        Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function3 = this._onSuggestionSelect;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __SearchView_OnSuggestionListener$onSuggestionSelect$1(function3, i, null), 2, null);
        }
        return z;
    }

    public static /* synthetic */ void onSuggestionSelect$default(__SearchView_OnSuggestionListener __searchview_onsuggestionlistener, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        __searchview_onsuggestionlistener.onSuggestionSelect(z, function3);
    }

    public final void onSuggestionSelect(boolean z, @NotNull Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onSuggestionSelect = function3;
        this._onSuggestionSelect_returnValue = z;
    }

    public boolean onSuggestionClick(int i) {
        boolean z = this._onSuggestionClick_returnValue;
        Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function3 = this._onSuggestionClick;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __SearchView_OnSuggestionListener$onSuggestionClick$1(function3, i, null), 2, null);
        }
        return z;
    }

    public static /* synthetic */ void onSuggestionClick$default(__SearchView_OnSuggestionListener __searchview_onsuggestionlistener, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        __searchview_onsuggestionlistener.onSuggestionClick(z, function3);
    }

    public final void onSuggestionClick(boolean z, @NotNull Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onSuggestionClick = function3;
        this._onSuggestionClick_returnValue = z;
    }
}
