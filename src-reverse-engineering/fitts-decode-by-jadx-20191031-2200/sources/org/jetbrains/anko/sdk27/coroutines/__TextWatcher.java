package org.jetbrains.anko.sdk27.coroutines;

import android.text.Editable;
import android.text.TextWatcher;
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

public final class __TextWatcher implements TextWatcher {
    private Function3<? super CoroutineScope, ? super Editable, ? super Continuation<? super Unit>, ? extends Object> _afterTextChanged;
    private Function6<? super CoroutineScope, ? super CharSequence, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> _beforeTextChanged;
    private Function6<? super CoroutineScope, ? super CharSequence, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> _onTextChanged;
    private final CoroutineContext context;

    public __TextWatcher(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        Function6<? super CoroutineScope, ? super CharSequence, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function6 = this._beforeTextChanged;
        if (function6 != null) {
            GlobalScope globalScope = GlobalScope.INSTANCE;
            CoroutineContext coroutineContext = this.context;
            __TextWatcher$beforeTextChanged$1 __textwatcher_beforetextchanged_1 = new __TextWatcher$beforeTextChanged$1(function6, charSequence, i, i2, i3, null);
            BuildersKt__Builders_commonKt.launch$default(globalScope, coroutineContext, null, __textwatcher_beforetextchanged_1, 2, null);
        }
    }

    public final void beforeTextChanged(@NotNull Function6<? super CoroutineScope, ? super CharSequence, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(function6, "listener");
        this._beforeTextChanged = function6;
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        Function6<? super CoroutineScope, ? super CharSequence, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function6 = this._onTextChanged;
        if (function6 != null) {
            GlobalScope globalScope = GlobalScope.INSTANCE;
            CoroutineContext coroutineContext = this.context;
            __TextWatcher$onTextChanged$1 __textwatcher_ontextchanged_1 = new __TextWatcher$onTextChanged$1(function6, charSequence, i, i2, i3, null);
            BuildersKt__Builders_commonKt.launch$default(globalScope, coroutineContext, null, __textwatcher_ontextchanged_1, 2, null);
        }
    }

    public final void onTextChanged(@NotNull Function6<? super CoroutineScope, ? super CharSequence, ? super Integer, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function6) {
        Intrinsics.checkParameterIsNotNull(function6, "listener");
        this._onTextChanged = function6;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        Function3<? super CoroutineScope, ? super Editable, ? super Continuation<? super Unit>, ? extends Object> function3 = this._afterTextChanged;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __TextWatcher$afterTextChanged$1(function3, editable, null), 2, null);
        }
    }

    public final void afterTextChanged(@NotNull Function3<? super CoroutineScope, ? super Editable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._afterTextChanged = function3;
    }
}
