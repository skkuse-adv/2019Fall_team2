package kotlin.reflect;

import kotlin.Unit;
import kotlin.reflect.KProperty.Accessor;
import org.jetbrains.annotations.NotNull;

public interface KMutableProperty<R> extends KProperty<R> {

    public interface Setter<R> extends Accessor<R>, KFunction<Unit> {
    }

    @NotNull
    Setter<R> getSetter();
}
