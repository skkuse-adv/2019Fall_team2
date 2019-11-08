package kotlin.reflect;

import kotlin.Function;

public interface KFunction<R> extends KCallable<R>, Function<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}
