package kotlin.reflect;

import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KProperty2<D, E, R> extends KProperty<R>, Function2<D, E, R> {

    public interface Getter<D, E, R> extends kotlin.reflect.KProperty.Getter<R>, Function2<D, E, R> {
    }

    R get(D d, E e);

    @Nullable
    Object getDelegate(D d, E e);

    @NotNull
    Getter<D, E, R> getGetter();
}
