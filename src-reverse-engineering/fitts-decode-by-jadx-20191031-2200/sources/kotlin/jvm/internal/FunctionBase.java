package kotlin.jvm.internal;

import kotlin.Function;

public interface FunctionBase<R> extends Function<R> {
    int getArity();
}
