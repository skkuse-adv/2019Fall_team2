package kotlin;

import org.jetbrains.annotations.NotNull;

class LazyKt__LazyKt extends LazyKt__LazyJVMKt {
    @NotNull
    public static final <T> Lazy<T> lazyOf(T t) {
        return new InitializedLazyImpl(t);
    }
}
