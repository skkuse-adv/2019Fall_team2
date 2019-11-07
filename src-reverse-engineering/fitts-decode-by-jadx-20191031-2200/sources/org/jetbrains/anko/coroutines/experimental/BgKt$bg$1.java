package org.jetbrains.anko.coroutines.experimental;

import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "org/jetbrains/anko/coroutines/experimental/BgKt$bg$1", f = "bg.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class BgKt$bg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function0 $block;
    int label;
    private CoroutineScope p$;

    public BgKt$bg$1(Function0 function0, Continuation continuation) {
        this.$block = function0;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        BgKt$bg$1 bgKt$bg$1 = new BgKt$bg$1(this.$block, continuation);
        bgKt$bg$1.p$ = (CoroutineScope) obj;
        return bgKt$bg$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((BgKt$bg$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof Failure)) {
            return this.$block.invoke();
        } else {
            throw ((Failure) obj).exception;
        }
    }
}
