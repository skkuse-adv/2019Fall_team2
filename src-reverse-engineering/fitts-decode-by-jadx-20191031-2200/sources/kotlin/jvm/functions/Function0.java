package kotlin.jvm.functions;

import kotlin.Function;

public interface Function0<R> extends Function<R> {
    R invoke();
}
