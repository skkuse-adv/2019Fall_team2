package kotlin.reflect;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public interface KMutableProperty0<R> extends KProperty0<R>, KMutableProperty<R> {

    public interface Setter<R> extends kotlin.reflect.KMutableProperty.Setter<R>, Function1<R, Unit> {
    }

    @NotNull
    Setter<R> getSetter();

    void set(R r);
}
