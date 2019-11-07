package kotlin.properties;

import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public interface ReadWriteProperty<R, T> {
    T getValue(R r, @NotNull KProperty<?> kProperty);

    void setValue(R r, @NotNull KProperty<?> kProperty, T t);
}
