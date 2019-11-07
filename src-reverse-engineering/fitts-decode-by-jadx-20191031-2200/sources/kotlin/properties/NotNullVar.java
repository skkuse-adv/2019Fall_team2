package kotlin.properties;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class NotNullVar<T> implements ReadWriteProperty<Object, T> {
    private T value;

    @NotNull
    public T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        T t = this.value;
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Property ");
        sb.append(kProperty.getName());
        sb.append(" should be initialized before get.");
        throw new IllegalStateException(sb.toString());
    }

    public void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        Intrinsics.checkParameterIsNotNull(t, "value");
        this.value = t;
    }
}
