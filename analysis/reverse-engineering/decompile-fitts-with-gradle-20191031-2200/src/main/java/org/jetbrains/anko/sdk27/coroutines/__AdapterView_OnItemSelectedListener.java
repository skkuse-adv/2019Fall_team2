package org.jetbrains.anko.sdk27.coroutines;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class __AdapterView_OnItemSelectedListener implements OnItemSelectedListener {
    private Function6<? super CoroutineScope, ? super AdapterView<?>, ? super View, ? super Integer, ? super Long, ? super Continuation<? super Unit>, ? extends Object> _onItemSelected;
    private Function3<? super CoroutineScope, ? super AdapterView<?>, ? super Continuation<? super Unit>, ? extends Object> _onNothingSelected;
    private final CoroutineContext context;

    public __AdapterView_OnItemSelectedListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        Function6<? super CoroutineScope, ? super AdapterView<?>, ? super View, ? super Integer, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function6 = this._onItemSelected;
        if (function6 != null) {
            GlobalScope globalScope = GlobalScope.INSTANCE;
            CoroutineContext coroutineContext = this.context;
            __AdapterView_OnItemSelectedListener$onItemSelected$1 __adapterview_onitemselectedlistener_onitemselected_1 = new __AdapterView_OnItemSelectedListener$onItemSelected$1(function6, adapterView, view, i, j, null);
            BuildersKt__Builders_commonKt.launch$default(globalScope, coroutineContext, null, __adapterview_onitemselectedlistener_onitemselected_1, 2, null);
        }
    }

    public final void onItemSelected(@NotNull Function6<? super CoroutineScope, ? super AdapterView<?>, ? super View, ? super Integer, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(function6, "listener");
        this._onItemSelected = function6;
    }

    public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
        Function3<? super CoroutineScope, ? super AdapterView<?>, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onNothingSelected;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __AdapterView_OnItemSelectedListener$onNothingSelected$1(function3, adapterView, null), 2, null);
        }
    }

    public final void onNothingSelected(@NotNull Function3<? super CoroutineScope, ? super AdapterView<?>, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onNothingSelected = function3;
    }
}
