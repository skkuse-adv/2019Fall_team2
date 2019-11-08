package org.jetbrains.anko.sdk27.coroutines;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class __AbsListView_OnScrollListener implements OnScrollListener {
    private Function6<? super CoroutineScope, ? super AbsListView, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> _onScroll;
    private Function4<? super CoroutineScope, ? super AbsListView, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> _onScrollStateChanged;
    private final CoroutineContext context;

    public __AbsListView_OnScrollListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onScrollStateChanged(@Nullable AbsListView absListView, int i) {
        Function4<? super CoroutineScope, ? super AbsListView, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function4 = this._onScrollStateChanged;
        if (function4 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __AbsListView_OnScrollListener$onScrollStateChanged$1(function4, absListView, i, null), 2, null);
        }
    }

    public final void onScrollStateChanged(@NotNull Function4<? super CoroutineScope, ? super AbsListView, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "listener");
        this._onScrollStateChanged = function4;
    }

    public void onScroll(@Nullable AbsListView absListView, int i, int i2, int i3) {
        Function6<? super CoroutineScope, ? super AbsListView, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function6 = this._onScroll;
        if (function6 != null) {
            GlobalScope globalScope = GlobalScope.INSTANCE;
            CoroutineContext coroutineContext = this.context;
            __AbsListView_OnScrollListener$onScroll$1 __abslistview_onscrolllistener_onscroll_1 = new __AbsListView_OnScrollListener$onScroll$1(function6, absListView, i, i2, i3, null);
            BuildersKt__Builders_commonKt.launch$default(globalScope, coroutineContext, null, __abslistview_onscrolllistener_onscroll_1, 2, null);
        }
    }

    public final void onScroll(@NotNull Function6<? super CoroutineScope, ? super AbsListView, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(function6, "listener");
        this._onScroll = function6;
    }
}
