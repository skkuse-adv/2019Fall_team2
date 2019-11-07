package kotlinx.coroutines;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.UndispatchedEventLoop.EventLoop;
import org.jetbrains.annotations.NotNull;

final class UndispatchedEventLoop$threadLocalEventLoop$1 extends Lambda implements Function0<EventLoop> {
    public static final UndispatchedEventLoop$threadLocalEventLoop$1 INSTANCE = new UndispatchedEventLoop$threadLocalEventLoop$1();

    UndispatchedEventLoop$threadLocalEventLoop$1() {
        super(0);
    }

    @NotNull
    public final EventLoop invoke() {
        return new EventLoop(false, null, 3, null);
    }
}
