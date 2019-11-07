package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class __SeekBar_OnSeekBarChangeListener implements OnSeekBarChangeListener {
    private Function5<? super CoroutineScope, ? super SeekBar, ? super Integer, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> _onProgressChanged;
    private Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> _onStartTrackingTouch;
    private Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> _onStopTrackingTouch;
    private final CoroutineContext context;

    public __SeekBar_OnSeekBarChangeListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onProgressChanged(@Nullable SeekBar seekBar, int i, boolean z) {
        Function5<? super CoroutineScope, ? super SeekBar, ? super Integer, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function5 = this._onProgressChanged;
        if (function5 != null) {
            GlobalScope globalScope = GlobalScope.INSTANCE;
            CoroutineContext coroutineContext = this.context;
            __SeekBar_OnSeekBarChangeListener$onProgressChanged$1 __seekbar_onseekbarchangelistener_onprogresschanged_1 = new __SeekBar_OnSeekBarChangeListener$onProgressChanged$1(function5, seekBar, i, z, null);
            BuildersKt__Builders_commonKt.launch$default(globalScope, coroutineContext, null, __seekbar_onseekbarchangelistener_onprogresschanged_1, 2, null);
        }
    }

    public final void onProgressChanged(@NotNull Function5<? super CoroutineScope, ? super SeekBar, ? super Integer, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(function5, "listener");
        this._onProgressChanged = function5;
    }

    public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onStartTrackingTouch;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __SeekBar_OnSeekBarChangeListener$onStartTrackingTouch$1(function3, seekBar, null), 2, null);
        }
    }

    public final void onStartTrackingTouch(@NotNull Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onStartTrackingTouch = function3;
    }

    public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
        Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onStopTrackingTouch;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __SeekBar_OnSeekBarChangeListener$onStopTrackingTouch$1(function3, seekBar, null), 2, null);
        }
    }

    public final void onStopTrackingTouch(@NotNull Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onStopTrackingTouch = function3;
    }
}
