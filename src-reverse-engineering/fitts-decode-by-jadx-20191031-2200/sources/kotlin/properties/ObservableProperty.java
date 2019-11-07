package kotlin.properties;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ObservableProperty<T> implements ReadWriteProperty<Object, T> {
    private T value;

    /* access modifiers changed from: protected */
    public void afterChange(@NotNull KProperty<?> kProperty, T t, T t2) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
    }

    /* access modifiers changed from: protected */
    public boolean beforeChange(@NotNull KProperty<?> kProperty, T t, T t2) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        return true;
    }

    public ObservableProperty(T t) {
        this.value = t;
    }

    public T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        return this.value;
    }

    public void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, T t) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        T t2 = this.value;
        if (beforeChange(kProperty, t2, t)) {
            this.value = t;
            afterChange(kProperty, t2, t);
        }
    }
}
