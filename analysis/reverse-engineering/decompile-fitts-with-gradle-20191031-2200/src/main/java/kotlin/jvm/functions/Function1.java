package kotlin.jvm.functions;

import kotlin.Function;

public interface Function1<P1, R> extends Function<R> {
    R invoke(P1 p1);
}
