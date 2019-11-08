package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(@NotNull Function0<? extends T> function0, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(function0, "initializer");
        this.initializer = function0;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        if (obj == 0) {
            obj = this;
        }
        this.lock = obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            obj = null;
        }
        this(function0, obj);
    }

    public T getValue() {
        T t;
        T t2 = this._value;
        if (t2 != UNINITIALIZED_VALUE.INSTANCE) {
            return t2;
        }
        synchronized (this.lock) {
            t = this._value;
            if (t == UNINITIALIZED_VALUE.INSTANCE) {
                Function0<? extends T> function0 = this.initializer;
                if (function0 == null) {
                    Intrinsics.throwNpe();
                }
                t = function0.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
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
