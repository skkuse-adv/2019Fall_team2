package kotlin.sequences;

import java.util.Iterator;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "kotlin/sequences/SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {0, 1}, l = {67, 69}, m = "invokeSuspend", n = {"iterator", "iterator"}, s = {"L$0", "L$0"})
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $defaultValue;
    final /* synthetic */ Sequence $this_ifEmpty;
    Object L$0;
    int label;
    private SequenceScope p$;

    SequencesKt__SequencesKt$ifEmpty$1(Sequence sequence, Function0 function0, Continuation continuation) {
        this.$this_ifEmpty = sequence;
        this.$defaultValue = function0;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, continuation);
        sequencesKt__SequencesKt$ifEmpty$1.p$ = (SequenceScope) obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                Iterator it = (Iterator) this.L$0;
                if (obj instanceof Failure) {
                    throw ((Failure) obj).exception;
                }
            } else if (i == 2) {
                Iterator it2 = (Iterator) this.L$0;
                if (obj instanceof Failure) {
                    throw ((Failure) obj).exception;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (!(obj instanceof Failure)) {
            SequenceScope sequenceScope = this.p$;
            Iterator it3 = this.$this_ifEmpty.iterator();
            if (it3.hasNext()) {
                this.L$0 = it3;
                this.label = 1;
                if (sequenceScope.yieldAll(it3, (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Sequence sequence = (Sequence) this.$defaultValue.invoke();
                this.L$0 = it3;
                this.label = 2;
                if (sequenceScope.yieldAll(sequence, (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            throw ((Failure) obj).exception;
        }
        return Unit.INSTANCE;
    }
}
