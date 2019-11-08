package kotlin.reflect;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

public interface KMutableProperty1<T, R> extends KProperty1<T, R>, KMutableProperty<R> {

    public interface Setter<T, R> extends kotlin.reflect.KMutableProperty.Setter<R>, Function2<T, R, Unit> {
    }

    @NotNull
    Setter<T, R> getSetter();

    void set(T t, R r);
}
