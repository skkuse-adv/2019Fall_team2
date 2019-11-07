package kotlin.reflect;

import org.jetbrains.annotations.NotNull;

public interface KProperty<R> extends KCallable<R> {

    public interface Accessor<R> {
        @NotNull
        KProperty<R> getProperty();
    }

    public interface Getter<R> extends Accessor<R>, KFunction<R> {
    }

    @NotNull
    Getter<R> getGetter();

    boolean isConst();

    boolean isLateinit();
}
