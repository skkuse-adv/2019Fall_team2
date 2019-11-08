package kotlin.reflect;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KProperty0<R> extends KProperty<R>, Function0<R> {

    public interface Getter<R> extends kotlin.reflect.KProperty.Getter<R>, Function0<R> {
    }

    R get();

    @Nullable
    Object getDelegate();

    @NotNull
    Getter<R> getGetter();
}
