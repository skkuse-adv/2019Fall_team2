package kotlin.coroutines;

import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ContinuationInterceptor extends Element {
    public static final Key Key = Key.$$INSTANCE;

    public static final class DefaultImpls {
        public static <R> R fold(ContinuationInterceptor continuationInterceptor, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
            Intrinsics.checkParameterIsNotNull(function2, "operation");
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.fold(continuationInterceptor, r, function2);
        }

        @NotNull
        public static CoroutineContext plus(ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext coroutineContext) {
            Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
            return kotlin.coroutines.CoroutineContext.Element.DefaultImpls.plus(continuationInterceptor, coroutineContext);
        }

        public static void releaseInterceptedContinuation(ContinuationInterceptor continuationInterceptor, @NotNull Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        }

        @Nullable
        public static <E extends Element> E get(ContinuationInterceptor continuationInterceptor, @NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            if (key != ContinuationInterceptor.Key) {
                return null;
            }
            if (continuationInterceptor != null) {
                return continuationInterceptor;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        }

        @NotNull
        public static CoroutineContext minusKey(ContinuationInterceptor continuationInterceptor, @NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return key == ContinuationInterceptor.Key ? EmptyCoroutineContext.INSTANCE : continuationInterceptor;
        }
    }

    public static final class Key implements kotlin.coroutines.CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @Nullable
    <E extends Element> E get(@NotNull kotlin.coroutines.CoroutineContext.Key<E> key);

    @NotNull
    <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> continuation);

    @NotNull
    CoroutineContext minusKey(@NotNull kotlin.coroutines.CoroutineContext.Key<?> key);

    void releaseInterceptedContinuation(@NotNull Continuation<?> continuation);
}
