package org.jetbrains.anko.sdk27.coroutines;

import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/__TextWatcher$beforeTextChanged$1", f = "ListenersWithCoroutines.kt", i = {}, l = {83, 85}, m = "invokeSuspend", n = {}, s = {})
final class __TextWatcher$beforeTextChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $after;
    final /* synthetic */ int $count;
    final /* synthetic */ Function6 $handler;
    final /* synthetic */ CharSequence $s;
    final /* synthetic */ int $start;
    int label;
    private CoroutineScope p$;

    __TextWatcher$beforeTextChanged$1(Function6 function6, CharSequence charSequence, int i, int i2, int i3, Continuation continuation) {
        this.$handler = function6;
        this.$s = charSequence;
        this.$start = i;
        this.$count = i2;
        this.$after = i3;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        __TextWatcher$beforeTextChanged$1 __textwatcher_beforetextchanged_1 = new __TextWatcher$beforeTextChanged$1(this.$handler, this.$s, this.$start, this.$count, this.$after, continuation);
        __textwatcher_beforetextchanged_1.p$ = (CoroutineScope) obj;
        return __textwatcher_beforetextchanged_1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((__TextWatcher$beforeTextChanged$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
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
            Function6 function6 = this.$handler;
            CharSequence charSequence = this.$s;
            Integer boxInt = Boxing.boxInt(this.$start);
            Integer boxInt2 = Boxing.boxInt(this.$count);
            Integer boxInt3 = Boxing.boxInt(this.$after);
            this.label = 1;
            if (function6.invoke(coroutineScope, charSequence, boxInt, boxInt2, boxInt3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Failure) obj).exception;
        }
        return Unit.INSTANCE;
    }
}
