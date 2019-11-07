package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SeekBar;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/__SeekBar_OnSeekBarChangeListener$onProgressChanged$1", f = "ListenersWithCoroutines.kt", i = {}, l = {913, 915}, m = "invokeSuspend", n = {}, s = {})
final class __SeekBar_OnSeekBarChangeListener$onProgressChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromUser;
    final /* synthetic */ Function5 $handler;
    final /* synthetic */ int $progress;
    final /* synthetic */ SeekBar $seekBar;
    int label;
    private CoroutineScope p$;

    __SeekBar_OnSeekBarChangeListener$onProgressChanged$1(Function5 function5, SeekBar seekBar, int i, boolean z, Continuation continuation) {
        this.$handler = function5;
        this.$seekBar = seekBar;
        this.$progress = i;
        this.$fromUser = z;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        __SeekBar_OnSeekBarChangeListener$onProgressChanged$1 __seekbar_onseekbarchangelistener_onprogresschanged_1 = new __SeekBar_OnSeekBarChangeListener$onProgressChanged$1(this.$handler, this.$seekBar, this.$progress, this.$fromUser, continuation);
        __seekbar_onseekbarchangelistener_onprogresschanged_1.p$ = (CoroutineScope) obj;
        return __seekbar_onseekbarchangelistener_onprogresschanged_1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((__SeekBar_OnSeekBarChangeListener$onProgressChanged$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (obj instanceof Failure) {
                throw ((Failure) obj).exception;
            }
        } else if (!(obj instanceof Failure)) {
            CoroutineScope coroutineScope = this.p$;
            Function5 function5 = this.$handler;
            SeekBar seekBar = this.$seekBar;
            Integer boxInt = Boxing.boxInt(this.$progress);
            Boolean boxBoolean = Boxing.boxBoolean(this.$fromUser);
            this.label = 1;
            if (function5.invoke(coroutineScope, seekBar, boxInt, boxBoolean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Failure) obj).exception;
        }
        return Unit.INSTANCE;
    }
}
