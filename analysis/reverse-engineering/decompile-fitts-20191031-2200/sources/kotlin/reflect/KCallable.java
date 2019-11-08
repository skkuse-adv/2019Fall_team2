package kotlin.reflect;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KCallable<R> extends KAnnotatedElement {
    R call(@NotNull Object... objArr);

    R callBy(@NotNull Map<Object, ? extends Object> map);

    @NotNull
    String getName();

    @NotNull
    List<Object> getParameters();

    @NotNull
    KType getReturnType();

    @NotNull
    List<Object> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
