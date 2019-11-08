package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {
    private Object _value = UNINITIALIZED_VALUE.INSTANCE;
    private Function0<? extends T> initializer;

    public UnsafeLazyImpl(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "initializer");
        this.initializer = function0;
    }

    public T getValue() {
        if (this._value == UNINITIALIZED_VALUE.INSTANCE) {
            Function0<? extends T> function0 = this.initializer;
            if (function0 == null) {
                Intrinsics.throwNpe();
            }
            this._value = function0.invoke();
            this.initializer = null;
        }
        return this._value;
    }

    public boolean isInitialized() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
