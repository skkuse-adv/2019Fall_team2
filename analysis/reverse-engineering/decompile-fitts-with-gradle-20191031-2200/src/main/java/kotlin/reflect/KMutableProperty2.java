package kotlin.reflect;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

public interface KMutableProperty2<D, E, R> extends KProperty2<D, E, R>, KMutableProperty<R> {

    public interface Setter<D, E, R> extends kotlin.reflect.KMutableProperty.Setter<R>, Function3<D, E, R, Unit> {
    }

    @NotNull
    Setter<D, E, R> getSetter();

    void set(D d, E e, R r);
}
