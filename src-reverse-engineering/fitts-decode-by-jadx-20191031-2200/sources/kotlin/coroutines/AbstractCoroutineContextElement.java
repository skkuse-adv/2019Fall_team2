package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractCoroutineContextElement implements Element {
    @NotNull
    private final Key<?> key;

    public AbstractCoroutineContextElement(@NotNull Key<?> key2) {
        Intrinsics.checkParameterIsNotNull(key2, "key");
        this.key = key2;
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        return DefaultImpls.fold(this, r, function2);
    }

    @Nullable
    public <E extends Element> E get(@NotNull Key<E> key2) {
        Intrinsics.checkParameterIsNotNull(key2, "key");
        return DefaultImpls.get(this, key2);
    }

    @NotNull
    public Key<?> getKey() {
        return this.key;
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull Key<?> key2) {
        Intrinsics.checkParameterIsNotNull(key2, "key");
        return DefaultImpls.minusKey(this, key2);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return DefaultImpls.plus(this, coroutineContext);
    }
}
