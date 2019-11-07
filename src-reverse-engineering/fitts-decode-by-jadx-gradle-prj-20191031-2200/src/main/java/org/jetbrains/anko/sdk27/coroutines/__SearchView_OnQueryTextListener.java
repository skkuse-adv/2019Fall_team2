package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SearchView.OnQueryTextListener;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class __SearchView_OnQueryTextListener implements OnQueryTextListener {
    private Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> _onQueryTextChange;
    private boolean _onQueryTextChange_returnValue;
    private Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> _onQueryTextSubmit;
    private boolean _onQueryTextSubmit_returnValue;
    private final CoroutineContext context;

    public __SearchView_OnQueryTextListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public boolean onQueryTextSubmit(@Nullable String str) {
        boolean z = this._onQueryTextSubmit_returnValue;
        Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> function3 = this._onQueryTextSubmit;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __SearchView_OnQueryTextListener$onQueryTextSubmit$1(function3, str, null), 2, null);
        }
        return z;
    }

    public static /* synthetic */ void onQueryTextSubmit$default(__SearchView_OnQueryTextListener __searchview_onquerytextlistener, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        __searchview_onquerytextlistener.onQueryTextSubmit(z, function3);
    }

    public final void onQueryTextSubmit(boolean z, @NotNull Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onQueryTextSubmit = function3;
        this._onQueryTextSubmit_returnValue = z;
    }

    public boolean onQueryTextChange(@Nullable String str) {
        boolean z = this._onQueryTextChange_returnValue;
        Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> function3 = this._onQueryTextChange;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __SearchView_OnQueryTextListener$onQueryTextChange$1(function3, str, null), 2, null);
        }
        return z;
    }

    public static /* synthetic */ void onQueryTextChange$default(__SearchView_OnQueryTextListener __searchview_onquerytextlistener, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        __searchview_onquerytextlistener.onQueryTextChange(z, function3);
    }

    public final void onQueryTextChange(boolean z, @NotNull Function3<? super CoroutineScope, ? super String, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onQueryTextChange = function3;
        this._onQueryTextChange_returnValue = z;
    }
}
