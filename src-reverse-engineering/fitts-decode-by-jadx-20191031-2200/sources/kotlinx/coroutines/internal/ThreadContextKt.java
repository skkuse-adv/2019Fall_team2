package kotlinx.coroutines.internal;

import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ThreadContextKt {
    private static final Symbol ZERO = new Symbol("ZERO");
    private static final Function2<Object, Element, Object> countAll = ThreadContextKt$countAll$1.INSTANCE;
    private static final Function2<ThreadContextElement<?>, Element, ThreadContextElement<?>> findOne = ThreadContextKt$findOne$1.INSTANCE;
    private static final Function2<ThreadState, Element, ThreadState> restoreState = ThreadContextKt$restoreState$1.INSTANCE;
    private static final Function2<ThreadState, Element, ThreadState> updateState = ThreadContextKt$updateState$1.INSTANCE;

    @NotNull
    public static final Object threadContextElements(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Object fold = coroutineContext.fold(Integer.valueOf(0), countAll);
        if (fold == null) {
            Intrinsics.throwNpe();
        }
        return fold;
    }

    @Nullable
    public static final Object updateThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == Integer.valueOf(0)) {
            return ZERO;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), updateState);
        }
        if (obj != null) {
            return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    public static final void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        if (obj != ZERO) {
            if (obj instanceof ThreadState) {
                ((ThreadState) obj).start();
                coroutineContext.fold(obj, restoreState);
            } else {
                Object fold = coroutineContext.fold(null, findOne);
                if (fold != null) {
                    ((ThreadContextElement) fold).restoreThreadContext(coroutineContext, obj);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                }
            }
        }
    }
}
