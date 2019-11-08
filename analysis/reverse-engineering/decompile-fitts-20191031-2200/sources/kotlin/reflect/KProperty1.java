package kotlin.reflect;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KProperty1<T, R> extends KProperty<R>, Function1<T, R> {

    public interface Getter<T, R> extends kotlin.reflect.KProperty.Getter<R>, Function1<T, R> {
    }

    R get(T t);

    @Nullable
    Object getDelegate(T t);

    @NotNull
    Getter<T, R> getGetter();
}
