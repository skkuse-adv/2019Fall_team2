package org.jetbrains.anko.sdk27.coroutines;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class __ViewGroup_OnHierarchyChangeListener implements OnHierarchyChangeListener {
    private Function4<? super CoroutineScope, ? super View, ? super View, ? super Continuation<? super Unit>, ? extends Object> _onChildViewAdded;
    private Function4<? super CoroutineScope, ? super View, ? super View, ? super Continuation<? super Unit>, ? extends Object> _onChildViewRemoved;
    private final CoroutineContext context;

    public __ViewGroup_OnHierarchyChangeListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onChildViewAdded(@Nullable View view, @Nullable View view2) {
        Function4<? super CoroutineScope, ? super View, ? super View, ? super Continuation<? super Unit>, ? extends Object> function4 = this._onChildViewAdded;
        if (function4 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1(function4, view, view2, null), 2, null);
        }
    }

    public final void onChildViewAdded(@NotNull Function4<? super CoroutineScope, ? super View, ? super View, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "listener");
        this._onChildViewAdded = function4;
    }

    public void onChildViewRemoved(@Nullable View view, @Nullable View view2) {
        Function4<? super CoroutineScope, ? super View, ? super View, ? super Continuation<? super Unit>, ? extends Object> function4 = this._onChildViewRemoved;
        if (function4 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __ViewGroup_OnHierarchyChangeListener$onChildViewRemoved$1(function4, view, view2, null), 2, null);
        }
    }

    public final void onChildViewRemoved(@NotNull Function4<? super CoroutineScope, ? super View, ? super View, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "listener");
        this._onChildViewRemoved = function4;
    }
}
