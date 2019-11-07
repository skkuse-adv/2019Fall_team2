package kotlin.coroutines;

import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CoroutineContext {

    public static final class DefaultImpls {
        @NotNull
        public static CoroutineContext plus(CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2) {
            Intrinsics.checkParameterIsNotNull(coroutineContext2, "context");
            return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext$plus$1.INSTANCE);
        }
    }

    public interface Element extends CoroutineContext {

        public static final class DefaultImpls {
            @NotNull
            public static CoroutineContext plus(Element element, @NotNull CoroutineContext coroutineContext) {
                Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
                return DefaultImpls.plus(element, coroutineContext);
            }

            @Nullable
            public static <E extends Element> E get(Element element, @NotNull Key<E> key) {
                Intrinsics.checkParameterIsNotNull(key, "key");
                if (!Intrinsics.areEqual((Object) element.getKey(), (Object) key)) {
                    return null;
                }
                if (element != null) {
                    return element;
                }
                throw new TypeCastException("null cannot be cast to non-null type E");
            }

            public static <R> R fold(Element element, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.checkParameterIsNotNull(function2, "operation");
                return function2.invoke(r, element);
            }

            @NotNull
            public static CoroutineContext minusKey(Element element, @NotNull Key<?> key) {
                Intrinsics.checkParameterIsNotNull(key, "key");
                return Intrinsics.areEqual((Object) element.getKey(), (Object) key) ? EmptyCoroutineContext.INSTANCE : element;
            }
        }

        <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

        @Nullable
        <E extends Element> E get(@NotNull Key<E> key);

        @NotNull
        Key<?> getKey();

        @NotNull
        CoroutineContext minusKey(@NotNull Key<?> key);
    }

    public interface Key<E extends Element> {
    }

    <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

    @Nullable
    <E extends Element> E get(@NotNull Key<E> key);

    @NotNull
    CoroutineContext minusKey(@NotNull Key<?> key);

    @NotNull
    CoroutineContext plus(@NotNull CoroutineContext coroutineContext);
}
