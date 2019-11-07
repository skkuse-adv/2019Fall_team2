package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ThreadContextElement<S> extends Element {

    public static final class DefaultImpls {
        public static <S, R> R fold(ThreadContextElement<S> threadContextElement, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
            Intrinsics.checkParameterIsNotNull(function2, "operation");
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.fold(threadContextElement, r, function2);
        }

        @Nullable
        public static <S, E extends Element> E get(ThreadContextElement<S> threadContextElement, @NotNull Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.get(threadContextElement, key);
        }

        @NotNull
        public static <S> CoroutineContext minusKey(ThreadContextElement<S> threadContextElement, @NotNull Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.minusKey(threadContextElement, key);
        }

        @NotNull
        public static <S> CoroutineContext plus(ThreadContextElement<S> threadContextElement, @NotNull CoroutineContext coroutineContext) {
            Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.plus(threadContextElement, coroutineContext);
        }
    }

    void restoreThreadContext(@NotNull CoroutineContext coroutineContext, S s);

    S updateThreadContext(@NotNull CoroutineContext coroutineContext);
}
